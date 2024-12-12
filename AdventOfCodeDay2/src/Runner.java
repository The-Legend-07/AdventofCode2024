import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int numSafe = 0;
		
		
		File file = new File("input.txt");
		
		try {
			
			Scanner scan = new Scanner(file);
			
			while (scan.hasNextLine()) {
				
				ArrayList<Integer> current = new ArrayList<Integer>();
				
				//these are to temporarily store the line, then put it into an string array with each number separated
				String line = scan.nextLine();
				String[] elements = line.split(" ");
				
				
				/*
				 * String line = scan.nextLine();
				 * 
				 * String[] elements = line.split(" ");
				 * 
				 * for (int i = 0; i < list.length; i++){
				 * 	int el1 = Integer.valueOf(list[i]);
				 * }
				 * 
				 */
				
				//this puts each of those into an arraylist of nums, but it seems we don't even need this
				for (int i = 0; i < elements.length; i++) {
					if (!((elements[i]).equals(" "))) {
						current.add(Integer.valueOf(elements[i]));
					}
				}
//				for (int i = 0; i < working.size(); i++) {
//					current.add(	Integer.valueOf(working.get(i))	);
//				}
				
				
				int incr = 0;
				int decr = 0;
				int errors = 0;
				
				int total = current.size()-1;
				
				
				for (int i = 0; i < current.size() - 1; i++) {
					
					
					if (Math.abs(current.get(i) - current.get(i+1)) > 3) {
						errors++;
						if (errors <= 1) {
							current.remove(i);
						}
					} else if (current.get(i) > current.get(i+1)) {
						decr++;
						//System.out.println("incr: " + incr);
					} else if (current.get(i) < current.get(i+1)) {
						incr++;
						//System.out.println("decr: " + decr);
					} else {
						errors++;
						if (errors <= 1) {
							current.remove(i);
						}
					}
					
					
				}
				
				System.out.println(errors);
				if ((incr >= current.size()-1 || decr >= current.size()-1)) {
					numSafe++;
					System.out.println(incr);
					System.out.println(decr);
					System.out.println("safe");
				}
				
				
			}
			
			
			System.out.println("The number of safe reports is: " + numSafe);
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
