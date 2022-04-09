package problem06;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> primes = new ArrayList<Integer>();
        boolean[] check = new boolean[1000001];

        for(int i = 2; i <= 1000000 ; i++) {
            if(check[i] == false) {
                primes.add(i);
                for(int j = i+i ; j <= 1000000; j+=i) {
                    check[j] = true;
                }
            }
        }
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int ans = 0;
            for(int p : primes) {
                if(n-p >= 2 && p <= n-p) {
                    if(check[n-p] == false) {
                        ans += 1;
                    }
                } else {
                    break;
                }
            }
            System.out.println(ans);
        }

    }
}
