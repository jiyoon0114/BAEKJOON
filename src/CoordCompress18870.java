import java.io.*;
import java.util.*;

class Num {
    int result;
    int value;
    int order;

    public Num(int value, int order) {
        this.value = value;
        this.order = order;
    }
}

public class CoordCompress18870 {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        List<Num> list = new ArrayList<>(n);
        String numbers = br.readLine();
        StringTokenizer st = new StringTokenizer(numbers);
        for (int i = 0; i < n; i++) {
            list.add(new Num(Integer.parseInt(st.nextToken()), i));
        }

        list.sort(new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                return o1.value - o2.value;
            }
        });

        Num pre = list.get(0);
        pre.result = 0;
        int rank = 0;

        for (int i = 1; i < n; i++) {
            Num Number = list.get(i);
            if (pre.value == Number.value) {
                Number.result = rank;
            } else {
                rank++;
                Number.result = rank;
                pre = Number;
            }
        }

        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            Num Number = list.get(i);
            end[Number.order] = Number.result;
        }
        for (int i = 0; i < n; i++) {
            sb.append(end[i]);
            sb.append(' ');
        }

        System.out.print(sb);

    }
}
