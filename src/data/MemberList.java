package data;

import java.io.Serializable;
import java.util.ArrayList;

public class MemberList implements Serializable{
	
	public ArrayList<Member> list = new ArrayList<Member>();
	
	public MemberList(){
	}
	
	public boolean Create(String name, String number){
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getName().equals(name)==true && list.get(i).getNumber().equals(number)==true){
				return false;
			}
		}
		list.add(new Member(name, number));
		return true;
	}
	
	public boolean Delete(String name, String number){
		Member m;
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getName().equals(name)==true && list.get(i).getNumber().equals(number)==true){
				m = list.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Member Search(String name, String number){
		Member mem;
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getName().equals(name)==true && list.get(i).getNumber().equals(number)==true){
				mem = list.get(i);
				return mem;
			}
		}
		return null;
	}
	
	public void printList(){
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).print());
		}
	}
	
}
