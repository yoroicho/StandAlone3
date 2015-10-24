package panel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JcomboTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JcomboTest frame = new JcomboTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JcomboTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		final JLabel label = new JLabel("");
		contentPane.add(label, BorderLayout.CENTER);

		final JLabel lblItem= new JLabel("");
		contentPane.add(lblItem, BorderLayout.SOUTH);

		final JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println(comboBox.getSelectedItem().toString());
				main.Typist.sendKey(comboBox.getSelectedItem().toString());
			}
		});
		comboBox.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				System.out.println(comboBox.getSelectedItem().toString());
				main.Typist.sendKey(comboBox.getSelectedItem().toString());
			}
		});
		comboBox.setEditable(true);
		contentPane.add(comboBox, BorderLayout.NORTH);

		JButton btnDel = new JButton("Del");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeItem(comboBox.getSelectedItem());
				label.setText(Integer.toString(comboBox.getSelectedIndex()));
				lblItem.setText((String) comboBox.getSelectedItem());
			}
		});
		contentPane.add(btnDel, BorderLayout.WEST);

		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.addItem(comboBox.getSelectedItem());
				label.setText(Integer.toString(comboBox.getSelectedIndex()));
				lblItem.setText((String) comboBox.getSelectedItem());
			}
		});
		contentPane.add(btnEnter, BorderLayout.EAST);
 //
	}

}
