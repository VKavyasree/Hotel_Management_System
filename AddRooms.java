
package hotel_management_system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class AddRooms extends JFrame implements ActionListener{
    JButton Add,cancel;
    JTextField tfroom,tfprice;
    JComboBox availablecombo,ccombo,bcombo;
    AddRooms()
    {
        setLayout(null);
        setBounds(330,200,940,470);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading=new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,16));
        heading.setBounds(150,20,200,20);
        add(heading);
        
         JLabel roomno=new JLabel("Room Number");
        roomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        roomno.setBounds(60,80,120,30);
        add(roomno);
        
        tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);
        
        JLabel avl=new JLabel("Room status");
        avl.setBounds(60,130,120,30);
        avl.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(avl);
        
        String available[]={"Available","Occupied"};
        availablecombo=new JComboBox(available);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
          JLabel cleanly=new JLabel("Cleaning status");
     cleanly.setBounds(60,180,120,30);
       cleanly.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(cleanly);
        
        String c1[]={"Cleaned","Dirty"};
        ccombo=new JComboBox(c1);
        ccombo.setBounds(200,180,150,30);
       ccombo.setBackground(Color.WHITE);
        add(ccombo);
        
         JLabel bedtype=new JLabel("No.of Beds");
     bedtype.setBounds(60,220,120,30);
      bedtype.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(bedtype);
        
        String bed[]={"Single","Double"};
        bcombo=new JComboBox(bed);
        bcombo.setBounds(200,220,150,30);
       bcombo.setBackground(Color.WHITE);
        add(bcombo);
        
          JLabel price=new JLabel("Price");
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        price.setBounds(60,270,120,30);
        add(price);
        
        tfprice=new JTextField();
        tfprice.setBounds(200,270,150,30);
        add(tfprice);
        
        Add=new JButton("Add Room");
        Add.setForeground(Color.WHITE);
        Add.setBackground(Color.BLACK);
        Add.setBounds(60,350,130,30);
        Add.addActionListener(this);
        add(Add);
        
        cancel=new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        setVisible(true);
            
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Add)
        {
            String roomnumber=tfroom.getText();
            String availability=(String)availablecombo.getSelectedItem();
            String status=(String)ccombo.getSelectedItem();
            String price=tfprice.getText();
            String type=(String)bcombo.getSelectedItem();
            try{
               Conn conn=new Conn();
               String str="insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
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
        new AddRooms();
    }
}
