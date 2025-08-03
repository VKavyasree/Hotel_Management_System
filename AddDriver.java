
package hotel_management_system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener{
   JButton add,cancel;
    JTextField tfname,tfcar,tfage,tfmodel,tfloc;
    JComboBox gencombo,avlcombo;
    AddDriver()
    {
        setLayout(null);
        setBounds(300,200,980,470);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading=new JLabel("Add Drivers");
        
        heading.setFont(new Font("Tahoma",Font.BOLD,16));
        heading.setBounds(150,10,200,20);
        add(heading);
        
         JLabel roomno=new JLabel("Name");
        roomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        roomno.setBounds(60,70,120,30);
        add(roomno);
        
        tfname=new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);
        
        JLabel age=new JLabel("Age");
        age.setBounds(60,110,120,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(age);
        
        tfage=new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);
        
         JLabel Gender=new JLabel("Gender");
        Gender.setBounds(60,150,120,30);
        Gender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(Gender);
        
        String gender[]={"Male","Female"};
        gencombo=new JComboBox(gender);
        gencombo.setBounds(200,150,150,30);
        gencombo.setBackground(Color.WHITE);
        add(gencombo);
        
        JLabel car=new JLabel("Car Company");
        car.setBounds(60,190,120,30);
        car.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(car);
        
        tfcar=new JTextField();
        tfcar.setBounds(200,190,150,30);
        add(tfcar);
        
        
        JLabel carmodel=new JLabel("Car Model");
        carmodel.setBounds(60,230,120,30);
        carmodel.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(carmodel);
        
        tfmodel=new JTextField();
        tfmodel.setBounds(200,230,150,30);
        add(tfmodel);
        
        JLabel avl=new JLabel("Available");
        avl.setBounds(60,270,120,30);
        avl.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(avl);
        
        String driveroptions[]={"Available","Busy"};
        avlcombo=new JComboBox(driveroptions);
        avlcombo.setBounds(200,270,150,30);
        avlcombo.setBackground(Color.WHITE);
        add(avlcombo);
        
        JLabel location=new JLabel("Location");
        location.setBounds(60,310,120,30);
        location.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(location);
        
        tfloc=new JTextField();
        tfloc.setBounds(200,310,150,30);
        add(tfloc);
        
        add=new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,370,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,370,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);
        
        setVisible(true);
            
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            String name=tfname.getText();
            String age=tfage.getText();
            String gender=(String)gencombo.getSelectedItem();
            String company =tfcar.getText();
            String model=tfmodel.getText();
            String available=(String)avlcombo.getSelectedItem();;
            String location=tfloc.getText();
            try{
               Conn conn=new Conn();
               String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
                setVisible(false);
            }
            
            catch(Exception e)
            {
                e.printStackTrace();
            }
           
        }
        else
        {
            setVisible(false);
        }
    }
    public static void main(String args[])
    {
        new AddDriver();
    }
}