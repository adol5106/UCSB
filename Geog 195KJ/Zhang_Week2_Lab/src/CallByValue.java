

public class CallByValue {


	public static void main(String[] args) {
		
		int a=5;
		System.out.println("Before calling addOne with a: "+a);
		addOne(a);
		System.out.println("After calling addOne with a: "+a);
	}

	public static void addOne(int a) {
		a++;
	}
}
