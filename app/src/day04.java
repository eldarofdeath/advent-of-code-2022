import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract class day04 {
    static void run() {
        BufferedReader reader;
        int sumOfFullyContainedRanges = 0;
        int sumOfFullyIntersected = 0;
        try {
            reader = new BufferedReader(new FileReader("app/resources/day4.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] elves = line.split(",");
                List<Integer> firstElf = createElfList(elves[0]);
                List<Integer> secondElf = createElfList(elves[1]);
                if (firstElf.containsAll(secondElf) || secondElf.containsAll(firstElf)){
                    sumOfFullyContainedRanges+=1;
                }
                for (Integer x : firstElf){
                    if (secondElf.contains(x)){
                        sumOfFullyIntersected+=1;
                        break;
                    }
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("How many assignment pairs does one range fully contain the other? " + sumOfFullyContainedRanges);
        System.out.println("In how many assignment pairs do the ranges overlap? " + sumOfFullyIntersected);
    }

    private static List<Integer> createElfList(String elfSchedule) {
        List<Integer> elfList = new ArrayList<>();
        String[] interval = elfSchedule.split("-");
        for (int i = Integer.parseInt(interval[0]); i <= Integer.parseInt(interval[1]); i++) {
            elfList.add(i);
        }
        return elfList;
    }

}
