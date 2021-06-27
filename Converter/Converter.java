import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Converter
{
	public static void main (String[] args)
	{
		JFrame f=new JFrame("Converter Lite");
		f.setSize(430,350);
		
		ImageIcon img=new ImageIcon(Converter.class.getResource("Convert.PNG"));
		JLabel imglb=new JLabel(img);
		imglb.setBounds(115,20,img.getIconWidth(),img.getIconHeight());
		f.add(imglb);
		
		String to[]={"Meter","Feet","Inch","Centimeter"};
		
		JLabel l=new JLabel("Input in:");
		l.setBounds(100,70,100,20);
		f.add(l);
		
		JLabel l2=new JLabel("");
		l2.setBounds(100,150,250,20);
		l2.setFont(new Font("Vedrana",Font.ITALIC,10));
		l2.setBackground(Color.GRAY);
		f.add(l2);
		
		JLabel lcb=new JLabel("Convert To:");
		lcb.setBounds(100,170,100,20);
		f.add(lcb);
		
		JComboBox cb1=new JComboBox(to);
		cb1.setBounds(100,90,100,20);
		f.add(cb1);
		
		JComboBox cb=new JComboBox(to);
		cb.setBounds(100,190,100,20);
		f.add(cb);
		
		JTextField t=new JTextField();
		t.setBounds(100,125,200,30);
		f.add(t);
		
		JButton clr=new JButton("CLEAR");
		clr.setBounds(210,90,90,20);
		f.add(clr);
		
		JButton cnvrt=new JButton("Convert");
		cnvrt.setBounds(210,190,90,20);
		f.add(cnvrt);
		
		clr.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				t.setText("");
				l2.setText("");
			}
		});
		
		cnvrt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String input=""+cb1.getItemAt(cb1.getSelectedIndex());
				String output=""+cb.getItemAt(cb.getSelectedIndex());
				
				boolean bol=true;
				try{
					float data=Float.parseFloat(t.getText());
				}
				catch(NumberFormatException a){
					t.setText(""+"Wrong Input");
				}
				if(bol)
				{
					float data=Float.parseFloat(t.getText());
				
					if(input.equals(output))
						t.setText("Input & Output type same");
					else if(input.equals("Meter") && output.equals("Feet"))
						t.setText(""+data*3.281);
					else if(input.equals("Meter") && output.equals("Inch"))
						t.setText(""+data*39.37);
					else if((input.equals("Meter") && output.equals("Centimeter")))
						t.setText(data*100+"");
						
					else if((input.equals("Feet") && output.equals("Meter")))
						t.setText(data/3.281+"");
					else if((input.equals("Feet") && output.equals("Inch")))
						t.setText(data*12+"");
					else if((input.equals("Feet") && output.equals("Centimeter")))
						t.setText(data*30.48+"");
					
					else if((input.equals("Inch") && output.equals("Meter")))
						t.setText(data/39.37+"");
					else if((input.equals("Inch") && output.equals("Feet")))
						t.setText(data/12+"");
					else if((input.equals("Inch") && output.equals("Centimeter")))
						t.setText(data*2.54+"");
						
					else if((input.equals("Centimeter") && output.equals("Meter")))
						t.setText(data/100+"");
					else if((input.equals("Centimeter") && output.equals("Feet")))
						t.setText(data/30.48+"");
					else if((input.equals("Centimeter") && output.equals("Inch")))
						t.setText(data/2.54+"");
						
					l2.setText("Converted from "+input+" to "+output+"..!!!");
					
				}
			}
		});

		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}