import javax.swing.*;
import java.awt.*;

class Q85_86{
	public static void main(String args[]){
		JFrame f1=new JFrame("Calculator");	
		f1.setSize(300,300);
		f1.setLocationRelativeTo(null);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton[] btArray=new JButton[5];
		String[] buttonText={"North","South","East","West","Center"}; 
		
		for (int i = 0; i < 5; i++){
			btArray[i]=new JButton(buttonText[i]);
			btArray[i].setSize(300,400);
			btArray[i].setFont(new Font("",1,30));
			f1.add(buttonText[i],btArray[i]);
		}
		f1.pack();
		f1.setVisible(true);
	}
}
