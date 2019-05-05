package StudentManage;

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

public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	//该界面提供多个按钮选择，每个按钮跳转到不同的功能界面
	public GUI() {
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 7));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(9, 1, 5, 2));
		
		JPanel tips = new JPanel();
		contentPane.add(tips);
		tips.setLayout(new BorderLayout(0, 0));
		
		JLabel tipsText = new JLabel("\u8BF7\u9009\u62E9\u8981\u6267\u884C\u7684\u64CD\u4F5C\uFF1A");
		tipsText.setFont(new Font("宋体", Font.BOLD, 26));
		tips.add(tipsText, BorderLayout.CENTER);
		
		JPanel topLine = new JPanel();
		contentPane.add(topLine);
		topLine.setLayout(new BorderLayout(0, 0));
		
		JLabel topLineText = new JLabel("*************************");
		topLineText.setFont(new Font("宋体", Font.BOLD, 24));
		topLine.add(topLineText, BorderLayout.CENTER);
		
		//跳转到插入信息界面
		JPanel insert = new JPanel();
		contentPane.add(insert);
		insert.setLayout(new BorderLayout(0, 0));
		
		JButton insertButton = new JButton("1  \u63D2\u5165");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.this.dispose();
				Insert ins = new Insert();
				ins.setVisible(true);
			}
		});
		insertButton.setFont(new Font("宋体", Font.BOLD, 24));

		insert.add(insertButton, BorderLayout.CENTER);
		
		//跳转到搜索学生信息界面
		JPanel find = new JPanel();
		contentPane.add(find);
		find.setLayout(new BorderLayout(0, 0));
		
		JButton findButton = new JButton("2  \u67E5\u627E");
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.this.dispose();
				Find fi = new Find();
				fi.setVisible(true);
			}
		});
		findButton.setFont(new Font("宋体", Font.BOLD, 24));
		find.add(findButton, BorderLayout.CENTER);
		
		//跳转到删除学生信息界面
		JPanel delete = new JPanel();
		contentPane.add(delete);
		delete.setLayout(new BorderLayout(0, 0));
		
		JButton deleteButton = new JButton("3  \u5220\u9664");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.this.dispose();
				Delete de = new Delete();
				de.setVisible(true);
			}
		});
		deleteButton.setFont(new Font("宋体", Font.BOLD, 24));
		delete.add(deleteButton, BorderLayout.CENTER);
		
		//跳转到修改学生信息界面
		JPanel revise = new JPanel();
		contentPane.add(revise);
		revise.setLayout(new BorderLayout(0, 0));
		
		JButton reviseButton = new JButton("4  \u4FEE\u6539");
		reviseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.this.dispose();
				Revise re = new Revise();
				re.setVisible(true);
			}
		});
		reviseButton.setFont(new Font("宋体", Font.BOLD, 24));
		revise.add(reviseButton, BorderLayout.CENTER);
		
		//全部学生信息展示页
		JPanel output = new JPanel();
		contentPane.add(output);
		output.setLayout(new BorderLayout(0, 0));
		
		JButton outputButton = new JButton("5  \u8F93\u51FA");
		outputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI.this.dispose();
				Output OP = new Output();
				OP.setVisible(true);
			}
		});
		outputButton.setFont(new Font("宋体", Font.BOLD, 24));
		output.add(outputButton, BorderLayout.CENTER);
		
		//退出整个系统
		JPanel exit = new JPanel();
		contentPane.add(exit);
		exit.setLayout(new BorderLayout(0, 0));
		
		JButton exitButton = new JButton("6  \u9000\u51FA");
		exitButton.setFont(new Font("宋体", Font.BOLD, 24));
		exitButton.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exit.add(exitButton, BorderLayout.CENTER);
		
		JPanel bottomLine = new JPanel();
		contentPane.add(bottomLine);
		bottomLine.setLayout(new BorderLayout(0, 0));
		
		JLabel bottomLineText = new JLabel("*************************");
		bottomLineText.setFont(new Font("宋体", Font.BOLD, 24));
		bottomLine.add(bottomLineText, BorderLayout.CENTER);
		
		
	}

}
