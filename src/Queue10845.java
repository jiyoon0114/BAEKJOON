import java.io.*;

class Myqueue{
    int[] queue;
    int head = 0, tail =0;

    public Myqueue(int[] queue) {
        this.queue = queue;
    }

    public void push(int x) {
        queue[tail] = x;
        tail++;
    }

    public int size() {
        return tail - head;
    }

    public int empty() {
        if(tail == head)
            return 1;
        else
            return 0;
    }

    public int front() {
        if(empty() == 1)
            return -1;
        else
            return queue[head];
    }

    public int back() {
        if(empty() ==1)
            return -1;
        else
            return queue[tail-1];
    }

    public int pop() {
        if(empty() == 1) {
            return -1;
        }
        else {
            int popnum;
            if(empty() ==1) {
                return -1;
            }
            else {
                popnum = queue[head];
                head++;
            }
            return popnum;
        }
    }
}


public class Queue10845 {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] queue = new int[n];
        Myqueue Myq = new Myqueue(queue);

        for(int i=0; i<n; i++) {
            String command = br.readLine();

            if(command.startsWith("push")) {
                String[] str = command.split(" ");
                int num = Integer.parseInt(str[1]);
                Myq.push(num);
            }
            else if(command.equals("size")) {
                sb.append(Myq.size());
                sb.append("\n");
            }
            else if(command.equals("empty")) {
                sb.append(Myq.empty());
                sb.append("\n");
            }
            else if(command.equals("pop")) {
                sb.append(Myq.pop());
                sb.append("\n");
            }
            else if(command.equals("front")) {
                sb.append(Myq.front());
                sb.append("\n");
            }
            else if(command.equals("back")) {
                sb.append(Myq.back());
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
