import java.util.*;

public class Stringlotto34803 {
    
    public int findMax(String s, String[] tryLottos){
        int N = tryLottos.length;
        int L = tryLottos[0].length();
        int K = s.length();
        int max = 0;
        
        for(int i =0; i < N; i++){
            String lotto = tryLottos[i];
            for(int j = 0; j <= L - K; j++){
                StringBuilder sb = new StringBuilder();
                for(int q = 0; q < K ; q++){
                    sb.append(lotto.charAt(j + q));
                }
                if(s.equals(sb.toString()))
                    max++;
            }
        }
        
        return max;
    }

    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        Stringlotto34803 object = new Stringlotto34803();
        int L = sc.nextInt(); // 문자열 길이
        int N = sc.nextInt(); // 문자열 개수
        sc.nextLine();
        String[] tryLottos = new String[N];
        
        for(int i =0; i < N; i++){
            String lotto = sc.nextLine();
            tryLottos[i] = lotto;
        }
        int K = sc.nextInt();
        
        int max = 0;
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= L - K; j++){
                StringBuilder sb = new StringBuilder();
                for(int q = 0; q < K; q++){
                    sb.append(tryLottos[i].charAt(j+q));
                }
                String s = sb.toString();
                int newMax =object.findMax(s, tryLottos);
                if(max < newMax){
                    max = newMax;
                }
            }
        }
        
        System.out.print(max);
    }
}
