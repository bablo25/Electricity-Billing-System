import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.BorderLayout;
class MainFrame extends LoginFrame
{
	JLabel imag,n;
	JPanel pan,p1;
	JMenuBar mb;
	JMenu personal,calculate,generatebill;
	JMenuItem logP,perP,newP,calcC,billG,statusG;
	String status,logId,ebNo,name,add1,add2,dst,mob,aadharNo;
	
	MainFrame(ResultSet x)
	{
		
		this.rs=x;
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		setSize(d.width,d.height);
		setVisible(true);
		setTitle("Electricity Billing System");
		constructUI();
		designUI();
		handleEvent1();
	}
	public void constructUI()
	{
		n=new JLabel("WELCOME ");
		n.setForeground(Color.WHITE);
		n.setFont(new Font("Comic Sans MS",Font.BOLD,40));
		imag=new JLabel(new ImageIcon("C:\\Users\\reshman\\Desktop\\GUI\\Project\\back1.jpg"));
		pan=new JPanel();
		p1=new JPanel();
		pan.setBackground(Color.BLACK);
		
		mb=new JMenuBar();
		
		personal=new JMenu("Personal"+getNamee());
		calculate=new JMenu("Calculate");
		generatebill=new JMenu("Billing");
		
		newP=new JMenuItem("New User");
		logP=new JMenuItem("Logout");
		perP=new JMenuItem("Info");
		
		calcC=new JMenuItem("Calculate Amount");
		
		billG=new JMenuItem("Generate Bill");
		statusG=new JMenuItem("Check Status");
		
		status=getStatus();
		logId=getlogId();
		ebNo=getEbNo();
		name=getNamee();
		add1=addr1();
		add2=addr2();
		dst=dist();
		mob=getMobNo();
		aadharNo=getAadNo();
		
	}
	public String getNamee()
	{
		try
		{
			String name=rs.getString(4);
			System.out.println(name);
			return name;
		}
		catch(Exception e)
		{
			String name="error";
			return name;
		}
	}
	public String getlogId()
	{
		try
		{
			String name=rs.getString(1);
			System.out.println(name);
			return name;
		}
		catch(Exception e)
		{
			String name="error";
			return name;
		}
	}
	public String addr1()
	{
		try
		{
			String name=rs.getString(5);
			System.out.println(name);
			return name;
			
		}
		catch(Exception e)
		{
			String name="error";
			return name;
		}
	}
	public String addr2()
	{
		try
		{
			String name=rs.getString(6);
			System.out.println(name);
			return name;
			
		}
		catch(Exception e)
		{
			String name="error";
			return name;
		}
	}
	public String dist()
	{
		try
		{
			String name=rs.getString(7);
			System.out.println(name);
			return name;
			
		}
		catch(Exception e)
		{
			String name="error";
			return name;
		}
	}
	public String getEbNo()
	{
		try
		{
			String name=""+rs.getString(3);
			System.out.println(name);
			return name;
			
		}
		catch(Exception e)
		{
			String name="error";
			return name;
		}
	}
	public String getAadNo()
	{
		try
		{
			String name=""+rs.getString(9);
			System.out.println(name);
			return name;
			
		}
		catch(Exception e)
		{
			String name="error";
			return name;
		}
	}
	public String getMobNo()
	{
		try
		{
			String name=""+rs.getString(8);
			System.out.println(name);
			return name;
			
		}
		catch(Exception e)
		{
			String name="error";
			return name;
		}
	}
	public String getStatus()
	{
		try
		{
			String nam=rs.getString(11);
			System.out.println(nam);
			return nam;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			String nam="error";
			return nam;
		}
	}
	public void designUI()
	{
		pan.add(imag);
		pan.add(n);
		personal.setMnemonic('P');
		calculate.setMnemonic('C');
		generatebill.setMnemonic('G');
		
		personal.add(perP);personal.add(newP);personal.add(logP);
		
		calculate.add(calcC);
		
		generatebill.add(billG);generatebill.add(statusG);
		
		mb.add(personal);mb.add(calculate);mb.add(generatebill);
	
		setJMenuBar(mb);
		
		getContentPane().add(n,BorderLayout.CENTER);
		n.setBounds(320,30,1000,100);	
		add(pan);
	}
	public void handleEvent1()
	{
		newP.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("New Clicked");
				RegistrationFrame r1=new RegistrationFrame();
			}
		}
		);
		perP.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("Personal Clicked");
				PersonalFrame p1=new PersonalFrame(name,add1,add2,logId,dst,ebNo,mob,aadharNo,status);
			}
		}
		);
		calcC.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("Calc Clicked");
				//RegistrationFrame r1=new RegistrationFrame();
			}
		}
		);
		billG.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("bill Clicked");
				//RegistrationFrame r1=new RegistrationFrame();
			}
		}
		);
		statusG.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{			
					System.out.println("Status Clicked");
					JOptionPane.showMessageDialog(null,"Status:"+status);
			}
		}
		);
		logP.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("New Clicked");
				System.exit(0);
			}
		}
		);
	}
}

