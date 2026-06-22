import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        List<Log> logs = new ArrayList<>();
        
        // 1. 입력 형변환 및 저장 (이미 end 기준 오름차순 정렬되어 있음)
        for(String line: lines){
            String[] log = line.split(" ");
            int end = parseTime(log[1]);
            int processTime = getProcessTime(log[2]);
            logs.add(new Log(end, processTime));
        }
        
        // 2. 각 로그의 '종료 시점'을 기준으로 1초 구간에 몇 개가 겹치는지 체크
        for(int i = 0; i < logs.size(); i++) {
            Log current = logs.get(i);
            
            // 현재 로그의 종료 시간부터 1초(999ms) 구간의 끝 설정
            int windowStart = current.end;
            int windowEnd = current.end + 999;
            
            int count = 0;
            // 이미 end 기준으로 정렬되어 있으므로, 현재(i) 이후의 로그들만 검사해도 충분합니다.
            for(int j = i; j < logs.size(); j++) {
                Log next = logs.get(j);
                
                // 다음 로그의 시작 시간이 1초 구간의 끝보다 작거나 같으면 무조건 겹침
                // (이미 end 기준 오름차순이므로 next.end < windowStart인 경우는 없음)
                if(next.start <= windowEnd) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
    
    private int parseTime(String strTime){
        String[] log = strTime.split(":");
        int hourToMiliSec = Integer.parseInt(log[0]) * 60 * 60 * 1000;
        int minuteToMiliSec = Integer.parseInt(log[1]) * 60 * 1000;
        // 고치신 부분 반영: 정확한 밀리초 변환
        int secondToMiliSec = (int) (Double.parseDouble(log[2]) * 1000);
        
        return hourToMiliSec + minuteToMiliSec + secondToMiliSec;
    }
    
    private int getProcessTime(String strProcessTime){
        // 고치신 부분 반영: 정확한 밀리초 변환
        return (int)(Double.parseDouble(strProcessTime.replace("s", "")) * 1000); 
    }
    
    class Log{
        int start;
        int end;
        
        public Log(int end, int processTime){
            this.start = end - processTime + 1;
            this.end = end;
        }
    }
}