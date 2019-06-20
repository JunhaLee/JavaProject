package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import data.Book;
import data.BookList;
import data.Member;
import data.MemberList;
import operation.BookManage;
import operation.CreateSequentialFile;
import operation.MemberManage;

import javax.swing.JTextArea;
import javax.swing.JTable;

public class Layout extends JFrame {

	private JButton member_button;			//버튼 생성
	private JButton book_button;
	private JButton member_search_button;
	private JButton book_search_button;
	private JButton book_rent_button;
	private JButton book_return_button;
	private JButton book_extend_button;
	
	private JTextField member_search_name;	//텍스트 필드 생성
	private JTextField member_search_num;
	private JTextField book_search_name;
	private JTextField book_search_num;
	private JTextField member_result_name;
	private JTextField member_result_book;
	private JTextField member_result_num;
	private JTextField member_result_day;
	private JTextField book_result_name;
	private JTextField book_result_num;
	private JTextField book_result_publish;
	private JTextField book_result_author;
	
	private JLabel label;
	private JLabel label_1;
	private JLabel label_7;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_2;
	
	protected static JTable table;
	protected static DefaultTableModel mod;

	private JPanel contentPane;
	
	public Layout() {
		
		BookManage b = new BookManage();
	      b.Blist = b.readFile();
	      String header[]={"번호","제목","작가","출판사", "대출 가능 여부"};
	      String contents[][] = new String[b.Blist.list.size()][5];   
	      
	      for(int i=0; i<b.Blist.list.size();i++){
	         contents[i][0]=b.Blist.list.get(i).getNum();
	         contents[i][1]=b.Blist.list.get(i).getName();
	         contents[i][2]=b.Blist.list.get(i).getWriter();
	         contents[i][3]=b.Blist.list.get(i).getPub();
	         if(b.Blist.list.get(i).getCan() == true) contents[i][4]="Y";
	         else contents[i][4]="N";
	      }

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.white);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		member_button = new JButton(new ImageIcon(getClass().getResource("회원_nom.jpg")));	//회원관리 버튼
		member_button.setPressedIcon(new ImageIcon(getClass().getResource("회원_pre.jpg")));
		member_button.setRolloverIcon(new ImageIcon(getClass().getResource("회원_on.jpg")));
		member_button.setBorderPainted(false);
		member_button.setFocusPainted(false);
		member_button.setContentAreaFilled(false);
		member_button.setBounds(12, 10, 97, 63);
		contentPane.add(member_button);
		member_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Member_Set_Open();
			}
		});
		
		book_button = new JButton(new ImageIcon(getClass().getResource("도서_nom.jpg")));		//도서관리 버튼
		book_button.setPressedIcon(new ImageIcon(getClass().getResource("도서_pre.jpg")));
		book_button.setRolloverIcon(new ImageIcon(getClass().getResource("도서_on.jpg")));
		book_button.setBorderPainted(false);
		book_button.setFocusPainted(false);
		book_button.setContentAreaFilled(false);
		book_button.setBounds(12, 10, 97, 63);
		book_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Book_Set_Open(table, mod);
			}
		});
		book_button.setBounds(12, 95, 97, 63);
		contentPane.add(book_button);
		
		book_rent_button = new JButton(new ImageIcon(getClass().getResource("도서대출_nom.jpg")));	//도서대출 버튼
		book_rent_button.setPressedIcon(new ImageIcon(getClass().getResource("도서대출_pre.jpg")));
		book_rent_button.setRolloverIcon(new ImageIcon(getClass().getResource("도서대출_on.jpg")));
		book_rent_button.setBorderPainted(false);
		book_rent_button.setFocusPainted(false);
		book_rent_button.setContentAreaFilled(false);
		book_rent_button.setBounds(716, 181, 97, 36);
		book_rent_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Book_Rent_Open(table, mod);
			}
		});
		contentPane.add(book_rent_button);
		
		book_return_button = new JButton(new ImageIcon(getClass().getResource("도서반납_nom.jpg")));	//도서반납 버튼
		book_return_button.setPressedIcon(new ImageIcon(getClass().getResource("도서반납_pre.jpg")));
		book_return_button.setRolloverIcon(new ImageIcon(getClass().getResource("도서반납_on.jpg")));
		book_return_button.setBorderPainted(false);
		book_return_button.setFocusPainted(false);
		book_return_button.setContentAreaFilled(false);
		book_return_button.setBounds(716, 236, 97, 36);
		book_return_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Book_Return_Open(table, mod);
			}
		});
		contentPane.add(book_return_button);
		
		member_search_button = new JButton(new ImageIcon(getClass().getResource("검색_nom.jpg")));		//회원 검색 버튼
		member_search_button.setPressedIcon(new ImageIcon(getClass().getResource("검색_pre.jpg")));
		member_search_button.setRolloverIcon(new ImageIcon(getClass().getResource("검색_on.jpg")));
		member_search_button.setBorderPainted(false);
		member_search_button.setFocusPainted(false);
		member_search_button.setContentAreaFilled(false);
		member_search_button.setBounds(323, 10, 97, 63);
		member_search_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MemberManage m = new MemberManage();
				Member mem;
				m.Mlist = m.readFile();
				mem = m.Mlist.Search(member_search_name.getText(), member_search_num.getText());
				if(mem == null) JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다.");
				else{
					member_result_name.setText(mem.getName());
					member_result_num.setText(mem.getNumber());
					member_result_book.setText(mem.getBook());
					if(mem.getCan() == true) member_result_day.setText("-");
					else{
						member_result_day.setText(mem.getOverreturn()+"까지");
					}
				}
			}
		});
		contentPane.add(member_search_button);
		
		book_search_button = new JButton(new ImageIcon(getClass().getResource("검색_nom.jpg")));		//도서 검색 버튼
		book_search_button.setPressedIcon(new ImageIcon(getClass().getResource("검색_pre.jpg")));
		book_search_button.setRolloverIcon(new ImageIcon(getClass().getResource("검색_on.jpg")));
		book_search_button.setBorderPainted(false);
		book_search_button.setFocusPainted(false);
		book_search_button.setContentAreaFilled(false);
		book_search_button.setBounds(323, 95, 97, 63);
		book_search_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BookManage b = new BookManage();
				b.Blist = b.readFile();
				Book book;
				book = b.Blist.SearchBookN(book_search_name.getText());
				if(book==null)book = b.Blist.SearchBook(book_search_num.getText());
				if(book == null) JOptionPane.showMessageDialog(null, "존재하지 않는 도서입니다.");
				else{
					book_result_name.setText(book.getName());
					book_result_num.setText(book.getNum());
					book_result_publish.setText(book.getPub());
					book_result_author.setText(book.getWriter());
				}
			}
		});
		contentPane.add(book_search_button);
		
		member_search_name = new JTextField("회원 이름을 입력하세요.");
		member_search_name.setBounds(131, 10, 180, 28);
		contentPane.add(member_search_name);
		member_search_name.setColumns(10);
		
		member_search_num = new JTextField("회원 번호를 입력하세요.");
		member_search_num.setColumns(10);
		member_search_num.setBounds(131, 45, 180, 28);
		contentPane.add(member_search_num);
		
		book_search_name = new JTextField("도서 이름을 입력하세요.");
		book_search_name.setColumns(10);
		book_search_name.setBounds(131, 95, 180, 28);
		contentPane.add(book_search_name);
		
		book_search_num = new JTextField("도서 번호를 입력하세요.");
		book_search_num.setColumns(10);
		book_search_num.setBounds(131, 130, 180, 28);
		contentPane.add(book_search_num);
		
		member_result_name = new JTextField();
		member_result_name.setBounds(507, 16, 116, 22);
		member_result_name.setEditable(false);
		contentPane.add(member_result_name);
		member_result_name.setColumns(10);
		
		member_result_book = new JTextField();
		member_result_book.setColumns(10);
		member_result_book.setBounds(507, 51, 116, 22);
		member_result_book.setEditable(false);
		contentPane.add(member_result_book);
		
		member_result_num = new JTextField();
		member_result_num.setColumns(10);
		member_result_num.setBounds(715, 17, 116, 22);
		member_result_num.setEditable(false);
		contentPane.add(member_result_num);
		
		member_result_day = new JTextField();
		member_result_day.setColumns(10);
		member_result_day.setBounds(715, 52, 116, 22);
		member_result_day.setEditable(false);
		contentPane.add(member_result_day);
		
		book_result_name = new JTextField();
		book_result_name.setColumns(10);
		book_result_name.setBounds(507, 95, 116, 22);
		book_result_name.setEditable(false);
		contentPane.add(book_result_name);
		
		book_result_num = new JTextField("");
		book_result_num.setColumns(10);
		book_result_num.setBounds(507, 130, 116, 22);
		book_result_num.setEditable(false);
		contentPane.add(book_result_num);
		
		book_result_publish = new JTextField();
		book_result_publish.setColumns(10);
		book_result_publish.setBounds(715, 96, 116, 22);
		book_result_publish.setEditable(false);
		contentPane.add(book_result_publish);
		
		book_result_author = new JTextField();
		book_result_author.setColumns(10);
		book_result_author.setBounds(715, 131, 116, 22);
		book_result_author.setEditable(false);
		contentPane.add(book_result_author);
		
		label_5 = new JLabel(new ImageIcon(getClass().getResource("메인출판사.jpg")));
		label_5.setBounds(650, 95, 57, 22);
		contentPane.add(label_5);
		
		label_6 = new JLabel(new ImageIcon(getClass().getResource("메인등록번호.jpg")));
		label_6.setBounds(444, 130, 57, 22);
		contentPane.add(label_6);
		
		label_7 = new JLabel(new ImageIcon(getClass().getResource("메인작가.jpg")));
		label_7.setBounds(650, 130, 57, 22);
		contentPane.add(label_7);
		
		label_3 = new JLabel(new ImageIcon(getClass().getResource("메인연체일.jpg")));
		label_3.setBounds(650, 51, 57, 22);
		contentPane.add(label_3);
		
		label_4 = new JLabel(new ImageIcon(getClass().getResource("메인제목.jpg")));
		label_4.setBounds(444, 95, 57, 22);
		contentPane.add(label_4);
		
		label_2 = new JLabel(new ImageIcon(getClass().getResource("메인번호.jpg")));
		label_2.setBounds(650, 16, 57, 22);
		contentPane.add(label_2);
		
		label = new JLabel(new ImageIcon(getClass().getResource("메인이름.jpg")));
		label.setBounds(444, 16, 57, 22);
		contentPane.add(label);
		
		label_1 = new JLabel(new ImageIcon(getClass().getResource("메인대출책수.jpg")));
		label_1.setBounds(444, 51, 57, 22);
		contentPane.add(label_1);
		
		mod = new DefaultTableModel(contents, header){
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		table = new JTable(mod);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollpane = new JScrollPane(table);
		DefaultTableCellRenderer dtcr=new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm=table.getColumnModel();
		for(int i=0;i<tcm.getColumnCount();i++){
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	    table.setBounds(12, 181, 685, 379);
	    scrollpane.setBounds(12, 181, 685, 379);
	    contentPane.add(scrollpane);
	}
	public void Member_Set_Open(){
		
		Member_Set member=new Member_Set();
		member.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		member.setSize(200, 320);
		member.setVisible(true);
	}
	public void Book_Set_Open(JTable table, DefaultTableModel mod){
		
		Book_Set book=new Book_Set(table, mod);
		book.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		book.setSize(200, 240);
		book.setVisible(true);
	}
	public void Book_Rent_Open(JTable table, DefaultTableModel mod){
	      
	      Book_Rent book=new Book_Rent(table, mod);
	      book.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      book.setSize(460, 260);
	      book.setVisible(true);
	   }
	public void Book_Return_Open(JTable table, DefaultTableModel mod){
	      
	      Book_Return book=new Book_Return(table, mod);
	      book.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      book.setSize(460, 260);
	      book.setVisible(true);
	   }
	
	public void UpdateBookList(String[] temp){
		this.mod.addRow(temp);
	}
}