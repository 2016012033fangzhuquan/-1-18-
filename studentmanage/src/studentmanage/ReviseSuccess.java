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

public class ReviseSuccess extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviseSuccess frame = new ReviseSuccess();
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
	public ReviseSuccess() {
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
		
		JLabel tipsText = new JLabel("\u5B66\u751F\u4FE1\u606F\u5DF2\u4FEE\u6539\u6210\u529F\u3002");
		tipsText.setFont(new Font("宋体", Font.BOLD, 30));
		tips.add(tipsText);
		
		//确认结果并退回上级
		JPanel panelButton = new JPanel();
		contentPane.add(panelButton, BorderLayout.SOUTH);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReviseSuccess.this.dispose();
				Revise re = new Revise();
				re.setVisible(true);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 26));
		panelButton.add(button);
	}

}
