package Week3;


public class LightBulb {

	private int life;
	private boolean state;
	
	//The constructor build the life attribute of the bulb as member variable/
	public LightBulb(int life) {
        setLifetime(life);
        setState();
	}
	
	//This method checks whether or not this bulb is broken/
	public boolean isBroken(){  
		if (getLifetime()>=1)
		{System.out.println("The bulb is still work!");
		return true;}
		else {System.out.println("The bulb is broken!");
			return false;
		}
	}
	//This method returns the state of light bulb/
	public boolean isState(){
		if (getState() && getLifetime()>0)
		{ System.out.println("The bulb is on");
			return true;}

		else {System.out.println("The bulb is off");
			return false;}
	}
    //This method to return the lifetime of the bulb/
	public int getLifetime()  
	{
		return this.life;
	}
	//This method to change the value of the bulb's life time/
	public void changeState()
	{
		state=!state;
	}
    //set the lifetime of the light bulb
	public void setLifetime(int newLifetime){
		if (newLifetime<0)
			System.out.println("The lifetime of the light bulb should not be negative number!");
		else this.life=newLifetime;
	}
	//Get the state of the light bulb
	public boolean getState(){
		return state;
	}
	//Print out the remaining bulb lifetime
	public void printLifetime(){
		System.out.println("The bulb still have "+life+" times to switch.");
	}
	//Initialize the bulb state to false
	private void setState()
	{
		this.state=false;
	}

	}


