import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


abstract class day05 {
    static void run() {
        BufferedReader reader;
        List<Stack<String>> crateStacks = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("app/resources/day5.txt"));
            crateStacks = createCrateStacks(reader);
            String line = reader.readLine();
            while (line != null) {
                String x = line;
                x = x.replace("move ", "");
                x = x.replace(" from ", ";");
                x = x.replace(" to ", ";");
                String[] instructions = x.split(";");
                Stack<String> fromStack = crateStacks.get(Integer.parseInt(instructions[1]) - 1);
                Stack<String> toStack = crateStacks.get(Integer.parseInt(instructions[2]) - 1);

                for (int i = 0; i < Integer.parseInt(instructions[0]); i++) {
                    if (fromStack.size() > 0) {
                        toStack.push(fromStack.pop());
                    }
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String cratesOnTopOfEachStack = getCratesOnTopOfEachStack(crateStacks);
        System.out.println("After the rearrangement procedure completes, what crate ends up on top of each stack? " + cratesOnTopOfEachStack);
    }

    static void run2() {
        BufferedReader reader;
        List<Stack<String>> crateStacksPickMultiple = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("app/resources/day5.txt"));
            crateStacksPickMultiple = createCrateStacks(reader);
            String line = reader.readLine();
            while (line != null) {
                String x = line;
                x = x.replace("move ", "");
                x = x.replace(" from ", ";");
                x = x.replace(" to ", ";");
                String[] instructions = x.split(";");

                Stack<String> fromStackPickMultiple = crateStacksPickMultiple.get(Integer.parseInt(instructions[1]) - 1);
                Stack<String> toStackPickMultiple = crateStacksPickMultiple.get(Integer.parseInt(instructions[2]) - 1);
                List<String> thingsToPush = new ArrayList<>();
                for (int i = 0; i < Integer.parseInt(instructions[0]); i++) {
                    if (fromStackPickMultiple.size() > 0) {
                        thingsToPush.add(fromStackPickMultiple.pop());
                    }
                }

                Collections.reverse(thingsToPush);
                for (String psh : thingsToPush) {
                    toStackPickMultiple.push(psh);
                }


                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String cratesOnTopOfEachStackPickMultiple = getCratesOnTopOfEachStack(crateStacksPickMultiple);
        System.out.println("After the rearrangement procedure completes, what crate ends up on top of each stack? " + cratesOnTopOfEachStackPickMultiple);
    }

    private static String getCratesOnTopOfEachStack(List<Stack<String>> crateStacks) {
        String x = "";
        for (Stack<String> stack : crateStacks) {
            if (stack.size() > 0) {
                x += stack.pop();
            }
        }
        return x;
    }

    private static List<Stack<String>> createCrateStacks(BufferedReader reader) throws IOException {
        List<Stack<String>> crateStacks = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lines.add(reader.readLine());
        }
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            indexes.put(i, lines.get(8).indexOf(String.valueOf(i)));
        }
        lines.remove(8);
        lines.remove(8);
        Collections.reverse(lines);
        for (int j = 1; j < 10; j++) {
            Stack<String> stack = new Stack<>();
            for (String lajn : lines) {
                if (indexes.get(j) < lajn.length()) {
                    String x = lajn.substring(indexes.get(j), indexes.get(j) + 1);
                    if (!" ".equals(x)) {
                        stack.push(x);
                    }
                }
            }
            crateStacks.add(stack);
        }
        return crateStacks;
    }

}
