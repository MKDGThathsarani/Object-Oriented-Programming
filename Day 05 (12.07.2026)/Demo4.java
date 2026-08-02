import java.util.*;
import java.io.*;
class Demo{
	public static void main(String args[])throws IOException{
		Scanner input=new Scanner(new File("Student.txt"));
		StudentList stList=new StudentList();
		
		String line=input.nextLine();
		while(input.hasNext()){
			String[] rowData=line.split(",");
			String id=rowData[0];
			String name=rowData[1];
			int prf=Integer.parseInt(rowData[2]);
			int dbms=Integer.parseInt(rowData[3]);
			Student student=new Student(id,name,prf,dbms);
			stList.add(student);
			line=input.nextLine();
		}
		
		stList.printList();
	}
}
