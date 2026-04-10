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

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCaseNum = Integer.parseInt(br.readLine());
        Deque<Document> printer = new ArrayDeque<>();
        
        for(int i = 0; i < testCaseNum; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            int documentNum = Integer.parseInt(st.nextToken());
            int wonderDocument = Integer.parseInt(st.nextToken());

            String DocumentNumbers = br.readLine();
            ArrayList<Integer> documentImportantArr = new ArrayList<>();
            
            for(int j = 0; j < documentNum; j++) {
                StringTokenizer st2 = new StringTokenizer(DocumentNumbers," ");
                int importance = Integer.parseInt(st2.nextToken());
                if (j == wonderDocument) {
                    Document doc = new Document(importance, true);
                    documentImportantArr.add(importance);
                    printer.addFirst(doc);
                }
                else {
                    Document doc = new Document(importance, false);
                    documentImportantArr.add(importance);
                    printer.addFirst(doc);
                }
            }
            Collections.sort(documentImportantArr, Collections.reverseOrder());
        }
    }
}
