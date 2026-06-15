class Box{
	//-------attributes declarations--------
	private int length;
	private int width;
	private int height;
	
	//-------methods declarations--------
	public void printVolume(){
		int volume;
		volume=length*width*height;
		System.out.println("Volume of the box : "+volume);
	}
	public void setSize(int length, int width, int height){
		this.length=length;
		this.width=width;
		this.height=height;
	}
	public void setLength(int length){
		this.length=length;
	}
	public void setHeight(int height){
		this.height=height;
	}
	public void setWidth(int width){
		this.width=width;
	}
	public int getLength(){
		return this.length; //return length;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
}
class Demo{
	public static void main(String args[]){
		Box b1=new Box();
		b1.setSize(12,5,3);
		b1.printVolume(); //180
		System.out.println("Length : "+b1.getLength()); //12
		System.out.println("Width  : "+b1.getWidth()); //5
		System.out.println("Height : "+b1.getHeight()); //3
		
		b1.setLength(180); //b1.length=180; //Illegal
	}
}
