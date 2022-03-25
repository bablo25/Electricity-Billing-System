import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.*;
import java.awt.BorderLayout;

class LoginFrame extends JFrame
{
	Connection con;
	Statement st;
	ResultSet rs;

	JLabel img;
	
	JPanel p1,p2;
	JTextField usertf;
	JPasswordField pf;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JCheckBox c1;
	private JButton b1,b2;
	LoginFrame()
	{
		try
		{
			
			Toolkit kit=Toolkit.getDefaultToolkit();
			Dimension d=kit.getScreenSize();
			Image logo=kit.getImage("logo1.jpg");
			setIconImage(logo);
			setSize(d.width,d.height);
			
			setTitle("LOGIN PAGE");
			constructUI();
			designUI();
			setVisible(true);
			
			
			
			handleEvent();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void constructUI()
	{
		img=new JLabel(new ImageIcon("C:\\Users\\reshman\\Desktop\\GUI\\Project\\back2.jpg"));
		p1=new JPanel();
		p1.setBackground(Color.BLACK);
		l4=new JLabel("ELECTRICITY BILLING SYSTEM");
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Century Schoolbook",Font.BOLD, 30));
		l1=new JLabel(" USER CREDENTIALS ");
		l1.setForeground(Color.YELLOW);
		l1.setFont(new Font("Century Schoolbook",Font.BOLD,20));
		l2=new JLabel("USERNAME:");
		l2.setForeground(Color.GREEN);
		l2.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		usertf=new JTextField(15);
		l3=new JLabel("PASSWORD:");
		l3.setForeground(Color.GREEN);
		l3.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		pf=new JPasswordField(15);
		pf.setEchoChar('*');
		c1=new JCheckBox("Show Password");
		b1=new JButton("Login");
		b2=new JButton("Sign Up");
		l5=new JLabel("20BCS099-Hariharakrishnan B");
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
		l6=new JLabel("20BCS107-Nithish Kumar J");
		l6.setForeground(Color.WHITE);
		l6.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
		l7=new JLabel("20BCS111-Reshman Bablo B");
		l7.setForeground(Color.WHITE);
		l7.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
	}
	public void designUI()
	{
		p1.add(img);
		getContentPane().add(l4);
		l4.setBounds(600,0,1000,200);
		getContentPane().add(l1);
		l1.setBounds(875,200,1000,30);
		getContentPane().add(l2);
		l2.setBounds(850,250,1000,30);
		getContentPane().add(usertf);
		usertf.setBounds(950,250,150,30);
		getContentPane().add(l3);
		l3.setBounds(850,300,1000,30);
		getContentPane().add(pf);
		pf.setBounds(950,300,150,30);
		getContentPane().add(c1);
		c1.setBounds(950,350,150,30);
		getContentPane().add(b1);
		b1.setBounds(850,400,100,30);
		getContentPane().add(b2);
		b2.setBounds(1000,400,100,30);
		getContentPane().add(l5);
		l5.setBounds(10,650,300,30);
		getContentPane().add(l6);
		l6.setBounds(10,675,300,30);
		getContentPane().add(l7);
		l7.setBounds(10,700,300,30);
		
		add(p1);
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
	public void handleEvent()
	{
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					makeConnection();
					rs=st.executeQuery("select * from eBill");
					rs.first();
					String x=usertf.getText();
					String y=pf.getText();
					int key=0;
					do
					{
						if((x.equals(rs.getString(1)))&&(y.equals(rs.getString(2))))
						{
							JOptionPane.showMessageDialog(null,"Log In Successfull");
							MainFrame f1 =new MainFrame(rs);
							key=1;
						}
					}while(rs.next());
					if(key==0)
					{
						JOptionPane.showMessageDialog(null,"Credentials Invalid");
						rs.first();
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		);
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				RegistrationFrame r1=new RegistrationFrame();
			}
		}
		);
		c1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ae)
			{
				if(ae.getSource()==c1)
				{
					if(c1.isSelected())
					{
						pf.setEchoChar((char) 0);
					}
					else
					{
						pf.setEchoChar('*');
					}
				}
			}
		});
		
	}
}




class MainFrame extends JFrame
{
	JFrame frame;
	ResultSet rs;
	Connection con;
	Statement st;
	ResultSet rs1;
	JLabel imag,title;
	JPanel pan,p1;
	JMenuBar mb;
	JMenu personal,calculate,generatebill,nameM;
	JMenuItem logP,perP,newP,calcC,billG,statusG,delG;
	String status,name;
	
