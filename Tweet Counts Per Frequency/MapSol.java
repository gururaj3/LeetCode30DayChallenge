class TweetCounts {

    Map<String, List<Integer>> map;
    public TweetCounts() {
        this.map = new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        if(map.containsKey(tweetName)){
            map.get(tweetName).add(time);
        }
        else{
            map.put(tweetName, new ArrayList<>());
            map.get(tweetName).add(time);
        }
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        
        int interval = 60;
        if(freq.equals("hour"))
            interval = interval * 60;
        if(freq.equals("day"))
            interval = interval * 60 * 24;
        List<Integer> res = new ArrayList<>();
        
        // get the number of possible intervals, 
        // if startTime = 30 and endTime = 150 with minute as freq
        // (150 - 30) / 60 = 2, this means there will be 3 intervals
        // [30, 90); [90, 150); [150, 150)
        for(int i = 0; i <= (endTime - startTime) / interval; i++)
            res.add(0);
        
        List<Integer> times = map.get(tweetName);
        for(int time : times){
            if(startTime <= time && time <= endTime){
                // get the index of which interval at current time
                int idx = (time - startTime) / interval;
                res.set(idx, res.get(idx)+1);
            }
        }
        return res;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */

