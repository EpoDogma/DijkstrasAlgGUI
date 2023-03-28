import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Collections;
import java.util.Vector;

@SuppressWarnings("serial")
public class Node extends Component	{
	private static int IDGEN = 0;
	private static Vector< Integer > unboundIDs = new Vector<>();
	private final int ID;
	private int length;
	private int x;
	private int y;
	
	public Node()	{
		this(30, 0, 0);
	}
	
	public Node(int x, int y)	{
		this(30, x, y);
	}
	
	public Node(int length, int x, int y)	{
		this.length = length;
		this.x = x;
		this.y = y;
		
		if (unboundIDs.size() > 0)	{
			ID = unboundIDs.firstElement();	// Auto-boxing
			unboundIDs.remove(0);
		}	else	{
			ID = IDGEN;
			IDGEN++;
		}
	}
	
	public void draw(Graphics g)	{
		Graphics2D g2D = (Graphics2D) g;
		Rectangle rect = new Rectangle(getX(), getY(), getLength(), getLength());
		
		g2D.setColor(new Color(20, 20, 20));
		g2D.setStroke(new BasicStroke(2));
		g2D.draw(rect);
		
		g2D.setColor(new Color(50, 60, 80)); 
		g2D.fill(rect);
	}

	public int getLength() {
		return length;
	}

	public int getID()	{
		return ID;
	}
	
	public int getX() {
		return y;
	}
	
	public int getY() {
		return x;
	}
	
	public static void addUnboundID(int ID)	{
		unboundIDs.add(ID);
		Collections.sort(unboundIDs);
		
		for (int i = unboundIDs.size() - 1; i >= 0; i--)	{
			if (unboundIDs.get(i) != IDGEN - 1)	{
				break;
			}

			IDGEN--;
			unboundIDs.remove(i);
		}
		
		System.out.println("Unbounded: " + ID);
	}
	
	public void setLength(int length) {
		this.length = length;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}