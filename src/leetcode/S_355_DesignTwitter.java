package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class S_355_DesignTwitter {
	private static int timeStamp = 0;
    private Map<Integer, User> userMap;
    private class Tweet{
    	public int id;
    	public int time;
    	public Tweet next;
    	public Tweet(int id) {
    		this.id = id;
    		time = timeStamp++;
    		next = null;
    	}
    }
    public class User{
    	public int id;
    	public Set<Integer> followed;
    	public Tweet tweet_head;
    	public User(int id) {
    		this.id = id;
    		followed = new HashSet<>();
    		follow(id);
    		tweet_head = null;
    	}
    	public void follow(int id)
    	{
    		followed.add(id);
    	}
    	public void unfollow(int id) {
    		followed.remove(id);
    	}
    	public void post(int id) {
    		Tweet t = new Tweet(id);
    		t.next = tweet_head;
    		tweet_head = t;
    	}
    }
    
    
	/** Initialize your data structure here. */
    public S_355_DesignTwitter () {
        userMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)) {
        	User u = new User(userId);
        	userMap.put(userId, u);
        }
    	userMap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	List<Integer> ret = new ArrayList<>();
        if(!userMap.containsKey(userId))
        	return ret;
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq= new PriorityQueue<>(users.size(), (a,b)->(b.time-a.time));
        for(int user : users) {
        	Tweet t = userMap.get(user).tweet_head;
        	if(t != null)
        		pq.add(t);
        }
        int n = 0;
        while(!pq.isEmpty() && n < 10) {
        	Tweet t = pq.poll();
        	ret.add(t.id);
        	if(t.next != null)
        		pq.add(t.next);
        	n++;
        }
        return ret;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	if(!userMap.containsKey(followerId)) {
        	User u = new User(followerId);
        	userMap.put(followerId, u);
    	}
    	if(!userMap.containsKey(followeeId)) {
        	User u = new User(followeeId);
        	userMap.put(followeeId, u);
    	}
    	userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followeeId == followerId)
        	return;
        userMap.get(followerId).unfollow(followeeId);
    }
}
