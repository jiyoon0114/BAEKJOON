import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Virus2606 {
    public int countingVirus(ArrayList<Integer>[] computers, boolean[] visited, int computerNum){
        ArrayList<Integer> connectComputer = computers[computerNum];
        Iterator<Integer> iterator = connectComputer.iterator();
        int count = 0;
        
        while(iterator.hasNext()){
            int num = iterator.next();
            if(visited[num] == false){
                visited[num] = true;
                count++;
                count += countingVirus(computers,visited, num);
            }
        }
        return count;
    }
    public static void main(String[] arg) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int range = Integer.parseInt(br.readLine());
        int connectNum = Integer.parseInt(br.readLine());
        
        ArrayList<Integer>[] computers = new ArrayList[range + 1];
        boolean[] visited = new boolean[range+1];
        
        for(int i =1; i <= range; i++){
            computers[i] = new ArrayList<>();
        }
        
        for(int i =0; i < connectNum; i++){
            String[] TwoComputers = br.readLine().split(" ");
            int first = Integer.parseInt(TwoComputers[0]);
            int second = Integer.parseInt(TwoComputers[1]);
            
            computers[first].add(second);
            computers[second].add(first);
        }
        
        Virus2606 Virus = new Virus2606();
        visited[1] = true; // 감염된 컴퓨터 수를 count -> 1번 컴퓨터는 제외
        int result = Virus.countingVirus(computers, visited, 1);
        System.out.print(result);
    }
}