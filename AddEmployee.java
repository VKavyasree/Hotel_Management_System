
package hotel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener {
 JTextField tfname,tfphone,tfage,tfsal;
 JRadioButton male,female;
 JButton submit;
 JComboBox cbjob;
    AddEmployee()
 {
     setLayout(null);
     setBounds(350,200,850,540);
     getContentPane().setBackground(Color.WHITE);
     
     JLabel name=new JLabel("NAME");
     name.setBounds(60,30,120,30);
     name.setFont(new Font("Tahoma",Font.PLAIN,17));
     add(name);
     
     tfname=new JTextField();
     tfname.setBounds(200,30,150,30);
     add(tfname);
     
      JLabel age=new JLabel("AGE");
     age.setBounds(60,80,120,30);
     age.setFont(new Font("Tahoma",Font.PLAIN,17));
     add(age);
     
     tfage=new JTextField();
     tfage.setBounds(200,80,150,30);
     add(tfage);
     
     JLabel gender=new JLabel("GENDER");
     gender.setBounds(60,130,120,30);
     gender.setFont(new Font("Tahoma",Font.PLAIN,17));
     add(gender);
     
     male=new JRadioButton("Male");
     female=new JRadioButton("Female");
     male.setBounds(200,130,70,30);
     female.setBounds(280,130,70,30);
     male.setBackground(Color.WHITE);
      female.setBackground(Color.WHITE);
     add(male);
     add(female);
     
     ButtonGroup bg=new ButtonGroup();
     bg.add(male);
     bg.add(female);
     
     JLabel job=new JLabel("JOB");
     job.setBounds(60,180,120,30);
     job.setFont(new Font("Tahoma",Font.PLAIN,17));
     add(job);
     
     String a[]={"Front Desk Clerk","Porters","Housekeeping","Kitchen staff","Waiter/Waitress","Manager","Accountant","Room Service","Chef"};
     cbjob=new JComboBox(a);
     cbjob.setBounds(200,180,150,30);
     cbjob.setBackground(Color.WHITE);
     add(cbjob);
    
      JLabel sal=new JLabel("SALARY");
     sal.setBounds(60,230,120,30);
     sal.setFont(new Font("Tahoma",Font.PLAIN,17));
     add(sal);
     
     tfsal=new JTextField();
     tfsal.setBounds(200,230,150,30);
     add(tfsal);
     
      JLabel phone=new JLabel("PHONE");
     phone.setBounds(60,280,120,30);
     phone.setFont(new Font("Tahoma",Font.PLAIN,17));
     add(phone);
     
     tfphone=new JTextField();
     tfphone.setBounds(200,280,150,30);
     add(tfphone);
     
     submit=new JButton("SUBMIT");
     submit.setBackground(Color.BLACK);
     submit.setForeground(Color.WHITE);
     submit.setBounds(200,400,150,30);
     submit.addActionListener(this);
     add(submit);
     
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
     Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
     ImageIcon i3=new ImageIcon(i2);
     JLabel image=new JLabel(i3);
     image.setBounds(380,60,450,380);
     add(image);
     
      setVisible(true);
 }
 public void actionPerformed(ActionEvent ae)
 {
     String name=tfname.getText();
     String age=tfage.getText();
     String salary=tfsal.getText();
     String phone=tfphone.getText();
     String gender=null;
     if(male.isSelected())
     {
         gender="Male";
     }
     else if(female.isSelected())
     {
         gender="Female";
     }
     String job=(String)cbjob.getSelectedItem();
     try
     {
         Conn conn=new Conn();
         String query = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "')";
         conn.s.executeUpdate(query);
         JOptionPane.showMessageDialog(null,"Employee added successfully");
         setVisible(false);
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
 }
 public static void main(String args[])
 {
     new AddEmployee();
 }
}
