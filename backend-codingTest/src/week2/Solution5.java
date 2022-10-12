package week2;

import java.util.Arrays;

public class Solution5 {

    public int[][] solution (int[][] image, int K) {
        int n = (K - 1) / 2;
        int N = K*K;
        int height = image.length;
        int width = image[0].length;

        SlidingWindow window = new SlidingWindow(K);
        int[][] result = new int[height][width];

        int[] values = new int[K];
        int[] removed;

        int windowSum = 0;
        for (int i = 0; i < K - 1; i++) {
            for (int j = 0; j < K; j++) {
                int val = 0;
                int iImage = -n + i;
                int jImage = -n + j;

                if (iImage >= 0 && iImage < height &&
                    jImage >= 0 && jImage < width) {
                    val = image[iImage][jImage];
                }
                values[j] = val;
            }
            removed = window.shiftDown(values);
            windowSum -= Arrays.stream(removed).sum();
            windowSum += Arrays.stream(values).sum();
        }

        int j = -1;
        for (int i = 0; i < height; i++)
        {
            for (int jWin = 0; jWin < K; jWin++)
            {
                int val = 0;
                int iImage = i + n;
                int jImage;

                if (i % 2 == 0)
                {
                    j = 0;
                    jImage = -n + jWin;
                } else {
                    j = width - 1;
                    jImage = width - 1 - n + jWin;
                }

                if (iImage >= 0 && iImage < height &&
                    jImage >= 0 && jImage < width)
                {
                    val = image[iImage][jImage];
                }
                values[jWin] = val;
            }

            removed = window.shiftDown(values);
            windowSum -= Arrays.stream(removed).sum();
            windowSum += Arrays.stream(values).sum();

            result[i][j] = windowSum / N;

            if (i % 2 == 0)
            {
                for (j = 1; j < width; j++)
                {
                    for (int iWin = 0; iWin < K; iWin++)
                    {
                        int val = 0;
                        int jImage = j + n;
                        int iImage = i - n + iWin;

                        if (iImage >= 0 && iImage < height &&
                            jImage >= 0 && jImage < width)
                        {
                            val = image[iImage][jImage];
                        }
                        values[iWin] = val;
                    }

                    removed = window.shiftRight(values);
                    windowSum -= Arrays.stream(removed).sum();
                    windowSum += Arrays.stream(values).sum();

                    result[i][j] = windowSum / N;
                }
            }
            else
            {
                for (j = width - 2; j >= 0; j--)
                {
                    for (int iWin = 0; iWin < K; iWin++)
                    {
                        int val = 0;
                        int jImage = j - n;
                        int iImage = i - n + iWin;

                        if (iImage >= 0 && iImage < height &&
                            jImage >= 0 && jImage < width)
                        {
                            val = image[iImage][jImage];
                        }
                        values[iWin] = val;
                    }

                    removed = window.shiftLeft(values);
                    windowSum -= Arrays.stream(removed).sum();
                    windowSum += Arrays.stream(values).sum();

                    result[i][j] = windowSum / N;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();

        int[][] array = solution5.solution(new int[][] {
            {4, 5, 2, 6, 7},
            {5, 4, 2, 4, 6},
            {6, 8, 4, 8, 7},
            {7, 3, 6, 6, 4},
            {5, 0, 4, 1, 5}}
            , 3);

        for(int[] arr : array) {
            System.out.println(Arrays.toString( arr ));
        }
    }

}


class Node {
    int value = 0;
    Node bottom = null;
    Node right = null;

    Node () {}

    Node (int value) {
        this.value = value;
    }
}

class SlidingWindow {
    int K;
    Node head = null;

    SlidingWindow(int K) {
        this.K = K;
        this.head = new Node();

        Node curr = this.head;
        for (int i = 0; i < K - 1; i++) {
            curr.right = new Node();
            curr = curr.right;
        }

        Node upper_first = this.head;
        for (int i = 0; i < K - 1; i++) {
            Node upper = upper_first;
            upper.bottom = new Node();
            curr = upper.bottom;
            for (int j = 0; j < K - 1; j++) {
                upper = upper.right;
                upper.bottom = new Node();

                curr.right = upper.bottom;
                curr = curr.right;
            }
            upper_first = upper_first.bottom;
        }

    }

    int[] shiftRight (int[] values) {
        Node left = this.head;
        for (int i = 0; i < this.K - 1; i++) {
            left = left.right;
        }

        left.right = new Node(values[0]);
        Node curr = left.right;
        for (int i = 1; i < this.K; i++) {
            left = left.bottom;
            left.right = new Node(values[i]);

            curr.bottom = left.right;
            curr = curr.bottom;
        }

        int[] removed = new int[this.K];
        curr = this.head;
        for (int i = 0; i < this.K; i++) {
            removed[i] = curr.value;
            curr = curr.bottom;
        }

        this.head = this.head.right;
        return removed;
    }

    int[] shiftLeft (int[] values) {
        Node right = this.head;
        this.head = new Node(values[0]);
        this.head.right = right;
        Node curr = this.head;
        for (int i = 1; i < this.K; i++) {
            right = right.bottom;

            curr.bottom = new Node(values[i]);
            curr = curr.bottom;
            curr.right = right;
        }

        curr = this.head;
        for (int i = 0; i < this.K; i++) {
            curr = curr.right;
        }

        int[] removed = new int[this.K];
        for (int i = 0; i < this.K; i++) {
            removed[i] = curr.value;
            curr = curr.bottom;
        }

        curr = this.head;
        for (int i = 0; i < this.K - 1; i++) {
            curr = curr.right;
        }

        for (int i = 0; i < this.K; i++) {
            curr.right = null;
            curr = curr.bottom;
        }

        return removed;
    }

    int[] shiftDown (int[] values) {
        Node upper = this.head;
        for (int i = 0; i < this.K - 1; i++) {
            upper = upper.bottom;
        }

        upper.bottom = new Node(values[0]);
        Node curr = upper.bottom;
        for (int i = 1; i < this.K; i++) {
            upper = upper.right;
            upper.bottom = new Node(values[i]);

            curr.right = upper.bottom;
            curr = curr.right;
        }

        curr = this.head;
        int[] removed = new int[this.K];
        for (int i = 0; i < this.K; i++) {
            removed[i] = curr.value;
            curr = curr.right;
        }

        this.head = this.head.bottom;
        return removed;
    }
}
