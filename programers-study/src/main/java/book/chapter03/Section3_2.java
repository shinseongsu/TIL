package book.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Ax + By + C = 0 으로 표현할 수 있는 n개의 직선이 주어질떄, 이 직선의 교점 중 정수 좌표에 별을 그리려 합니다.
 * 예를 들어 다음과 같은 직선 5개를
 * 2x - y + 4 = 0
 * -2x - y + 4 = 0
 * -y + 1 = 0
 * 5x - 8y - 12 = 0
 * 5x + 8y + 12 = 0
 *
 * 이때 모든 교점의 좌표는 (4,1), (4,-4), (-4,-4), (-4,1), (0,4), (1.5, 1.0), (2.1, -0.19), (0., -1.5), (-2.1, -0.19), (-1.5, 1.0) 입니다.
 * 이 중 정수로만 표현되는 좌표는 (4,1), (4,-4), (-4,-4), (-4,1), (0,4) 입니다.
 * 만약 정수로 표현되는 교점에 별을 그리면 다음과 같습니다.
 *
 */
public class Section3_2 {

    private class Point {
        public final long x, y;
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        if ( x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long) x, (long) y);
    }

    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MIN_VALUE;

        for(Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }

        return new Point(x, y);
    }

    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for(Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }

        return new Point(x, y);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        // 교점 구하기
        for (int i = 0 ; i < line.length; i++) {
            for(int j = i + 1 ; j < line.length ; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2],
                                                  line[j][0], line[j][1], line[j][2]);

                if(intersection != null) {
                    points.add(intersection);
                }
            }
        }

        Point minimum = getMinimumPoint(points); // 최대 좌표
        Point maximum = getMaximumPoint(points); // 최소 좌표

        int width = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - maximum.y + 1);

        char[][] arr = new char[height][width];
        for(char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for (Point p : points) {
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);
            arr[y][x] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0 ; i < result.length ; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }

}