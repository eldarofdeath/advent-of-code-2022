import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

abstract class day01 {
    static void run() {
        BufferedReader reader;
        List<Integer> caloriesCarriedByElves = new ArrayList<>();
        try {
            int calories = 0;
            reader = new BufferedReader(new FileReader("app/resources/day1.txt"));
            String line = reader.readLine();

            while (line != null) {
                if ("".equals(line)) {
                    caloriesCarriedByElves.add(calories);
                    calories = 0;
                    line = reader.readLine();
                    continue;
                }
                calories += Integer.parseInt(line);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        caloriesCarriedByElves.sort(Comparator.reverseOrder());
        int top3 = caloriesCarriedByElves.get(0) + caloriesCarriedByElves.get(1) + caloriesCarriedByElves.get(2);
        System.out.println("Max calories carried by elf: " + caloriesCarriedByElves.get(0) + ", top 3 elves carry together: " + top3);
    }
}
