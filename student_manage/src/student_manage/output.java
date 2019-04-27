package student_manage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class output extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					output frame = new output();
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
	public output() {
		StudentManager outputSt = new StudentManager();
		outputSt.read();
//		outputSt.students[i]
		
		setTitle("\u8F93\u51FA\u5B66\u751F\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 458);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1,5, 2));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JLabel label = new JLabel("\u8F93\u51FA\u5B66\u751F\u4FE1\u606F\u5982\u4E0B\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 26));
		panel_1.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 4, 5, 2));
		
		JLabel id = new JLabel("\u5B66\u53F7");
		id.setFont(new Font("宋体", Font.BOLD, 26));
		id.setBackground(new Color(0, 128, 128));
		panel.add(id);
		
		JLabel name = new JLabel("\u59D3\u540D");
		name.setFont(new Font("宋体", Font.BOLD, 26));
		name.setBackground(new Color(0, 128, 128));
		panel.add(name);
		
		JLabel birth = new JLabel("\u751F\u65E5");
		birth.setFont(new Font("宋体", Font.BOLD, 26));
		birth.setBackground(new Color(0, 128, 128));
		panel.add(birth);
		
		JLabel gender = new JLabel("\u6027\u522B");
		gender.setFont(new Font("宋体", Font.BOLD, 26));
		gender.setBackground(new Color(0, 128, 128));
		panel.add(gender);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 4, 5, 2));
		
		
		String idlist = "<html>";
		String namelist = "<html>";
		String birlist = "<html>";
		String genlist = "<html>";
		JLabel id_list = new JLabel("New label");
		for(int i =0;i<outputSt.getCnt();i++) {
			idlist = idlist + outputSt.students[i].getID() + "<br>";
			namelist = namelist + outputSt.students[i].getName() + "<br>";
			birlist = birlist + outputSt.students[i].getBirDate() + "<br>";
			genlist = genlist + (outputSt.students[i].getGender()==true?"男":"女") + "<br>";
		}
		idlist = idlist +"</html>";
		namelist = namelist +"</html>";
		birlist = birlist +"</html>";
		genlist = genlist +"</html>";
		
		id_list.setText(idlist);
		id_list.setFont(new Font("宋体", Font.BOLD, 19));
		panel_3.add(id_list);
		
		JLabel name_list = new JLabel("New label");
		name_list.setText(namelist);
		name_list.setFont(new Font("宋体", Font.BOLD, 19));
		panel_3.add(name_list);
		
		JLabel birth_list = new JLabel("New label");
		birth_list.setText(birlist);
		birth_list.setFont(new Font("宋体", Font.BOLD, 19));
		panel_3.add(birth_list);
		
		JLabel gender_list = new JLabel("New label");
		gender_list.setText(genlist);
		gender_list.setFont(new Font("宋体", Font.BOLD, 19));
		panel_3.add(gender_list);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton back = new JButton("\u8FD4\u56DE");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.this.dispose();
				gui menu = new gui();
				menu.setVisible(true);
			}
		});
		back.setFont(new Font("宋体", Font.BOLD, 26));
		panel_2.add(back);
		
		JButton exit = new JButton("\u9000\u51FA");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setFont(new Font("宋体", Font.BOLD, 26));
		panel_2.add(exit);
	}

}
