package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(Arrays.stream(s.split(" ")).filter(word->!word.isBlank()).count());
    }
}
