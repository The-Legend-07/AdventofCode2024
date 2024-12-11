import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		
		
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		
		// TODO Auto-generated method stub
	
//this part gets the data from the file and puts it into an arrayList		
		
		File file = new File("input.txt");
		
		try {
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNext()) {
				//read in 2 ints per iteration
				int first = scanner.nextInt();
				int second = scanner.nextInt();
				
				//add the two numbers to their respective lists
				left.add(first);
				right.add(second);
			}
			
//			//for testing only, let's print the lists
//			System.out.println(left);
//			System.out.println(right);
			
		//1) perform a sequential search in the left list to look for the smallest element
			
			int sum = 0;			
			
			while(left.size()>0) {
				
				int smallest = left.get(0);
				int smallestIndex = 0;
				
				//now look for something smaller than the current smallest
				for (int i = 0; i < left.size(); i++) {
					
					if (left.get(i) < smallest) {
						smallest = left.get(i);
						smallestIndex = i;
					}
					
				}
		
				//remove the smallest value found so it won't be in the list next time
				left.remove(smallestIndex);
//				System.out.println(smallest);
				
				int smallest2 = right.get(0);
				int smallestIndex2 = 0;
				
				for (int i = 0; i < right.size(); i++) {
					
					if (right.get(i) < smallest2) {
						smallest2 = right.get(i);
						smallestIndex2 = i;
					}
					
				}
				
				right.remove(smallestIndex2);
//				System.out.println(smallest2);
				
				System.out.println("difference is: " + Math.abs(smallest - smallest2));
				sum+=  Math.abs(smallest - smallest2);
				
				
			}
			
			System.out.println("sum is: " + sum);
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
