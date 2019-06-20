package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import data.Book;
import data.Member;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import operation.BookManage;
import operation.MemberManage;

public class Book_Return_Member extends JFrame {

   private JPanel contentPane;
   
   private JTextField name_field;
   private JTextField num_field;
   private JTextField book_num_field;
   private JLabel book_list;
   private JLabel num;
   private JLabel name;
   private JLabel book_num;
   private JButton return_button;
   private JTable book_table;
   public Book_Return_Member temp;
   
   private JTable table;
   private DefaultTableModel mod;
   private DefaultTableModel book_mod;
   private Member m;

   public Book_Return_Member(JTable table, DefaultTableModel mod, Member m) {
      temp = this;
      
      this.table = table;
      this.mod = mod;
      this.m = m;
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 560, 560);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      contentPane.setBackground(Color.white);
      
      name = new JLabel(new ImageIcon(getClass().getResource("리턴이름.jpg")));
      name.setBounds(25, 27, 57, 22);
      contentPane.add(name);
  
      
      name_field = new JTextField();
      name_field.setBounds(94, 28, 82, 21);
      contentPane.add(name_field);
      name_field.setColumns(10);
      name_field.setEditable(false);
      
      num = new JLabel(new ImageIcon(getClass().getResource("리턴번호.jpg")));
      num.setBounds(188, 27, 57, 22);
      contentPane.add(num);
      
      num_field = new JTextField();
      num_field.setBounds(257, 28, 82, 21);
      contentPane.add(num_field);
      num_field.setColumns(10);
      num_field.setEditable(false);
      
      book_num = new JLabel(new ImageIcon(getClass().getResource("리턴대출책수.jpg")));
      book_num.setBounds(351, 27, 57, 22);
      contentPane.add(book_num);
      
      book_num_field = new JTextField();
      book_num_field.setBounds(416, 28, 82, 21);
      contentPane.add(book_num_field);
      book_num_field.setColumns(10);
      book_num_field.setEditable(false);
      
      name_field.setText(m.getName());
      num_field.setText(m.getNumber());
      book_num_field.setText(m.getBook());
      
      book_list = new JLabel(new ImageIcon(getClass().getResource("리턴대여한책목록.jpg")));
      book_list.setBounds(25, 94, 120, 22);
      contentPane.add(book_list);
      
      String book_header[]={"번호","제목","작가","출판사", "반납 기한"};
      String book_contents[][] = new String[m.borrowed.size()][5];   
      
      for(int i=0; i<m.borrowed.size();i++){
         book_contents[i][0]=m.borrowed.get(i).getNum();
         book_contents[i][1]=m.borrowed.get(i).getName();
         book_contents[i][2]=m.borrowed.get(i).getWriter();
         book_contents[i][3]=m.borrowed.get(i).getPub();
         book_contents[i][4]=m.borrowed.get(i).getDate();
      }
      
      for(int i=0; i<m.borrowed.size(); i++){
    	  
      }
      
      book_mod = new DefaultTableModel(book_contents, book_header){
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
        book_table = new JTable(book_mod);
		book_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane book_scrollpane = new JScrollPane(book_table);
		DefaultTableCellRenderer dtcr=new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm=book_table.getColumnModel();
		for(int i=0;i<tcm.getColumnCount();i++){
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		book_table.setBounds(25, 142, 382, 358);
	    book_scrollpane.setBounds(25, 142, 382, 358);
	    contentPane.add(book_scrollpane);
      
      //book_table.setBounds(25, 142, 382, 358);
      
      return_button = new JButton(new ImageIcon(getClass().getResource("리턴반납_nom.jpg")));
      return_button.setPressedIcon(new ImageIcon(getClass().getResource("리턴반납_pre.jpg")));
      return_button.setRolloverIcon(new ImageIcon(getClass().getResource("리턴반납_on.jpg")));
      return_button.setBorderPainted(false);
      return_button.setFocusPainted(false);
      return_button.setContentAreaFilled(false);
      return_button.setBounds(429, 142, 97, 42);
      return_button.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
         	if(book_table.getSelectedRow()==-1){
         		JOptionPane.showMessageDialog(null, "도서를 선택하세요.");
         	}
         	else{
					MemberManage mm = new MemberManage();
					mm.Mlist = mm.readFile();
					BookManage b = new BookManage();
					b.Blist = b.readFile();

					String[] temps = new String[4];
					temps[0] = (String) book_mod.getValueAt(book_table.getSelectedRow(), 0);
					temps[1] = (String) book_mod.getValueAt(book_table.getSelectedRow(), 1);
					temps[2] = (String) book_mod.getValueAt(book_table.getSelectedRow(), 2);
					temps[3] = (String) book_mod.getValueAt(book_table.getSelectedRow(), 3);

					Book book = b.Blist.SearchBook(temps);
					Member member = mm.Mlist.Search(m.getName(), m.getNumber());
					member.ReturnBook(book);
					if(member.getCan()==true){
						
						mod.setValueAt("Y", tableSearch(book), 4);
						JOptionPane.showMessageDialog(null, "도서를 반납하였습니다.");
						book_mod.removeRow(book_table.getSelectedRow());
						book_num_field.setText(member.getBook());
						
					}
					else{
						String str = String.format("도서를 반납하였습니다.\n     <연체>     \n%s까지 대출불가", member.getOverreturn());
						JOptionPane.showMessageDialog(null, str);
						book_mod.removeRow(book_table.getSelectedRow());
						book_num_field.setText(member.getBook());
					}
					mm.saveFile();
					b.saveFile();

					//temp.setVisible(false);

				}
			}
		});
      contentPane.add(return_button);
   }
   public int tableSearch(Book b){
	   for(int i=0; i<table.getRowCount(); i++){
		   String str = (String) table.getValueAt(i, 0);
		   if(str.equals(b.getNum())) return i;
	   }
	   return -1;
   }
}