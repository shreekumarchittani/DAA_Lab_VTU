package programs;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Program2b {
	
	public static void main(String[] args) {
		
		String name;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Name and Date_of_Birth in the format <Name,DD/MM/YYYY>");
		name = scan.next();

		// create stringTokenizer with delimiter "/"
		StringTokenizer st = new StringTokenizer(name, ",/");

		// Count the number of tokens
		int count = st.countTokens();

		// Print one token at a time and induce new delimiter ","
		for (int i = 1; i <= count && st.hasMoreTokens(); i++) {
			System.out.print(st.nextToken());
			if (i < count)
				System.out.print(",");
		}
	}
}
