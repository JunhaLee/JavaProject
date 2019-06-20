package data;

import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Book implements Serializable{
	
	private String number;
	private String name;
	private String writer;
	private String publisher;
	private boolean Canborrow = true; //true일 때 빌릴 수 있음
	
	Date returnDate = new Date();
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat d_simple = new SimpleDateFormat("yy/MM/dd");
	
	public Book(String number, String name, String writer, String publisher){
		this.number = number;
		this.name = name;
		this.writer = writer;
		this.publisher = publisher;
	}
	
	public void Borrowed(){
		this.setReturnDate();
		Canborrow = false;
	}
	
	public boolean Returned(){
		cal = Calendar.getInstance();
		//System.out.println(cal.getTime());
		if(cal.getTime().after(returnDate)){
			Canborrow = true;
			return false; //return unsuccessfully.
		}
		Canborrow = true;
		return true; // return successfully.
	}
	
	public String getNum(){
		return number;
	}
	
	public String getName(){
		return name;
	}
	
	public String getWriter(){
		return writer;
	}
	
	public String getPub(){
		return publisher;
	}
	
	public boolean getCan(){
		return Canborrow;
	}
	
	public String getDate(){
		return String.format(d_simple.format(returnDate));
	}
	
	public void setReturnDate(){
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)+7);
		//cal.set(Calendar.SECOND, cal.get(Calendar.SECOND)+7);
		returnDate = cal.getTime();
		//System.out.println(d_simple.format(returnDate));
	} //set the due of returning book.
	
}
