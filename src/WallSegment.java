
public class WallSegment {
	private double charge;
	private double yPos;
	
	public WallSegment(double c, double y)
	{
		charge = c;
		yPos = y;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}
}
