package LLD_Design.LinkedIn.service;

import LLD_Design.LinkedIn.entity.*;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionService {

    // Simulates a DB table for connection requests
    private final Map<String, Connection> connectionRequests = new ConcurrentHashMap<>();

    NotificationService notificationService;

    public ConnectionService(NotificationService notificationService) {
       notificationService = new NotificationService();
    }

    public String sendRequest(Member from, Member to) {
        String requestId =UUID.randomUUID().toString();
        connectionRequests.put(requestId,new Connection(from,to));
        System.out.printf("%s sent a connection request to %s.%n", from.getName(), to.getName());

        Notification notification= new Notification(
                to.getId(),
                NotificationType.CONNECTION_REQUEST
                from.getName() + " wants to connect with you."
        );
        notificationService.sendNotification(to,notification);
        return requestId;
    }

    public void acceptRequest(String requestId) {
        Connection request = connectionRequests.get(requestId);

       if(request==null && request.getStatus()== ConnectionStatus.PENDING) {
           request.setStatus(ConnectionStatus.ACCEPTED);
              Member from = request.getFromMember();
              Member to = request.getToMember();
              from.addConnection(to);
              to.addConnection(from);
              System.out.printf("%s accepted the connection request from %s.%n", to.getName(), from.getName());
              connectionRequests.remove(requestId); // Clean up
       }
       else {
           System.out.println("Invalid or already handled request ID.");
       }
    }
}
