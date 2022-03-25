import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.BorderLayout;

class BillFrame extends JFrame
{
	Connection con;
	Statement st;
	ResultSet rs;
	
	JPanel P1;
	String aa;
   JTextArea tprint;
   JButton print,pay;
   JTextField unitT;
   JLabel unitL,i;
   JLabel title;
   double unit=200;
  
   
   BillFrame(String x)
   {
	  
	   try
	   {
		setResizable(false);
		
		P1=new JPanel();
		setSize(1000,1000);
		constructUI();
		designUI();
		setVisible(true);
		setTitle("Bill Payment");
	 
		makeConnection();
		rs=st.executeQuery("select * from eBill");
		rs.first();
		this.aa=x;
		handleEvent();
		makeConnection();
		rs=st.executeQuery("select * from eBill");
		rs.first();
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
   }
   public void PrintTxt()
   {
	try{   
		do
		{
			if((aa.equals(rs.getString(4))))
			{	
				
				CalculateBill c1=new CalculateBill(unit);
				tprint.setText("========================================================"+"\n");
				tprint.setText(tprint.getText()+"\n");
				tprint.setText(tprint.getText()+" 	         ELECTRICITY BILL                   "+"\n");
				tprint.setText(tprint.getText()+"\n");
				tprint.setText(tprint.getText()+"========================================================"+"\n");
				tprint.setText(tprint.getText()+"\n");
				tprint.setText(tprint.getText()+"	NAME:"+rs.getString(4)+"\n");
				tprint.setText(tprint.getText()+"\n");
				tprint.setText(tprint.getText()+"	ADDRESS:"+rs.getString(5)+","+rs.getString(6)+"\n");
				tprint.setText(tprint.getText()+"\n");
				tprint.setText(tprint.getText()+"	DISTRICT:"+rs.getString(7)+"\n");
				tprint.setText(tprint.getText()+"\n");
				tprint.setText(tprint.getText()+"	MOBILE NO:"+rs.getString(8)+"\n");
				tprint.setText(tprint.getText()+"\n");
				tprint.setText(tprint.getText()+"	EB NO     :"+rs.getString(3)+"\n");
				tprint.setText(tprint.getText()+"\n");
				tprint.setText(tprint.getText()+"	AADHAR NO :"+rs.getString(9)+"\n");
				tprint.setText(tprint.getText()+"\n");
				tprint.setText(tprint.getText()+"	Unit consumped:"+rs.getString(10)+"\n");
				tprint.setText(tprint.getText()+"\n");
				tprint.setText(tprint.getText()+"	AMOUNT     :"+c1.toString()+"\n");
				tprint.setText(tprint.getText()+"\n");
				tprint.setText(tprint.getText()+"	STATUS     :"+rs.getString(11)+"\n");
				tprint.setText(tprint.getText()+"\n");
				tprint.setText(tprint.getText()+"========================================================"+"\n");
				tprint.setText(tprint.getText()+"	         SAVE ELECTRICITY				 "+"\n");
				tprint.setText(tprint.getText()+"========================================================"+"\n");
				tprint.setText(tprint.getText()+"\n");
				tprint.setForeground(Color.BLACK);
				tprint.setFont(new Font("Comic Sans MS",Font.BOLD,13));
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
        P1.add(title);P1.add(unitL);P1.add(unitT);P1.add(print);P1.add(tprint);P1.add(pay);
		
		getContentPane().add(title,BorderLayout.CENTER);
		title.setBounds(320,30,1000,100);	
		
		getContentPane().add(unitL,BorderLayout.CENTER);
		unitL.setBounds(50,370,200,30);	
		
		getContentPane().add(unitT,BorderLayout.CENTER);
		unitT.setBounds(200,370,150,30);
		
		getContentPane().add(print,BorderLayout.CENTER);
		print.setBounds(100,420,150,30);	
		
		getContentPane().add(tprint,BorderLayout.CENTER);
		tprint.setBounds(400,150,400,520);
		
		getContentPane().add(pay,BorderLayout.CENTER);
		pay.setBounds(530,680,150,30);	
		
		
		P1.add(i);
		add (P1);
   }
   public void constructUI()
   {
		i=new JLabel(new ImageIcon("C:\\Users\\reshman\\Desktop\\GUI\\Project\\bacK6.jpg"));
		
        title=new JLabel("BILL PAYMENT");
		title.setForeground(Color.BLACK);
		title.setFont(new Font("Comic Sans MS",Font.BOLD,40));
		unitL=new JLabel("Enter The Unit:");
		unitL.setForeground(Color.WHITE);
		unitL.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		unitT=new JTextField(10);
		print=new JButton("Print");
		pay=new JButton("Pay");
		tprint=new JTextArea(20,20);
		
		tprint.setEditable(false);
		P1=new JPanel();
		P1.setBackground(Color.BLACK);
	  
   }
   public void handleEvent()
   {
	   print.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent ae) 
			{
				try
				{
					unit=Double.parseDouble(unitT.getText());
					int x=st.executeUpdate("update eBill set unit="+unit+",status='UNPAID' where name='"+aa+"'");
					if (x==1)
					{
						JOptionPane.showMessageDialog(null,"Updation Successful");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Updation UnSuccessful");
					}
					makeConnection();
					rs=st.executeQuery("select * from eBill");
					rs.first();
					PrintTxt();
					}
				
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			}
		);
			pay.addActionListener( new ActionListener()
			{
				public void actionPerformed(ActionEvent ae) 
				{
				try
				{
					int y=JOptionPane.showConfirmDialog(null,"I hereby acknowledge that No refunds is provided.","Terms and Conditions",JOptionPane.OK_CANCEL_OPTION);
					if(y==JOptionPane.OK_OPTION)
					{
					int x=st.executeUpdate("update eBill set status='PAID'where name='"+aa+"'");
					
					if (x==1)
					{
						JOptionPane.showMessageDialog(null,"Payment Successful");
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Payment Unsuccessful");
					}
					makeConnection();
					rs=st.executeQuery("select * from eBill");
					rs.first();
					PrintTxt();
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
		
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
