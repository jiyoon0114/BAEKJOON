import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pos{
    int x;
    int y;
    int dis;
    
    public Pos(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

public class Maze2178 {
    
    public static int bfs(boolean[][] maze, boolean[][] visited, int startX, int startY){
        int row = visited.length - 2;
        int column = visited[1].length - 2;
        Queue<Pos> queue = new LinkedList<>();
        Pos LastPoint = new Pos(row, column, 0);
        
        int[][] direction = {
                {-1, 0}, // 왼
                {1, 0}, // 오
                {0, -1}, // 위
                {0, 1} // 아래
        };
        
        Pos StartPoint = new Pos(startX, startY, 1);
        queue.add(StartPoint);
        visited[StartPoint.y][StartPoint.x] = true;
        
        while(!queue.isEmpty()){
            Pos CurrentPoint = queue.poll();
            int x = CurrentPoint.x;
            int y = CurrentPoint.y;
            
            if(x == column && y == row){
                return CurrentPoint.dis;
            }
            
            for(int i = 0; i < 4; i++){
                
                int availableY = y + direction[i][1];
                int availableX = x + direction[i][0];
                
                if((!visited[availableY][availableX]) && maze[availableY][availableX]){
                    Pos AvailablePoint = new Pos(x + direction[i][0], y + direction[i][1], CurrentPoint.dis + 1);
                    queue.add(AvailablePoint);
                    visited[availableY][availableX] = true;
                }
            }
        }
        
        return LastPoint.dis;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] RC = br.readLine().split(" ");
        int row = Integer.parseInt(RC[0]); // y
        int column = Integer.parseInt(RC[1]); // x
        
        boolean[][] maze = new boolean[row+2][column+2]; // 탐색하는 과정에서 범위가 넘치는거 방지
        boolean[][] visited = new boolean[row + 2][column + 2];
        
        //미로 이동 가능 통로 입력받기
        for(int i =1; i <= row; i++){
            String str = br.readLine();
            for(int j = 1; j <= column; j++){
                if(str.charAt(j-1) == '1'){
                    maze[i][j] = true; // true인 경우 이동할 수 있는 칸
                }
                else
                    maze[i][j] = false;
            }
        }
        
        int result = Maze2178.bfs(maze, visited, 1,1);
        
        System.out.print(result);
    }
}
