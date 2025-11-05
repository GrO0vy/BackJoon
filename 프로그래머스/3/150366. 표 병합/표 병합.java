import java.util.*;

class Solution {
    public String[] solution(String[] commands) {
        String[] answer = {};
        
        Map<String, Set<Cell>> cellMap = new HashMap<>();
        cellMap.put("", new HashSet<>());
        
        Cell[][] graph = new Cell[51][51];
        for(int i = 1; i <= 50; i++){
            for(int j = 1; j <= 50; j++){
                Cell cell = new Cell("");
                graph[i][j] = cell;
                cellMap.get("").add(cell);
            }
        }
    
        List<String> result = new ArrayList<>();
        
        for(String command: commands){
            String[] cmd = command.split(" ");
            
            if(cmd[0].equals("UPDATE")){
                if(cmd.length == 4){
                    int x = Integer.parseInt(cmd[1]);
                    int y = Integer.parseInt(cmd[2]);
                    String newValue = cmd[3];
                    String prevValue = graph[x][y].value;
                    
                    if(prevValue.equals(newValue)) continue;
                    
                    if(!cellMap.containsKey(newValue)) {
                        cellMap.put(newValue, new HashSet<>());
                    }
                    
                    Set<Cell> newSet = cellMap.get(newValue);
                    Set<Cell> prevSet = cellMap.get(prevValue);
                    
                    for(Cell cell: graph[x][y].merged){
                        cell.value = newValue;
                        newSet.add(cell);
                        prevSet.remove(cell);
                    }
                    
                    graph[x][y].value = newValue;
                    newSet.add(graph[x][y]);
                    prevSet.remove(graph[x][y]);
                }
                else{
                    String prevValue = cmd[1];
                    String newValue = cmd[2];
                    
                    if(!cellMap.containsKey(prevValue)){
                        continue;
                    }
                    
                    if(prevValue.equals(newValue)) continue;
                    
                    if(!cellMap.containsKey(newValue)){
                        cellMap.put(newValue, new HashSet<>());
                    }
                    
                    Set<Cell> newSet = cellMap.get(newValue);
                    Set<Cell> prevSet = cellMap.get(prevValue);
                    
                    for(Cell cell: prevSet){
                        cell.value = newValue;
                        newSet.add(cell);
                    }
                    
                    prevSet.clear();
                }
            }
            else if(cmd[0].equals("MERGE")){
                int x1 = Integer.parseInt(cmd[1]);
                int y1 = Integer.parseInt(cmd[2]);
                int x2 = Integer.parseInt(cmd[3]);
                int y2 = Integer.parseInt(cmd[4]);
                
                if(x1 == x2 && y1 == y2) continue;
                
                Set<Cell> set1 = graph[x1][y1].merged;
                Set<Cell> set2 = graph[x2][y2].merged;
                
                if(set1.contains(graph[x2][y2])) continue;
                
                String value = graph[x2][y2].value;
                if(!graph[x1][y1].value.equals("")){
                    value = graph[x1][y1].value;
                }
                
                for(Cell cell: set2){
                    if(!cell.value.equals(value)){
                        cellMap.get(cell.value).remove(cell);
                        cellMap.get(value).add(cell);    
                    }
                    cell.value = value;
                    cell.merged.add(graph[x1][y1]);
                    cell.merged.addAll(set1);
                }
                
                for(Cell cell: set1){
                    if(!cell.value.equals(value)){
                        cellMap.get(cell.value).remove(cell);
                        cellMap.get(value).add(cell);    
                    }
                    cell.value = value;
                    cell.merged.add(graph[x2][y2]);
                    cell.merged.addAll(set2);
                }
                
                cellMap.get(graph[x1][y1].value).remove(graph[x1][y1]);
                cellMap.get(value).add(graph[x1][y1]);
                graph[x1][y1].value = value;
                
                cellMap.get(graph[x2][y2].value).remove(graph[x2][y2]);
                cellMap.get(value).add(graph[x2][y2]);
                graph[x2][y2].value = value;
                
                
                set1.addAll(set2);
                set2.addAll(set1);
                set1.add(graph[x2][y2]);
                set2.add(graph[x1][y1]);
            }
            else if(cmd[0].equals("UNMERGE")){
                int x = Integer.parseInt(cmd[1]);
                int y = Integer.parseInt(cmd[2]);
                
                String key = graph[x][y].value;
                
                for(Cell cell: graph[x][y].merged){
                    cellMap.get("").add(cell);
                    cellMap.get(key).remove(cell);
                    cell.merged.clear();
                    cell.value = "";
                }

                graph[x][y].merged.clear();
            }
            else{
                int x = Integer.parseInt(cmd[1]);
                int y = Integer.parseInt(cmd[2]);
                
                if(graph[x][y].value.equals("")) result.add("EMPTY");
                else result.add(graph[x][y].value);   
            }
        }
        
        answer = result.stream().toArray(String[]::new);
        return answer;
    }
}

class Cell{
    String value;
    Set<Cell> merged;
    
    public Cell(String value){
        this.value = value;
        merged = new HashSet<>();
    }
}