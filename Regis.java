import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class RegistrationFrame extends JFrame
{
	Connection con;
	Statement st;
	ResultSet rs;
	
	private JFrame frame;
   private JPanel P1;
   private JButton S1,c1;
   private JTextField t1,t2,t3,t4,t5,t6,t7,t8;
   private JLabel i,l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
   private JPasswordField p1;
   RegistrationFrame()
   {
	   try
	   {
		frame=new JFrame();
		P1=new JPanel();
		
		frame.setSize(1300,780);
		constructUI();
		designUI();
		
		frame.setVisible(true);
		frame.setTitle("Registration form");
	 
		makeConnection();
		rs=st.executeQuery("select * from eBill");
		rs.first();
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
		P1.add(l7);P1.add(t7);P1.add(l8);P1.add(t8);P1.add(l9);P1.add(p1);
		P1.add(S1);P1.add(c1);P1.add(i);
		
		frame.getContentPane().add(l0,BorderLayout.CENTER);
		l0.setBounds(320,30,1000,100);	
		
		frame.getContentPane().add(l1,BorderLayout.CENTER);
		l1.setBounds(350,150,150,30);	
		
		frame.getContentPane().add(t1,BorderLayout.CENTER);
		t1.setBounds(550,150,150,30);
		
		frame.getContentPane().add(l2,BorderLayout.CENTER);
		l2.setBounds(350,200,150,30);	
		
		frame.getContentPane().add(t2,BorderLayout.CENTER);
		t2.setBounds(550,200,150,30);
		
		frame.getContentPane().add(l3,BorderLayout.CENTER);
		l3.setBounds(350,250,150,30);	
		
		frame.getContentPane().add(t3,BorderLayout.CENTER);
		t3.setBounds(550,250,150,30);
		
		frame.getContentPane().add(l4,BorderLayout.CENTER);
		l4.setBounds(350,300,150,30);	
		
		frame.getContentPane().add(t4,BorderLayout.CENTER);
		t4.setBounds(550,300,150,30);
		
		frame.getContentPane().add(l5,BorderLayout.CENTER);
		l5.setBounds(350,350,150,30);	
		
		frame.getContentPane().add(t5,BorderLayout.CENTER);
		t5.setBounds(550,350,150,30);
		
		frame.getContentPane().add(l6,BorderLayout.CENTER);
		l6.setBounds(350,400,150,30);	
		
		frame.getContentPane().add(t6,BorderLayout.CENTER);
		t6.setBounds(550,400,150,30);
		
		frame.getContentPane().add(l7,BorderLayout.CENTER);
		l7.setBounds(350,450,150,30);	
		
		frame.getContentPane().add(t7,BorderLayout.CENTER);
		t7.setBounds(550,450,150,30);
		
		frame.getContentPane().add(l8,BorderLayout.CENTER);
		l8.setBounds(350,500,150,30);	
		
		frame.getContentPane().add(t8,BorderLayout.CENTER);
		t8.setBounds(550,500,150,30);
		
		frame.getContentPane().add(l9,BorderLayout.CENTER);
		l9.setBounds(350,550,150,30);	
		
		frame.getContentPane().add(p1,BorderLayout.CENTER);
		p1.setBounds(550,550,150,30);	
		
		
		
		frame.getContentPane().add(S1,BorderLayout.CENTER);
		S1.setBounds(370,650,100,30);	
		
		frame.getContentPane().add(c1,BorderLayout.CENTER);
		c1.setBounds(570,650,100,30);
		
		frame.add (P1);
		handleEvents();
   }
   public void constructUI()
   {
		i=new JLabel(new ImageIcon("C:\\Users\\reshman\\Desktop\\GUI\\Project\\back.jpg"));
        t1= new JTextField(15);
        t2= new JTextField(20);
        t3= new JTextField(20);
		t4= new JTextField(10);
		t5= new JTextField(10);
		t6= new JTextField(15);
		t7= new JTextField(12);
		t8= new JTextField(10);
		
		l0= new JLabel("REGISTRATION FORM");
		l0.setForeground(Color.WHITE);
		l0.setFont(new Font("Comic Sans MS",Font.BOLD,40));
		l1= new JLabel("Name:");
		l1.setForeground(Color.GREEN);
		l1.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		l2= new JLabel("Address Line1:");
		l2.setForeground(Color.GREEN);
		l2.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		l3= new JLabel("Address Line2:");
		l3.setForeground(Color.GREEN);
		l3.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		l4= new JLabel("District:");
		l4.setForeground(Color.GREEN);
		l4.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		l5= new JLabel("Phone no:");
		l5.setForeground(Color.GREEN);
		l5.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		l6= new JLabel("EB no:");
		l6.setForeground(Color.GREEN);
		l6.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		l7= new JLabel("Aadhar No:");
		l7.setForeground(Color.GREEN);
		l7.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		l8= new JLabel("User Id:");
		l8.setForeground(Color.GREEN);
		l8.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		l9= new JLabel("Password:");
		l9.setForeground(Color.GREEN);
		l9.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		p1= new JPasswordField(10);
		
        S1=new JButton("Submit");
		c1= new JButton("Cancel");
	    P1=new JPanel();
		P1.setBackground(Color.BLUE);
   }
   public void handleEvents()
   {
			S1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) 
			{
				try
				{
					makeConnection();
					rs=st.executeQuery("select * from eBill");
					rs.first();
					int ph,ebno,ad,flag=0;
					double unit;
					String n=t1.getText();
					String a1=t2.getText();
					String a2=t3.getText();
					String d=t4.getText();
					ph=Integer.parseInt(t5.getText());
					ebno=Integer.parseInt(t6.getText());
					ad=Integer.parseInt(t7.getText());
					String uname=t8.getText();
					String pwd=p1.getText();
					unit=0;
					String status="UNPAID";
					do
					{
						if(t7.getText().equals(rs.getString(9)))
						{	
							flag=1;
						}
					}while(rs.next());
					if (flag!=1)
					{
						int x=st.executeUpdate("insert into eBill values('"+uname+"','"+pwd+"',"+ebno+",'"+n+"','"+a1+"','"+a2+"','"+d+"',"+ph+","+ad+","+unit+",'"+status+"')");
						if (x==1)
						{
							JOptionPane.showMessageDialog(null,"Insertion Successful");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Insertion UnSuccessful");
						}
					}
					else
					{
							JOptionPane.showMessageDialog(null,"Duplicates Found");
					}
				
				}
				catch(Exception i)
				{
					System.out.println(i);
				}
			}
	   
			});
			c1.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				JOptionPane.showMessageDialog(null,"Registration Cancelled");
				frame.dispose();
			}
		}
		);	
   }	
}