import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WindowRunner extends JFrame {
	private static NodeManager nm;
	
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
		this.setBounds(x, y, width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(50, 50, 50));
		
		// RefreshButtonPanel
		JPanel refreshButtonPanel = new JPanel();
		refreshButtonPanel.setLayout(new GridBagLayout());
		refreshButtonPanel.setOpaque(false);
		
		// RefreshButton
		JButton refreshButton = new JButton("Refresh");
		refreshButton.setFont(new Font("Arial", Font.PLAIN, 10));
		refreshButton.setBackground(new Color(100, 100, 100));
		refreshButton.setFocusable(false);
		refreshButton.setRolloverEnabled(false);
		refreshButton.setPreferredSize(new Dimension(70, 20));
		
		// Add Components
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.LINE_END;
		refreshButtonPanel.add(refreshButton, gbc);
		this.add(refreshButtonPanel, BorderLayout.SOUTH);
		
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