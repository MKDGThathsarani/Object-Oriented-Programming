import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
class UpdateStudentForm  extends JFrame{
	private JTextField txtStudentId;
	private JTextField txtName;
	private JTextField txtPrfMarks;
	private JTextField txtDbmsMarks;
	
	private JButton btCancel;
	private JButton btUpdate;
	
	UpdateStudentForm(){
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel titleLabel=new JLabel("Search Student Form");
		titleLabel.setFont(new Font("",1,27));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		add("North",titleLabel);
		//-------------------------------------------------------------
		
		JPanel southPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btUpdate=new JButton("Update Student");
		btCancel=new JButton("Cancel");
		btUpdate.setFont(new Font("",1,20));
		btUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					File stFile=new File("Student.txt");
					File tempFile=new File("TempStudent.txt");
					FileWriter fw=new FileWriter(tempFile);
					
					Scanner input=new Scanner(stFile);
					String id=txtStudentId.getText();
					String[] rowData=null;
					while(input.hasNext()){
						String line=input.nextLine();
						rowData=line.split(",");
						if(rowData[0].equalsIgnoreCase(id)){
							String newRow=id+","+txtName.getText()+","+txtPrfMarks.getText()+","+txtDbmsMarks.getText();
							fw.write(newRow+"\n");
							fw.flush();
						}else{
							fw.write(line+"\n");
							fw.flush();
						}
					}
					fw.close();
					input.close();
					//--------------------------------------------------------
					fw=new FileWriter("Student.txt");
					input=new Scanner(new File("TempStudent.txt"));
					while(input.hasNext()){
						String line=input.nextLine();
						fw.write(line+"\n");
					}
					fw.close();
					input.close();
					tempFile.delete();
				}catch(IOException ex){}
				
			}
		});
		btCancel.setFont(new Font("",1,20));
		
		southPanel.add(btUpdate);
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
		txtStudentId.addActionListener(new ActionListener(){
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
	public static void main(String args[]){
		new UpdateStudentForm().setVisible(true);
	}
}

