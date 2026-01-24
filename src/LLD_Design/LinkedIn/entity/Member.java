package LLD_Design.LinkedIn.entity;

import LLD_Design.LinkedIn.Observer.NotificationObserver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Member implements NotificationObserver {

    private final String id;
    private final String name;
    private final String email;
    private final Profile profile;
    private final Set<Member> connections
            = new HashSet<>();
    private final List<Notification> notifications = new ArrayList<>();

    private Member(String id, String name, String email, Profile profile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void addConnection(Member member){
        connections.add(member);
    }
    public void display(){
        System.out.println("\n--- Profile for "+ name + " (" + email + ") ----" );
        profile.display();
        System.out.println( "Connections: "+ connections.size());
    }

    public void viewNotifications(){
        System.out.println("\n--- Notifications for " + name + " ---");
        if (notifications.isEmpty()) {
            System.out.println("  No new notifications.");
            return;
        }

        notifications.stream()
                .filter(notification -> !notification.isRead())
                .forEach(notification -> {
                    System.out.println(" - "+notification.getContent());
                    notification.markAsRead();
                });
    }

    @Override
    public void update(Notification notification) {
        this.notifications.add(notification);
        System.out.printf("Notification pushed to %s: %s%n", this.name, notification.getContent());
    }

    //Builder Class

    public static class Builder{
        private final String id;
        private final String name;
        private final String email;
        private final Profile profile =new Profile();

        public Builder(String id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public Builder withSummary( String summary){
            this.profile.setSummary(summary);
            return this;
        }
        public Builder addExperience(Experience experience){
            this.profile.addExperience(experience);
            return this;
        }
        public Builder addEducation(Education education){
            this.profile.addEducation(education);
            return this;
        }
        public Member build(){
            return new Member(id,name,email,profile);
        }

    }
}
