import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OrganicFarm1012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            boolean [][] farm = new boolean[N][M];
            int count = 0; // 배추흰지렁이 수
            OrganicFarm1012 OraganicFarm = new OrganicFarm1012();
            for(int j = 0; j < K; j++){
                StringTokenizer xy = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(xy.nextToken());
                int y = Integer.parseInt(xy.nextToken());
                farm[y][x] = true; // 배추 심어져 있는 위치 true
            }

            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(farm[j][k] == true){
                        //한개의 배추지렁이가 보호하는 위치들
                        OraganicFarm.visit(N, M, j,k,farm);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    void visit(int maxN, int maxM, int N, int K, boolean[][] farm){
        farm[N][K] = false;
        if(N>=1){
            if(farm[N-1][K] == true) {
                farm[N - 1][K] = false;
                visit(maxN,maxM,N-1,K,farm);
            }
        }
        if(K>=1){
            if(farm[N][K-1] == true) {
                farm[N][K - 1] = false;
                visit(maxN, maxM, N,K-1,farm);
            }
        }
        if(N+1 < maxN){
            if(farm[N+1][K] == true) {
                farm[N + 1][K] = false;
                visit(maxN, maxM, N+1, K, farm);
            }
        }
        if(K + 1 < maxM){
            if(farm[N][K+1] == true) {
                farm[N][K + 1] = false;
                visit(maxN, maxM, N,K+1, farm);
            }
        }


    }
}
