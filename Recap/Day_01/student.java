class Students{
	String name;
	int age;
	String city;
	
	public Students(String name,int age, String city){
		this.name = name;
		this.age = age;
		this.city = city;
		}
		
		public void display(){
			System.out.println("Name: " + name);
			System.out.println("Age: " + age);
			System.out.println("City: " + city);
			}
		}
		
		public class student{
			public static void main(String args[]){
				Students s1 = new Students("Kmal",10,"Sri Lanka");
				Students s2 = new Students("Nimal",10,"Sri Lanka");
				Students s3 = new Students("Sunil",10,"Sri Lanka");
				
				s1.display();
				s2.display();
			}
	}
