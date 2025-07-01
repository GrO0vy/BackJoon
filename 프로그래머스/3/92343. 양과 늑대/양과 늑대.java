import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < info.length; i++) adjList.add(new ArrayList<>());
        
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);    
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 0, adjList.get(0)));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            
            answer = Math.max(answer, node.sheep);
            
            for(int nextNode: node.nextNodes){
                int next = info[nextNode];
                
                int nextSheep = node.sheep;
                int nextWolf = node.wolf;
                
                if(next == 0) nextSheep++;
                else nextWolf++;
                
                if(nextSheep > nextWolf){
                    List<Integer> nextNodes = new ArrayList<>(node.nextNodes);
                    
                    nextNodes.remove((Integer) nextNode);
                    nextNodes.addAll(adjList.get(nextNode));
                    
                    queue.offer(new Node(nextSheep, nextWolf, nextNodes));
                }
            }
            
        }
        return answer;
    }
}

class Node{
    int sheep;
    int wolf;
    List<Integer> nextNodes;
    
    public Node(int sheep, int wolf, List<Integer> nextNodes){
        this.sheep = sheep;
        this.wolf = wolf;
        this.nextNodes = nextNodes;
    }
}