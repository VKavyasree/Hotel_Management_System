/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Hotel_Management_System extends JFrame implements ActionListener {
    Hotel_Management_System(){
       setSize(1366,565);
       setLocation(100,100);
       setLayout(null);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
       JLabel image=new JLabel(i1);
       image.setBounds(0,0,1366,565);
       add(image);
       
       JLabel label=new JLabel("HOTEL MANAGEMENT SYSTEM");
       label.setBounds(20,430,1000,90);
       label.setForeground(Color.WHITE);
       label.setFont(new Font("serif",Font.PLAIN,50));
       image.add(label);
       
       JButton next=new JButton("Next");
       next.setBounds(1150,450,150,50);
       next.setBackground(Color.WHITE);
       next.setFont(new Font("serif",Font.PLAIN,20));
       image.add(next);
       next.addActionListener(this);
       
         setVisible(true);
         
         while(true)
         {
             label.setVisible(false);
             try{
                 Thread.sleep(500);
             } catch(Exception e)
             {
                 e.printStackTrace(); 
             }
             label.setVisible(true);
              try{
                 Thread.sleep(500);
             } catch(Exception e)
             {
                 e.printStackTrace(); 
             }
         }
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(true);
        new Login();
    }
    public static void main(String[] args) {
        new Hotel_Management_System();
    }
    
}
