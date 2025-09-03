import java.util.*;

class Solution {
    int[] parent;
    int[] cntChild;
    
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = {};
        
        int lastNode = 0;
        for(int node: nodes){
            lastNode = Math.max(lastNode, node);
        }
        
        cntChild = new int[lastNode + 1];
        parent = new int[lastNode + 1];
        for(int i = 0; i <= lastNode; i++){
            parent[i] = i;
        }
        
        for(int[] edge: edges){
            int node1 = edge[0];
            int node2 = edge[1];
            
            cntChild[node1]++;
            cntChild[node2]++;
            
            merge(node1, node2);
        }
        
        Map<Integer, Tree> trees = new HashMap<>();
        for(int node: nodes){
            int group = find(node);
            
            Tree tree = trees.getOrDefault(group, new Tree());
            
            if(node % 2 == 0){
                if(cntChild[node] % 2 == 0){
                    tree.evenNode++;
                }
                else tree.reverseEvenNode++;
            }
            else{
                if(cntChild[node] % 2 == 1){
                    tree.oddNode++;
                }
                else tree.reverseOddNode++;
            }
            
            if(!trees.containsKey(group)) trees.put(group, tree);
        }
        
        int tree = 0;
        int reverseTree = 0;
        
        for(Tree currentTree: trees.values()){
            if(currentTree.isTree()) tree++;
            if(currentTree.isReverseTree()) reverseTree++; 
        }
        
        answer = new int[]{tree, reverseTree};
        
        return answer;
    }
    
    class Tree{
        int oddNode;
        int evenNode;
        int reverseOddNode;
        int reverseEvenNode;
        
        boolean isTree(){
            if(oddNode == 1 && evenNode == 0 || evenNode == 1 && oddNode == 0){
                return true;
            }
            
            return false;
        }
        
        boolean isReverseTree(){
            if(reverseOddNode == 1 && reverseEvenNode == 0 || reverseEvenNode == 1 && reverseOddNode == 0){
                return true;
            }
            
            return false;
        }
    }
    
    void merge(int node1, int node2){
        int parent1 = find(node1);
        int parent2 = find(node2);
        
        if(parent1 != parent2){
            parent[parent2] = parent1;
        }
    }
    
    int find(int node){
        if(parent[node] == node) return node;
        
        return parent[node] = find(parent[node]);
    }
}