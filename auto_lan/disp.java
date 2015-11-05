package auto_lan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class disp extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					disp frame = new disp();
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
	public disp() {
		setTitle("SENSHUWL_AUTO_LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		id = new JTextField();
		id.setBounds(121, 90, 127, 28);
		contentPane.add(id);
		id.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(121, 153, 127, 28);
		contentPane.add(pass);
		
		JLabel lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(77, 96, 32, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPasswar = new JLabel("passward");
		lblPasswar.setBounds(50, 159, 59, 16);
		contentPane.add(lblPasswar);
		
		JButton btnSet = new JButton("set");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			command_ran cr = new command_ran(id.getText(),pass.getPassword());
			}
		});
		btnSet.setBounds(211, 230, 117, 29);
		contentPane.add(btnSet);
		
		JLabel lblMac = new JLabel("ログインのポップが出てくるけど閉じてね");
		lblMac.setBounds(50, 40, 296, 16);
		contentPane.add(lblMac);
	}
}
