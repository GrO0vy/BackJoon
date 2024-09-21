class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String[] videoTime = video_len.split(":");
        int videoEnd = Integer.parseInt(videoTime[0]) * 60 + Integer.parseInt(videoTime[1]);
        
        String[] opStartTime = op_start.split(":");
        int opStart = Integer.parseInt(opStartTime[0]) * 60 + Integer.parseInt(opStartTime[1]);
        
        String[] opEndTime = op_end.split(":");
        int opEnd = Integer.parseInt(opEndTime[0]) * 60 + Integer.parseInt(opEndTime[1]);
        
        String[] time = pos.split(":");
        int totalSeconds = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        
        for(String command: commands){
            if(totalSeconds >= opStart) 
                totalSeconds = Math.max(totalSeconds, opEnd); 
            
            if(command.equals("prev")) 
                totalSeconds = Math.max(totalSeconds - 10, 0);
            else
                totalSeconds = Math.min(totalSeconds + 10, videoEnd);
        }
        
        if(totalSeconds >= opStart) 
            totalSeconds = Math.max(totalSeconds, opEnd); 
        
        answer = String.format("%02d:%02d", totalSeconds / 60, totalSeconds % 60);
        
        return answer;
    }
}