package operation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import data.BookList;
import data.Book;

public class CreateSequentialFile {
   private ObjectOutputStream output;
   private BookList bookList=new BookList();
   //private Book book;
   public BookList openFile() throws IOException{
      Scanner input =new Scanner(new FileReader("book.txt"));
      while(input.hasNext()){
         String line=input.nextLine();
         String[] temp=new String[4];
         String[] tokens=line.split(" ");
         int cnt=0;
         for(String token : tokens){
            temp[cnt++] = token;
         }
         cnt=0;
         bookList.add(new Book(tokens[0], tokens[1], tokens[2], tokens[3]));
      }
      //bookList.PrintTest();
      return bookList;
   }
   
}