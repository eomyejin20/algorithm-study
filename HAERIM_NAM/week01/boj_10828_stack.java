import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stack = new int[n];
        int top = -1;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {

            String[] cmd = br.readLine().split(" ");

            switch (cmd[0]) {

                case "push":
                    int x = Integer.parseInt(cmd[1]);
                    top++;
                    stack[top] = x;
                    break;

                case "pop":
                    if (top == -1) sb.append(-1).append("\n");
                    else {
                        sb.append(stack[top]).append("\n");
                        top--;
                    }
                    break;

                case "size":
                    sb.append(top + 1).append("\n");
                    break;

                case "empty":
                    if (top == -1) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;

                case "top":
                    if (top == -1) sb.append(-1).append("\n");
                    else sb.append(stack[top]).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}