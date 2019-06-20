package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

import operation.MemberManage;

public class Member_Set_Add extends JFrame {

	private JPanel contentPane;
	
	private JTextField name_field;
	private JTextField num_field;
	private JLabel num;
	private JLabel name;
	private JButton add_button;
	public Member_Set_Add temp;

	public Member_Set_Add() {
		temp = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 462, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		
		name_field = new JTextField();
		name_field.setText("");
		name_field.setBounds(122, 53, 150, 21);
		contentPane.add(name_field);
		name_field.setColumns(10);
		
		num_field = new JTextField();
		num_field.setText("");
		num_field.setBounds(122, 128, 150, 21);
		contentPane.add(num_field);
		num_field.setColumns(10);
		
		name = new JLabel(new ImageIcon(getClass().getResource("멤이름.jpg")));
		name.setBounds(39, 48, 71, 31);
		contentPane.add(name);
		
		num = new JLabel(new ImageIcon(getClass().getResource("멤번호.jpg")));
		num.setBounds(39, 123, 71, 31);
		contentPane.add(num);
		
		add_button = new JButton(new ImageIcon(getClass().getResource("추가_nom.jpg")));
		add_button.setPressedIcon(new ImageIcon(getClass().getResource("추가_pre.jpg")));
		add_button.setRolloverIcon(new ImageIcon(getClass().getResource("추가_on.jpg")));
		add_button.setBorderPainted(false);
		add_button.setFocusPainted(false);
		add_button.setContentAreaFilled(false);
		add_button.setBounds(324, 53, 97, 97);
		add_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(name_field.getText().equals("")==true || num_field.getText().equals("")==true){
					JOptionPane.showMessageDialog(null, "이름, 번호를 모두 입력하세요.");
				}
				else{
					MemberManage m = new MemberManage();
					m.Mlist = m.readFile();
					if(m.Mlist.Create(name_field.getText(), num_field.getText())==true){
					m.saveFile();
					JOptionPane.showMessageDialog(null, "회원이 추가되었습니다.");
					temp.setVisible(false);
					}
					else{
						JOptionPane.showMessageDialog(null, "이미 중복된 회원이 있습니다.");
					}
				}
			}
		});
		contentPane.add(add_button);
	}
}
