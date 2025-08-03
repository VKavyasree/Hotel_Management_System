
package hotel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Checkout extends JFrame implements ActionListener {
    Choice Ccustomer;
    JLabel room,cin,cout;
    JButton Checkout,Back;
    Checkout()
    {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
        
        JLabel id=new JLabel("Customer Id");
        id.setBounds(30,80,100,30);
        add(id);
        
        
         Ccustomer=new Choice();
        Ccustomer.setBounds(150,80,150,30);
        add(Ccustomer);
        
        JLabel rno=new JLabel("Room Number");
        rno.setBounds(30,130,100,30);
        add(rno);
        
        room=new JLabel();
         room.setBounds(200,130,100,30);
        add(room);
        
        JLabel checkin=new JLabel("Checkin Time");
        checkin.setBounds(30,180,100,30);
        add(checkin);
        
        cin=new JLabel();
         cin.setBounds(200,180,100,30);
        add(cin);
        
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
        Ccustomer.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent ie) {
        try {
            Conn conn = new Conn();
            String selectedId = Ccustomer.getSelectedItem();
            ResultSet rs = conn.s.executeQuery("select * from customer where number = '"+selectedId+"'");
            if(rs.next()) {
                room.setText(rs.getString("room"));
                cin.setText(rs.getString("checkintime"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
});

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2=i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(310,80,20,20);
         add(image);
        
        
    
        
        JLabel checkout=new JLabel("Checkout");
        checkout.setBounds(30,230,100,30);
        add(checkout);
        
        Date date=new Date();
        cout=new JLabel(""+date);
        cout.setBounds(150,230,150,30);
        add(cout);
        
        Checkout=new JButton("Checkout");
        Checkout.setBackground(Color.BLACK);
        Checkout.setForeground(Color.WHITE);
        Checkout.setBounds(30,280,120,30);
        Checkout.addActionListener(this);
        add(Checkout);
        
        
        
        
        Back=new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(170,280,100,30);
        Back.addActionListener(this);
        add(Back);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image2=new JLabel(i6);
        image2.setBounds(350,50,400,250);
        add(image2);
        
         
        setBounds(300,200,800,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Checkout)
        {
            String query1="delete from customer where number='"+Ccustomer.getSelectedItem()+"'";
            String query2="update room set availability='Available' where roomnumber='"+room.getText()+"'";
        
        try
        {
            Conn c=new Conn();
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            JOptionPane.showMessageDialog(null,"Checkout Done");      
        
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
        new Checkout();
    }
    
}
