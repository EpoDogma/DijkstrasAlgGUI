import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Vector;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class NodeMap extends JComponent	{
	private Vector< Node > nodes;
	private Vector< Line2D > lines;
	
	public NodeMap() {
		this.nodes = new Vector<>();
	}
	
	@Override
	public void paintComponent(Graphics g)	{
		Graphics2D g2D = (Graphics2D) g;
		
		for (Node node: nodes)	{
			node.draw(g2D);
		}
	}

	public void deleteNode(int ID) {
		for (int i = 0; i < nodes.size(); i++)	{
			Node node = nodes.get(i);
			
			if (node.getID() == ID)	{
				Node.addUnboundID(node.getID());
				nodes.remove(i);
				break;
			}
		}
		
		repaint();
	}
	
	public void deleteAllNodes()	{
		while(true)	{
			Node node;
			
			if (nodes.size() == 0)	{
				break;
			}
			
			node = nodes.firstElement();
			
			Node.addUnboundID(node.getID());
			nodes.remove(0);
		}
		
		repaint();
	}

	public void addNode(Node node) {
		nodes.add(node);
		
		repaint();
	}
	
	// Distribute Nodes
	public void distributeNodes(int windowWidth, int windowHeight)	{
		/* Distribute nodes randomly in space within confines, 
		 * NO OVERLAP, 
		 * Increase minX as more nodes are added,
		 * Alg needs to be heavily weighted by total # nodes and current # nodes:
		 * 		X: %winMax?
		 * 		Y:
		 */
		
		// Window for x coord, shifts along by increments proportional to node #, 
		// window should reach total width by final node
	}
	
	// Determine which nodes are going to be connected
	
	// Draw Lines Between Nodes 
		// Line can be 50, 60, 150
}