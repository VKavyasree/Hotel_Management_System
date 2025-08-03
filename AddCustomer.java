
package hotel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class AddCustomer extends JFrame implements ActionListener{
    JComboBox comboid;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton male,female;
    Choice croom;
    JLabel checkintime;
    JButton add,back;
    AddCustomer()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);
        
        JLabel id=new JLabel("ID");
        id.setBounds(35,80,100,20);
        id.setFont(new Font("Raleway",Font.PLAIN,20));
        add(id);
        
        String options[]={"Aadhaar Card","Passport","Driving License","Voter id card","Ration Card"};
        comboid=new JComboBox(options);
        comboid. setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel number=new JLabel("Number");
        number.setBounds(35,120,100,20);
        number.setFont(new Font("Raleway",Font.PLAIN,20));
        add(number);
        
        tfnumber=new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);
        
         JLabel name=new JLabel("Name");
        name.setBounds(35,160,100,20);
        name.setFont(new Font("Raleway",Font.PLAIN,20));
        add(name);
        
        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        JLabel gender=new JLabel("Gender");
        gender.setBounds(35,200,100,20);
        gender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(200,200,60,25);
        male.setBackground(Color.WHITE);
        female=new JRadioButton("Female");
        female.setBounds(280,200,100,25);
        female.setBackground(Color.WHITE);
        add(male);
        add(female);
        
        JLabel country=new JLabel("Country");
        country.setBounds(35,240,100,30);
        country.setFont(new Font("Raleway",Font.PLAIN,20));
        add(country);
        
        tfcountry=new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        
        JLabel room=new JLabel("Allocated Room");
        room.setBounds(35,280,150,30);
        room.setFont(new Font("Raleway",Font.PLAIN,20));
        add(room);
        
        tfcountry=new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        
        croom=new Choice();
        croom.setBounds(200,280,150,25);
        add(croom);
        try
        {
            Conn conn=new Conn();
            String query="select * from room where availability='Available'";
            ResultSet rs=conn.s.executeQuery(query);
            while(rs.next())
            {
                croom.add(rs.getString("roomnumber"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JLabel time=new JLabel("Checkin Time");
        time.setBounds(35,320,150,30);
        time.setFont(new Font("Raleway",Font.PLAIN,20));
        add(time);
        
       
        Date date=new Date();
         
        checkintime=new JLabel(" "+date);
        checkintime.setBounds(200,320,120,25);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,15));
        add(checkintime);
        
       
        
        JLabel deposit=new JLabel("Deposit");
        deposit.setBounds(35,360,150,30);
        deposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(deposit);
        
        tfdeposit=new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);
        
        add=new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,410,120,35);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,410,120,35);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        
        setBounds(350,200,800,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
    
     if(ae.getSource()==add)
     {
         String id=(String)comboid.getSelectedItem();
         String number=tfnumber.getText();
         String name=tfname.getText();
         String gender=null;
         if(male.isSelected())
         {
             gender="Male";
         }
         else
         {
             gender="Female";
         }
         String country=tfcountry.getText();
         String room=croom.getSelectedItem();
         String time=checkintime.getText();
         String deposit=tfdeposit.getText();
         try
         {
             String query="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
             String query2="update room set availability='Occupied' where roomnumber='"+room+"'";
             Conn conn=new Conn();
             conn.s.executeUpdate(query);
             conn.s.executeUpdate(query2);
             
             JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
             setVisible(false);
             new Reception();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
     }
     else if(ae.getSource()==back)
     {
         setVisible(false);
         new Reception();
     }
    
    }
    
    public static void main(String args[])
    {
       new AddCustomer();
        
    }
}
