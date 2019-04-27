package student_manage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
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
	public gui() {
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 7));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(9, 1, 5, 2));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u8981\u6267\u884C\u7684\u64CD\u4F5C\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 26));
		panel.add(label, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel("*************************");
		label_1.setFont(new Font("宋体", Font.BOLD, 24));
		panel_1.add(label_1, BorderLayout.CENTER);
		
		JPanel insert = new JPanel();
		contentPane.add(insert);
		insert.setLayout(new BorderLayout(0, 0));
		
		JButton insert_ = new JButton("1  \u63D2\u5165");
		insert_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.this.dispose();
				insert ins = new insert();
				ins.setVisible(true);
			}
		});
		insert_.setFont(new Font("宋体", Font.BOLD, 24));

		insert.add(insert_, BorderLayout.CENTER);
		
		JLabel label_2 = new JLabel("*");
		label_2.setFont(new Font("宋体", Font.BOLD, 24));
		insert.add(label_2, BorderLayout.WEST);
		
		JLabel label_3 = new JLabel("*");
		label_3.setFont(new Font("宋体", Font.BOLD, 24));
		insert.add(label_3, BorderLayout.EAST);
		
		JPanel find = new JPanel();
		contentPane.add(find);
		find.setLayout(new BorderLayout(0, 0));
		
		JButton find_ = new JButton("2  \u67E5\u627E");
		find_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.this.dispose();
				find fi = new find();
				fi.setVisible(true);
			}
		});
		find_.setFont(new Font("宋体", Font.BOLD, 24));
		find.add(find_, BorderLayout.CENTER);
		
		JLabel label_4 = new JLabel("*");
		label_4.setFont(new Font("宋体", Font.BOLD, 24));
		find.add(label_4, BorderLayout.WEST);
		
		JLabel label_5 = new JLabel("*");
		label_5.setFont(new Font("宋体", Font.BOLD, 24));
		find.add(label_5, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JButton delete_ = new JButton("3  \u5220\u9664");
		delete_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.this.dispose();
				delete de = new delete();
				de.setVisible(true);
			}
		});
		delete_.setFont(new Font("宋体", Font.BOLD, 24));
		panel_4.add(delete_, BorderLayout.CENTER);
		
		JLabel label_6 = new JLabel("*");
		label_6.setFont(new Font("宋体", Font.BOLD, 24));
		panel_4.add(label_6, BorderLayout.WEST);
		
		JLabel label_10 = new JLabel("*");
		label_10.setFont(new Font("宋体", Font.BOLD, 24));
		panel_4.add(label_10, BorderLayout.EAST);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JButton revise_ = new JButton("4  \u4FEE\u6539");
		revise_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.this.dispose();
				revise re = new revise();
				re.setVisible(true);
			}
		});
		revise_.setFont(new Font("宋体", Font.BOLD, 24));
		panel_5.add(revise_, BorderLayout.CENTER);
		
		JLabel label_7 = new JLabel("*");
		label_7.setFont(new Font("宋体", Font.BOLD, 24));
		panel_5.add(label_7, BorderLayout.WEST);
		
		JLabel label_11 = new JLabel("*");
		label_11.setFont(new Font("宋体", Font.BOLD, 24));
		panel_5.add(label_11, BorderLayout.EAST);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JButton output_ = new JButton("5  \u8F93\u51FA");
		output_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.this.dispose();
				output OP = new output();
				OP.setVisible(true);
			}
		});
		output_.setFont(new Font("宋体", Font.BOLD, 24));
		panel_6.add(output_, BorderLayout.CENTER);
		
		JLabel label_8 = new JLabel("*");
		label_8.setFont(new Font("宋体", Font.BOLD, 24));
		panel_6.add(label_8, BorderLayout.WEST);
		
		JLabel label_12 = new JLabel("*");
		label_12.setFont(new Font("宋体", Font.BOLD, 24));
		panel_6.add(label_12, BorderLayout.EAST);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JButton exit_ = new JButton("6  \u9000\u51FA");
		exit_.setFont(new Font("宋体", Font.BOLD, 24));
		exit_.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		panel_7.add(exit_, BorderLayout.CENTER);
		
		JLabel label_9 = new JLabel("*");
		label_9.setFont(new Font("宋体", Font.BOLD, 24));
		panel_7.add(label_9, BorderLayout.WEST);
		
		JLabel label_13 = new JLabel("*");
		label_13.setFont(new Font("宋体", Font.BOLD, 24));
		panel_7.add(label_13, BorderLayout.EAST);
		
		JPanel panel_8 = new JPanel();
		contentPane.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel label_14 = new JLabel("*************************");
		label_14.setFont(new Font("宋体", Font.BOLD, 24));
		panel_8.add(label_14, BorderLayout.CENTER);
		
		
	}

}
