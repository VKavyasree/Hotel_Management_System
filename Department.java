
package hotel_management_system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Department extends JFrame implements ActionListener{
    JTable table;
    JButton back;
   Department(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
       table=new JTable();
       table.setBounds(0,40,700 ,300);
       add(table);
       
       try
       {
           Conn conn=new Conn();
           ResultSet res=conn.s.executeQuery("select * from department ");
           table.setModel(DbUtils.resultSetToTableModel(res));
       }
       
       
       catch(Exception e)
       {
           e.printStackTrace();
       }
        
      
      
      
      JLabel l1=new JLabel("Department");
      l1.setBounds(130,10,100,20);
      add(l1);
     
      JLabel l3=new JLabel("Budget");
      l3.setBounds(420,10,100,20);
      add(l3);
      
      
      back=new JButton("Back");
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.addActionListener(this);
      back.setBounds(280,400,120,30);
      add(back);

      
      
      setBounds(400,200,700,550);
      setVisible(true);
        
}
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Reception();
    }
    public static void main(String args[])
    {
        new Department();
    }
    
}

