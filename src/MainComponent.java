import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainComponent implements ActionListener{
	public static final int WIDTH = 812;
	public static final int HEIGHT = 635;
	
	private JFrame window;
	
	private JPanel jtfPanel;
	private ImagePanel imgPan;
	
	private JButton launchBut;
	
	private JTextField[] wallSegs;
	private JTextField deltaBox;

	private JLabel deltaTag;
	private JLabel resultTag;
	
	public static void main(String[] args) {
		new MainComponent();
	}
	
	public MainComponent()
	{
		window = new JFrame("LAB 2");
		
		jtfPanel = new JPanel();
		jtfPanel.setLayout(null);
		jtfPanel.setBounds(0, 0, 200, 600);
		
		imgPan = new ImagePanel(600, 400);
		imgPan.setBounds(200, 0, 600, 600);
		
		window.add(jtfPanel);
		window.add(imgPan);
		
		window.setLayout(null);
		//window.setLocation(2500, 200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH, HEIGHT);
		window.setVisible(true);
		
		launchBut = new JButton("LAUNCH");
		deltaBox = new JTextField();
		deltaTag = new JLabel("delta");
		resultTag = new JLabel("Closest X: ");
		
		jtfPanel.add(launchBut);
		jtfPanel.add(deltaBox);
		jtfPanel.add(deltaTag);
		jtfPanel.add(resultTag);
		
		launchBut.setBounds(50, 470, 100, 25);
		launchBut.addActionListener(this);
		
		deltaBox.setBounds(50, 450, 50, 20);
		deltaTag.setBounds(53, 439, 50, 10);
		resultTag.setBounds(30, 530, 200, 10);
		
		wallSegs = new JTextField[10];
		for(int i = 0; i < wallSegs.length; i++)
		{
			wallSegs[i] = new JTextField();
			wallSegs[i].setBounds(50, 370 - ((i * 40) + 1), 30, 20);
			jtfPanel.add(wallSegs[i]);
		}
		
		jtfPanel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		Wall w = new Wall();
		
		for(int i = 0; i < w.getSegs().length; i++)
		{
			if(wallSegs[i].getText().equals(""))
			{
				wallSegs[i].setText("0");
			}
			
			Double chg = Double.parseDouble(wallSegs[i].getText());
			w.setChargeAt(i, chg);
		}
		
		if(w.getTotalCharge() > 1.60001)
		{
			JOptionPane.showMessageDialog(null, "Your total charge must be less than or equal to 1.6mC.");
		}
		else
		{
			double del = 1;
			
			if(!deltaBox.getText().equals(""))
			{
				del = Double.parseDouble(deltaBox.getText());
			}
			
			MotionCalculator m = new MotionCalculator(w, del);
			imgPan.drawTorpedoPath(m.getTorpedo());
			resultTag.setText("Closest X: " + m.getClosestX());
		}
	}
}
