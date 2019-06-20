package data;

import java.io.Serializable;
import java.util.ArrayList;

public class BookList implements Serializable{
	
	public ArrayList<Book> list = new ArrayList<Book>();
	
	public BookList(){
	}
	
	public void add(Book stuff){
		list.add(stuff);
	}
	
	public void del(Book stuff){
		list.remove(stuff);
	}
	
	public void PrintTest(){
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getName()+list.get(i).getWriter()+list.get(i).getPub());
		}
	}
	
	public int Search(String[] temp){
		
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getNum().equals(temp[0]) && list.get(i).getName().equals(temp[1])
					&&list.get(i).getWriter().equals(temp[2]) && list.get(i).getPub().equals(temp[3]))
				return i;
		}
		
		return -1;
	}
	
	public Book SearchBook(String number){
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getNum().equals(number))
				return list.get(i);
		}
		
		return null;
	}
	
	public Book SearchBookN(String name){
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getName().equals(name))
				return list.get(i);
		}
		
		return null;
	}

	public Book SearchBook(String[] temp) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNum().equals(temp[0]) && list.get(i).getName().equals(temp[1])
					&& list.get(i).getWriter().equals(temp[2]) && list.get(i).getPub().equals(temp[3]))
				return list.get(i);
		}

		return null;
	}
}
