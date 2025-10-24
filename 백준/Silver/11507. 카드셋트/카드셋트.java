// 1. HashMap 에 P, K, H, T 각각 카드의 개수를 저장한다.
// 2. 문자열을 substring을 이용해 3글자씩 읽는다.
// 3. 사라진 카드 목록에 substring 문자열을 저장한다.
// 4. 이미 사라진 카드 목록에 해당 문자열이 존재하면 GRESKA 출력 후 종료
// 5. 그렇지 않으면 substring 의 첫 글자를 가져와서 P/K/H/T 의 개수를 1 감소시킨다.
// 6. 마지막으로 P, K, H, T 의 개수를 출력한다.

import java.io.*;
import java.util.*;

public class Main{
    static final int CNT_CARD_DEFAULT = 13;
    static final String GRESKA = "GRESKA";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lost = br.readLine();

        List<Character> shapes = new ArrayList<>();
        shapes.add('P');
        shapes.add('K');
        shapes.add('H');
        shapes.add('T');

        HashMap<Character, Integer> cntCard = new HashMap<>();
        for(char shape: shapes){
            cntCard.put(shape, CNT_CARD_DEFAULT);
        }

        Set<String> complete = new HashSet<>();

        for(int i = 0; i < lost.length(); i += 3){
            String card = lost.substring(i, i + 3);

            if(complete.contains(card)){
                System.out.println(GRESKA);
                return;
            }

            complete.add(card);

            char shape = card.charAt(0);
            cntCard.put(shape, cntCard.get(shape) - 1);
        }

        StringBuilder sb = new StringBuilder();
        for(char shape: shapes){
            sb.append(cntCard.get(shape) + " ");
        }

        System.out.println(sb.toString());
    }
}