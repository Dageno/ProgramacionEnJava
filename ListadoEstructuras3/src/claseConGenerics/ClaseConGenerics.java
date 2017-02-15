package claseConGenerics;

import java.util.ArrayList;

public class ClaseConGenerics<T> {
	ArrayList<T> arraylist;
	
	public ClaseConGenerics() {
		arraylist = new ArrayList<T>();
	}
	
	void add(T type){
		arraylist.add(type);
	}
	
	T get(int index){
		return arraylist.get(index);
	}
}
