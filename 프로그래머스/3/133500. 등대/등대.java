import java.util.*;

class Solution {
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        
        Map<Integer, List<Integer>> connection = new HashMap<>();
        for(int i = 0; i <= n; i++) connection.put(i, new ArrayList<>());
        
        for(int[] l: lighthouse){
            int node1 = l[0];
            int node2 = l[1];
            
            connection.get(node1).add(node2);
            connection.get(node2).add(node1);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int node: connection.keySet())
        {
            if(connection.get(node).size() == 1) queue.offer(node);    
        }
        
        while(!queue.isEmpty()){
            int leaf = queue.poll();
            
            if(connection.get(leaf).size() == 0) continue;
            
            int parent = connection.get(leaf).get(0);
            
            for(int child: connection.get(parent)){
                connection.get(child).remove(Integer.valueOf(parent));
                if(connection.get(child).size() == 1) queue.offer(child);
            }
            
            connection.get(parent).clear();
            
            answer++;
        }
        
        return answer;
    }
    
    // 1. 리프노드를 찾는다.
    // 2. 리프노드의 부모노드의 불을 킨다.
    // 3. 리프노드와 연결된 노드와의 연결 모두 제거
    // 4. 부모노드와 연결된 노드와의 연결 모두 제거
    // 5. 다시 리프노드를 찾아서 반복
    // 6.
}