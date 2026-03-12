import java.util.*;

public class FirstNandM15649 {
    
    public void dfs(int depth, int[] result, boolean[] visited, StringBuilder sb){
        if(depth == result.length){
            for(int i =0; i < result.length; i++){
                sb.append(result[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        else{
            for(int i = 1; i <= visited.length -1; i++){
                if(visited[i] == false){
                    visited[i] = true;
                    result[depth] = i;
                    dfs(depth+1, result, visited, sb);
                    visited[i] = false;
                }
            }
        }
    }
    
    public static void main(String[] args){
        FirstNandM15649 NandM = new FirstNandM15649();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int N = sc.nextInt(); //  숫자 범위
        int M = sc.nextInt(); //수열 길이
        
        boolean[] visited = new boolean[N+1]; //i 숫자 사용하면 i 인덱스는 true
        int[] result = new int[M];
        int depth = 0;
        
        NandM.dfs(depth, result, visited, sb);
        
        System.out.print(sb);
    }
}
