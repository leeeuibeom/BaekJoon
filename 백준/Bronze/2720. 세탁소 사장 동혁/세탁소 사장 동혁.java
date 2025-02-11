import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int[] de = {25,10,5,1};
        int n = sc.nextInt();
        int[][] a = new int[n][4];
        int leave;
        
        
        
        for(int i = 0; i < n; i++){
            leave = sc.nextInt();
            for(int j = 0; j < 4; j++){
                a[i][j] = leave / de[j];
                leave = leave - (a[i][j] * de[j]);
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 4; j++){
                System.out.println(a[i][j]);
            }
        }
    }
}