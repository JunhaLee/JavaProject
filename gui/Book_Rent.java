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
import javax.swing.JOptionPane;
import javax.swing.JTable;

import operation.BookManage;
import operation.MemberManage;
import data.*;

public class Book_Rent extends JFrame {

   private JPanel contentPane;
   
   private JTextField name_field;
   private JTextField num_field;
   private JLabel num;
   private JLabel name;
   private JButton add_button;
   public Book_Rent temp;
   private JTable table;
   private DefaultTableModel mod;

   public Book_Rent(JTable table, DefaultTableModel mod) {
	   this.table = table;
	   this.mod = mod;
      temp = this;
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      if(table.getSelectedRow()==-1){
    		JOptionPane.showMessageDialog(null, "도서를 선택하세요.");
    	 }
      else{
      
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
      
      add_button = new JButton(new ImageIcon(getClass().getResource("확인_nom.jpg")));
      add_button.setPressedIcon(new ImageIcon(getClass().getResource("확인_pre.jpg")));
      add_button.setRolloverIcon(new ImageIcon(getClass().getResource("확인_on.jpg")));
      add_button.setBorderPainted(false);
      add_button.setFocusPainted(false);
      add_button.setContentAreaFilled(false);
      add_button.setBounds(324, 53, 97, 97);
      add_button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if (table.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "도서를 선택하세요.");
					} else {
						if (table.getValueAt(table.getSelectedRow(), 4).equals("N") == true) {
							JOptionPane.showMessageDialog(null, "이미 대출중인 도서입니다.");

						} else {
							MemberManage m = new MemberManage();
							m.Mlist = m.readFile();
							BookManage b = new BookManage();
							b.Blist = b.readFile();
							if (m.Mlist.Search(name_field.getText(), num_field.getText()) == null)
								JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다.");
							else {
								String[] temps = new String[4];
								temps[0] = (String) mod.getValueAt(table.getSelectedRow(), 0);
								temps[1] = (String) mod.getValueAt(table.getSelectedRow(), 1);
								temps[2] = (String) mod.getValueAt(table.getSelectedRow(), 2);
								temps[3] = (String) mod.getValueAt(table.getSelectedRow(), 3);

								Book book = b.Blist.SearchBook(temps);
								book.setReturnDate();

								m.Mlist.Search(name_field.getText(), num_field.getText()).BorrowBook(book);
								mod.setValueAt("N", table.getSelectedRow(), 4);
								JOptionPane.showMessageDialog(null, "도서를 대출하였습니다.");

								m.saveFile();
								b.saveFile();

								temp.setVisible(false);
							}
						}
					}
				}
			});
      contentPane.add(add_button);
   }
   }
}