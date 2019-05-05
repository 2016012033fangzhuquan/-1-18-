package StudentManage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindFail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindFail frame = new FindFail();
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
	public FindFail() {
		setTitle("\u67E5\u627E\u5931\u8D25");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel resultTips = new JPanel();
		contentPane.add(resultTips, BorderLayout.CENTER);
		resultTips.setLayout(new BorderLayout(0, 0));
		
		JLabel resultTipsText = new JLabel("\u9519\u8BEF\uFF01\u67E5\u65E0\u6B64\u4EBA\uFF01\u8BF7\u91CD\u65B0\u786E\u8BA4\uFF01");
		resultTipsText.setFont(new Font("宋体", Font.BOLD, 30));
		resultTips.add(resultTipsText);
		
		JPanel panelButton = new JPanel();
		contentPane.add(panelButton, BorderLayout.SOUTH);
		
		//确认结果并退回上级
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindFail.this.dispose();
				Find fi = new Find();
				fi.setVisible(true);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 26));
		panelButton.add(button);
	}

}
