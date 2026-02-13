package LLD_Design.LinkedIn.service;

import LLD_Design.LinkedIn.entity.Member;
import LLD_Design.LinkedIn.entity.NewsFeed;
import LLD_Design.LinkedIn.entity.Post;
import LLD_Design.LinkedIn.startegy.ChronologicalSortStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NewsFeedService {

    Map<String,List<Post>> memberPostsMap;

    public NewsFeedService() {
        this.memberPostsMap = new ConcurrentHashMap<>();
    }

    public void addPost(Member member, Post post) {
        memberPostsMap.getOrDefault(member.getId(),new ArrayList<>()).add(post);

    }

    public List<Post> getMemberPosts(Member member) {
        return memberPostsMap.getOrDefault(member.getId(),new ArrayList<>());
    }

    public void displayFeedForMember(Member member, ChronologicalSortStrategy chronologicalSortStrategy) {

        List<Post> feedPosts = new ArrayList<>();
        for(Member connection: member.getConnections()){
            List<Post> connectionPosts = memberPostsMap.get(connection.getId());
            if(connectionPosts!=null){
                feedPosts.addAll(connectionPosts);
            }
        }
        NewsFeed feed = new NewsFeed(feedPosts);
        feed.display(chronologicalSortStrategy);
    }
}
