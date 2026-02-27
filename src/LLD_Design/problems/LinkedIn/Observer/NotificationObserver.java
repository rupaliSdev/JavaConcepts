package LLD_Design.problems.LinkedIn.Observer;

import LLD_Design.problems.LinkedIn.entity.Notification;

public interface NotificationObserver {
    void update(Notification notification);
}
