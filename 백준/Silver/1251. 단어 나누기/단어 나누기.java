import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String result = "";

        for(int i = 1; i < str.length() - 1; i++){
            for(int j = i + 1; j < str.length(); j++){
                String temp = "";
                StringBuilder sb = new StringBuilder();

                String one = str.substring(0, i);
                temp += sb = new StringBuilder(one).reverse();
                String two =  str.substring(i, j);
                temp += sb = new StringBuilder(two).reverse();
                String three = str.substring(j);
                temp += sb = new StringBuilder(three).reverse();

                if(result.equals("")){
                    result = temp;
                    continue;
                }
                
                if(temp.compareTo(result) < 0) result = temp;
            }
        }

        System.out.println(result);
    }
}