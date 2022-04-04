package practice04;

public class Main {

    public static String solution(int[] keyLog) {
        final int BACK_SAPCE = 0;
        final int SHIFT = 16;
        final int CAPS_LOCK = 20;
        final int SPACE_BAR = 32;
        final int KEY_LEFT = 37;
        final int KEY_RIGHT = 39;
        final int INSERT = 155;
        final int DELETE = 127;

        StringBuffer sb = new StringBuffer();

        int step = (int)('a' - 'A');

        int curSor =0;
        int cmdIdx = 0;
        boolean isShift = false;
        boolean isCapsLock = false;
        boolean isInsert = false;

        while(cmdIdx != keyLog.length) {
            int cur = keyLog[cmdIdx];

            if(cur == BACK_SAPCE) {
                if(curSor == 0) {
                    cmdIdx++;
                    continue;
                }
                sb.delete(curSor-1 , curSor);
                curSor = Math.max(0, curSor -1);
            } else if (cur == SHIFT) {
                isShift = true;
            } else if (cur == CAPS_LOCK) {
                isCapsLock = !isCapsLock;
            } else if (cur == SPACE_BAR) {
                // 공백 문자 넣기
                inputData(sb, ' ', curSor, isInsert);
                curSor += 1;
            } else if (cur == KEY_LEFT) {
                curSor = Math.max(0, curSor-1);
            } else if (cur == KEY_RIGHT) {
                curSor = Math.min(sb.length(), curSor + 1);
            } else if (cur == INSERT) {
                isInsert = !isInsert;
            } else if (cur == DELETE) {
                if(curSor == sb.length()) {
                    cmdIdx++;
                    continue;
                }
                sb.delete(curSor, curSor + 1);
            } else if (cur >= 97 && cur <= 122) {
                int data = cur;

                if (isCapsLock && isShift) {
                    data = cur;
                } else if (isCapsLock || isShift) {
                    data -= step;
                }
                // 데이터 입력
                inputData(sb, (char)data, curSor, isInsert );

                isShift = false;
                curSor += 1;
            } else if (cur >= 48 && cur <= 57) {
                if(isShift) {
                    char[] spacialKey = { ')', '!' ,'@', '#', '$', '%', '^', '&', '*', '('  };
                    inputData(sb, spacialKey[cur -'0'], curSor, isInsert);
                } else {
                    inputData(sb, (char) cur, curSor, isInsert);
                }
                isShift = false;
                curSor += 1;
            }

            cmdIdx++;
        }

        return sb.toString();
    }

    public static void inputData(StringBuffer sb, char data, int curSor, boolean isInsert) {
        if(isInsert == false) {
            sb.insert(curSor, data);
        } else {
            sb.setCharAt(curSor, data);
        }
    }


    public static void main(String[] args) {
        // Test Code
        int[] keyLog = {16, 106, 101, 108, 108, 111, 37, 37, 37, 37, 37, 155, 16, 104};
        System.out.println(solution(keyLog));

        keyLog = new int[]{ 20, 104, 16, 105, 32, 20, 16, 106, 97, 118, 97 };
        System.out.println(solution(keyLog));

        keyLog = new int[]{ 49, 51, 8, 50, 51, 53, 55, 37, 37, 127, 127, 52, 53};
        System.out.println(solution(keyLog));

        keyLog = new int[]{20, 97, 98, 16, 99, 16, 100, 16, 49, 16, 50, 16, 51};
        System.out.println(solution(keyLog));

    }

}
