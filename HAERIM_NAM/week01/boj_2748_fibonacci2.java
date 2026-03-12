import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in))

    int n = Integer.parseInt(br.readLine());
    if (n==0) {
        System.out.println(0);
        return;
    }

    long prev = 0;
    long curr = 1;

    for (int i = 2; i <= n; i++) {
        long next = prev + curr;
        prev = curr;
        curr = next;

    }

    System.out.println(curr);
}