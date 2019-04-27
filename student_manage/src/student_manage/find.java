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
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class find extends JFrame {
	private JPanel contentPane;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					find frame = new find();
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
	public find() {
		setTitle("\u67E5\u627E\u5B66\u751F\u4FE1\u606F");
		setBackground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 1, 5, 2));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel title = new JLabel("\u8FDB\u884C\u5B66\u751F\u4FE1\u606F\u67E5\u627E\uFF1A");
		title.setFont(new Font("宋体", Font.BOLD, 26));
		panel_1.add(title, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 24));
		panel.add(label_1, BorderLayout.WEST);
		
		name = new JTextField();
		name.setFont(new Font("宋体", Font.BOLD, 20));
		panel.add(name, BorderLayout.CENTER);
		name.setColumns(28);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 3, 0, 0));
		
		JButton find = new JButton("\u67E5\u627E");
		find.setFont(new Font("宋体", Font.BOLD, 25));
		panel_2.add(find);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find.this.dispose();
				gui menu = new gui();
				menu.setVisible(true);
			}
		});
		back.setFont(new Font("宋体", Font.BOLD, 25));
		panel_2.add(back);
		
		JButton exit = new JButton("\u9000\u51FA");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setFont(new Font("宋体", Font.BOLD, 25));
		panel_2.add(exit);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 26));
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 26));
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("\u751F\u65E5");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 26));
		panel_4.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("\u6027\u522B");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 26));
		panel_4.add(lblNewLabel_3);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel id = new JLabel("");
		id.setFont(new Font("宋体", Font.BOLD, 26));
		panel_3.add(id);
		
		JLabel sname = new JLabel("");
		sname.setFont(new Font("宋体", Font.BOLD, 26));
		panel_3.add(sname);
		
		JLabel bir = new JLabel("");
		bir.setFont(new Font("宋体", Font.BOLD, 26));
		panel_3.add(bir);
		
		JLabel gender = new JLabel("");
		gender.setFont(new Font("宋体", Font.BOLD, 26));
		panel_3.add(gender);
		
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentManager findSt = new StudentManager();
				String searchName = name.getText();
				findSt.read();
				int index = findSt.search(searchName);
				if(index == -1) {
					find.this.dispose();
					find_fail findF = new find_fail();
					findF.setVisible(true);
				}
				else {
					id.setText(findSt.students[index].getID() + "");
					sname.setText(findSt.students[index].getName());
					bir.setText(findSt.students[index].getBirDate());
					gender.setText(findSt.students[index].getGender() == true ?"男":"女");
					title.setText("查询成功，结果如下：");
				}
			}
		});
		
		
	}

}
