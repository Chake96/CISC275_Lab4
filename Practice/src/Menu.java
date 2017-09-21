import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	private String init(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Choose from the Following:\n"
				+ " 1) Create Random List and Sort\n"
				+ " 2) Create Specific List and Sort\n"
				+ " 3) TBD");
		String u_input = sc.next();
		
		return u_input;
	}
	
	
	public static void main(String[] args) throws IOException{
		
		
	}
	

}


