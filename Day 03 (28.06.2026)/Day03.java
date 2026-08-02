import javax.swing.*;
import java.awt.*;

class Day03{
	public static void main(String args[]){
		JFrame f1=new JFrame("Calculator");	
		f1.setSize(300,300);
		f1.setLocationRelativeTo(null);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton b1=new JButton("North");
		b1.setText("Hello");
		b1.setFont(new Font("",1,30));
		f1.add("North",b1);
		
		
		JButton b2=new JButton("South");
		b2.setText("Hello");
		b2.setFont(new Font("",1,30));
		f1.add("South",b2);
		
		
		JButton b3=new JButton("East");
		b3.setText("Hello");
		b3.setFont(new Font("",1,30));
		f1.add("East",b3);
		
		
		JButton b4=new JButton("West");
		b4.setText("Hello");
		b4.setFont(new Font("",1,30));
		f1.add("West",b4);
		
		
		JButton b5=new JButton("Center");
		b5.setText("Hello");
		b5.setFont(new Font("",1,30));
		f1.add("Center",b5);
		
		f1.setVisible(true);
		
	}
}
