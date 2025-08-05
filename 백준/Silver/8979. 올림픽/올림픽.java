import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Country[] countries = new Country[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            countries[i] = new Country(number, gold, silver, bronze);
        }

        Arrays.sort(countries);

        int ranking = 1;

        for(int i = 0; i < N; i++){
            if(i > 0 && !isSame(countries[i - 1], countries[i])) ranking = i + 1;

            if(countries[i].number == K){
                System.out.println(ranking);
                break;
            }
        }
    }

    static boolean isSame(Country c1, Country c2){
        return c1.gold == c2.gold && c1.silver == c2.silver && c1.bronze == c2.bronze;
    }

    static class Country implements Comparable<Country>{
        int number;
        int gold;
        int silver;
        int bronze;

        public Country(int number, int gold, int silver, int bronze){
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int compareTo(Country o){
            if(this.gold != o.gold) return o.gold - this.gold;
            if(this.silver != o.silver) return o.silver - this.silver;
            return o.bronze - this.bronze;
        }
    }
}