import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class EnglishWord20920 {
    public static void main(String[] ags) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);
        
        Map<String, Integer> voca = new HashMap<>();
        
        for(int i =0 ; i < n; i++){
            String word = br.readLine();
            if(voca.containsKey(word)){
                voca.put(word,voca.get(word) + 1);
            }
            else if(word.length()>=m)
                voca.put(word,1);
        }
        
        List<Map.Entry<String,Integer>> list = new ArrayList<>(voca.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    
                    if (o1.getKey().length() != o2.getKey().length()) {
                        return o2.getKey().length() - o1.getKey().length();
                    }
                    else
                        return o1.getKey().compareTo(o2.getKey());
                }
                else{
                    return o2.getValue() - o1.getValue();
                }
            }
            });
        
        for(Map.Entry<String,Integer> entry : list){
            sb.append(entry.getKey());
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
