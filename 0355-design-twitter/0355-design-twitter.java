class Pair{
    int f_id,t_id;
    
    Pair(int f_id,int t_id){
        this.f_id = f_id;
        this.t_id = t_id;
    }
}


class Twitter {
    
    HashMap<Integer,HashSet<Integer>> followers;
    ArrayList<Pair> tweets;
    public Twitter() {
        followers = new HashMap<>();
        tweets = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        //System.out.println("tweeted");
        tweets.add(new Pair(userId,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        int count = 10;
        List<Integer> ans = new ArrayList<>();
        

        for(int i=tweets.size()-1;i>=0;i--){
            Pair p = tweets.get(i);
            if(p.f_id == userId || (followers.containsKey(p.f_id) && followers.get(p.f_id).contains(userId))){
                ans.add(p.t_id);
                count-=1;
                //System.out.println(p.f_id+" "+userId+" "+p.t_id);

                if(count<=0)
                    break;
            }
        }
        // System.out.println("fetched new feed");
        // System.out.println(ans);
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followeeId)){
            HashSet<Integer> set = new HashSet<>();
            set.add(followerId);
            followers.put(followeeId,set);
        }else
            followers.get(followeeId).add(followerId);
        // System.out.println(followers);
        // System.out.println("Added follower");
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followeeId) && followers.get(followeeId).contains(followerId))
            followers.get(followeeId).remove(followerId); 

        // System.out.println("removed Follower");  
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */