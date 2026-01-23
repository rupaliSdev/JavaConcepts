package LLD_Design.LinkedIn.entity;

import java.time.LocalDateTime;

public class Connection {


    private final Member fromMember;
    private final Member toMember;

    private ConnectionStatus status;

    private final LocalDateTime requestedAt;
    private  LocalDateTime acceptedAt;

    public Connection(Member fromMember, Member toMember) {
        this.fromMember = fromMember;
        this.toMember = toMember;
        this.requestedAt = LocalDateTime.now();
        this.status= ConnectionStatus.PENDING;
    }

    public Member getFromMember() { return fromMember; }
    public Member getToMember() { return toMember; }
    public ConnectionStatus getStatus() { return status; }

    public void setStatus(ConnectionStatus status) {
        this.status = status;
        if(status==ConnectionStatus.ACCEPTED){
            acceptedAt= LocalDateTime.now();
        }
    }
}
