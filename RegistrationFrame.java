import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.BorderLayout;
class RegistrationFrame 
{
   JPanel P1;
   JScrollPane sp;
   JButton S1,c1 ;
   JTextField t1,t2,t3,t4,t5,t6,t7,t8;
   JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
   JPasswordField p1;
   JPasswordField p2;
   RegistrationFrame()
   {
     //Construction
     P1=new JPanel();
     constructUI();
     designUI();
     Toolkit kit=Toolkit.getDefaultToolkit();
     Dimension d=kit.getScreenSize();
     setSize(d.width,d.height);
     setVisible(true);
     setTitle("Registration form");
	 
   }
   public void designUI()
   {
		P1.setLayout(new GridLayout(11,2));
        P1.add(l1);		
		P1.add(t1);
		P1.add(l2);        
		P1.add(t2);
        P1.add(l3);        
		P1.add(t3); 
        P1.add(l4);        
		P1.add(t4);
        P1.add(l5);       
		P1.add(t5);
		P1.add(l6);		
		P1.add(t6);
		P1.add(l7);		
		P1.add(t7);
		P1.add(l8);		
		P1.add(t8);
        P1.add(l9);       
		P1.add(p1);	
		P1.add(l10);		
		P1.add(p2);
		P1.add(S1);
		P1.add(c1);
		add (P1);
   }
   public void constructUI()
   {
        t1= new JTextField(15);
        t2= new JTextField(20);
        t3= new JTextField(20);
		t4= new JTextField(10);
		t5= new JTextField(10);
		t6= new JTextField(15);
		t7= new JTextField(12);
		t8= new JTextField(10);
		l1= new JLabel("Name:");
		l2= new JLabel("Address Line1:");
		l3= new JLabel("Address Line2:");
		l4= new JLabel("District:");
		l5= new JLabel("Phone no:");
		l6= new JLabel("EB no:");
		l7= new JLabel("Aadhar No:");
		l8= new JLabel("User Id:");
		l9= new JLabel("Password:");
		l10= new JLabel("Re-enter password:");
		p1= new JPasswordField(10);
		p2= new JPasswordField(10);
        S1=new JButton("Submit");
		c1= new JButton("Cancel");
	    P1=new JPanel();
        handleEvents();
   }
   public void handleEvents()
   {
    S1.addActionListener( new ActionListener(){
       public void actionPerformed(ActionEvent ae) 
       {
		   try
		   {
		   
				String n=t1.getText();
				String a1=t2.getText();
				String a2=t3.getText();
				String d=t4.getText();
				int ph=Integer.parseInt(t5.getText());
				int ebno=Integer.parseInt(t6.getText());
				int ad=Integer.parseInt(t7.getText());
				String uname=t8.getText();
				String pwd=p2.getText();
				double unit=0;
				int x=st.executeUpdate("insert into eBill values('"+uname+"','"+pwd+"',"+ebno+",'"+n+"','"+a1+"','"+a2+"','"+d+"',"+ph+","+ad+","+unit+")");
				if (x==1)
				{
					JOptionPane.showMessageDialog(null,"Insertion Successful");
					//sleep(1000);
					//System.close();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Insertion UnSuccessful");
				}
				
		   }
		   catch(Exception e)
			{
				System.out.println(e);
			}
       }
	   
    });
	c1.addActionListener( new ActionListener(){
    public void actionPerformed(ActionEvent ae)
	{
		//System.close();
	}
	});
   }	
}