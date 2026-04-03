package DSA.Design;

import java.util.*;

public class Twitter {

    private static int timestamp=0;
    class Tweet{
        int id;
        int time;
        Tweet next;

        Tweet(int id){
            this.id=id;
            this.time=timestamp++;
        }
    }
    class User{
        int id;
        Set<Integer> followed;
        Tweet tweetHead;

        User(int id){
            this.id = id;
            follow(id);
        }

        void follow(int id) {
            followed.add(id);
        }

        void unFollow(int id) {
            if(id!=this.id){
            followed.remove(id);}
        }

        void postTweet(int tweetId){

            Tweet tweet= new Tweet(tweetId);
            tweet.next=tweetHead;
            tweetHead=tweet;
        }

    }

    Map<Integer,User> userMap;

    public Twitter() {
        this.userMap = new HashMap<>();
    }

    public void postTweet(int tweetId,int userId){
        userMap.putIfAbsent(userId,new User(userId));
        userMap.get(userId).postTweet(tweetId);

    }

    public void follow(int followerId, int followeeId){


        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));

        userMap.get(followerId).follow(followeeId);

    }
    public void unfollow(int followerId, int followeeId) {

        if (!userMap.containsKey(followerId))
            return;

        userMap.get(followerId).unFollow(followeeId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        if(!userMap.containsKey(userId)){
            return res;
        }
        Set<Integer> followers = userMap.get(userId).followed;

        PriorityQueue<Tweet> priorityQueue= new PriorityQueue<>((a,b)-> b.time-a.time);

        for(int u:followers){
            Tweet tweet= userMap.get(u).tweetHead;
            if(tweet!=null)priorityQueue.add(tweet);
        }

        while (!priorityQueue.isEmpty() && res.size()<10){
            Tweet tweet= priorityQueue.poll();
            res.add(tweet.id);
            if(tweet.next!=null){
                priorityQueue.add(tweet);
            }

        }
        return res;
    }
}
