import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
class SearchStudentForm  extends JFrame{
	private JTextField txtStudentId;
	private JTextField txtName;
	private JTextField txtPrfMarks;
	private JTextField txtDbmsMarks;
	
	private JButton btCancel;
	private JButton btSearch;
	
	SearchStudentForm(){
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel titleLabel=new JLabel("Search Student Form");
		titleLabel.setFont(new Font("",1,27));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		add("North",titleLabel);
		//-------------------------------------------------------------
		
		JPanel southPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btSearch=new JButton("Search Student");
		btCancel=new JButton("Cancel");
		btSearch.setFont(new Font("",1,20));
		btSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					Scanner input=new Scanner(new File("Student.txt"));
					String id=txtStudentId.getText();
					String[] rowData=null;
					while(input.hasNext()){
						String line=input.nextLine();
						rowData=line.split(",");
						if(rowData[0].equalsIgnoreCase(id)){
							break;
						}
					}
					txtName.setText(rowData[1]);
					txtPrfMarks.setText(rowData[2]);
					txtDbmsMarks.setText(rowData[3]);
				}catch(IOException ex){}
				
			}
		});
		btCancel.setFont(new Font("",1,20));
		
		southPanel.add(btSearch);
		southPanel.add(btCancel);
		add("South",southPanel);
		//-------------------------------------------------------------
		
		JLabel lblStudentId=new JLabel("Student ID");
		JLabel lblName=new JLabel("Name");
		JLabel lblPrfMarks=new JLabel("Prf Marks");
		JLabel lblDbmsMarks=new JLabel("Dbms Marks");
		lblStudentId.setFont(new Font("",1,20));
		lblName.setFont(new Font("",1,20));
		lblPrfMarks.setFont(new Font("",1,20));
		lblDbmsMarks.setFont(new Font("",1,20));
		
		JPanel labelPanel=new JPanel(new GridLayout(4,1));
		JPanel idTextPanal=new JPanel(new FlowLayout(FlowLayout.LEFT));
		labelPanel.add(lblStudentId);
		labelPanel.add(lblName);
		labelPanel.add(lblPrfMarks);
		labelPanel.add(lblDbmsMarks);
		add("West",labelPanel);
		
		//-------------------------------------------------------------
		txtStudentId=new JTextField(5);
		txtStudentId.setFont(new Font("",1,20));
		txtName=new JTextField(10);
		txtName.setFont(new Font("",1,20));
		txtPrfMarks=new JTextField(4);
		txtPrfMarks.setFont(new Font("",1,20));
		txtDbmsMarks=new JTextField(4);
		txtDbmsMarks.setFont(new Font("",1,20));
		
		JPanel textPanel=new JPanel(new GridLayout(4,1));
		
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		idTextPanal.add(txtStudentId);
		textPanel.add(idTextPanal);
		
		JPanel nameTextPanal=new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameTextPanal.add(txtName);
		textPanel.add(nameTextPanal);
		
		JPanel prfMarksTextPanal=new JPanel(new FlowLayout(FlowLayout.LEFT));
		prfMarksTextPanal.add(txtPrfMarks);
		textPanel.add(prfMarksTextPanal);
		
		JPanel dbmsMarksTextPanal=new JPanel(new FlowLayout(FlowLayout.LEFT));
		dbmsMarksTextPanal.add(txtDbmsMarks);
		textPanel.add(dbmsMarksTextPanal);
		add("Center",textPanel);
	}
}
