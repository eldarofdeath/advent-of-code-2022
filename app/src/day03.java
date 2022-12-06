import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract class day03 {
    static void run() {
        BufferedReader reader;
        int sumOfIndividualPriorities = 0;
        List<List<String>> groups = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("app/resources/day3.txt"));
            String line = reader.readLine();
            List<String> group = new ArrayList<>();
            while (line != null) {
                if (group.size() == 3) {
                    groups.add(group);
                    group = new ArrayList<>();
                }
                group.add(line);
                char character = getEqualChar(line);
                sumOfIndividualPriorities += getIntValueOfChar(character);


                line = reader.readLine();
            }
            groups.add(group);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int sumOfGroupPriorities = evaluateGroupPriorities(groups);
        System.out.println("Sum of priorities of individuals: " + sumOfIndividualPriorities);
        System.out.println("Sum of priorities of groups: " + sumOfGroupPriorities);
    }

    private static char getEqualChar(String line) {
        char retVal = '{';
        String firstSubstring = line.substring(0, line.length() / 2);
        String secondSubstring = line.substring(line.length() / 2, line.length());
        for (char i : firstSubstring.toCharArray()) {
            for (char j : secondSubstring.toCharArray()) {
                if (i == j) {
                    return i;
                }
            }
        }
        return retVal;
    }

    private static int getIntValueOfChar(char character) {
        if ((int) character > 96) {
            return (int) character - 96;
        }
        return (int) character - 38;
    }

    private static int evaluateGroupPriorities(List<List<String>> groups) {
        int sum = 0;
        for (List<String> group : groups) {
            sum+=getEqualCharValueInThreeGroups(group.get(0),group.get(1),group.get(2));
        }
        return sum;
    }

    private static int getEqualCharValueInThreeGroups(String first, String second, String third) {
        for (char i : first.toCharArray()) {
            for (char j : second.toCharArray()) {
                for (char k : third.toCharArray()) {
                    if (i == k && i == j) {
                        return getIntValueOfChar(i);
                    }
                }
            }
        }
        return 0;
    }

}
