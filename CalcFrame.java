import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class CalcFrame extends JFrame 
{
	JLabel title,des,unit,amt;
	JTextField tu;
	JTextField t2;
	JButton gen;
	JButton b1;
	JPanel p;
	CalcFrame()
   {
     setSize(500,450);
     setResizable(false);
     setTitle("Generate Bill");
	 constructUI();
	 designUI();
	 setVisible(true);
	 handleEvent();
	
   }
	 public void constructUI()
	{
		des=new JLabel(new ImageIcon("C:\\Users\\reshman\\Desktop\\GUI\\Images\\bulb7.jpg"));
		t2 = new JTextField(10);
		title = new JLabel("Calculate Amount");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Comic Sans MS",Font.BOLD,40));
		unit = new JLabel("Unit");
		unit.setForeground(Color.WHITE);
		unit.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		amt=new JLabel("Amount:");
		amt.setForeground(Color.WHITE);
		amt.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		tu = new JTextField(10);
		p = new JPanel();
		p.setBackground(Color.BLACK);
		gen = new JButton("Generate");
	}
	public void designUI()
	{
		
		p.add(title);p.add(unit);p.add(tu);
		p.add(t2);p.add(gen);
		getContentPane().add(title,BorderLayout.CENTER);
		title.setBounds(100,75,1000,50);
		getContentPane().add(unit,BorderLayout.CENTER);
		unit.setBounds(100,150,150,30);
		getContentPane().add(tu,BorderLayout.CENTER);
		tu.setBounds(200,150,150,30);
		getContentPane().add(amt,BorderLayout.CENTER);
		amt.setBounds(100,200,150,30);
		getContentPane().add(t2,BorderLayout.CENTER);
		t2.setBounds(200,200,150,30);
		getContentPane().add(gen,BorderLayout.CENTER);
		gen.setBounds(200,250,150,30);
		
		p.add(des);
	    add(p);	
		t2.setEditable(false);
	}
	public void handleEvent()
	{
		gen.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent ae) 
			{
				try{
				double x=Double.parseDouble(tu.getText());
				CalculateBill c1=new CalculateBill(x);
				t2.setText(c1.toString());
				}
				catch(NumberFormatException e)
				{
					System.out.println(e);
				}
			}
		}
		);
   
}

}
