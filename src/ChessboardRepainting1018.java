import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ChessboardRepainting1018 {

    public int[] getMN(BufferedReader br) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] MN = {M, N};
        return MN;
    }

    public char[][] getBoard(BufferedReader br, int M, int N) throws Exception{
        char[][] BlackandWhite = new char[M][N];

        for(int i =0; i<M; i++){
            String board = br.readLine();
            for(int j =0; j<N; j++){
                BlackandWhite[i][j] = board.charAt(j);
            }
        }
        return BlackandWhite;
    }

    public int getResult(int M, int N, char[][] BlackandWhite){
        int result = Integer.MAX_VALUE;

        for(int i =0; i<M-7; i++){
            for(int j=0; j<N-7; j++){
                int repaint1 = 0; // first W
                int repaint2 = 0; // first B

                for(int k =i; k<8+i; k++){
                    for(int h =j; h<8+j; h++){

                        if( ((k-i)+(h-j)) % 2 == 0){
                            if(BlackandWhite[k][h] == 'W')
                                repaint2++;
                            else
                                repaint1++;
                        }

                        else if( ((k-i) + (h-j)) % 2 == 1){
                            if(BlackandWhite[k][h] == 'W')
                                repaint1++;
                            else
                                repaint2++;
                        }
                    }
                }
                int repaint = Math.min(repaint1,repaint2);
                result = Math.min(repaint, result);
            }
        }
        return result;
    }

    public static void main(String[]args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ChessboardRepainting1018 ChessboardRepainting = new ChessboardRepainting1018();

        int[] MN = ChessboardRepainting.getMN(br);
        int M = MN[0];
        int N = MN[1];

        char[][] BlackandWhite = ChessboardRepainting.getBoard(br, M,N);
        int result = ChessboardRepainting.getResult(M,N,BlackandWhite);

        System.out.print(result);
    }
}
