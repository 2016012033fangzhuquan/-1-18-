package studentmanage;

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

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setTitle("\u5220\u9664\u5B66\u751F\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 382);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 5, 2));
		
		JPanel tips = new JPanel();
		contentPane.add(tips);
		tips.setLayout(new BorderLayout(0, 0));
		
		JLabel tipsText = new JLabel("\u67E5\u627E\u5B66\u751F\u4FE1\u606F\u5E76\u5220\u9664\uFF1A");
		tipsText.setFont(new Font("宋体", Font.BOLD, 26));
		tips.add(tipsText, BorderLayout.CENTER);
		
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
		
		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons);
		panelButtons.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		JButton delete = new JButton("\u5220\u9664");
		delete.addActionListener(new ActionListener() {
		//调用StudentManager类中方法完成查找并删除
			public void actionPerformed(ActionEvent e) {
				String searchName = nameTextArea.getText();
				StudentManager deleteSt = new StudentManager();
				deleteSt.read();
				int index = deleteSt.delete(searchName);
				if(index == -1) {
					Delete.this.dispose();
					DeleteFail deleteF = new DeleteFail();
					deleteF.setVisible(true);
				}
				else {
					Delete.this.dispose();
					DeleteSuccess deleteS = new DeleteSuccess();
					deleteS.setVisible(true);
				}
			}
		});
		delete.setFont(new Font("宋体", Font.BOLD, 26));
		panelButtons.add(delete);
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete.this.dispose();
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
