import java.util.ArrayList;


public class Torpedo {
	public static final double MASS = 0.5d;
	public static final double CHARGE = 16.0d;
	public static final double INITIAL_VELOCITY = -1200.0d;
	public static final double X_START = 10000.0d;
	public static final double Y_START = 500.0d;
	
	private double xPos;
	private double yPos;
	private double xvel;
	private double yvel;
	private double xacc;
	private double yacc;
	private double fx;
	private double fy;
	
	private ArrayList<Double> xloc;
	private ArrayList<Double> yloc;
	
	public Torpedo()
	{
		xPos = X_START;
		yPos = Y_START;
		xvel = INITIAL_VELOCITY;
		yvel = 0;
		xacc = 0;
		yacc = 0;
		fx = 0;
		fy = 0;
		
		xloc = new ArrayList<Double>();
		yloc = new ArrayList<Double>();
	}
	
	public void updatePos(double delta)
	{
		xacc = fx / MASS;
		yacc = fy / MASS;
		
		xvel = xvel + (xacc * delta);
		yvel = yvel + (yacc * delta);
		
		double nx = xPos + (xvel * delta) + (0.5 * xacc * delta * delta);
		double ny = yPos + (yvel * delta) + (0.5 * yacc * delta * delta);
		
		xPos = nx;
		yPos = ny;
		
		xloc.add(xPos);
		yloc.add(yPos);
	}
	
	public void incrementXForce(double f)
	{
		fx += f;
	}
	
	public void incrementYForce(double f)
	{
		fy += f;
	}
	
	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}

	public double getXvel() {
		return xvel;
	}

	public void setXvel(double xvel) {
		this.xvel = xvel;
	}

	public double getYvel() {
		return yvel;
	}

	public void setYvel(double yvel) {
		this.yvel = yvel;
	}

	public double getXacc() {
		return xacc;
	}

	public void setXacc(double xacc) {
		this.xacc = xacc;
	}

	public double getYacc() {
		return yacc;
	}

	public void setYacc(double yacc) {
		this.yacc = yacc;
	}

	public double getFx() {
		return fx;
	}

	public void setFx(double fx) {
		this.fx = fx;
	}

	public double getFy() {
		return fy;
	}

	public void setFy(double fy) {
		this.fy = fy;
	}

	public ArrayList<Double> getXloc() {
		return xloc;
	}

	public void setXloc(ArrayList<Double> xloc) {
		this.xloc = xloc;
	}

	public ArrayList<Double> getYloc() {
		return yloc;
	}

	public void setYloc(ArrayList<Double> yloc) {
		this.yloc = yloc;
	}
}
