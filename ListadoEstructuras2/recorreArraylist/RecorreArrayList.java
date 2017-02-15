package recorreArraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class RecorreArrayList {
	
	ArrayList<String> recorrer;
	
	public RecorreArrayList() {
		recorrer = new ArrayList<String>();
	}
	
	void add(String elemento){
		recorrer.add(elemento);
	}
	String show(){
		return recorrer.toString();
	}
	
	void showWithIterator(){
		Iterator<String> it = recorrer.iterator();
		
		while(it.hasNext())
			System.out.println(" \t "+ it.next());
		
	}
	
	void showWithIterator2(){
		for(Iterator<String> it = recorrer.iterator(); it.hasNext();)
			System.out.println(" \t "+ it.next());
		
	}
	
	void showWithGet(){
		for(int i= 0; i< recorrer.size(); i++)
			System.out.println(" \t "+ recorrer.get(i));
		
	}
	
	void showWithForEach(){
		for(String elemento: recorrer)
			System.out.println(" \t "+ elemento);
			
		
	}

}
