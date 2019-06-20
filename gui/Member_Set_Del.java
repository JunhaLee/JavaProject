package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import operation.MemberManage;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Member_Set_Del extends JFrame {

	private JPanel contentPane;
	
	private JTextField name_field;
	private JTextField num_field;
	private JLabel num;
	private JLabel name;
	private JButton del_button;
	public Member_Set_Del temp;

	public Member_Set_Del() {
		temp = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 462, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		
		name_field = new JTextField();
		name_field.setBounds(122, 53, 150, 21);
		contentPane.add(name_field);
		name_field.setColumns(10);
		
		num_field = new JTextField();
		num_field.setBounds(122, 128, 150, 21);
		contentPane.add(num_field);
		num_field.setColumns(10);
		
		name = new JLabel(new ImageIcon(getClass().getResource("멤이름.jpg")));
		name.setBounds(39, 48, 71, 31);
		contentPane.add(name);
		
		num = new JLabel(new ImageIcon(getClass().getResource("멤번호.jpg")));
		num.setBounds(39, 123, 71, 31);
		contentPane.add(num);
		
		del_button = new JButton(new ImageIcon(getClass().getResource("삭제_nom.jpg")));
		del_button.setPressedIcon(new ImageIcon(getClass().getResource("삭제_pre.jpg")));
		del_button.setRolloverIcon(new ImageIcon(getClass().getResource("삭제_on.jpg")));
		del_button.setBorderPainted(false);
		del_button.setFocusPainted(false);
		del_button.setContentAreaFilled(false);
		del_button.setBounds(324, 53, 97, 97);
		del_button.setBounds(324, 53, 97, 97);
		del_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MemberManage m = new MemberManage();
				m.Mlist = m.readFile();
				if(m.Mlist.Delete(name_field.getText(), num_field.getText()) == true){
					JOptionPane.showMessageDialog(null, "회원이 삭제되었습니다.");
					m.saveFile();
					temp.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다.");
				}
			}
		});
		contentPane.add(del_button);
	}
}
