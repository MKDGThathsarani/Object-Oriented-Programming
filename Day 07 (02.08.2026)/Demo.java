import java.util.*;
class WaterLevelObserver{
	public void update(int waterLevel){
		
	}
}
class Alarm extends WaterLevelObserver{
	public void update(int waterLevel){
		System.out.println(waterLevel>=50 ? "Alarm ON":"Alarm OFF");
	}
}
class Display extends WaterLevelObserver{
	public void update(int waterLevel){
		System.out.println("WaterLevel : "+waterLevel);
	}
}
class SMSSender extends WaterLevelObserver{
	public void update(int waterLevel){
		System.out.println("Sending water level : "+waterLevel);
	}
}
class ControlRoom{
	private WaterLevelObserver[] observerArray=new WaterLevelObserver[0]; 
	
	private int waterLevel;
	
	public void addWaterLevelObserver(WaterLevelObserver ob){
		extendsArray();
		observerArray[observerArray.length-1]=ob;
	}
	private void extendsArray(){
		WaterLevelObserver[] tempObserverArray=new WaterLevelObserver[observerArray.length+1];
		for (int i = 0; i < observerArray.length; i++){
			tempObserverArray[i]=observerArray[i]; 
		}
		observerArray=tempObserverArray;
		
	}
	
	public void setWaterLevel(int waterLevel){
		if(this.waterLevel!=waterLevel){
			this.waterLevel=waterLevel;
		}
		for(int i=0; i<observerArray.length; i++){
			observerArray[i].update(waterLevel);
		}
	}
}


class Demo{	
	public static void main(String args[]){
		ControlRoom controlRoom=new ControlRoom();
		controlRoom.addWaterLevelObserver(new Alarm());
		controlRoom.addWaterLevelObserver(new Display());
		controlRoom.addWaterLevelObserver(new SMSSender());
		
		Random r=new Random();
		while(true){
			int waterLevel=r.nextInt(101); //0 to 100
			controlRoom.setWaterLevel(waterLevel);
			try{Thread.sleep(1000);}catch(Exception ex){}
			System.out.println();
		}	
	}
}
