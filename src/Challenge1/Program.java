package Challenge1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
    public static void solution(String input) {
        // your code goes here

        int yellowInBowl = 12;
        int greenInBowl = 13;
        int blueInBowl = 14;

        String[] lines = input.split("\n");
        int sumID = 0;

        for (String line : lines) {
            List<Integer> sums = findColorSums(line);
            int sumBlue = sums.get(0);
            int sumGreen = sums.get(1);
            int sumYellow = sums.get(2);

            if (sumBlue <= blueInBowl && sumGreen <= greenInBowl && sumYellow <= yellowInBowl) {
                sumID += findId(line);
            }
        }

        System.out.println(sumID);
    }

    public static int findId(String inputString) {
        Pattern pattern = Pattern.compile("Game (\\d+):");
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            return 0;
        }
    }

    public static List<Integer> findColorSums(String inputString) {
        int sumBlue = 0, sumYellow = 0, sumGreen = 0;
        Pattern pattern = Pattern.compile("(\\d+)\\s+(\\w+)");
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group(1));
            String color = matcher.group(2);

            switch (color) {
                case "blue" -> sumBlue += number;
                case "yellow" -> sumYellow += number;
                case "green" -> sumGreen += number;
            }
        }
        List<Integer> sums = new ArrayList<>();
        sums.add(sumBlue);
        sums.add(sumGreen);
        sums.add(sumYellow);

        return sums;
    }

    // do not modify the code bellow this line
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfLines; i++) {
            input += scanner.nextLine();
            if (i < numberOfLines - 1) {
                input += "\n";
            }
        }

        solution(input);
        scanner.close();
    }
}