package Week3;


public class test1 {


	public static void main(String[] args) {
		  System.out.println("********Create a bulb with 5 lifetime Bulb A********");
	      LightBulb aBulb=new LightBulb(5);   //Create an object of the light bulb with life time of 5
	      System.out.println("********Create a light switch********");
	      LightSwitch aSwitch=new LightSwitch(aBulb);  //Create an object of the light switch
	      System.out.println("********Create a bulb with -10 lifetime Bulb B********");
	      LightBulb bBulb=new LightBulb(-10);
	      
	      System.out.println("********Check the lifetime of the Bulb A********");
	      aBulb.printLifetime();    //Print out the initial life time of the bulb
	      System.out.println("********Use the switch for three times********");
	      aSwitch.useSwitch();   //Use the switch for three times
	      aSwitch.useSwitch();   
	      aSwitch.useSwitch();

	      System.out.println("********Check the lifetime of the Bulb A********");
	      aBulb.printLifetime();   //Print out the life time after use the switch for five times
	      System.out.println("********Check the switch's state********");
	      aSwitch.isState();   //Print out the switch's state. Now, when the bulb is broken, the switch might be on.
	      System.out.println("********Check the Bulb A's state********");
	      aBulb.isState();   //Print out the bulb's state
	      System.out.println("********Check the Bulb B's state********");
	      bBulb.isState();   //Print out the second invaild bulb's state
	      System.out.println("********Use the switch twice more********");
	      aSwitch.useSwitch();   //Use the switch for two more times until it broken
	      aSwitch.useSwitch();
	      System.out.println("********Check the lifetime of the Bulb A********");
	      aBulb.printLifetime();   //Print out the life time after use the switch for five times
	      System.out.println("********Check the switch's state********");
	      aSwitch.isState();   //Print out the switch's state
	      System.out.println("********Check the Bulb A's state********");
	      aBulb.isState();   //Print out the bulb's state
	      System.out.println("********Check the Bulb A's broken condition********");
	      aBulb.isBroken();     //Print out the light bulb's broken state
 
	      System.out.println("********Use the switch one more time********");
	      aSwitch.useSwitch();   //Use the switch one more time
	      System.out.println("********Check the lifetime of the Bulb A********");
	      aBulb.printLifetime();  //Print out the life time of the new bulb after one time used
	      System.out.println("********Check the switch's state********");
	      aSwitch.isState();   //Print out the switch's state
	      System.out.println("********Check the Bulb A's state********");
	      aBulb.isState();    //Print out the bulb's state
	      System.out.println("********Replace Bulb C onto Bulb A********");
	      LightBulb cBulb=new LightBulb(15);   //The bulb C has 15 lifetime
	      aSwitch.replaceLightBulb(cBulb);     //replace a new bulb
	      System.out.println("********Print Bulb C's life time********");
          cBulb.printLifetime();    //Print out the life time after the bulb replacement
          System.out.println("********Check Bulb C's state********");
          cBulb.isState();   //Print out the bulb's state
          System.out.println("********Check Switch's state********");
          aSwitch.isState();  //Print out the switch's state
          System.out.println("********Use the switch one more time********");
	      aSwitch.useSwitch();   //Use the switch one times
	      System.out.println("********Print Bulb C's life time********");
	      cBulb.printLifetime();
	      System.out.println("********Check Bulb C's state********");
          cBulb.isState();   //Print out the bulb's state
          System.out.println("********Check Switch's state********");
          aSwitch.isState();  //Print out the switch's state
          System.out.println("********Use the switch sixteen more time********");
          for(int i=0;i<16;i++){
        	  aSwitch.useSwitch();
          }
          cBulb.printLifetime();
          cBulb.isState();
          aSwitch.isState();
	}

}
