

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=1;
		a=a+1000000000;
        String aTextingString="";
        for (int i=0;i<3;i++){
        aTextingString+=" what am "+i+"\n";
        }
        System.out.println((char) 65);
        int i = (int) 66.7;
        System.out.println(i);
        int r=add(1,1);
        System.out.println(r);

	}
     public static int add(int a, int b){
    	 return a+b;
     }
}
