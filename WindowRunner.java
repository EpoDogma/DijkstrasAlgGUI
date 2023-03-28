import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class WindowRunner extends JFrame {
	private static NodeManager nm;
	private JButton refreshButton;
	
	class RefreshButtonListener implements ActionListener	{
		@Override
		public void actionPerformed(ActionEvent e) {
			nm.refresh();
		}
	}
	
	public WindowRunner()	{
		this(600, 400, 100, 100, 0);
	}
	
	public WindowRunner(int numNodes)	{
		this(600, 400, 100, 100, numNodes);
	}
	
	private WindowRunner(int width, int height, int x, int y, int numNodes)	{
		super("Dijkstra's Algorithm");
		WindowRunner.nm = new NodeManager(this.getContentPane(), numNodes);
		
		initialize(width, height, x ,y);
	}
	
	private void initialize(int width, int height, int x, int y)	{
		// Configure Frame
		this.setBounds(x, y, width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(50, 50, 50));
		
		
		// Build Components
		refreshButton = new JButton("Refresh");
		refreshButton.setFont(new Font("Arial", Font.PLAIN, 10));
		refreshButton.setBackground(new Color(100, 100, 100));
		
		// Add Components to display
		this.add(refreshButton, BorderLayout.SOUTH);
		
		// ActionListeners
		refreshButton.addActionListener(new RefreshButtonListener());
		
		this.setVisible(true);
	}
	
	public static void main(String args[])	{
		new WindowRunner(7);
		
		try {
			Thread.sleep(1000);
		} 	catch (Exception e) {
			e.printStackTrace();
		}
		
		WindowRunner.nm.deleteAllNodes();
	}
}