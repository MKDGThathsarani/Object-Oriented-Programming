import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
class Calculator extends JFrame{
	private JButton btExit;
	private JTextField txtTitle;
	private JSlider slider;
	Calculator(String title){
		setTitle(title);
		setSize(300,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		btExit=new JButton("Exit");
		btExit.setFont(new Font("",1,25));
		btExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				
			}
		});
		add(btExit);
		
		txtTitle=new JTextField(12);
		txtTitle.setFont(new Font("",1,25));
		txtTitle.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent evt){
				String title=txtTitle.getText();
				setTitle(title);
			}
		});
		add(txtTitle);
		
		slider=new JSlider(1,10,200,100);
		slider.setFont(new Font("",1,25));
		slider.setPaintLabels(true);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value=slider.getValue();
				txtTitle.setText(value+"");
			}
		});
		add(slider);
	}
} 
class Demo1{
	public static void main(String args[]){
		Calculator c1=new Calculator("Calculator");
		c1.setVisible(true);
	}
}
