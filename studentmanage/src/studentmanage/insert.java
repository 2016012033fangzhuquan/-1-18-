package StudentManage;

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

public class Insert extends JFrame {

	private JPanel contentPane;
	private JTextField idTextArea;
	private JTextField studentName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert frame = new Insert();
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
	public Insert() {
		setTitle("\u63D2\u5165\u5B66\u751F\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 1, 5, 2));
		
		JPanel tips = new JPanel();
		contentPane.add(tips);
		tips.setLayout(new BorderLayout(0, 0));
		
		//以下各项均为读取输入学生信息
		JLabel tipsText = new JLabel("\u8F93\u5165\u5B66\u751F\u4FE1\u606F\uFF1A");
		tipsText.setFont(new Font("宋体", Font.BOLD, 26));
		tips.add(tipsText, BorderLayout.CENTER);
		
		JPanel panelId = new JPanel();
		contentPane.add(panelId);
		panelId.setLayout(new BorderLayout(0, 0));
		
		JLabel id = new JLabel("\u5B66\u53F7\uFF1A");
		id.setFont(new Font("宋体", Font.BOLD, 28));
		panelId.add(id, BorderLayout.WEST);
		
		idTextArea = new JTextField();
		idTextArea.setFont(new Font("宋体", Font.BOLD, 20));
		panelId.add(idTextArea, BorderLayout.EAST);
		idTextArea.setColumns(28);
		
		JPanel panelName = new JPanel();
		contentPane.add(panelName);
		panelName.setLayout(new BorderLayout(0, 0));
		
		studentName = new JTextField();
		studentName.setFont(new Font("宋体", Font.BOLD, 20));
		studentName.setColumns(28);
		panelName.add(studentName, BorderLayout.EAST);
		
		JLabel nameTextArea = new JLabel("\u59D3\u540D\uFF1A");
		nameTextArea.setFont(new Font("宋体", Font.BOLD, 28));
		panelName.add(nameTextArea, BorderLayout.WEST);
		
		JPanel panelBirth = new JPanel();
		contentPane.add(panelBirth);
		panelBirth.setLayout(new BorderLayout(0, 0));
		
		JLabel birthday = new JLabel("\u751F\u65E5\uFF1A");
		birthday.setFont(new Font("宋体", Font.BOLD, 28));
		panelBirth.add(birthday, BorderLayout.WEST);
		
		JPanel panelBirthSelect = new JPanel();
		panelBirth.add(panelBirthSelect, BorderLayout.CENTER);
		
		//定义生日信息下拉列表的选项
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
		
		JComboBox yearComboBox = new JComboBox(year);
		yearComboBox.setFont(new Font("宋体", Font.BOLD, 26));
		panelBirthSelect.add(yearComboBox);
		JComboBox monthComboBox = new JComboBox(month);
		monthComboBox.setFont(new Font("宋体", Font.BOLD, 26));
		panelBirthSelect.add(monthComboBox);
		JComboBox dayComboBox = new JComboBox(day);
		dayComboBox.setFont(new Font("宋体", Font.BOLD, 26));
		panelBirthSelect.add(dayComboBox);
		
		JPanel panelGender = new JPanel();
		contentPane.add(panelGender);
		panelGender.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel studentGender = new JLabel("\u6027\u522B\uFF1A");
		studentGender.setFont(new Font("宋体", Font.BOLD, 28));
		panelGender.add(studentGender);
		
		String[] sexs = {"男","女"};
		JComboBox sexComboBox = new JComboBox(sexs);
		sexComboBox.setMaximumRowCount(2);
		sexComboBox.setFont(new Font("宋体", Font.BOLD, 20));
		panelGender.add(sexComboBox);
		
		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons);
		panelButtons.setLayout(new GridLayout(1, 0, 0, 0));
		
		//读取上述的各文本框和combobox内容，并调用StudentManager类中的函数
		JButton submit = new JButton("\u63D0\u4EA4");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = idTextArea.getText();
				String name = studentName.getText();
				String birDate = (String)yearComboBox.getSelectedItem() +  (String)monthComboBox.getSelectedItem() + (String)dayComboBox.getSelectedItem();
				String gender = (String)sexComboBox.getSelectedItem();
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
		panelButtons.add(submit);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert.this.dispose();
				GUI  menu = new GUI();
				menu.setVisible(true);
			}
		});
		back.setFont(new Font("宋体", Font.BOLD, 22));
		panelButtons.add(back);
		
		JButton exit = new JButton("\u9000\u51FA");
		exit.setFont(new Font("宋体", Font.BOLD, 22));
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		panelButtons.add(exit);
	}

}
