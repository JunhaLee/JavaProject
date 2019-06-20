package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import data.Book;
import operation.BookManage;
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

public class Book_Set_Add extends JFrame {

   private JPanel contentPane;
   
   private JTextField name_field;
   private JTextField author_field;
   private JTextField publish_field;
   private JTextField number_field;
   private JLabel name;
   private JLabel author;
   private JLabel publish;
   private JLabel number;
   private JButton add_button;
   public Book_Set_Add temp;
   private JTable table;
   private DefaultTableModel mod;

   public Book_Set_Add(JTable table, DefaultTableModel mod) {
	  this.table = table;
	  this.mod = mod;
      temp = this;
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      setBounds(100, 100, 459, 250);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      contentPane.setBackground(Color.white);
      
      name = new JLabel(new ImageIcon(getClass().getResource("북제목.jpg")));
      name.setBounds(39, 48, 71, 31);
      contentPane.add(name);
      
      author = new JLabel(new ImageIcon(getClass().getResource("북작가.jpg")));
      author.setBounds(39, 89, 71, 31);
      contentPane.add(author);
      
      publish = new JLabel(new ImageIcon(getClass().getResource("북출판사.jpg")));
      publish.setBounds(39, 130, 71, 31);
      contentPane.add(publish);
      
      number = new JLabel(new ImageIcon(getClass().getResource("멤번호.jpg")));
      number.setBounds(39, 171, 71, 31);
      contentPane.add(number);
      
      name_field = new JTextField();
      name_field.setBounds(122, 53, 150, 21);
      contentPane.add(name_field);
      name_field.setColumns(10);
      
      author_field = new JTextField();
      author_field.setBounds(122, 94, 150, 21);
      contentPane.add(author_field);
      author_field.setColumns(10);
      
      publish_field = new JTextField();
      publish_field.setBounds(122, 135, 150, 21);
      contentPane.add(publish_field);
      publish_field.setColumns(10);
      
      number_field = new JTextField();
      number_field.setBounds(122, 176, 150, 21);
      contentPane.add(number_field);
      number_field.setColumns(10);
      
      add_button = new JButton(new ImageIcon(getClass().getResource("추가_nom.jpg")));
      add_button.setPressedIcon(new ImageIcon(getClass().getResource("추가_pre.jpg")));
      add_button.setRolloverIcon(new ImageIcon(getClass().getResource("추가_on.jpg")));
      add_button.setBorderPainted(false);
      add_button.setFocusPainted(false);
      add_button.setContentAreaFilled(false);
      add_button.setBounds(324, 53, 97, 97);
      add_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(name_field.getText().equals("")==true || author_field.getText().equals("")==true
						|| publish_field.getText().equals("")==true || number_field.getText().equals("")==true){
					JOptionPane.showMessageDialog(null, "입력 사항을 모두 입력하세요.");
				}
				else{
					BookManage b = new BookManage();
					b.Blist = b.readFile();
					b.Blist.add(new Book(number_field.getText(), name_field.getText(), 
							author_field.getText(), publish_field.getText()));
					JOptionPane.showMessageDialog(null, "도서 추가가 완료되었습니다.");
					
					String[] temps = new String[5];
					temps[0] = number_field.getText();
					temps[1] = name_field.getText();
					temps[2] = author_field.getText();
					temps[3] = publish_field.getText();
					temps[4] = "Y";
				    mod.addRow(temps);
					b.saveFile();
					temp.setVisible(false);
				}
			}
		});
      contentPane.add(add_button);
      
      
      
   }
}