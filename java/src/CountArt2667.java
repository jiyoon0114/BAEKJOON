import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

//아파트 좌표 위치
class Pos{
    int x;
    int y;

    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }   
}

class Count{
    ArrayList<Integer> bfs(boolean[][] apartments){
        ArrayList<Integer> countComplex = new ArrayList<>();
        Queue<Pos> queue = new LinkedList<>();
        int N = apartments.length;
        boolean[][] visited = new boolean[N][N];

        int direction[][] = {
            {1, 0}, //밑
            {-1, 0}, //위
            {0, -1}, //왼
            {0, 1} //오
        };

        for(int i = 0; i < N; i++){ // y
            for(int j =0; j < N; j++){ // x
                if(apartments[i][j] == true && visited[i][j] == false){
                    int apartmentNum = 1; // 단지 내 아파트 수
                    Pos Apartment = new Pos(j, i);
                    queue.add(Apartment);
                    visited[i][j] = true;

                    while(!queue.isEmpty()){
                        Pos Art = queue.poll();
                        int ArtX = Art.x;
                        int ArtY = Art.y;

                        for(int k = 0; k < 4; k++){
                            Pos sameComplexArt = new Pos(ArtX+direction[k][1], ArtY+direction[k][0]);
                            int sameArtX = sameComplexArt.x;
                            int sameArtY = sameComplexArt.y;
                            
                            if(sameArtX<0 || sameArtX >= N || sameArtY < 0 || sameArtY >=N ){
                                continue;
                            }

                            if(apartments[sameArtY][sameArtX] == false || visited[sameArtY][sameArtX] == true) {
                                continue;
                            }
                            
                            queue.add(sameComplexArt);
                            apartmentNum++;
                            visited[sameArtY][sameArtX] = true;
                        }
                    }
                    countComplex.add(apartmentNum);
                }
            }
        }
        
        return countComplex;
    }
}

public class CountArt2667 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        boolean[][] apartments = new boolean[N][N];
        Count Count = new Count();

        //아파트 있는 쪽 정보 저장
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j =0; j < N; j++){
                char ToN = str.charAt(j);
                if(ToN=='0'){
                    apartments[i][j] = false;
                }
                else {
                    apartments[i][j] = true;
                }
            }
        }

        ArrayList<Integer> countComplex = Count.bfs(apartments);

        countComplex.sort(Comparator.naturalOrder());

        sb.append(countComplex.size());
        for(int i =0; i < countComplex.size(); i++){
            sb.append("\n");
            sb.append(countComplex.get(i));
        }

        System.out.print(sb);
    }
}
