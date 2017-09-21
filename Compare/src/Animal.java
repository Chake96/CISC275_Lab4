abstract public class Animal {
	
	public String name;
	public int num_legs;
	
	
	public class AnimalCompare implements Comparable{

		@Override
		public int compare(Animal arg0, Animal arg1) {
		
			if(arg0 == arg1) return 0;
			
			else if(arg0.name.length() > arg1.name.length()) return 1;
			
			else if(arg0.name.length() < arg1.name.length()) return -1;
			
			else return (arg0.num_legs - arg1.num_legs);
		}
	}
	
	
}
