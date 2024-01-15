import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String result = "mixed";
        int[] arr = new int[8];
        
        for(int i = 0; i < 8; i++){
            int number = sc.nextInt();
            arr[i] = number;    
        }
        
        boolean flag = true;
        for(int i = 0; i < 8; i++){
            if(arr[i] != i + 1) {
                flag = false;
                break;
            }
        }
        if(flag) result = "ascending";
        
        flag = true;
        for(int i = 0; i < 8; i++){
            if(arr[i] != 8 - i) {
                flag = false;
                break;
            }    
        }
            
        if(flag) result = "descending";
        
        System.out.println(result);
    }
}