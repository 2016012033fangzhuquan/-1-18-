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
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Find extends JFrame {
	private JPanel contentPane;
	private JTextField nameTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Find frame = new Find();
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
	public Find() {
		setTitle("\u67E5\u627E\u5B66\u751F\u4FE1\u606F");
		setBackground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 1, 5, 2));
		
		JPanel tips = new JPanel();
		contentPane.add(tips);
		tips.setLayout(new BorderLayout(0, 0));
		
		JLabel tipsText = new JLabel("\u8FDB\u884C\u5B66\u751F\u4FE1\u606F\u67E5\u627E\uFF1A");
		tipsText.setFont(new Font("宋体", Font.BOLD, 26));
		tips.add(tipsText, BorderLayout.CENTER);
		
		JPanel studentName = new JPanel();
		contentPane.add(studentName);
		studentName.setLayout(new BorderLayout(0, 0));
		
		JLabel name = new JLabel("\u59D3\u540D\uFF1A");
		name.setFont(new Font("宋体", Font.BOLD, 24));
		studentName.add(name, BorderLayout.WEST);
		
		nameTextArea = new JTextField();
		nameTextArea.setFont(new Font("宋体", Font.BOLD, 20));
		studentName.add(nameTextArea, BorderLayout.CENTER);
		nameTextArea.setColumns(28);
		
		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons);
		panelButtons.setLayout(new GridLayout(1, 3, 0, 0));
		
		//使用查找功能
		JButton find = new JButton("\u67E5\u627E");
		find.setFont(new Font("宋体", Font.BOLD, 25));
		panelButtons.add(find);
		
		//退回上级菜单
		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Find.this.dispose();
				GUI menu = new GUI();
				menu.setVisible(true);
			}
		});
		back.setFont(new Font("宋体", Font.BOLD, 25));
		panelButtons.add(back);

		//直接退出整个系统	
		JButton exit = new JButton("\u9000\u51FA");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setFont(new Font("宋体", Font.BOLD, 25));
		panelButtons.add(exit);
		
		JPanel listHead = new JPanel();
		contentPane.add(listHead);
		listHead.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel resultId = new JLabel("\u5B66\u53F7");
		resultId.setFont(new Font("宋体", Font.BOLD, 26));
		listHead.add(resultId);
		
		JLabel resultName = new JLabel("\u59D3\u540D");
		resultName.setFont(new Font("宋体", Font.BOLD, 26));
		listHead.add(resultName);
		
		JLabel resultBirth = new JLabel("\u751F\u65E5");
		resultBirth.setFont(new Font("宋体", Font.BOLD, 26));
		listHead.add(resultBirth);
		
		JLabel resultGender = new JLabel("\u6027\u522B");
		resultGender.setFont(new Font("宋体", Font.BOLD, 26));
		listHead.add(resultGender);
		
		JPanel listBody = new JPanel();
		contentPane.add(listBody);
		listBody.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel idText = new JLabel("");
		idText.setFont(new Font("宋体", Font.BOLD, 26));
		listBody.add(idText);
		
		JLabel nameText = new JLabel("");
		nameText.setFont(new Font("宋体", Font.BOLD, 26));
		listBody.add(nameText);
		
		JLabel birthText = new JLabel("");
		birthText.setFont(new Font("宋体", Font.BOLD, 26));
		listBody.add(birthText);
		
		JLabel genderText = new JLabel("");
		genderText.setFont(new Font("宋体", Font.BOLD, 26));
		listBody.add(genderText);
		
		
		//find按键功能设置，调用StudentManager中方法
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentManager findSt = new StudentManager();
				String searchName = nameTextArea.getText();
				findSt.read();
				int index = findSt.search(searchName);
				if(index == -1) {
					Find.this.dispose();
					FindFail findF = new FindFail();
					findF.setVisible(true);
				}
				else {
					idText.setText(findSt.students[index].getID() + "");
					nameText.setText(findSt.students[index].getName());
					birthText.setText(findSt.students[index].getBirDate());
					genderText.setText(findSt.students[index].getGender() == true ?"男":"女");
					tipsText.setText("查询成功，结果如下：");
				}
			}
		});
		
		
	}

}
