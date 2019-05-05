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

public class DeleteSuccess extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteSuccess frame = new DeleteSuccess();
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
	public DeleteSuccess() {
		setTitle("\u5220\u9664\u5931\u8D25");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel deleteTips = new JPanel();
		contentPane.add(deleteTips, BorderLayout.CENTER);
		deleteTips.setLayout(new BorderLayout(0, 0));
		
		JLabel deleteTipsText = new JLabel("\u5DF2\u5C06\u8BE5\u5B66\u751F\u4FE1\u606F\u6210\u529F\u5220\u9664\u3002");
		deleteTipsText.setFont(new Font("宋体", Font.BOLD, 30));
		deleteTips.add(deleteTipsText);
		
		JPanel panelButton = new JPanel();
		contentPane.add(panelButton, BorderLayout.SOUTH);
		
		//确认结果并退回上级
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteSuccess.this.dispose();
				Delete de = new Delete();
				de.setVisible(true);
			}
		});
		button.setFont(new Font("宋体", Font.BOLD, 26));
		panelButton.add(button);
	}

}
