import java.util.ArrayList;
import java.util.Collections;

public class Dog extends Animal {

	
	Dog(){
		this.name = "none";
	}
	
	public String toString(){
		return this.name + " " + this.num_legs;		
	}

	public static void main(String[] args){
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		dogs.add(new Dog());
		dogs.add(new Dog());
		dogs.add(new Dog());
		dogs.get(1).num_legs = 2;
		System.out.print(dogs);
		
		
		
		Collections.sort(dogs);
		
		System.out.println(dogs);
	}

	
	
}



