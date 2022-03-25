import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.BorderLayout;

class PersonalFrame extends JFrame
{
	Connection con;
	Statement st;
	ResultSet rs;
	
   JPanel P1;
   JButton S1,c1;
   JTextField t1,t2,t3,t4,t5,t6,t7,t8;
   JLabel i,l0,l1,l2,l3,l4,l5,l6,l7,l8;
   String n,a1,a2,id,d,eb,mob,ad,stat;
   
   PersonalFrame(String x)
   {
	  
	   try
	   {
		setResizable(false);
		setVisible(true);
		P1=new JPanel();
		setSize(1000,700);
		constructUI();
		designUI();
		setTitle("Personal Details");
	 
		makeConnection();
		rs=st.executeQuery("select * from eBill");
		rs.first();
		String aa=x;
		do
		{
			if((aa.equals(rs.getString(4))))
			{		
				t1.setText(rs.getString(4));
				t2.setText(rs.getString(5));
				t3.setText(rs.getString(6));
				t4.setText(rs.getString(7));
				t5.setText(rs.getString(8));
				t6.setText(rs.getString(3));
				t7.setText(rs.getString(9));
				t8.setText(rs.getString(1));
			}
		}while(rs.next());
		
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
   }
    public void makeConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eb","root","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
   public void designUI()
   {
        P1.add(l0);P1.add(l1);P1.add(t1);P1.add(l2);P1.add(t2);P1.add(l3);P1.add(t3);
        P1.add(l4);P1.add(t4);P1.add(l5);P1.add(t5);P1.add(l6);P1.add(t6);
		P1.add(l7);P1.add(t7);P1.add(l8);P1.add(t8);P1.add(i);
		
		getContentPane().add(l0,BorderLayout.CENTER);
		l0.setBounds(320,30,1000,100);	
		
		getContentPane().add(l1,BorderLayout.CENTER);
		l1.setBounds(150,150,150,30);	
		
		getContentPane().add(t1,BorderLayout.CENTER);
		t1.setBounds(350,150,150,30);
		
		getContentPane().add(l2,BorderLayout.CENTER);
		l2.setBounds(150,200,150,30);	
		
		getContentPane().add(t2,BorderLayout.CENTER);
		t2.setBounds(350,200,150,30);
		
		getContentPane().add(l3,BorderLayout.CENTER);
		l3.setBounds(150,250,150,30);	
		
		getContentPane().add(t3,BorderLayout.CENTER);
		t3.setBounds(350,250,150,30);
		
		getContentPane().add(l4,BorderLayout.CENTER);
		l4.setBounds(150,300,150,30);	
		
		getContentPane().add(t4,BorderLayout.CENTER);
		t4.setBounds(350,300,150,30);
		
		getContentPane().add(l5,BorderLayout.CENTER);
		l5.setBounds(150,350,150,30);	
		
		getContentPane().add(t5,BorderLayout.CENTER);
		t5.setBounds(350,350,150,30);
		
		getContentPane().add(l6,BorderLayout.CENTER);
		l6.setBounds(150,400,150,30);	
		
		getContentPane().add(t6,BorderLayout.CENTER);
		t6.setBounds(350,400,150,30);
		
		getContentPane().add(l7,BorderLayout.CENTER);
		l7.setBounds(150,450,150,30);	
		
		getContentPane().add(t7,BorderLayout.CENTER);
		t7.setBounds(350,450,150,30);
		
		getContentPane().add(l8,BorderLayout.CENTER);
		l8.setBounds(150,500,150,30);	
		
		getContentPane().add(t8,BorderLayout.CENTER);
		t8.setBounds(350,500,150,30);
		
		
		add (P1);
   }
   public void constructUI()
   {try
	   {
		i=new JLabel(new ImageIcon("C:\\Users\\reshman\\Desktop\\GUI\\Project\\back4.jpg"));
        t1= new JTextField(15);
		t1.setEditable(false);
        t2= new JTextField(20);
		t2.setEditable(false);
        t3= new JTextField(20);
		t3.setEditable(false);
		t4= new JTextField(10);
		t4.setEditable(false);
		t5= new JTextField(10);
		t5.setEditable(false);
		t6= new JTextField(15);
		t6.setEditable(false);
		t7= new JTextField(12);
		t7.setEditable(false);
		t8= new JTextField(10);
		t8.setEditable(false);
		
		l0= new JLabel("PERSONAL DETAILS");
		l0.setForeground(Color.WHITE);
		l0.setFont(new Font("Comic Sans MS",Font.BOLD,40));
		l1= new JLabel("Name:");
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		l2= new JLabel("Address Line1:");
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		l3= new JLabel("Address Line2:");
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		l4= new JLabel("District:");
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		l5= new JLabel("Phone no:");
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		l6= new JLabel("EB no:");
		l6.setForeground(Color.WHITE);
		l6.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		l7= new JLabel("Aadhar No:");
		l7.setForeground(Color.WHITE);
		l7.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		l8= new JLabel("User Id:");
		l8.setForeground(Color.WHITE);
		l8.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		P1=new JPanel();
		P1.setBackground(Color.GREEN);
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
   }
}
