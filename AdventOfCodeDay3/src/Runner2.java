import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner2 {

    static int total = 0;

    // Method to extract and multiply mul instructions from a string
    public static int extractMul(String input) {
        // Regular expression to match mul(X,Y) where X and Y are integers
        String regex = "mul\\((\\d+),(\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            // Extract the two numbers from the matched groups
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));

            // Perform the multiplication and add the result to the total
            int result = x * y;
            total += result;
        }
        return total;
    }

    public static void main(String[] args) {
        File file = new File("input.txt");
        boolean enabled = true; // Initially, mul instructions are enabled

        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNext()) {
                String current = scan.next();

                // Check and process the "do()" and "don't()" instructions first
                if (current.equals("do()")) {
                    enabled = true;  // Enable future mul instructions
                } else if (current.equals("don't()")) {
                    enabled = false; // Disable future mul instructions
                }

                // Only process mul instructions if enabled
                if (enabled) {
                    extractMul(current); // Add the result of the multiplication
                }
            }

            System.out.println("The total is: " + total); // Output the final total

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
