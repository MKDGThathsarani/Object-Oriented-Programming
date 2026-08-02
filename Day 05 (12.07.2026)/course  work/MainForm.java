import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MainForm  extends JFrame{
	private JButton btAddStudent;
	private JButton btSearchStudent;
	private JButton btViewStudent;
	private JButton btExit;
	private StudentList studentList;
	
	MainForm(){
		setSize(500,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		studentList=new StudentList();
		JLabel titleLabel=new JLabel("Student' Marks Management System");
		titleLabel.setFont(new Font("",1,27));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		add("North",titleLabel);
		//-------------------------------------------------------------
		
		JPanel buttonPanel=new JPanel(new GridLayout(3,1));
		btAddStudent=new JButton("Add Student Form");
		btAddStudent.setFont(new Font("",1,20));
		btAddStudent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new AddStudentForm(studentList).setVisible(true);
			}
		});
		buttonPanel.add(btAddStudent);
		
		btViewStudent=new JButton("View Student Form");
		btViewStudent.setFont(new Font("",1,20));
		buttonPanel.add(btViewStudent);
		
		btSearchStudent=new JButton("Search Student Form");
		btSearchStudent.setFont(new Font("",1,20));
		buttonPanel.add(btSearchStudent);
		btSearchStudent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new SearchStudentForm(studentList).setVisible(true);
			}
		});
		btExit=new JButton("Exit");
		btExit.setFont(new Font("",1,20));
		buttonPanel.add(btExit);
		add("Center",buttonPanel);
	}
	public static void main(String args[]){
		new MainForm().setVisible(true);	
	}
}

