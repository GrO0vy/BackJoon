import java.util.*;
class Solution {
    private int[] Dist;
    private int N;
    private int min_fnd = Integer.MAX_VALUE;
    public int solution(int n, int[] weak, int[] dist) {
        // dist를 내림차순으로 정렬
        Dist = dist;
        N = n;
        sortReverse(Dist);
        
        List<Integer> weak_list = new ArrayList<>();
        for(int i = 0; i < weak.length; i++) {
            weak_list.add(weak[i]);
        }
        
        cntFriend(weak_list, 0);
        
        
        return min_fnd != Integer.MAX_VALUE ? min_fnd: -1;
    }
    
    
    private void cntFriend(List<Integer> weak, int fnd_num) {
        
        // 리턴조건1) 만약 weak 리스트가 비어있다면 모든 취약지점을 점검한 것
        // 해당 케이스에서 보낸 친구 수 체크해서 현재 최솟값과 비교해서 더 작다면 갱신한다.
        if(weak.isEmpty()){
            if(min_fnd > fnd_num)
                min_fnd = fnd_num;
            return;
        }
    
        
        // 리턴조건2) 만약 fnd_num이 Dist의 길이와 같다면 모든 친구가 점검한 것
        // weak 리스트가 비어있지 않는데도 모든 친구가 점검을 했다면 취약 지점을 전부 점검할 수 없는 케이스
        // 리턴조건3) 만약 fnd_num이 min_fnd와 같다면 해당 케이스는 가능성이 없는 케이스
        if(fnd_num == Dist.length || fnd_num == min_fnd)
            return;
        
        
        // 출발점을 취약점이 있는 곳으로 설정하여  점검하는 외벽을 제거 후 재귀 호출
        for(int i = 0; i < weak.size(); i++) {
            int start = weak.get(i); // 친구의 출발 지점
            int end; // 친구의 도착 지점
            
            // 시계 방향
            List<Integer> newWeak = new ArrayList<>(weak);
            end = start + Dist[fnd_num];
        
            // 현재 친구가 점검한 외벽을 리스트에서 제거
            for(int w: weak) {
                if(end < N) {
                    if(w >= start && w <= end)
                        newWeak.remove(newWeak.indexOf(w));
                } else {
                    if(w >= start || w <= end % N)
                        newWeak.remove(newWeak.indexOf(w));
                }
            }
            // 제거한 리스트로 재귀 호출
            cntFriend(newWeak, fnd_num + 1);
                
        }
    }
    
    private void sortReverse(int[] dist) {
        Integer[] distInteger = Arrays.stream(dist).boxed().toArray(Integer[]::new);
        Arrays.sort(distInteger, Collections.reverseOrder());
        for(int i = 0; i < distInteger.length; i++) {
            dist[i] = distInteger[i];
        }
    }
}