class CalculateBill 
{
	double Total_Amount;
	CalculateBill()
	{
		calculate(0);
	}
	CalculateBill(double x)
	{
		calculate(x);
	}
	public void calculate(double Units) 
	{
		double Amount, Sur_Charge;
  
	  	if (Units < 50)
	  	{
	        Amount = Units * 2.60;
	  		Sur_Charge = 25;  	
	  	} 
	  	else if (Units <= 100)
	  	{
	  		Amount = 130 + ((Units - 50 ) * 3.25);
	  		Sur_Charge = 35; 	
	  	}
	  	else if (Units <= 200)
	  	{
	  		Amount = 130 + 162.50 + ((Units - 100 ) * 5.26);
	  		Sur_Charge = 45; 	
	  	}
	  	else
	  	{
		   	Amount = 130 + 162.50 + 526 + ((Units - 200 ) * 7.75); 
		   	Sur_Charge = 55; 
		}
		
		this.Total_Amount = Amount + Sur_Charge;
	}
	public String toString()
	{
		String ans;
		ans= ""+Total_Amount;
		return ans;
	}
}





class PersonalFrame extends LoginFrame
{
   JPanel P1;
   JButton S1,c1;
   JTextField t1,t2,t3,t4,t5,t6,t7,t8;
   JLabel i,l0,l1,l2,l3,l4,l5,l6,l7,l8;
   String n,a1,a2,id,d,eb,mob,ad,stat;
   
   PersonalFrame(String name,String add1,String add2,String logId,String dst,String ebNo,String mob,String aadharNo,String status)
   {
	  this.n=name;
	  this.a1=add1;
	  this.a2=add2;
	  this.id=logId;
	  this.d=dst;
	  this.eb=ebNo;
	  this.mob=mob;
	  this.ad=aadharNo;
	  this.stat=status;
	setVisible(true);
     P1=new JPanel();
     constructUI();
     designUI();
	 setResizable(false);
	 //handleEvents();
     setSize(1200,600);
     setTitle("Personal Details");
	 
   }
   public void designUI()
   {
        P1.add(l0);P1.add(l1);P1.add(t1);P1.add(l2);P1.add(t2);P1.add(l3);P1.add(t3);
        P1.add(l4);P1.add(t4);P1.add(l5);P1.add(t5);P1.add(l6);P1.add(t6);
		P1.add(l7);P1.add(t7);P1.add(l8);P1.add(t8);/*P1.add(l9);P1.add(p1);
		P1.add(l10);P1.add(p2);P1.add(S1);P1.add(c1);*/P1.add(i);
		
		getContentPane().add(l0,BorderLayout.CENTER);
		l0.setBounds(320,30,1000,100);	
		
		getContentPane().add(l1,BorderLayout.CENTER);
		l1.setBounds(350,150,150,30);	
		
		getContentPane().add(t1,BorderLayout.CENTER);
		t1.setBounds(550,150,150,30);
		
		getContentPane().add(l2,BorderLayout.CENTER);
		l2.setBounds(350,200,150,30);	
		
		getContentPane().add(t2,BorderLayout.CENTER);
		t2.setBounds(550,200,150,30);
		
		getContentPane().add(l3,BorderLayout.CENTER);
		l3.setBounds(350,250,150,30);	
		
		getContentPane().add(t3,BorderLayout.CENTER);
		t3.setBounds(550,250,150,30);
		
		getContentPane().add(l4,BorderLayout.CENTER);
		l4.setBounds(350,300,150,30);	
		
		getContentPane().add(t4,BorderLayout.CENTER);
		t4.setBounds(550,300,150,30);
		
		getContentPane().add(l5,BorderLayout.CENTER);
		l5.setBounds(350,350,150,30);	
		
		getContentPane().add(t5,BorderLayout.CENTER);
		t5.setBounds(550,350,150,30);
		
		getContentPane().add(l6,BorderLayout.CENTER);
		l6.setBounds(350,400,150,30);	
		
		getContentPane().add(t6,BorderLayout.CENTER);
		t6.setBounds(550,400,150,30);
		
		getContentPane().add(l7,BorderLayout.CENTER);
		l7.setBounds(350,450,150,30);	
		
		getContentPane().add(t7,BorderLayout.CENTER);
		t7.setBounds(550,450,150,30);
		
		getContentPane().add(l8,BorderLayout.CENTER);
		l8.setBounds(350,500,150,30);	
		
		getContentPane().add(t8,BorderLayout.CENTER);
		t8.setBounds(550,500,150,30);
		
		
		add (P1);
   }
   public void constructUI()
   {
	    String n1=n;
		String a11=a1;
		String a22=a2;
		String lid=id;
		String ds=d;
		String ebN=eb;
		String mob1=mob;
		String ad1=ad;
		String stat1=stat;
		i=new JLabel(new ImageIcon("C:\\Users\\reshman\\Desktop\\GUI\\Project\\back4.jpg"));
        t1= new JTextField(15);
		t1.setEditable(false);
		System.out.println(n1);
		t1.setText(n1);
        t2= new JTextField(20);
		t2.setEditable(false);
		
        t3= new JTextField(20);
		t3.setEditable(false);
		t3.setText(a2);
		t4= new JTextField(10);
		t4.setEditable(false);
		t4.setText(d);
		t5= new JTextField(10);
		t5.setEditable(false);
		t5.setText(mob);
		t6= new JTextField(15);
		t6.setEditable(false);
		t6.setText(eb);
		t7= new JTextField(12);
		t7.setEditable(false);
		t7.setText(ad);
		t8= new JTextField(10);
		t8.setEditable(false);
		t8.setText(id);
		
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
		/*l9= new JLabel("Password:");
		l9.setForeground(Color.GREEN);
		l9.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		l10= new JLabel("Re-enter password:");
		l10.setForeground(Color.GREEN);
		l10.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		p1= new JPasswordField(10);
		p2= new JPasswordField(10);
        S1=new JButton("Submit");
		c1= new JButton("Cancel");*/
	    P1=new JPanel();
		P1.setBackground(Color.GREEN);
   }
}