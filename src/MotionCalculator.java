
public class MotionCalculator {
	public static final double CONSTANT_K = 8.99E+9;
	public static final double COULOMB_PER_mC = 1E-3;
	public static final double TOTAL_TIME = 9.0d;
	
	private double delta;
	
	private double closestX;
	
	private Torpedo torpedo;
	private Wall wall;
	
	public MotionCalculator(Wall w, double d)
	{
		torpedo = new Torpedo();
		wall = new Wall(w);
		
		delta = d;
		
		double ctr = 0d;
		while(ctr < (TOTAL_TIME / delta))
		{
			for(int j = 0; j < wall.getSegs().length; j++)
			{
				WallSegment ws = wall.getSegAt(j);
				double force = getForce(ws);
				double angle = getAngle(ws);
				double fx = Math.cos(angle) * force;
				double fy = Math.sin(angle) * force;
				
				torpedo.incrementXForce(fx);
				torpedo.incrementYForce(fy);	
			}
			
			torpedo.updatePos(delta);
			
			ctr += delta;
		}
		
		closestX = torpedo.getXloc().get(0);
		
		for(int i = 1; i < torpedo.getXloc().size(); i++)
		{
			double x = torpedo.getXloc().get(i);
			if(x < closestX)
			{
				closestX = x;
			}
		}
		
		System.out.println(closestX);
	}
	
	public MotionCalculator(MotionCalculator m)
	{
		torpedo = m.getTorpedo();
		wall = m.getWall();
		delta = m.getDelta();
	}
	
	public double getAcceleration(double force)
	{ 
		return force / Torpedo.MASS;
	}
	
	public double getTotalForce()
	{
		double totForce = 0;
		
		for(int i = 0; i < wall.getSegs().length; i++)
		{
			totForce += getForce(wall.getSegAt(i));
		}
		
		return totForce;
	}
	
	public double getForce(WallSegment seg)
	{
		double chgC = seg.getCharge() * COULOMB_PER_mC;
		double num = CONSTANT_K * Torpedo.CHARGE * chgC;
		double distance = getDistance(seg);
		double r2 = distance * distance;
		
		return num / r2;
	}
	
	public double getDistance(WallSegment seg)
	{
		double ydis = torpedo.getyPos() - seg.getyPos();
		double xdis = torpedo.getxPos();
		
		double y2 = ydis * ydis;
		double x2 = xdis * xdis;
		
		return Math.sqrt(x2 + y2);
	}
	
	public double getAngle(WallSegment seg)
	{
		double ydis = torpedo.getyPos() - seg.getyPos();
		double xdis = torpedo.getxPos();
		return Math.atan(ydis / xdis);
	}

	public double getDelta() {
		return delta;
	}

	public void setDelta(double delta) {
		this.delta = delta;
	}

	public Torpedo getTorpedo() {
		return torpedo;
	}

	public void setTorpedo(Torpedo torpedo) {
		this.torpedo = torpedo;
	}

	public Wall getWall() {
		return wall;
	}

	public void setWall(Wall wall) {
		this.wall = wall;
	}

	public double getClosestX() {
		return closestX;
	}

	public void setClosestX(double closestX) {
		this.closestX = closestX;
	}
}
