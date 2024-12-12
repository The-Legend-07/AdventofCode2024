import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
	
//	public static ArrayList<String> extractMul(String line) {
//		
//
//			
//			ArrayList<String> values = new ArrayList<String>();
//			
//			int start = line.indexOf("mul(");
//			int end = start;
//			if (line.indexOf(")", start) <= start + 7) {
//				end = line.indexOf(")", start);
//			}
//			
//			//Stop - if there is no closing ")" then this is not the one we want
//			
//			if (end != start) {
//				System.out.println(line.substring(start, end+1));
//				values.add( line.substring(start, end+1) );
//			}
//			
//			System.out.println();
//			return values;
//			
//		
//		
//	}
	
	static int total = 0;
	
	public static void extractMul(String input) {
	    // Regular expression to match mul(X,Y) where X and Y are integers
	    String regex = "mul\\((\\d+),(\\d+)\\)";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(input);

	    while (matcher.find()) {
	        // Extract the two numbers from the matched groups
	        int x = Integer.parseInt(matcher.group(1));
	        int y = Integer.parseInt(matcher.group(2));

	        // Perform the multiplication and output the result
	        int result = x * y;
//	        System.out.println("Result: " + result);
	        total+= result;
	    }
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file = new File("input.txt");
		
		try {
			
			Scanner scan = new Scanner(file);
			
			while(scan.hasNext()) {
				String current = scan.next();
			//	System.out.println(current);
			//	System.out.println("-------------");
				extractMul(current);
			}
			
			
			System.out.println("The total is: " + total);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
