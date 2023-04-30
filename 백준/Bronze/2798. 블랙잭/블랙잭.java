import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int count = sc.nextInt();
            int max = sc.nextInt();
            sc.nextLine();
            String[] numbers = sc.nextLine().split(" ");
            int result = 0;

            for(int i = 0; i < count; i++){
                for(int j=i+1; j<count; j++){
                    for(int k=j+1; k<count; k++){
                        int temp = Integer.parseInt(numbers[i]) + Integer.parseInt(numbers[j]) + Integer.parseInt(numbers[k]);
                        if(temp <= max && result < temp){
                            result = temp;
                        }
                    }
                }
            }
            System.out.println(result);
    }
}