package LLD_Design.LinkedIn.entity;

import LLD_Design.LinkedIn.Observer.Subject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Post extends Subject {
    private final String id;
    private final Member author;
    private final String content;
    private final LocalDateTime createdAt;
    private final List<Like> likes = new ArrayList<>();
    private final List<Comment> comments = new ArrayList<>();

    public Post(String id, Member author, String content, LocalDateTime createdAt) {
        this.id = UUID.randomUUID().toString();
        this.author = author;
        this.content = content;
        this.createdAt = LocalDateTime.now();

        this.addObserver(author);
    }

    public void addLike(Member member){
        likes.add(new Like(member));
        String notificationContent = member.getName() + " liked your post.";

        Notification notification = new Notification(author.getId(),NotificationType.POST_LIKE,notificationContent);
        notifyObservers(notification);
    }

    public void addComment(Member member,String text){
        comments.add(new Comment(member,text));
        String notificationContent = member.getName() + " commented on your post. \""+ text + "\"";

        Notification notification = new Notification(author.getId(),NotificationType.POST_LIKE,notificationContent);
        notifyObservers(notification);
    }

    public String getId() {
        return id;
    }

    public Member getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
