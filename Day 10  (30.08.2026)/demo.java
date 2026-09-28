import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MyFrame extends JFrame{
	/*JButton btnExit;*/
	JTextField txtTitle;
	MyFrame(){
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		/*btnExit=new JButton("Exit");
		btnExit.setFont(new Font("",1,30));
		btnExit.addMouseListener(new ButtonClock());
		add(btnExit);*/
		
		txtTitle = new JTextField(12);
		txtTitle.setFont(new Font("",1,30));
		txtTitle.addKeyListener(new TextFiledListener());
		add(txtTitle);
	}
}

/*class ButtonClock implements ActionListener{
	public void actionPerformed(ActionEvent evt){
		System.out.println("Exited...");
		System.exit(0); 
		}
	}*/
	
/*class ButtonClock implements MouseListener{
	public void mouseExited(MouseEvent evt){
		System.out.println("Mouse Exited...");
	}
	public void mouseEntered(MouseEvent evt){
		System.out.println("Mouse Entered...");
	}
	public void mouseReleased(MouseEvent evt){
		System.out.println("Mouse relesed...");
	}
	public void mousePressed(MouseEvent evt){
		System.out.println("Mouse Pressed...");
	}
	public void mouseClicked(MouseEvent evt){
		System.out.println("Mouse Clicked...");
	}
}*/

class TextFiledListener implements KeyListener{
	public void keyReleased(KeyEvent evt){
		System.out.println("keyReleased");
	}	
	public void keyPressed(KeyEvent evt){
		System.out.println("keyPressed");
	}	
	public void keyTyped(KeyEvent evt){
		System.out.println("keyTyped");
	}	
}


	
class demo{	
	public static void main(String args[]){
		new MyFrame().setVisible(true);
	}	
}

