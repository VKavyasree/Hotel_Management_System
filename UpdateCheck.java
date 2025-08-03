
package hotel_management_system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener
{
    Choice Ccustomer;
    JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending;
    JButton Update,Back,Check;
    UpdateCheck()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300,200,980,500);
        
        JLabel text=new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
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
        room.setBounds(30,120,100,20);
        add(room);
        
        tfroom=new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);
        
        JLabel name=new JLabel("Name");
        name.setBounds(30,160,100,20);
        add(name);
        
        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        JLabel checkin=new JLabel("Check in Time");
        checkin.setBounds(30,200,100,20);
        add(checkin);
        
        tfcheckin=new JTextField();
        tfcheckin.setBounds(200,200,150,25);
        add(tfcheckin);
        
        JLabel paid=new JLabel("Amount Paid");
        paid.setBounds(30,240,100,20);
        add(paid);
        
        tfpaid=new JTextField();
        tfpaid.setBounds(200,240,150,25);
        add(tfpaid);
        
        JLabel pending=new JLabel("Amount Pending");
        pending.setBounds(30,280,100,20);
        add(pending);
        
        tfpending=new JTextField();
        tfpending.setBounds(200,280,150,25);
        add(tfpending);
        
        Check=new JButton("Check");
        Check.setBackground(Color.BLACK);
        Check.setForeground(Color.WHITE);
        Check.setBounds(30,340,100,30);
        Check.addActionListener(this);
        add(Check);
        
         Update=new JButton("Update");
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        Update.setBounds(150,340,100,30);
        Update.addActionListener(this);
        add(Update);
        
        
        Back=new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(270,340,100,30);
         Back.addActionListener(this);
        add(Back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
         JLabel image=new JLabel(i1);
         image.setBounds(450,50,500,300);
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
                tfname.setText(res.getString("name"));
                tfcheckin.setText(res.getString("checkintime"));
                tfpaid.setText(res.getString("deposit"));
            }
           
          ResultSet rs2=c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
          while(rs2.next())
          {
              String price=rs2.getString("price");
              int amountPending=Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
              tfpending.setText(""+amountPending);
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
            String checkin=tfcheckin.getText(); 
            String deposit=tfpaid.getText();
             try
             {
           Conn c=new Conn();
              c.s.executeUpdate("update customer set room='"+room+"',name ='"+name+"',checkintime='"+checkin+"',deposit='"+deposit+"'  where number='"+number+"'");
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
new UpdateCheck();

}
}
