import java.util.*;
import java.io.*;

public class Numbercard10816 {

    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Numbercard10816 Numbercard = new Numbercard10816();

        String N = br.readLine();
        int n = Integer.parseInt(N);

        String Sangcard = br.readLine();
        StringTokenizer st = new StringTokenizer(Sangcard);

        Map<Integer,Integer> SangCards = Numbercard.getMap(st, n);

        String M = br.readLine();
        int m = Integer.parseInt(M);
        String card = br.readLine();
        StringTokenizer st2 = new StringTokenizer(card);

        int[] Cardnums = Numbercard.getArray(st2, m);

        Numbercard.printsb(sb, SangCards, Cardnums, m);
    }

    public Map<Integer,Integer> getMap(StringTokenizer st, int n){
        Map<Integer,Integer> SangCards = new HashMap<>();

        for(int i =0; i<n; i++) {
            Integer key = Integer.valueOf(st.nextToken());
            if(SangCards.containsKey(key)) {
                Integer CurrentValue = SangCards.get(key);
                SangCards.put(key, ++CurrentValue);
            }
            else
                SangCards.put(key, 1);
        }
        return SangCards;
    }

    public int[] getArray(StringTokenizer st2, int m){
        int[] Cardnums = new int[m];
        for(int i=0; i<m; i++) {
            Cardnums[i] = Integer.parseInt(st2.nextToken());
        }
        return Cardnums;
    }

    public void printsb(StringBuilder sb, Map<Integer,Integer> SangCards, int[] Cardnums, int m){
        for(int i=0; i<m; i++) {
            if(SangCards.containsKey(Cardnums[i])) {
                sb.append(SangCards.get(Cardnums[i]));
                sb.append(" ");
            }
            else {
                sb.append("0");
                sb.append(" ");
            }
        }

        System.out.print(sb);
    }
}

