package data;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		Book b1 = new Book("001", "a", "b", "c");
		BookList bl = new BookList();
		bl.add(b1);
		bl.PrintTest();
		bl.del(b1);
		bl.PrintTest();
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		SimpleDateFormat d_simple = new SimpleDateFormat("yy/MM/dd/ss");
		
		b1.Borrowed();
		
		System.out.println(cal.getTime());
		//cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)+1);
		System.out.println(cal.getTime());
		System.out.println(d_simple.format(cal.getTime()));
		
		Scanner input = new Scanner(System.in);
		System.out.print("waiting... : ");
		int i = input.nextInt();
		cal = Calendar.getInstance();

		System.out.println(b1.Returned());

	}

}
