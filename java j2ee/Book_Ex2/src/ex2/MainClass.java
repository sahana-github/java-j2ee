package ex2;
import java.util.*;
public class MainClass 
{
	public static void main(String args[]) 
	{
		Scanner input=new Scanner(System.in);
		ArrayList<Book> al = new ArrayList<Book>();
		 al.add(new Book("Dbms basics", "auth1", "pub1", 12345.00));
		 al.add(new Book("Dbms advanced", "auth1", "pub2", 22222.10));
		 al.add(new Book("Java J2EE", "auth2", "pub1", 123.566));
		 al.add(new Book("Machine Learning","auth3","pub3",567.56));
		 ArrayList<Book> al1 = new ArrayList<Book>(al);
		 //Sorting books based on price
		 Collections.sort(al1,new PriceCompare());
		 System.out.println("***********Sorted Collection**********");
		 for (Book b : al1) {
		 System.out.println(b);
		 }
		 System.out.println("-----------");
		 HashMap<Integer,Book> hm=new HashMap<Integer,Book>();
		 int i=0;//Maintain the book details with respect to an unique book id.
		 for(Book b:al1) {
		 hm.put(i, b);
		 i++;
		 
		 }
		 Set<Map.Entry<Integer, Book>> set1=hm.entrySet();
		 //Prompt for an author name and list all the books with the same author name. 
		 System.out.println("Enter author name");
		 String name=input.next();
		 for(Map.Entry<Integer, Book> setv:set1) {
		 if(setv.getValue().author.equals(name)) {
		 System.out.println(setv.getValue());
		 }
		 }
		 //Create a new list holding all the book details with price greater than a user specified price
		 System.out.println("Enter price");
		 double amt=input.nextDouble();
		 ArrayList<Book> ar=new ArrayList<Book>();
		 for(Map.Entry<Integer, Book> setv:set1) {
		 if(setv.getValue().price>amt) {
		 ar.add(setv.getValue());
		 }
		 }
		 
		 for(Book b1:ar) {
		 System.out.println(b1);
		 }
		 // find all the books that match either the whole or a part of the book title
		 System.out.println("Enter title");
		 String t=input.next();
		 for(Map.Entry<Integer, Book> setv:set1) {
		 if(setv.getValue().title.contains(t)) {
		 System.out.println(setv.getValue());
		 }
		 }
		 //Identify a publisher and print books from a particular publisher. 
		 System.out.println("Enter Publisher"); String str=input.next();
		 for(Map.Entry<Integer, Book> setv:set1) {
		 if(setv.getValue().publisher.equals(str)) {
		 System.out.println(setv.getValue());
		 }
		 }
		 //Update the publisher details based on a title.
		 System.out.println("Enter title for which you want to update publisher");
		 input.nextLine();
		 String t1=input.nextLine();
		 for(Map.Entry<Integer, Book> setv:set1) {
		 if(setv.getValue().title.equals(t1)) {
		 setv.getValue().publisher="New_one";
		 hm.put(setv.getKey(),setv.getValue());
		 
		 }
		 }
		 for(Map.Entry<Integer, Book> setv:set1) {
		 System.out.println(setv.getValue());
		 }
		 
		}
}
