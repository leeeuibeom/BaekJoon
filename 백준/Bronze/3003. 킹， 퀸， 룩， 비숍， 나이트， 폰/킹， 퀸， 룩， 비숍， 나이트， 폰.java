import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int king = 1;
        int queen = 1;
        int rook = 2;
        int bishop = 2;
        int knight = 2;
        int pawn = 8;

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        king = 1 - a;
        queen = 1 - b;
        rook = 2 - c;
        bishop = 2 - d;
        knight = 2 - e;
        pawn = 8 - f;

        System.out.println(king);     
        System.out.println(queen);     
        System.out.println(rook);    
        System.out.println(bishop);  
        System.out.println(knight); 
        System.out.println(pawn);  
    }
}
