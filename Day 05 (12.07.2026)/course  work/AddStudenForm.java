import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddStudentForm extends JFrame {
    private JTextField txtStudentId;
    private JTextField txtName;
    private JTextField txtPrfMarks;
    private JTextField txtDbmsMarks;
    
    private JButton btCancel;
    private JButton btAdd;
    
    private StudentList studentList;
    
    AddStudentForm(StudentList studentList) {
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.studentList = studentList;
        
        JLabel titleLabel = new JLabel("Add Student Form");
        titleLabel.setFont(new Font("", 1, 27));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North", titleLabel);
        
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btAdd = new JButton("Add Student");
        btCancel = new JButton("Cancel");
        btAdd.setFont(new Font("", 1, 20));
        btCancel.setFont(new Font("", 1, 20));
        
        btAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    String id = txtStudentId.getText();
                    String name = txtName.getText();
                    int prfMarks = Integer.parseInt(txtPrfMarks.getText());
                    int dbmsMarks = Integer.parseInt(txtDbmsMarks.getText());
                    
                    Student s1 = new Student(id, name, prfMarks, dbmsMarks);
                    studentList.add(s1);
                    
                    JOptionPane.showMessageDialog(null, "Student Added Successfully!");
                    
                    // Clear fields
                    txtStudentId.setText("");
                    txtName.setText("");
                    txtPrfMarks.setText("");
                    txtDbmsMarks.setText("");
                    txtStudentId.requestFocus();
                    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid marks!");
                }
            }
        });
        
        btCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        
        southPanel.add(btAdd);
        southPanel.add(btCancel);
        add("South", southPanel);
        
        // Labels
        JLabel lblStudentId = new JLabel("Student ID");
        JLabel lblName = new JLabel("Name");
        JLabel lblPrfMarks = new JLabel("Prf Marks");
        JLabel lblDbmsMarks = new JLabel("Dbms Marks");
        lblStudentId.setFont(new Font("", 1, 20));
        lblName.setFont(new Font("", 1, 20));
        lblPrfMarks.setFont(new Font("", 1, 20));
        lblDbmsMarks.setFont(new Font("", 1, 20));
        
        JPanel labelPanel = new JPanel(new GridLayout(4, 1));
        labelPanel.add(lblStudentId);
        labelPanel.add(lblName);
        labelPanel.add(lblPrfMarks);
        labelPanel.add(lblDbmsMarks);
        add("West", labelPanel);
        
        // Text Fields
        txtStudentId = new JTextField(5);
        txtStudentId.setFont(new Font("", 1, 20));
        txtName = new JTextField(10);
        txtName.setFont(new Font("", 1, 20));
        txtPrfMarks = new JTextField(4);
        txtPrfMarks.setFont(new Font("", 1, 20));
        txtDbmsMarks = new JTextField(4);
        txtDbmsMarks.setFont(new Font("", 1, 20));
        
        JPanel textPanel = new JPanel(new GridLayout(4, 1));
        
        JPanel idTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idTextPanel.add(txtStudentId);
        textPanel.add(idTextPanel);
        
        JPanel nameTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.add(txtName);
        textPanel.add(nameTextPanel);
        
        JPanel prfMarksTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        prfMarksTextPanel.add(txtPrfMarks);
        textPanel.add(prfMarksTextPanel);
        
        JPanel dbmsMarksTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dbmsMarksTextPanel.add(txtDbmsMarks);
        textPanel.add(dbmsMarksTextPanel);
        
        add("Center", textPanel);
    }
}
