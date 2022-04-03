import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Pratice {
    public static void main(String[] args) throws IOException {
        String inputfile = "./JamesArthurGoling.txt";
        String outputFile = "./JamesArthurGoling_deit.txt";

        // 찾을 단어 / 변경 단어 입력 받기
        System.out.print("찾을 단어: ");
        Scanner sc = new Scanner(System.in);
        String find = sc.nextLine();
        System.out.print("단어 변경: ");
        String to = sc.nextLine();

        // 파일 찾기, 변경 및 시작
        BufferedReader br = new BufferedReader(new FileReader(inputfile));
        FileWriter fw = new FileWriter(outputFile);

        while(true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }

            String newLine = line.replace(find, to);
            fw.write(newLine + '\n');
        }

        br.close();
        fw.close();
    }
}
