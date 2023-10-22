
import java.util.ArrayList;


public class Poisson {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Point> arrayList = new ArrayList<Point>();
	 	arrayList.add(new Point(0, 278));
	 	arrayList.add(new Point(1, 92));
	 	arrayList.add(new Point(2, 25));
	 	arrayList.add(new Point(3, 4));
	 	arrayList.add(new Point(4, 0));
	 	arrayList.add(new Point(5, 0));
	 	arrayList.add(new Point(6, 1));
	 	
	 	
	 	double z = getAverage(arrayList);
	 	double[] observedP = getObservedP(arrayList);
	 	
	 	System.out.println("Occurences :");
	 	for (int i =0; i<arrayList.size(); i++ ){
	 	System.out.println(arrayList.get(i).getY()); 	
	 	}
	 	
	 	System.out.println("Observed Probablities :");
	 	for (int i =0; i<arrayList.size(); i++ ){
	 		System.out.println(observedP[i]); 
		 	}
	 	
	 	System.out.println("Poissoon Probably for numbers of camper :");
	 	for (int i =0; i<arrayList.size(); i++ ){
	 		System.out.println(i + " is " + getPoisson(i, z) ); 	
		 	}
		
	 	System.out.println("Poissoon Probably for numbers of camper :");
	 	for (int i =0; i<arrayList.size(); i++ ){
	 		System.out.println(i + " is " + getPoisson(i, z)*400 ); 	
		 	}
	 	
	}
	
	public static double getAverage(ArrayList<Point> arry){
		
		double totalCampers = 0;
		double totalSquare = 0;
		
		for (Point element: arry){
			totalCampers += (element.x * element.y);
			totalSquare += element.y;
		}  
		return totalCampers/totalSquare;
	}
	
	public static double getPoisson(double k,double z){		
		return Math.exp(-z)*Math.pow(z, k)/getFac(k);
	}
	
	public static double getFac(double z){
		double t =1;
		for(int i=1; i<=z;i++){
			i *=i;
			t=i;
		}
		return t;
	}
	
	public static double[] getObservedP(ArrayList<Point> arry){
		
		double[] ObservedP = new double[arry.size()];
		double totalSquare = 0;
		
		for (Point element: arry){
			totalSquare += element.y;
		}  
		
		
		for (int i= 0; i<arry.size(); i++){
			ObservedP[i] = arry.get(i).getY()/totalSquare;
		}
		
		return ObservedP;
	}

}
