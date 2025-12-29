import java.util.Scanner;
public class Star2447 {
    
    public void star(int n, boolean[][] box) {
        int size = n;
        while(size >= 1){
            for(int i =0; i < n; i+= size){
                for(int j =0; j < n; j+= size){
                    smallstar(size, i, j, box);
                }
            }
            size = size/ 3;
        }
        
    }
    
    public void smallstar (int size, int x, int y, boolean[][] box){
        int count = size/3;
        for (int j = count; j < 2 * count; j++) {
            for (int k = count; k < 2 * count; k++) {
                box[j+x][k+y] = true;
            }
        }
    }
    
    
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        Star2447 star = new Star2447();
        int n = sc.nextInt();
        boolean[][] box = new boolean[n][n];
        star.star(n, box);
        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                if(box[i][j] == true){
                    sb.append(" ");
                    continue;
                }
                else
                    sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
