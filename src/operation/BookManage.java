package operation;

import data.*;
import java.io.*;

public class BookManage {
	public BookList Blist = new BookList();
	ObjectInputStream input;
	
	public BookList readFile() {
		try {
			input = new ObjectInputStream(new FileInputStream("BookList.ser"));
			Blist = (BookList)input.readObject();
			input.close();
		} catch (Exception e) {
			if(input == null ){
				CreateSequentialFile csf = new CreateSequentialFile();
				try {
					Blist = csf.openFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return Blist;
	}
	
	public void saveFile(){
		try{
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("BookList.ser"));
			output.flush();
			output.writeObject(Blist);
			output.close();
		}
		catch(Exception e){
			System.err.println("File Output Error.");
		}
	}
}

