import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Triple{
	
	public int index = -1;
	public int[] container = new int[3];
	
	Triple(){
		this.container[0] = 1;
		this.container[1] = 2;
		this.container[2] = 3;
	}
	
	public MyIter iterator(){
		return new MyIter();
	}
	
	public class MyIter implements Iterator{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stuff
			index = (index % 3 < 2) ? index+1 : 0;
			return container[index];
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		Triple t = new Triple();
		Iterator ti = t.iterator();
		for(int i = 0; i < 10; i++)
		if (ti.hasNext())
		System.out.print(ti.next() + " ");
		System.out.println();
		}// prints 1 2 3 1 2 3 1 2 3 1


	
}