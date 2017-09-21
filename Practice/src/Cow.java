import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Cow {

	public String name;
	
	Cow(){
		name = "name";
	}
	
	public String toString(){
		return this.name;
	}
	
	
//	public static void main(String[] args0){
//		Collection<Cow> cows = new ArrayList<Cow>();
//		cows.add(new Cow());
//		cows.add(new Cow());
//		for(Cow curr : cows){
//			System.out.println(curr.toString());
//		}
//		System.out.println(cows.toString());
//		
//	}
 
	
	public static void main(String[] args){
		final int LENGTH = 670;
		final int NUMS_PER_ROW = 30;
		int[] data = new int[LENGTH];
		int count = 0;
		
		for(int i = 0; i < LENGTH; i++) {
			data[i] = count; 
			count += 4;
		}
		
		for(int i = 0; i < LENGTH; i++){
			if(i % NUMS_PER_ROW == 0 && i >= NUMS_PER_ROW) System.out.print("\n\nNew Set:\n" + data[i]);
			else System.out.print(data[i] + "|");
		}
		
	}
	
}
