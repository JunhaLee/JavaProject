package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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

public class Book_Set extends JFrame {

	private JPanel contentPane;
	private JButton book_add_button;
	private JButton book_del_button;
	private JButton book_list_button;
	private JTable table;
	private DefaultTableModel mod;
	
	public Book_Set(JTable table, DefaultTableModel mod) {
		this.table = table;
		this.mod = mod;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		book_add_button = new JButton(new ImageIcon(getClass().getResource("도서추가_nom.jpg")));
		book_add_button.setPressedIcon(new ImageIcon(getClass().getResource("도서추가_pre.jpg")));
		book_add_button.setRolloverIcon(new ImageIcon(getClass().getResource("도서추가_on.jpg")));
		book_add_button.setBorderPainted(false);
		book_add_button.setFocusPainted(false);
		book_add_button.setContentAreaFilled(false);
		book_add_button.setBounds(40, 25, 101, 52);
		contentPane.add(book_add_button);
		book_add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Book_Set_Add_Open(table, mod);
			}
		});
		
		book_del_button = new JButton(new ImageIcon(getClass().getResource("도서삭제_nom.jpg")));
		book_del_button.setPressedIcon(new ImageIcon(getClass().getResource("도서삭제_pre.jpg")));
		book_del_button.setRolloverIcon(new ImageIcon(getClass().getResource("도서삭제_on.jpg")));
		book_del_button.setBorderPainted(false);
		book_del_button.setFocusPainted(false);
		book_del_button.setContentAreaFilled(false);
		book_del_button.setBounds(40, 107, 101, 52);
		contentPane.add(book_del_button);
		book_del_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Book_Set_Del_Open(table, mod);
			}
		});
		
	}
	public void Book_Set_Add_Open(JTable table, DefaultTableModel mod){
		
		Book_Set_Add book_add=new Book_Set_Add(table, mod);
		book_add.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		book_add.setSize(460, 260);
		book_add.setVisible(true);
	}
	public void Book_Set_Del_Open(JTable table, DefaultTableModel mod){
	
		Book_Set_Del book_del=new Book_Set_Del(table, mod);
		book_del.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		book_del.setSize(460, 260);
		book_del.setVisible(true);
	}
	
}
