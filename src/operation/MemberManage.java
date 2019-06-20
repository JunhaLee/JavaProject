package operation;

import data.*;
import java.io.*;

public class MemberManage {
	public MemberList Mlist = new MemberList();
	ObjectInputStream input;
	ObjectOutputStream output;

	public MemberList readFile() {
		try {
			input = new ObjectInputStream(new FileInputStream("MemberList.ser"));
			Mlist = (MemberList)input.readObject();
			input.close();
		} catch (Exception e) {
			//System.err.println("File Input Error.");
			if(input==null){
				this.saveFile();
				//System.err.println("File Creating..");
			}
		}
		return Mlist;
	}
	
	public void saveFile(){
		try{
			output = new ObjectOutputStream(new FileOutputStream("MemberList.ser"));
			output.flush();
			output.writeObject(Mlist);
			output.close();
		}
		catch(Exception e){
			System.err.println("File Output Error.");
		}
	}
}
