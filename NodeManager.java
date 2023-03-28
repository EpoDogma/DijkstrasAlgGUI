import java.awt.Container;

public class NodeManager {
	private Container contentPanel;
	private NodeMap map;
	
	public NodeManager(Container contentPanel)	{
		this(contentPanel, 0);
	}
	
	public NodeManager(Container contentPanel, int numNodes)	{
		this.contentPanel = contentPanel;
		this.map = new NodeMap();
		
		initialize(numNodes);
	}
	
	public void initialize(int numNodes)	{
		for (int i = 0; i < numNodes; i++)	{
			addNode();
		}
		
		contentPanel.add(map);
	}
	
	public void deleteNode(int ID) {
		map.deleteNode(ID);
	}
	
	public void deleteAllNodes()	{
		map.deleteAllNodes();
	}
	
	public void addNode()	{
		Node node = new Node();
		
		map.addNode(node);
	}
	
	public void refresh()	{
		// TODO: Refresh locations of nodes on map
		System.out.println("nm.refresh");
	}
}