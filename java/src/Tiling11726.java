import java.util.Scanner;

public class Tiling11726 {
    
    int tiling(int n){
        int[] NumOfCases = new int[n];
        NumOfCases[0] = 1;
        if(n >= 2)
            NumOfCases[1]= 2;
        for(int i = 2; i < n; i++){
            NumOfCases[i] = (NumOfCases[i-1]+NumOfCases[i-2]) % 10007;
        }
        return NumOfCases[n-1];
    }
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Tiling11726 Tiling = new Tiling11726();
        int result = Tiling.tiling(n) % 10007;
        System.out.print(result);
    }
}
