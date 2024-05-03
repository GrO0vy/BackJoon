import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a").replace("B#", "b");
        
        Arrays.sort(musicinfos, new Comparator<>(){
            public int compare(String o1, String o2){
                String[] s1 = o1.split(",");
                String[] s2 = o2.split(",");
                
                String[] start1 = s1[0].split(":");
                String[] end1 = s1[1].split(":");
                int playTime1 = Integer.parseInt(end1[0]) * 60 + Integer.parseInt(end1[1]) - Integer.parseInt(start1[0]) * 60 - Integer.parseInt(start1[1]);
                
                String[] start2 = s2[0].split(":");
                String[] end2 = s2[1].split(":");
                int playTime2 = Integer.parseInt(end2[0]) * 60 + Integer.parseInt(end2[1]) - Integer.parseInt(start2[0]) * 60 - Integer.parseInt(start2[1]);
                
                if(playTime1 == playTime2) return 0;
                else return playTime2 - playTime1;
            }
        });
        
        for(String musicInfo: musicinfos){
            String[] info = musicInfo.split(",");
            
            String[] start = info[0].split(":");
            String[] end = info[1].split(":");
            int playTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) - Integer.parseInt(start[0]) * 60 - Integer.parseInt(start[1]);
            
            info[3] = info[3].replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a").replace("B#", "b");
            
            int repeatTime = playTime / info[3].length();
            int remain = playTime % info[3].length();
            
            String music = info[3].repeat(repeatTime) + info[3].substring(0, remain);
            
            if(music.contains(m)) {
                answer = info[2];
                break;
            }
        }
        
        return answer;
    }
}