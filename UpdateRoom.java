
package hotel_management_system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener
{
    Choice Ccustomer;
    JTextField tfroom,tfname,tfstatus,tfpaid,tfpending;
    JButton Update,Back,Check;
    UpdateRoom()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300,200,980,500);
        
        JLabel text=new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(30,20,250,30);
        add(text);
        
        JLabel id=new JLabel("Customer id");
        //text.setFont(new Font("Tahoma",Font.PLAIN,20));
        id.setBounds(30,80,100,20);
        add(id);
        
        Ccustomer=new Choice();
        Ccustomer.setBounds(200,80,150,25);
        add(Ccustomer);
        
        try
        {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from customer");
            while(rs.next())
            {
                Ccustomer.add(rs.getString("number"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JLabel room=new JLabel("Room number");
        room.setBounds(30,130,100,20);
        add(room);
        
        tfroom=new JTextField();
        tfroom.setBounds(200,130,150,25);
        add(tfroom);
        
        JLabel name=new JLabel("Availability");
        name.setBounds(30,180,100,20);
        add(name);
        
        tfname=new JTextField();
        tfname.setBounds(200,180,150,25);
        add(tfname);
        
        JLabel checkin=new JLabel("Cleaning Status");
        checkin.setBounds(30,230,100,20);
        add(checkin);
        
        tfstatus=new JTextField();
        tfstatus.setBounds(200,230,150,25);
        add(tfstatus);
        
       
        
        Check=new JButton("Check");
        Check.setBackground(Color.BLACK);
        Check.setForeground(Color.WHITE);
        Check.setBounds(30,300,100,30);
        Check.addActionListener(this);
        add(Check);
        
         Update=new JButton("Update");
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        Update.setBounds(150,300,100,30);
        Update.addActionListener(this);
        add(Update);
        
        
        Back=new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(270,300,100,30);
         Back.addActionListener(this);
        add(Back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(450,20,500,400);
         add(image);
        
        
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Check)
        {
            String id=Ccustomer.getSelectedItem();
            String query="select * from customer where number='"+id+"'";
            try
            {
            Conn c=new Conn();
            ResultSet res=c.s.executeQuery(query);
            while(res.next())
            {
                tfroom.setText(res.getString("room"));
            }
               
           
          ResultSet rs2=c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
          while(rs2.next())
          {
              tfname.setText(rs2.getString("availability"));
              tfstatus.setText(rs2.getString("status"));
          }
            }
          catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==Update)
        {
            String number=Ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String name=tfname.getText();
            String status=tfstatus.getText(); 
            
             try
             {
           Conn c=new Conn();
              c.s.executeUpdate("update room set availability='"+name+"',status='"+status+"' where roomnumber='"+room+"'");
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
               setVisible(false);
               new Reception();
             } 
             catch(Exception e)
             {
                 e.printStackTrace();
             }
        }
        else
        {
            setVisible(false);
            new Reception();
        }
    }

public static void main(String args[])
{
new UpdateRoom();

}
}

