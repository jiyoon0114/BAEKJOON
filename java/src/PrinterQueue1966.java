// 1966번
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

class Document {
    int importance;
    boolean isWonder;

    public Document(int importance, boolean isWonder){
        this.importance = importance;
        this.isWonder = isWonder;
    }
}

public class PrinterQueue1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        
        int testCaseNum = Integer.parseInt(br.readLine());
        Deque<Document> printer = new ArrayDeque<>();
        
        for(int i = 0; i < testCaseNum; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int documentNum = Integer.parseInt(st.nextToken());
            int wonderDocument = Integer.parseInt(st.nextToken());

            ArrayList<Integer> importantArr = new ArrayList<>();
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
            
            for(int j = 0; j < documentNum; j++) {
                int importance = Integer.parseInt(st2.nextToken());
                if (j == wonderDocument) {
                    Document Doc = new Document(importance, true);
                    importantArr.add(importance);
                    //문서들 큐의 앞부분에 저장함 -> 그럼 뺄땐 뒤에서부터 빼야함
                    printer.addFirst(Doc);
                }
                else {
                    Document Doc = new Document(importance, false);
                    importantArr.add(importance);
                    printer.addFirst(Doc);
                }
              }
              Collections.sort(importantArr);
              //중요도 높은게 맨뒤에 있도록 정렬
              int order = 0;
              while(!printer.isEmpty()) {
                  Document PickDoc = printer.pollLast();
                  // 현재 프린터에 더 중요도가 높은 문서가 있는 경우
                  if(PickDoc.importance < importantArr.get(importantArr.size() - 1)) {
                      printer.addFirst(PickDoc);
                  }
                  else {
                      importantArr.remove(importantArr.size() - 1);
                      order++;
                      if(PickDoc.isWonder) {
                          sb.append(order);
                          sb.append("\n");
                      }
                  }
            }
            
        }
        System.out.print(sb);
    }
}
