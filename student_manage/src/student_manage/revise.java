package student_manage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JComboBox;

public class revise extends JFrame {

	private JPanel contentPane;
	private JTextField reName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					revise frame = new revise();
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
	public revise() {
		setTitle("\u4FEE\u6539\u5B66\u751F\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 446);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 5, 2));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("\u67E5\u627E\u5B66\u751F\u4FE1\u606F\u5E76\u8FDB\u884C\u4FEE\u6539\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 26));
		panel_1.add(label, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setFont(new Font("宋体", Font.BOLD, 26));
		panel_2.add(label_1, BorderLayout.WEST);
		
		reName = new JTextField();
		reName.setFont(new Font("宋体", Font.BOLD, 26));
		panel_2.add(reName, BorderLayout.CENTER);
		reName.setColumns(28);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel("\u751F\u65E5\uFF1A");
		label_2.setFont(new Font("宋体", Font.BOLD, 28));
		panel_3.add(label_2, BorderLayout.WEST);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.CENTER);
		
		
		String[]year = new String[20];
		for(int i = 0;i<20;i++) {
			year[i] = i+1985+"";
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
		panel_4.add(year_comboBox);
		JComboBox month_comboBox = new JComboBox(month);
		month_comboBox.setFont(new Font("宋体", Font.BOLD, 26));
		panel_4.add(month_comboBox);
		JComboBox day_comboBox = new JComboBox(day);
		day_comboBox.setFont(new Font("宋体", Font.BOLD, 26));
		panel_4.add(day_comboBox);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton revise = new JButton("\u67E5\u627E\u4FEE\u6539");
		revise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchName = reName.getText();
				String birDate = (String)year_comboBox.getSelectedItem() +  (String)month_comboBox.getSelectedItem() + (String)day_comboBox.getSelectedItem();
				StudentManager reviseSt = new StudentManager();
				reviseSt.read();
				int index = reviseSt.search(searchName);
				if(index == -1) {
					revise.this.dispose();
					revise_fail reviseF = new revise_fail();
					reviseF.setVisible(true);
				}
				else {
					Student tmp = reviseSt.students[index];
					tmp.setBirDate(birDate);
					reviseSt.revise(searchName, tmp);
					revise.this.dispose();
					revise_success reviseS= new revise_success();
					reviseS.setVisible(true);
				}
			}
		});
		revise.setFont(new Font("宋体", Font.BOLD, 26));
		panel.add(revise);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revise.this.dispose();
				gui menu = new gui();
				menu.setVisible(true);
			}
		});
		back.setFont(new Font("宋体", Font.BOLD, 26));
		panel.add(back);
		
		JButton exit = new JButton("\u9000\u51FA");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setFont(new Font("宋体", Font.BOLD, 26));
		panel.add(exit);
	}

}
