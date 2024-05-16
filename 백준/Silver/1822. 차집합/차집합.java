import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cntA = Integer.parseInt(st.nextToken());
        int cntB = Integer.parseInt(st.nextToken());

        List<Integer> setA = new ArrayList<>();
        List<Integer> setB = new ArrayList<>();
        LinkedHashSet<Integer> result = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cntA; i++){
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cntB; i++){
            setB.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(setA);
        Collections.sort(setB);

        for(int a: setA){
            result.add(a);
        }
        
        int idxA = 0;
        int idxB = 0;


       while(idxA < cntA  && idxB < cntB){
            if(setA.get(idxA) < setB.get(idxB)){
                idxA++;
            }
            else if(setA.get(idxA) > setB.get(idxB)){
                idxB++;
            }
            else {
                result.remove(setA.get(idxA));
                idxB++;
                idxA++;
            }
        }

        StringBuilder sb = new StringBuilder();

        if(result.isEmpty()) sb.append(0);
        else{
            sb.append(result.size() + "\n");
            for(int num: result) sb.append(num + " ");
        }

        System.out.println(sb);
    }
}