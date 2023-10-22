package Week3;

public class LightBulb {

	private int life;
	
	
	//The constructor build the life attribute of the bulb as member variable/
	public LightBulb(int life) {
		this.life=life;
		
	}
	
	//This method checks whether or not this bulb is broken/
	public boolean isBroken(){  
		if (this.life>=1)
		{System.out.println("The bulb is still work!");
		return true;}
		else {System.out.println("The bulb is broken!");
			return false;
		}
	}
	//This method returns the state of light bulb/
	public boolean isState(LightSwitch Switches){
		if (Switches.getState()==true && life>=1)
		{ System.out.println("The bulb is on");
			return true;}
		else if (life<0)
		{System.out.println("Life time cannot be a negative number!");
		    return false;}
		else {System.out.println("The bulb is off");
			return false;}
	}
    //This method to return the lifetime of the bulb/
	public int getLifetime()  
	{
		return this.life;
	}
	//This method to change the value of the bulb's life time/
	public void setLifetime(int newLifetime){
		this.life=newLifetime;
	}
	//Print out the remaining bulb lifetime
	public void printLifetime(){
		System.out.println("The bulb still have "+life+" times to switch.");
	}
}

