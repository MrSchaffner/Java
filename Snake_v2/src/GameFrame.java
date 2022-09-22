import javax.swing.JFrame;

public class GameFrame extends JFrame{

	public GameFrame() { //Only called be SnakeGame()
		// TODO Auto-generated constructor stub
		this.add(new GamePanel());// since it wasn't named, it can't be called later.
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
}
