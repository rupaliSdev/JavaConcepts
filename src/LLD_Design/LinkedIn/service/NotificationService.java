package LLD_Design.LinkedIn.service;

import LLD_Design.LinkedIn.entity.Member;
import LLD_Design.LinkedIn.entity.Notification;

public class NotificationService {
    public void sendNotification(Member member, Notification notification) {
        // In a real system, this would push to a queue or a websocket.
        // Here, we directly call the member's update method.
        member.update(notification);
    }
}
