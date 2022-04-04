package practice01;

import java.util.HashMap;

public class Main {

    public static void solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < arr.length - 1 ; i++) {
            if(map.get(arr[i]) < map.get(arr[i + 1])) {
                sum -= map.get(arr[i]);
            } else {
                sum += map.get(arr[i]);
            }
        }
        sum += map.get(arr[arr.length - 1]);
        System.out.println(sum);
    }

    public static void main(String[] args) {

        // Test Code
        solution("III");
        solution("IV");
        solution("VI");
        solution("XIII");
        solution("XXVI");
        solution("MCMXCIV");

    }
}
