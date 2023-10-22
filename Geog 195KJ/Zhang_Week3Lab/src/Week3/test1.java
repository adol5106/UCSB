package Week3;

public class test1 {


	public static void main(String[] args) {
		
	      LightBulb aBulb=new LightBulb(5);   //Create an object of the light bulb with life time of 5
	      LightSwitch aSwitch=new LightSwitch(aBulb);  //Create an object of the light switch
	      LightBulb bBulb=new LightBulb(-10);
	      
	      
	      aBulb.printLifetime();    //Print out the initial life time of the bulb
	      
	      aSwitch.useSwitch();   //Use the switch for three times
	      aSwitch.useSwitch();   
	      aSwitch.useSwitch();

	      
	      aBulb.printLifetime();   //Print out the life time after use the switch for five times
	      aSwitch.isState();   //Print out the switch's state. Now, when the bulb is broken, the switch might be on.
	      aBulb.isState(aSwitch);   //Print out the bulb's state
   
	      bBulb.isState(aSwitch);   //Print out the second invaild bulb's state
	      aSwitch.useSwitch();   //Use the switch for two more times until it broken
	      aSwitch.useSwitch();
	      aBulb.printLifetime();   //Print out the life time after use the switch for five times
	      aSwitch.isState();   //Print out the switch's state
	      aBulb.isState(aSwitch);   //Print out the bulb's state
	      aBulb.isBroken();     //Print out the light bulb's broken state
 
	      
	      aSwitch.useSwitch();   //Use the switch one more time
	      aBulb.printLifetime();  //Print out the life time of the new bulb after one time used
	      aSwitch.isState();   //Print out the switch's state
	      aBulb.isState(aSwitch);    //Print out the bulb's state
          

   
	
	}

}
