package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import data.MemberList;
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
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JTable;

public class Member_Set_List extends JFrame {

   private JPanel contentPane;
   private JTable table;
   private JLabel book_list;

   public Member_Set_List() {
      
      String header[]={"이름","번호"};
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 299, 501);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      contentPane.setBackground(Color.white);
      
      MemberManage m = new MemberManage();
      m.Mlist = m.readFile();
      table = Member_List_Maker(table, m.Mlist);
      table.setBounds(22, 53, 234, 386);
      JScrollPane scrollpane = new JScrollPane(table);
      DefaultTableCellRenderer dtcr=new DefaultTableCellRenderer();
      dtcr.setHorizontalAlignment(SwingConstants.CENTER);
      TableColumnModel tcm=table.getColumnModel();
      for(int i=0;i<tcm.getColumnCount();i++){
         tcm.getColumn(i).setCellRenderer(dtcr);
      }
       scrollpane.setBounds(22, 53, 234, 386);
       contentPane.add(scrollpane);
      
      book_list = new JLabel(new ImageIcon(getClass().getResource("회원리스트.jpg")));
      book_list.setBounds(23, 10, 106, 33);
      contentPane.add(book_list);
      
   }
   public JTable Member_List_Maker(JTable table, MemberList m){
      
      String[] header = {"이름","번호"};
      String content[][] = new String[m.list.size()][2];
      
      for(int i=0;i<m.list.size();i++){
         content[i][0]=m.list.get(i).getName();
         content[i][1]=m.list.get(i).getNumber();
      }
      
      table=new JTable(content,header);
      return table;
   }
}