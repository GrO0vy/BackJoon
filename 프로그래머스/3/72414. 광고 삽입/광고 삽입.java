class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        long[] timeLog = new long[360001];
        
        for(String log: logs){
            String[] playTime = log.split("-");
            int start = toInt(playTime[0]);
            int end = toInt(playTime[1]);
            
            timeLog[start]++;
            timeLog[end]--;
        }
        
        for(int i = 1; i < timeLog.length; i++){
            timeLog[i] += timeLog[i - 1];
        }
        
        for (int i = 1; i < timeLog.length; i++) {
            timeLog[i] += timeLog[i - 1];
        }

        
        int total = toInt(play_time);
        int adv = toInt(adv_time);
        
        long maxView = timeLog[adv - 1];
        int maxStart = 0;
        
        for(int i = adv; i <= total; i++){
            long view = timeLog[i] - timeLog[i - adv];
            
            if(view > maxView){
                maxStart = i - adv + 1;
                maxView = view;
            }
        }
        
        return toString(maxStart);
    }
    
    int toInt(String timeStr){
        String[] time = timeStr.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        int second = Integer.parseInt(time[2]);
        
        return hour * 3600 + minute * 60 + second;
    }
    
    String toString(int timeInt){        
        int second = timeInt % 60;
        timeInt /= 60;
        
        int minute = timeInt % 60;
        timeInt /= 60;
        
        int hour = timeInt % 100;
        
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}