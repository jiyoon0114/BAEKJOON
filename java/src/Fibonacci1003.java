import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Fibonacci1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testnum = Integer.parseInt(br.readLine());
        
        for(int i =0; i<testnum; i++){
            int n = Integer.parseInt(br.readLine());
            
            int[][] array = new int[n+1][2];
            
            if(n >= 0){
                array[0][0] = 1; array[0][1] = 0;
            }
            
            if(n >= 1){
                array[1][0] = 0; array[1][1] = 1;
                
            }
            
            for(int j=2; j<=n; j++){
                array[j][0] = array[j-1][0] + array[j-2][0];
                array[j][1] = array[j-1][1] + array[j-2][1];
            }
            
            System.out.println(array[n][0] +" "+array[n][1]);
        }
    }
}