	MainFrame(ResultSet x)
	{
		frame=new JFrame();
		this.rs=x;
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		frame.setSize(d.width,d.height);
		
		frame.setTitle("Electricity Billing System");
		constructUI();
		designUI();
		frame.setVisible(true);
		handleEvent1();
	}
	public void constructUI()
	{
		
		name=getNamee();
		imag=new JLabel(new ImageIcon("C:\\Users\\reshman\\Desktop\\GUI\\Project\\back1.jpg"));
		pan=new JPanel();
		p1=new JPanel();
		pan.setBackground(Color.BLACK);
		
		mb=new JMenuBar();
		
		nameM=new JMenu("Welcome "+getNamee());
		personal=new JMenu("Personal");
		calculate=new JMenu("Calculate");
		generatebill=new JMenu("Billing");
		
		newP=new JMenuItem("New User");
		newP.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
		logP=new JMenuItem("Logout");
		logP.setAccelerator(KeyStroke.getKeyStroke("ctrl L"));
		perP=new JMenuItem("Info");
		perP.setAccelerator(KeyStroke.getKeyStroke("ctrl I"));
		delG=new JMenuItem("Delete Account");
		delG.setAccelerator(KeyStroke.getKeyStroke("ctrl D"));
		
		calcC=new JMenuItem("Calculate Amount");
		calcC.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
		
		billG=new JMenuItem("Generate Bill");
		billG.setAccelerator(KeyStroke.getKeyStroke("ctrl B"));
		statusG=new JMenuItem("Check Status");
		statusG.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		
		title=new JLabel("Welcome"+name);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
		
		status=getStatus();	
		
	}
	public String getNamee()
	{
		try
		{
			String name=rs.getString(4);
			return name;
		}
		catch(Exception e)
		{
			System.out.println(e);
			String name="error";
			return name;
		}
	}
	public String getStatus()
	{
		try
		{
			String nam=rs.getString(11);
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
		personal.setMnemonic('P');
		calculate.setMnemonic('C');
		generatebill.setMnemonic('B');
		
		personal.add(perP);personal.add(newP);personal.add(logP);personal.add(delG);
		perP.setMnemonic('I');newP.setMnemonic('N');logP.setMnemonic('L');delG.setMnemonic('D');
		
		calculate.add(calcC);
		calcC.setMnemonic('U');
		
		generatebill.add(billG);generatebill.add(statusG);
		billG.setMnemonic('G');statusG.setMnemonic('S');
		
		mb.add(nameM);mb.add(personal);mb.add(calculate);mb.add(generatebill);
	
		frame.setJMenuBar(mb);
				
		pan.add(title);	
		frame.add(pan);
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
	public void handleEvent1()
	{
		newP.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				RegistrationFrame r1=new RegistrationFrame();
			}
		}
		);
		perP.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				PersonalFrame p1=new PersonalFrame(name);
			}
		}
		);
		calcC.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				CalcFrame r1=new CalcFrame();
			}
		}
		);
		billG.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				BillFrame f1=new BillFrame(name);
			}
		}
		);
		statusG.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{			
			try
			{
				
				makeConnection();
				rs1=st.executeQuery("select * from eBill");
				rs1.first();
				do
				{
					if((name.equals(rs1.getString(4))))
					{		
						JOptionPane.showMessageDialog(null,"Status:"+rs1.getString(11));
					}
				}while(rs1.next());
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			}
		}
		);
		delG.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{			
			try
			{
				
				makeConnection();
				rs1=st.executeQuery("select * from eBill");
				rs1.first();
				int y=JOptionPane.showConfirmDialog(null,"Confirm Deletion","ALERT",JOptionPane.OK_CANCEL_OPTION);
				if(y==JOptionPane.OK_OPTION)
				{
					int x=st.executeUpdate("delete from eBill where name='"+name+"'");
					if (x==0)
					{
						JOptionPane.showMessageDialog(null,"Deletion UnSuccessful");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Deletion Successful");
						frame.dispose();
					}
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			}
		}
		);
		logP.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				JOptionPane.showMessageDialog(null,"Logged Out Successfully");
				frame.dispose();
			}
		}
		);
	}
}

public class MyProject
{ 
	public static void main(String[]arg)
	{
		LoginFrame f1=new LoginFrame();
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
