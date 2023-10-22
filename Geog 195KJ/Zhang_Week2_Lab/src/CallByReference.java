package edu.ucsb.geog.w2;

public class CallByReference {

	public int aInt;
	
	public static void main(String[] args) {
		Number a = new Number(5);
		
		System.out.println("Before calling addOne on a: "+a.theNumber);
		a.addOne(a);
		System.out.println("Before calling addOne on a: "+a.theNumber);
		
	}
}
