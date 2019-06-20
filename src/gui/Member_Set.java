package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.JTable;

public class Member_Set extends JFrame {

	private JPanel contentPane;
	private JButton member_add_button;
	private JButton member_del_button;
	private JButton member_list_button;

	public Member_Set() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		
		member_add_button = new JButton(new ImageIcon(getClass().getResource("회원추가_nom.jpg")));
		member_add_button.setPressedIcon(new ImageIcon(getClass().getResource("회원추가_pre.jpg")));
		member_add_button.setRolloverIcon(new ImageIcon(getClass().getResource("회원추가_on.jpg")));
		member_add_button.setBorderPainted(false);
		member_add_button.setFocusPainted(false);
		member_add_button.setContentAreaFilled(false);
		member_add_button.setBounds(40, 25, 101, 52);
		contentPane.add(member_add_button);
		member_add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Member_Set_Add_Open();
			}
		});
		
		member_del_button = new JButton(new ImageIcon(getClass().getResource("회원삭제_nom.jpg")));
		member_del_button.setPressedIcon(new ImageIcon(getClass().getResource("회원삭제_pre.jpg")));
		member_del_button.setRolloverIcon(new ImageIcon(getClass().getResource("회원삭제_on.jpg")));
		member_del_button.setBorderPainted(false);
		member_del_button.setFocusPainted(false);
		member_del_button.setContentAreaFilled(false);
		member_del_button.setBounds(40, 107, 101, 52);
		contentPane.add(member_del_button);
		member_del_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Member_Set_Del_Open();
			}
		});

		member_list_button = new JButton(new ImageIcon(getClass().getResource("회원목록_nom.jpg")));
		member_list_button.setPressedIcon(new ImageIcon(getClass().getResource("회원목록_pre.jpg")));
		member_list_button.setRolloverIcon(new ImageIcon(getClass().getResource("회원목록_on.jpg")));
		member_list_button.setBorderPainted(false);
		member_list_button.setFocusPainted(false);
		member_list_button.setContentAreaFilled(false);
		member_list_button.setBounds(40, 190, 101, 52);
		member_list_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MemberManage m = new MemberManage();
			     m.Mlist = m.readFile();
			     m.Mlist.printList();
				Member_Set_List_Open();
			}
		});
		contentPane.add(member_list_button);
	}
	public void Member_Set_Add_Open(){
		
		Member_Set_Add member_add=new Member_Set_Add();
		member_add.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		member_add.setSize(460, 260);
		member_add.setVisible(true);
	}
	public void Member_Set_Del_Open(){
		
		Member_Set_Del member_del=new Member_Set_Del();
		member_del.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		member_del.setSize(460, 260);
		member_del.setVisible(true);
	}
	  public void Member_Set_List_Open(){
	      
	      Member_Set_List member_list=new Member_Set_List();
	      member_list.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      member_list.setSize(300, 500);
	      member_list.setVisible(true);
	   }

}
