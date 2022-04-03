interface CompareTool {
    public abstract int getMaxNum(int num1, int num2);
}

public class Pratice {
    public static void main(String[] args) {
        // test Code
        CompareTool cTool = new CompareTool() {
            @Override
            public int getMaxNum(int num1, int num2) {
                return num1 > num2 ? num1 : num2;
            }
        };
        System.out.println(cTool.getMaxNum(10, 11));

        // 람다식
        CompareTool cTool2 = (x, y) -> x > y ? x : y;
        System.out.println(cTool2.getMaxNum(10, 11));

    }
}
