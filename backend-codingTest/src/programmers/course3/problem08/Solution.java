package programmers.course3.problem08;

public class Solution {
    private int ret;
    private int[][] dir;
    private boolean[][] map;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        ret = Integer.MAX_VALUE;
        dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        map = new boolean[102][102];

        for(int[] rect : rectangle) {
            int x1=rect[0]*2, y1=rect[1]*2, x2=rect[2]*2, y2=rect[3]*2;
            for(int i=x1 ; i<=x2 ; i++) {
                for(int j=y1 ; j<=y2 ; j++) {
                    map[i][j] = true;
                }
            }
        }
        helper(characterX*2, characterY*2, itemX*2, itemY*2, new boolean[102][102], 0);
        return ret/2;
    }

    public void helper(int cx, int cy, int ix, int iy, boolean[][] visit, int cnt) {
        if(cx==ix && cy==iy) {
            ret = Math.min(ret, cnt);
            return;
        }
        if(ret<=cnt || !check(cx, cy, map, visit)) {
            return;
        }
        visit[cx][cy] = true;
        for(int[] d : dir) {
            helper(cx+d[0], cy+d[1], ix, iy, visit, cnt+1);
        }
        visit[cx][cy] = false;
    }

    public boolean check(int i, int j, boolean[][] map, boolean[][] visit) {
        if(visit[i][j] || !map[i][j]) return false;
        int[][] dir = new int[][]{{1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1}};
        for(int[] d : dir) {
            if(!map[i+d[0]][j+d[1]]) return true;
        }
        return false;
    }


}
