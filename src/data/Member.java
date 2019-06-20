package data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Member implements Serializable{
	private String name;
	private String number;
	private boolean Canborrow = true;
	
	public ArrayList<Book> borrowed = new ArrayList<Book>();
	Calendar cal = Calendar.getInstance();
	Date overReturn = new Date();
	SimpleDateFormat d_simple = new SimpleDateFormat("yy/MM/dd");
	
	public Member(String name, String number){
		this.name = name;
		this.number = number;
	}
	
	public void BorrowBook(Book stuff){
		if(Canborrow == true && stuff.getCan() == true) borrowed.add(stuff);
		// else return cannot borrow
	}
	
	@SuppressWarnings("deprecation")
	public void ReturnBook(Book stuff){
		cal = Calendar.getInstance();
		if(stuff.Returned() == false){
			System.out.println("false");
			Canborrow = false;
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)+3);
			overReturn = cal.getTime();
		}
		int index = this.borrowSearch(stuff);
		borrowed.remove(index);
	}
	
	public boolean getCan(){
		return Canborrow;
	}
	
	public String getName(){
		return name;
	}
	
	public String getNumber(){
		return number;
	}
	
	public String getBook(){
		return String.format("%d", borrowed.size());
	}
	
	public String getOverreturn(){
		return String.format(d_simple.format(overReturn));
	}
	
	public String print(){
		return String.format(this.getName()+"/"+this.getNumber());
	}
	public int borrowSearch(Book stuff){
		for(int i=0; i<borrowed.size(); i++){
			if(borrowed.get(i).getNum().equals(stuff.getNum())) return i;
		}
		return -1;
	}
}
