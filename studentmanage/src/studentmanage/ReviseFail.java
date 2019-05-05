package studentmanage;

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

public class ReviseFail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviseFail frame = new ReviseFail();
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
	public ReviseFail() {
		setTitle("\u5220\u9664\u5931\u8D25");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel tips = new JPanel();
		contentPane.add(tips, BorderLayout.CENTER);
		tips.setLayout(new BorderLayout(0, 0));
		
		JLabel tipsText = new JLabel("\u9519\u8BEF\uFF01\u67E5\u65E0\u6B64\u4EBA\uFF01\u8BF7\u91CD\u65B0\u786E\u8BA4\uFF01");
		tipsText.setFont(new Font("宋体", Font.BOLD, 30));
		tips.add(tipsText);
		
		//确认结果并退回上级
		JPanel panelbutton = new JPanel();
		contentPane.add(panelbutton, BorderLayout.SOUTH);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReviseFail.this.dispose();
				Revise re = new Revise();
				re.setVisible(true);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 26));
		panelbutton.add(button);
	}

}
