import java.util.*;

class Solution {
    List<Integer> pre;
    List<Integer> post;
    Node[] nodes;
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        pre = new ArrayList<>();
        post = new ArrayList<>();
        nodes = new Node[nodeinfo.length];
        
        for(int i = 0; i < nodeinfo.length; i++){
            int[] current = nodeinfo[i];
            
            nodes[i] = new Node(i + 1, current[0], current[1]);
        }
        
        Arrays.sort(nodes, new Comparator<>(){
            public int compare(Node o1, Node o2){
                if(o1.y != o2.y) return o2.y - o1.y;
                
                return o1.x - o2.x;
            }
        });
        
        for(int i = 1; i < nodes.length; i++){
            insert(nodes[0], nodes[i]);
        }
        
        preOrder(nodes[0]);
        postOrder(nodes[0]);
        
        for(int i = 0; i < answer[0].length; i++){
            answer[0][i] = pre.get(i);
        }
        
        for(int i = 0; i < answer[0].length; i++){
            answer[1][i] = post.get(i);
        }
        
        return answer;
    }
    
    void preOrder(Node current){
        if(current == null) return;
        
        pre.add(current.num);
        // System.out.printf("%d %d\n", start, end);
        // System.out.println(nodes[mid].num);
        // System.out.println("============");
        
        preOrder(current.left);
        preOrder(current.right);
    }
    
    void postOrder(Node current){
        if(current == null) return;
        
        postOrder(current.left);
        postOrder(current.right);
        
        post.add(current.num);
    }
    
    private void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }
    
    class Node{
        int num;
        int x;
        int y;
        Node left, right;
        
        public Node(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
}

