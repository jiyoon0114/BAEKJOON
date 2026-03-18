import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Pos{
    int x;
    int y;
    int count;

    public Pos(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class Tomato7576{
    int bfs(int[][] RipeFruit, boolean[][] visited, Queue<Pos> queue, int notRipetomato) {

        int count = 0; // 토마토 다 익을때까지 날짜

        int[][] direction = {
                {0, 1}, // 밑
                {0, -1}, // 위
                {1, 0}, // 오른
                {-1,0} // 왼쪽
            };

        int M = RipeFruit[1].length;
        int N = RipeFruit.length;

        while(!queue.isEmpty()){
            Pos RipeTomato = queue.poll();
            int currentX = RipeTomato.x;
            int currentY = RipeTomato.y;
            int currentCount = RipeTomato.count;
            
            for(int i=0; i < 4; i++) {
                Pos SoonRipe = new Pos(currentX + direction[i][0], currentY + direction[i][1], currentCount + 1);
                int SoonX = SoonRipe.x;
                int SoonY = SoonRipe.y;
                int SoonCount = SoonRipe.count;
                
                if(SoonX < 0 || SoonX>=M || SoonY<0 || SoonY>=N) continue;

                if(RipeFruit[SoonY][SoonX] == -1) continue;
                
                if(visited[SoonY][SoonX] == false) {
                    queue.add(SoonRipe);
                    visited[SoonY][SoonX] = true;
                    count = SoonCount;
                    --notRipetomato;
                }
            }
        }

        if(notRipetomato == 0)
            return count;
        else
            return -1;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tomato7576 main = new Tomato7576();
        Queue<Pos> queue = new LinkedList<>();
        int notRipetomato =0;

        String[] MN = br.readLine().split(" ");

        int M = Integer.parseInt(MN[0]); // 열
        int N = Integer.parseInt(MN[1]); // 행
        boolean[][] visited = new boolean[N][M];

        int[][] RipeFruit = new int[N][M];
        
        //박스 안 토마토 정보 저장
        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                String ToN = str[j];
                if(ToN.equals("0")) {
                    RipeFruit[i][j] = 0; // 0은 익지 않은 토마토
                    ++notRipetomato;
                }
                else if(ToN.equals("1")) {
                    RipeFruit[i][j] = 1; //1은 익은 토마토
                    Pos RipeTomato = new Pos(j, i, 0);
                    queue.add(RipeTomato);
                    visited[i][j] = true;
                }
                else {
                    RipeFruit[i][j] = -1; // -1은 토마토가 들어있지 않은 칸
                }
            }
        }

        int result = main.bfs(RipeFruit, visited, queue, notRipetomato);

        System.out.print(result);

    }
}