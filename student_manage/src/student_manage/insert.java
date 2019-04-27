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
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class insert extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField sname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insert frame = new insert();
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
	public insert() {
		setTitle("\u63D2\u5165\u5B66\u751F\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 1, 5, 2));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u5B66\u751F\u4FE1\u606F\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 26));
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("\u5B66\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 28));
		panel_1.add(label, BorderLayout.WEST);
		
		id = new JTextField();
		id.setFont(new Font("宋体", Font.BOLD, 20));
		panel_1.add(id, BorderLayout.EAST);
		id.setColumns(28);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		sname = new JTextField();
		sname.setFont(new Font("宋体", Font.BOLD, 20));
		sname.setColumns(28);
		panel_2.add(sname, BorderLayout.EAST);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 28));
		panel_2.add(label_1, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel("\u751F\u65E5\uFF1A");
		label_2.setFont(new Font("宋体", Font.BOLD, 28));
		panel_3.add(label_2, BorderLayout.WEST);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6, BorderLayout.CENTER);
		
		String[]year = new String[15];
		for(int i = 0;i<15;i++) {
			year[i] = i+1995+"";
		}
		String[] month = new String[12];
		for(int i =0;i<12;i++)
		{
			month[i] = 1+i+"";
		}
		String[] day = new String[31];
		for(int i =0;i<31;i++)
		{
			day[i] = 1+i+"";
		}
		
		JComboBox year_comboBox = new JComboBox(year);
		year_comboBox.setFont(new Font("宋体", Font.BOLD, 26));
		panel_6.add(year_comboBox);
		JComboBox month_comboBox = new JComboBox(month);
		month_comboBox.setFont(new Font("宋体", Font.BOLD, 26));
		panel_6.add(month_comboBox);
		JComboBox day_comboBox = new JComboBox(day);
		day_comboBox.setFont(new Font("宋体", Font.BOLD, 26));
		panel_6.add(day_comboBox);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label_3 = new JLabel("\u6027\u522B\uFF1A");
		label_3.setFont(new Font("宋体", Font.BOLD, 28));
		panel_4.add(label_3);
		
		String[] sexs = {"男","女"};
		JComboBox sex_comboBox = new JComboBox(sexs);
		sex_comboBox.setMaximumRowCount(2);
		sex_comboBox.setFont(new Font("宋体", Font.BOLD, 20));
		panel_4.add(sex_comboBox);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton submit = new JButton("\u63D0\u4EA4");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = id.getText();
				String name = sname.getText();
				String birDate = (String)year_comboBox.getSelectedItem() +  (String)month_comboBox.getSelectedItem() + (String)day_comboBox.getSelectedItem();
				String gender = (String)sex_comboBox.getSelectedItem();
				Student tmp = new Student();
				tmp.setID(Integer.parseInt(ID));
				tmp.setName(name);
				tmp.setBirDate(birDate);
				tmp.setGender(gender =="男"?true:false);
				StudentManager insertSt = new StudentManager();
				insertSt.read();
				insertSt.insert(tmp);
				try {
					insertSt.output();
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		submit.setFont(new Font("宋体", Font.BOLD, 22));
		panel_5.add(submit);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert.this.dispose();
				gui  menu = new gui();
				menu.setVisible(true);
			}
		});
		back.setFont(new Font("宋体", Font.BOLD, 22));
		panel_5.add(back);
		
		JButton exit = new JButton("\u9000\u51FA");
		exit.setFont(new Font("宋体", Font.BOLD, 22));
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		panel_5.add(exit);
	}

}
