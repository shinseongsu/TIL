package step1;

public class Calculator {

    private Calculator() { }

    public static int calcSum(String input) {
        String[] numStrArr = Splitter.splitInput(input);
        int[] numArr = Parser.parseNumStrArr(numStrArr);
        return calcSum(numArr);
    }

    private static int calcSum(int[] numArr) {
        int sum = 0;
        for (int num: numArr) {
            sum += num;
        }
        return sum;
    }

}
