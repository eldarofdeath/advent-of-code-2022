import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

abstract class day02 {
    static void run() {
        BufferedReader reader;
        Map<String, Map<String, Integer>> firstStrategyMap = firstStrategy();
        Map<String, Map<String, Integer>> secondStrategyMap = secondStrategy();
        int firstStrategyPoints = 0;
        int secondStrategyPoints = 0;
        try {
            reader = new BufferedReader(new FileReader("app/resources/day2.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] rps = line.split(" ");
                firstStrategyPoints += firstStrategyMap.get(rps[0]).get(rps[1]);
                secondStrategyPoints += secondStrategyMap.get(rps[0]).get(rps[1]);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total points for my first strategy: " + firstStrategyPoints);
        System.out.println("Total points for my second strategy: " + secondStrategyPoints);
    }

    private static Map<String, Map<String, Integer>> firstStrategy() {
        Map<String, Map<String, Integer>> mapa = new HashMap<>();
        int win = 6;
        int lose = 0;
        int draw = 3;
        mapa.put("A", Map.of("X", draw + 1, "Y", win + 2, "Z", lose + 3));
        mapa.put("B", Map.of("X", lose + 1, "Y", draw + 2, "Z", win + 3));
        mapa.put("C", Map.of("X", win + 1, "Y", lose + 2, "Z", draw + 3));
        return mapa;
    }

    private static Map<String, Map<String, Integer>> secondStrategy() {
        Map<String, Map<String, Integer>> mapa = new HashMap<>();
        int win = 6;
        int lose = 0;
        int draw = 3;
        mapa.put("A", Map.of("X", lose + 3, "Y", draw + 1, "Z", win + 2));
        mapa.put("B", Map.of("X", lose + 1, "Y", draw + 2, "Z", win + 3));
        mapa.put("C", Map.of("X", lose + 2, "Y", draw + 3, "Z", win + 1));
        return mapa;
    }
}
