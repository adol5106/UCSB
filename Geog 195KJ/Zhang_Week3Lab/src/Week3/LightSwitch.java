package Week3;



public class LightSwitch {
  
	private int switchtime;  
	private boolean state;
	LightBulb nBulb;
	
	//The constructor build a bulb, switch's state, and the attribute of occurrences of the switch uses as member variables/
  public LightSwitch(LightBulb nBulb){
	   this.switchtime=0;
	   this.nBulb=nBulb;
	}
    
    //This method return the state of the light switch/
  public boolean isState() {
	  if (this.switchtime%2==1 && !(nBulb.getLifetime()<0)){
		   state=true;
		   System.out.println("The switch is on");
		   return state;
		} else if(nBulb.getLifetime()<0)
			{state=false;
			System.out.println("Life time cannot be a negative number!");
			return state;
			}
		  else{
			state=false;
			System.out.println("The switch is off");
			return state;
		}
	}
  
   //This method change the life time of the bulb and the occurrence of the switch uses/
  public void useSwitch() {
		
	 if (nBulb.getLifetime()>=1){
		nBulb.setLifetime(nBulb.getLifetime()-1);
		switchtime++;
	 }
	 else if (nBulb.getLifetime()<0){System.out.println("Life time cannot be a negative number! So it not be able to use the switch!");}
	 else {System.out.println("Since This bulb is broken! Even though you use the switch, the bulb is still off! o(¨s¡õ¨t)o");
	       switchtime++;
	 }
  }
   

  //Get the state of the switch only for lightbulb class to be used
  public boolean getState() {
	  return this.state;
  }

  }

