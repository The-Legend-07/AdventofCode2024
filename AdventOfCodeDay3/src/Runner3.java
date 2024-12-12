import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner3 {
    
    static int total = 0; // To store the total of the valid multiplications
    static boolean enabled = true; // Initially, mul instructions are enabled

    // Method to extract mul instructions and process them based on enabled flag
    public static void extractMul(String input) {
        // Regular expression to match mul(X,Y) where X and Y are integers
        String regex = "mul\\((\\d+),(\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            // Only process mul instructions if they are enabled
            if (enabled) {
                // Extract the two numbers from the matched groups
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));

                // Perform the multiplication and add the result to the total
                int result = x * y;
                total += result;
            }
        }
    }

    // Method to check for do() and don't() instructions
    public static void checkDoDont(String input) {
        // Check if the input contains do() or don't()
        if (input.contains("do()")) {
            enabled = true;  // Enable mul instructions
        }
        if (input.contains("don't()")) {
            enabled = false; // Disable mul instructions
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File file = new File("input.txt");

        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNext()) {
                String current = scan.next(); // Read each token (word) in the file
                
                // Check for do() or don't() instructions
                checkDoDont(current);
                
                // Extract and process any mul() instructions
                extractMul(current);
            }

            // Print the final total result
            System.out.println("The total is: " + total);

        } catch (FileNotFoundException e) {
            // Handle file not found exception
            e.printStackTrace();
        }
    }
}
