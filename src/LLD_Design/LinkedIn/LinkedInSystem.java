package LLD_Design.LinkedIn;

import LLD_Design.LinkedIn.entity.Member;
import LLD_Design.LinkedIn.entity.Notification;
import LLD_Design.LinkedIn.entity.Post;
import LLD_Design.LinkedIn.service.ConnectionService;
import LLD_Design.LinkedIn.service.NewsFeedService;
import LLD_Design.LinkedIn.service.NotificationService;
import LLD_Design.LinkedIn.service.SearchService;
import LLD_Design.LinkedIn.startegy.ChronologicalSortStrategy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LinkedInSystem {

    private static volatile LinkedInSystem instance;

    //Data stores
    private final Map<String, Member> memberMap= new ConcurrentHashMap<>();

    //services
    private final ConnectionService connectionService;
    private final NewsFeedService newsFeedService;
    private final SearchService searchService;

    public LinkedInSystem() {
        //initialize services
        this.connectionService = new ConnectionService(new NotificationService());
        this.newsFeedService =new NewsFeedService();
        this.searchService =new SearchService();
    }

    public static LinkedInSystem getInstance(){
        if(instance==null){
            synchronized (LinkedInSystem.class){
                if(instance==null){
                    instance= new LinkedInSystem();
                }
            }
        }
        return instance;
    }

    public void registerMember(Member member){
        memberMap.put(member.getId(), member);
        System.out.println("New member registered"+ member.getName());
    }

    public Member getMember(String name){
        return  memberMap.values().stream().filter(member -> member.getName().equals(name)).findFirst().orElse(null);
    }

    public String sendConnectionRequest(Member from ,Member to){
        return connectionService.sendRequest(from,to);
    }

    public void acceptConnectionRequest(String requestId){
        connectionService.acceptRequest(requestId);
    }
    public void createPost(String memberId,String content){
        Member author = memberMap.get(memberId);
        Post post = new Post(memberId,author,content, LocalDateTime.now());
        newsFeedService.addPost(author,post);
        System.out.printf("%s created a new post.%n",author.getName());

    }
    public  Post getLatestPostByAMember(String memberId){

        List<Post> memberPosts= newsFeedService.getMemberPosts(memberMap.get(memberId));
        if(!memberPosts.isEmpty()){
            return memberPosts.get(memberPosts.size()-1);
        }
        return null;
    }

    public void viewNewsFeed(String memberId){
        Member member = memberMap.get(memberId);
        System.out.println("\n--- News Feed for " + member.getName() + " ---");
        // Using the default chronological strategy
        newsFeedService.displayFeedForMember(member, new ChronologicalSortStrategy());

    }

    public List<Member> searchMemberByName(String name) {
        return searchService.searchByName(name);
    }


}
