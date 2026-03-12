import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ScoreAllocator34804 {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] SNM = br.readLine().split(" ");
        int N = Integer.parseInt(SNM[0]); // 수강생 수
        int M = Integer.parseInt(SNM[1]); // 시험 범위 챕터 수
        
        int[] chapterScores = new int[M];
        Map<Integer, String> students = new HashMap<>(); // 학생들이 배운 챕터 정리
        Set<String> OK = new HashSet<>();
        ArrayList<Integer> validChapter = new ArrayList<>();
        
        // 학생들이 공부한 챕터 파악
        for(int i =0; i < N; i++){
            String pattern = br.readLine();
            String[] studyChapter = pattern.split(" ");
           for(int j = 1; j < studyChapter.length; j++){
               validChapter.add(Integer.parseInt(studyChapter[j]));
           }
            students.put(i, pattern);
        }
        
        Iterator<Map.Entry<Integer, String>> student = students.entrySet().iterator();

        while(student.hasNext()){
            String pass = student.next().getValue();
            if(OK.contains(pass)){
                System.out.print(-1);
                break;
            }
            else {
                OK.add(pass);
            }
            
        }
        
        
    }
}
