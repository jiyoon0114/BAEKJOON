import java.io.*;

class MyStack{
    int[] stack;
    int tail =0;

    public MyStack(int[] stack) {
        this.stack = stack;
    }

    public void push(int x) {
        stack[tail] = x;
        tail++;
    }

    public int size() {
        return tail;
    }

    public int empty() {
        if(tail == 0)
            return 1;
        else
            return 0;
    }

    public int top() {
        if(empty() ==1)
            return -1;
        else
            return stack[tail-1];
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
                tail--;
                popnum = stack[tail];
            }
            return popnum;
        }
    }
}

public class Stack10828 {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] queue = new int[n];
        MyStack Mys = new MyStack(queue);

        for(int i=0; i<n; i++) {
            String command = br.readLine();

            if(command.startsWith("push")) {
                String[] str = command.split(" ");
                int num = Integer.parseInt(str[1]);
                Mys.push(num);
            }
            else if(command.equals("size")) {
                sb.append(Mys.size());
                sb.append("\n");
            }
            else if(command.equals("empty")) {
                sb.append(Mys.empty());
                sb.append("\n");
            }
            else if(command.equals("pop")) {
                sb.append(Mys.pop());
                sb.append("\n");
            }
            else if(command.equals("top")) {
                sb.append(Mys.top());
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}

