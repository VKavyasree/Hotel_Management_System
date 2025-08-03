
package hotel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    JButton logout,newCustomer,rooms,dept,search,update,roomstatus,pickup,checkout;
    Reception()
    {
        setLayout(null);
        setBounds(350,200,800,570);
        getContentPane().setBackground(Color.WHITE);
        
        newCustomer=new JButton("New Customer Form");
        newCustomer.addActionListener(this);
        newCustomer.setBounds(20,30,200,30);
        add(newCustomer);
        
         rooms=new JButton("Rooms");
        rooms.addActionListener(this);
        rooms.setBounds(20,70,200,30);
        add(rooms);
        
         dept=new JButton("Department");
        dept.addActionListener(this);
        dept.setBounds(20,110,200,30);
        add(dept);
        
        JButton allEmployee=new JButton("All Employee");
        allEmployee.setBounds(20,150,200,30);
        add(allEmployee);
        
        JButton customers=new JButton("Customer Info");
        customers.setBounds(20,190,200,30);
        add(customers);
        
        JButton managerInfo=new JButton("Manager Info");
         managerInfo.setBounds(20,230,200,30);
        add(managerInfo);
        
    checkout=new JButton("Checkout");
         checkout.setBounds(20,270,200,30);
         checkout.addActionListener(this);
        add(checkout);
        
        update=new JButton("Update Status");
         update.setBounds(20,310,200,30);
         update.addActionListener(this);
        add(update);
        
         roomstatus=new JButton("Room Status");
         roomstatus.setBounds(20,350,200,30);
         roomstatus.addActionListener(this);
        add(roomstatus);
        
         pickup=new JButton("Pickup Service");
         pickup.setBounds(20,390,200,30);
         pickup.addActionListener(this);
        add(pickup);
        
        search=new JButton("Search Room");
         search.addActionListener(this);
         search.setBounds(20,430,200,30);
         add(search);
         
           logout=new JButton("Logout");
         logout.setBounds(20,470,200,30);
         logout.addActionListener(this);
         add(logout);
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
         JLabel image=new JLabel(i1);
         image.setBounds(250,30,500,470);
         add(image);
        
     
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==newCustomer)
        {
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource()==rooms)
        {
            setVisible(false);
            new Room();
        }
        else if(ae.getSource()==dept)
        {
            setVisible(false);
            new Department();
        }
        else if(ae.getSource()==search)
        {
            setVisible(true);
            new SearchRoom();
        }
        else if(ae.getSource()==update)
        {
            setVisible(false);
            new UpdateCheck();
        }
        else if(ae.getSource()==roomstatus)
        {
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource()==pickup)
        {
            setVisible(false);
            new Pickup();
        }
        else if(ae.getSource()==checkout)
        {
            setVisible(false);
            new Checkout();
        }
        else if(ae.getSource()==logout)
        {
            setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
        new Reception();
    }
    
}
