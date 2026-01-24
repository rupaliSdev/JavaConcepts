package LLD_Design.LinkedIn.Observer;

import LLD_Design.LinkedIn.entity.Notification;

public interface NotificationObserver {
    void update(Notification notification);
}
