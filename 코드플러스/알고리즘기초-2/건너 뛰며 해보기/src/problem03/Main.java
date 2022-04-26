package problem03;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int ans = 0;
            for (int l1=1; l1<=3; l1++) {
                if (l1 == n) {
                    ans += 1;
                }
                for (int l2=1; l2<=3; l2++) {
                    if (l1+l2 == n) {
                        ans += 1;
                    }
                    for (int l3=1; l3<=3; l3++) {
                        if (l1+l2+l3 == n) {
                            ans += 1;
                        }
                        for (int l4=1; l4<=3; l4++) {
                            if (l1+l2+l3+l4 == n) {
                                ans += 1;
                            }
                            for (int l5=1; l5<=3; l5++) {
                                if (l1+l2+l3+l4+l5 == n) {
                                    ans += 1;
                                }
                                for (int l6=1; l6<=3; l6++) {
                                    if (l1+l2+l3+l4+l5+l6 == n) {
                                        ans += 1;
                                    }
                                    for (int l7=1; l7<=3; l7++) {
                                        if (l1+l2+l3+l4+l5+l6+l7 == n) {
                                            ans += 1;
                                        }
                                        for (int l8=1; l8<=3; l8++) {
                                            if (l1+l2+l3+l4+l5+l6+l7+l8 == n) {
                                                ans += 1;
                                            }
                                            for (int l9=1; l9<=3; l9++) {
                                                if (l1+l2+l3+l4+l5+l6+l7+l8+l9 == n) {
                                                    ans += 1;
                                                }
                                                for (int l0=1; l0<=3; l0++) {
                                                    if (l1+l2+l3+l4+l5+l6+l7+l8+l9+l0 == n) {
                                                        ans += 1;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
