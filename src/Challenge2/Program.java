package Challenge2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
    public static void solution(String input) {
        List<Integer> minMarbles = findMinMarblesNeededByColor(input);
        String[] lines = input.split("\n");
        int power = 0;

        for (String line : lines) {
            List<Integer> minMarblesForLine = findMinMarblesNeededByColor(line);
            int blueMarbles = minMarblesForLine.get(0);
            int greenMarbles = minMarblesForLine.get(1);
            int yellowMarbles = minMarblesForLine.get(2);
            power += (blueMarbles * yellowMarbles * greenMarbles);
        }

        System.out.println(power);

    }
    public static List<Integer> findMinMarblesNeededByColor(String input) {
        int minBlue = 0;
        int minGreen = 0;
        int minYellow = 0;

        Pattern pattern = Pattern.compile("(\\d+)\\s+(\\w+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group(1));
            String color = matcher.group(2);

            switch (color) {
                case "blue" -> minBlue = Math.max(minBlue, number);
                case "green" -> minGreen = Math.max(minGreen, number);
                case "yellow" -> minYellow = Math.max(minYellow, number);
            }
        }

        List<Integer> minMarblesNeeded = new ArrayList<>();
        minMarblesNeeded.add(minBlue);
        minMarblesNeeded.add(minGreen);
        minMarblesNeeded.add(minYellow);

        return minMarblesNeeded;
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