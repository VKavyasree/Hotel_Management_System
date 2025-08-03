
package hotel_management_system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
    SearchRoom(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
   
       table=new JTable();
       table.setBounds(0,200,1000,300);
       add(table);
       
       try
       {
           Conn conn=new Conn();
           ResultSet res=conn.s.executeQuery("select * from room");
           table.setModel(DbUtils.resultSetToTableModel(res));
       }
       
       
       catch(Exception e)
       {
           e.printStackTrace();
       }
        
      JLabel text=new JLabel("Search for Room");
      text.setFont(new Font("Tahoma",Font.PLAIN,20));
      text.setBounds(400,30,200,30);
      add(text);
      
      JLabel b=new JLabel("Bed Type");
      b.setBounds(50,100,100,20);
      add(b);
      
      bedtype=new JComboBox(new String[]{"Single","Double"});
      bedtype.setBounds(150,100,150,25);
      bedtype.setBackground(Color.WHITE);
      add(bedtype);
      
      JLabel l1=new JLabel("Room Number");
      l1.setBounds(50,160,100,20);
      add(l1);
      JLabel l2=new JLabel("Availability");
      l2.setBounds(270,160,100,20);
      add(l2);
      JLabel l3=new JLabel("Cleaning");
      l3.setBounds(450,160,100,20);
      add(l3);
      JLabel l4=new JLabel("Price");
      l4.setBounds(670,160,100,20);
      add(l4);
      JLabel l5=new JLabel("Bed Type");
      l5.setBounds(870,160,100,20);
      add(l5);
      
     available=new JCheckBox("Only Display Available");
     available.setBounds(650,100,150,25);
     available.setBackground(Color.WHITE);
     add(available);
     
      back=new JButton("Back");
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.addActionListener(this);
      back.setBounds(450,500,120,30);
      add(back);
      
      
      submit=new JButton("Submit");
      submit.setBackground(Color.BLACK);
      submit.setForeground(Color.WHITE);
      submit.addActionListener(this);
      submit.setBounds(650,500,120,30);
      add(submit);

      
      
      setBounds(300,200,1000,600);
      setVisible(true);
        
}
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
        try
        {
            String query1="select * from room where type='"+bedtype.getSelectedItem()+"'";
            String query2="select * from room where availability='Available' AND type='"+bedtype.getSelectedItem()+"'";
            Conn conn =new Conn();
            ResultSet res;
            if(available.isSelected())
            {
                res=conn.s.executeQuery(query2);
            }
                
            
            else
            {
                 res=conn.s.executeQuery(query1);
            }
            table.setModel(DbUtils.resultSetToTableModel(res));
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
        new SearchRoom();
    }
    
}

