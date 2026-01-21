import java.util.Scanner;

public class Hanoi11729 {
    
    StringBuilder hanoi(int n, int goal, int mid,  int start, StringBuilder sb){
        if(n == 1) {
            sb.append(start).append(" ").append(goal);
            sb.append("\n");
            return sb;
        }
        StringBuilder result1 = hanoi(n-1, mid, goal, start, sb);
        StringBuilder result2 = hanoi(1, goal, mid, start, sb);
        StringBuilder result3 = hanoi(n-1, goal, start, mid,sb);
        return sb;
    }
    
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int k = 1;
        for(int i = 1; i < n; i++){
            k = k*2 +1;
        }
        Hanoi11729 Hanoi = new Hanoi11729();
        
        sb = Hanoi.hanoi(n,3,2,1,sb);
        System.out.print(k + "\n");
        System.out.print(sb);
    }
}
