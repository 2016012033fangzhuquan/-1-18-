package studentmanage;

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

public class Revise extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Revise frame = new Revise();
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
	public Revise() {
		setTitle("\u4FEE\u6539\u5B66\u751F\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 446);
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 5, 2));
		
		JPanel tips = new JPanel();
		contentPane.add(tips);
		tips.setLayout(new BorderLayout(0, 0));
		
		JLabel tipsText = new JLabel("\u67E5\u627E\u5B66\u751F\u4FE1\u606F\u5E76\u8FDB\u884C\u4FEE\u6539\uFF1A");
		tipsText.setFont(new Font("宋体", Font.BOLD, 26));
		tips.add(tipsText, BorderLayout.CENTER);
		
		
		//读取输入的学生名
		JPanel panelName = new JPanel();
		contentPane.add(panelName);
		panelName.setLayout(new BorderLayout(0, 0));
		
		JLabel name = new JLabel("\u59D3\u540D\uFF1A");
		name.setFont(new Font("宋体", Font.BOLD, 26));
		panelName.add(name, BorderLayout.WEST);
		
		nameTextArea = new JTextField();
		nameTextArea.setFont(new Font("宋体", Font.BOLD, 26));
		panelName.add(nameTextArea, BorderLayout.CENTER);
		nameTextArea.setColumns(28);
		
		//读取修改后的学生信息
		JPanel panelBirth = new JPanel();
		contentPane.add(panelBirth);
		panelBirth.setLayout(new BorderLayout(0, 0));
		
		JLabel birth = new JLabel("\u751F\u65E5\uFF1A");
		birth.setFont(new Font("宋体", Font.BOLD, 28));
		panelBirth.add(birth, BorderLayout.WEST);
		
		JPanel panelNewBirth = new JPanel();
		panelBirth.add(panelNewBirth, BorderLayout.CENTER);
		
			//学生生日下拉列表的选项设置
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
		
		JComboBox yearComboBox = new JComboBox(year);
		yearComboBox.setFont(new Font("宋体", Font.BOLD, 26));
		panelNewBirth.add(yearComboBox);
		JComboBox monthComboBox = new JComboBox(month);
		monthComboBox.setFont(new Font("宋体", Font.BOLD, 26));
		panelNewBirth.add(monthComboBox);
		JComboBox dayComboBox = new JComboBox(day);
		dayComboBox.setFont(new Font("宋体", Font.BOLD, 26));
		panelNewBirth.add(dayComboBox);
		
		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons);
		panelButtons.setLayout(new GridLayout(1, 0, 0, 0));
		
		//读取输入的学生名，先进行查找，根据查找结果进行 信息修改并跳转到修改成功页面 或者 直接跳转到失败页面 ，其中调用StudentManager类中搜索功能和修改功能的方法
		JButton revise = new JButton("\u67E5\u627E\u4FEE\u6539");
		revise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchName = nameTextArea.getText();
				String birDate = (String)yearComboBox.getSelectedItem() +  (String)monthComboBox.getSelectedItem() + (String)dayComboBox.getSelectedItem();
				StudentManager reviseSt = new StudentManager();
				reviseSt.read();
				int index = reviseSt.search(searchName);
				if(index == -1) {
					Revise.this.dispose();
					ReviseFail reviseF = new ReviseFail();
					reviseF.setVisible(true);
				}
				else {
					Student tmp = reviseSt.students[index];
					tmp.setBirDate(birDate);
					reviseSt.revise(searchName, tmp);
					Revise.this.dispose();
					ReviseSuccess reviseS= new ReviseSuccess();
					reviseS.setVisible(true);
				}
			}
		});
		revise.setFont(new Font("宋体", Font.BOLD, 26));
		panelButtons.add(revise);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Revise.this.dispose();
				GUI menu = new GUI();
				menu.setVisible(true);
			}
		});
		back.setFont(new Font("宋体", Font.BOLD, 26));
		panelButtons.add(back);
		
		JButton exit = new JButton("\u9000\u51FA");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setFont(new Font("宋体", Font.BOLD, 26));
		panelButtons.add(exit);
	}

}
