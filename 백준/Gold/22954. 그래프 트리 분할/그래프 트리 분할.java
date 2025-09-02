import java.io.*;
import java.util.*;

public class Main{
    static boolean[] visited;
    static List<Tree> trees;
    static List<List<Edge>> connections;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        if(N <= 2){
            System.out.println(-1);
            return;
        }
        
        visited = new boolean[N + 1];
        trees = new ArrayList<>();
        
        connections = new ArrayList<>();
        for(int i = 0; i <= N; i++) connections.add(new ArrayList<>());
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            
            connections.get(node1).add(new Edge(i + 1, node2));
            connections.get(node2).add(new Edge(i + 1, node1));
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= N; i++){
            if(!visited[i]) {
                Tree tree = new Tree();
                trees.add(tree);
                
                dfs(i, tree);
            }
        }
    
        if(trees.size() > 2){
            System.out.println(-1);
            return;
        }
        else if(trees.size() == 2){
            if(trees.get(0).nodes.size() == trees.get(1).nodes.size()){
                System.out.println(-1);
                return;    
            }
            else{
                System.out.println(getResult(trees.get(0), trees.get(1)));    
            }
        }
        else{
            Tree originTree = trees.get(0);
            Integer leafNode = originTree.nodes.get(originTree.nodes.size() - 1);
            
            Tree newTree = new Tree();
            newTree.nodes.add(leafNode);
            
            originTree.nodes.remove(originTree.nodes.size() - 1);
            originTree.edges.remove(originTree.edges.size() - 1);
            
            System.out.println(getResult(originTree, newTree));              
        }
    }
    
    static String getResult(Tree tree1, Tree tree2){
        StringBuilder sb = new StringBuilder();

        sb.append(tree1.nodes.size() + " ");
        sb.append(tree2.nodes.size());
        sb.append("\n");
        
        for(int node: tree1.nodes){
            sb.append(node + " ");
        }
        
        sb.append("\n");
        
        for(int edge: tree1.edges){
            sb.append(edge + " ");
        }
        
        sb.append("\n");
        
        for(int node: tree2.nodes){
            sb.append(node + " ");
        }
        
        sb.append("\n");
        
        for(int edge: tree2.edges){
            sb.append(edge + " ");
        }
        
        return sb.toString();
    }
    
    static void dfs(int node, Tree tree){
        visited[node] = true;
        tree.nodes.add(node);
        
        for(Edge edge: connections.get(node)){
            if(!visited[edge.destination]){
                tree.edges.add(edge.num);
                dfs(edge.destination, tree);
            }
        }
    }
    
    static class Tree{
        List<Integer> nodes;
        List<Integer> edges;
        
        public Tree(){
            nodes = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }
    
    static class Edge{
        int num;
        int destination;
        
        public Edge(int num, int destination){
            this.num = num;
            this.destination = destination;
        }
    }
}