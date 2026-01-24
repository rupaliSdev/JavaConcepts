package LLD_Design.LinkedIn.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Notification {

    private final String id;
    private final String memberId;
    private final NotificationType type;
    private final String content;
    private final LocalDateTime createdAt;
    private boolean isRead = false;

    public Notification(String memberId, NotificationType type, String content) {
        this.id = UUID.randomUUID().toString();
        this.memberId = memberId;
        this.type = type;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }


    public String getContent() {
        return content;
    }


    public boolean isRead() {
        return isRead;
    }

    public void markAsRead() {
        isRead = true;
    }
}
