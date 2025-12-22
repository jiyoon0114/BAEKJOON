import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SymmetricDifference1269 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int numA = Integer.parseInt(st.nextToken());
        int numB = Integer.parseInt(st.nextToken());
        Set<Integer> A = new HashSet<>();
        Set<Integer> A_B = new HashSet<>();
        Set<Integer> B_A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        
        String numsA = br.readLine();
        StringTokenizer stA = new StringTokenizer(numsA);
        for(int i =0; i < numA; i++){
            int num = Integer.parseInt(stA.nextToken());
            A.add(num);
        }
        
        String numsB = br.readLine();
        StringTokenizer stB = new StringTokenizer(numsB);
        for(int i =0; i < numB; i++) {
            int num = Integer.parseInt(stB.nextToken());
            B.add(num);
        }
        
        for(int num : B){
            if(!A.contains(num)){
                B_A.add(num);
            }
        }
        
        for(int num : A){
            if(!B.contains(num)){
                A_B.add(num);
            }
        }
        
        int result = A_B.size() + B_A.size();
        for(int num : A_B){
            if(B_A.contains(num)){
                --result;
            }
        }
        
        System.out.print(result);
    }
}
