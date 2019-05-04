package student_manage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class delete extends JFrame {

	private JPanel contentPane;
	private JTextField deName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete frame = new delete();
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
	public delete() {
		setTitle("\u5220\u9664\u5B66\u751F\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 382);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 5, 2));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("\u67E5\u627E\u5B66\u751F\u4FE1\u606F\u5E76\u5220\u9664\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 26));
		panel_1.add(label, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 26));
		panel.add(label_1, BorderLayout.WEST);
		
		deName = new JTextField();
		deName.setFont(new Font("宋体", Font.BOLD, 26));
		panel.add(deName, BorderLayout.CENTER);
		deName.setColumns(28);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton delete = new JButton("\u5220\u9664");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchName = deName.getText();
				StudentManager deleteSt = new StudentManager();
				deleteSt.read();
				int index = deleteSt.delete(searchName);
				if(index == -1) {
					delete.this.dispose();
					delete_fail deleteF = new delete_fail();
					deleteF.setVisible(true);
				}
				else {
					delete.this.dispose();
					delete_success deleteS = new delete_success();
					deleteS.setVisible(true);
				}
			}
		});
		delete.setFont(new Font("宋体", Font.BOLD, 26));
		panel_2.add(delete);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete.this.dispose();
				gui menu = new gui();
				menu.setVisible(true);
			}
		});
		back.setFont(new Font("宋体", Font.BOLD, 26));
		panel_2.add(back);
		
		JButton exit = new JButton("\u9000\u51FA");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setFont(new Font("宋体", Font.BOLD, 26));
		panel_2.add(exit);
	}

}
