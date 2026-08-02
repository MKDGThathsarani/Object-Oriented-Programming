import javax.swing.*;
import java.awt.*;
class Calculator extends JFrame{
	private JButton btNorth;
	
	Calculator(String title){
		setTitle(title);
		setSize(300,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btNorth=new JButton("North");
		btNorth.setFont(new Font("",1,25));
		add("North",btNorth);
	}
} 
class Demo{
	public static void main(String args[]){
		Calculator c1=new Calculator("Calculator");
		c1.setVisible(true);
	}
}
