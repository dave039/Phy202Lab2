import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class ImagePanel extends JPanel{
	private int width;
	private int height;
	
	private Torpedo torp;
	
	public ImagePanel(int w, int h)
	{
		super();
		width = w;
		height = h;
	}
	
	public static void main(String[] args) {
		double k = 8.99E+9;
		double q1 = -4.52d * 1E-9;
		double q2 = 12.6d * 1E-9;
		double R1 = 0.06d;
		double R2 = 0.1d;
		double R13 = R1 * R1 * R1;
		double R23 = R2 * R2 * R2;
		double r = 0.04d;
		double pi = Math.PI;
		double e0 = 8.85E-12;
		
		double ans1 = (((1 / (4*pi*e0)) * q1) / R13) * r;
		double ans2 = ((k * q2) / R23) * r;
		
		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans1 + ans2);
		
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 10, height);
		
		if(torp != null)
		{
			g.setColor(Color.RED);
			for(int i = 0; i < torp.getXloc().size(); i++)
			{
				double xp = torp.getXloc().get(i);
				double yp = torp.getYloc().get(i);
				
				g.fillRect(convertX(xp), convertY(yp), 4, 4);
			}
		}
	}
	
	public int convertY(double y)
	{
		double yp = y / 1000d;
		double yph = yp * height;
		double dif = yph - (height / 2);
		double ny = (height / 2) - dif;
		return (int)ny; 
	}
	
	public int convertX(double x)
	{
		return (int)((x * width) / Torpedo.X_START);
	}
	
	public void drawTorpedoPath(Torpedo t)
	{
		torp = t;
		repaint();
	}
}
