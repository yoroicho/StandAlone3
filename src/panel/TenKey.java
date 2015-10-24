package panel;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;

public class TenKey {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TenKey window = new TenKey();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TenKey() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
		});
		frame.setTitle("⇖");
		frame.setType(Type.UTILITY);
		frame.setAlwaysOnTop(true);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TenKey.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		frame.setBounds(100, 100, 177, 192);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(4, 4, 0, 0));


		JButton button = new JButton("1");
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("2");
		frame.getContentPane().add(button_1);

		JButton button_2 = new JButton("3");
		frame.getContentPane().add(button_2);

		JButton button_3 = new JButton("4");
		frame.getContentPane().add(button_3);

		JButton button_4 = new JButton("5");
		frame.getContentPane().add(button_4);

		JButton button_5 = new JButton("6");
		frame.getContentPane().add(button_5);

		JButton button_6 = new JButton("7");
		frame.getContentPane().add(button_6);

		JButton button_7 = new JButton("8");
		frame.getContentPane().add(button_7);

		JButton button_8 = new JButton("9");
		frame.getContentPane().add(button_8);

		JButton button_9 = new JButton("*");
		frame.getContentPane().add(button_9);

		JButton button_10 = new JButton("0");
		frame.getContentPane().add(button_10);

		JButton button_11 = new JButton("#");
		frame.getContentPane().add(button_11);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
