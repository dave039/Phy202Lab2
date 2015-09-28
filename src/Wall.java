
public class Wall {
	WallSegment[] segs;
	
	public Wall()
	{
		segs = new WallSegment[10];
		
		for(int i = 0; i < segs.length; i++)
		{
			segs[i] = new WallSegment(0, (100 * i) + 50);
		}
	}
	
	public Wall(Wall w)
	{
		segs = new WallSegment[10];
		
		for(int i = 0; i < segs.length; i++)
		{
			segs[i] = w.getSegAt(i);
		}
	}
	
	public double getTotalCharge()
	{
		double total = 0d;
		
		for(int i = 0; i < segs.length; i++)
		{
			total += segs[i].getCharge();
		}
		
		return total;
	}
	
	public WallSegment getSegAt(int i)
	{
		WallSegment ws = null;
		
		try
		{
			ws = segs[i];
		}
		catch(Exception e)
		{
			System.err.println("Index out of bounds Wall: getSegAt(int i)");
		}
		
		return ws;
	}
	
	public void setChargeAt(int i, double c)
	{
		try
		{
			segs[i].setCharge(c);
		}
		catch(Exception e)
		{
			System.out.println("Index out of bounds Wall: setChargeAt(int i)");
		}
	}
	
	public WallSegment[] getSegs() {
		return segs;
	}

	public void setSegs(WallSegment[] segs) {
		this.segs = segs;
	}
}
