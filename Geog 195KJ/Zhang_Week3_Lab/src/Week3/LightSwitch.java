package Week3;

public class LightSwitch {
  
	private int switchtime;  
	private boolean state;
	private LightBulb nBulb;
	
	//The constructor build a bulb, switch's state, and the attribute of occurrences of the switch uses as member variables/
public LightSwitch(LightBulb nBulb){
	   setSwitchtime(0);
	   setBulb(nBulb);
	   setState();
	}
    
    //This method return the state of the light switch/
public boolean isState() {
	  if (getState()){
		   System.out.println("The switch is on");
		   return state;
		} 
		  else{
			System.out.println("The switch is off");
			return state;
		}
	}
  
   //This method change the life time of the bulb and the occurrence of the switch uses/
public void useSwitch() {
		
	 if (nBulb.getLifetime()>=1)
	 {
		nBulb.setLifetime(nBulb.getLifetime()-1);
		setSwitchtime(getSwitchtime() + 1);
		changeState();
		nBulb.changeState();
	 }
	 
	 else {System.out.println("Since This bulb is broken! Even though you use the switch, the bulb is still off! o(¨s¡õ¨t)o");
	       setSwitchtime(getSwitchtime() + 1);
	       changeState();
	 }
  }

  //Get the state of the switch only for light bulb class to be used
public boolean getState() {
	  return this.state;
  }
  //Switch the switch state
public void changeState() {
	  state=!state;
  }
  //Set the light bulb
public void setBulb(LightBulb nBulb) {
	  this.nBulb=nBulb;
  }
//Get the switch time
public int getSwitchtime() {
	return switchtime;
}
//Initialize the switch time
public void setSwitchtime(int switchtime) {
	this.switchtime = switchtime;
}
//Initialize the bulb state to false
private void setState(){
	this.state=false;
}
//Replace the old light bulb
public void replaceLightBulb(LightBulb lb) {
        nBulb=lb;}


}

