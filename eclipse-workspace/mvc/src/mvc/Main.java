package mvc;
import java.util.*;

class Tem{
	int usrid;
	String comm;
	Tem(int id,String n){
		this.usrid=id;
		this.comm=n;
	}
}
class Reply{
	int usrid;
	List<String> al=new ArrayList<>();
	Reply(int id,List<String> a){
		this.usrid=id;
		this.al.addAll(a);
	}
}
class Comment{
	int id;
	public static Map<Integer,Reply> map=new HashMap<>(); 
	Comment(){}
	Comment(int id,Tem o){
		this.id=id;
		if(map.containsKey(id)) {
			Reply al=map.get(id);
			al.al.add(o.comm);
			map.put(id, al);
		}
		else {
			List<String> t=new ArrayList<>();
			t.add(o.comm);
			map.put(id,new Reply(o.usrid,t));
		}
	}
	public void print() {
		System.out.println(map);
	}
}
class Admin extends Comment{
	public static Map<Integer,List<String>> rep=new HashMap<>();
	public void reply(int id) {
		Reply ob=map.get(id);
		List<String> t=new ArrayList<>();
		if(!map.containsKey(id)) {
			t.add("shdshdsidhdd");
			rep.put(id,t);
		}
		else {
			t=rep.get(id);
			t.add("sduhshdiushdd");
			rep.put(id,t);
		}
		System.out.println(rep);
	}
}
public class Main {

	public static void main(String[] args) {
		Comment obj=new Comment();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		while(n!=0) {
		int id=sc.nextInt();
		int usrid=sc.nextInt();
		String comment=sc.next();
		Comment ob=new Comment(id,new Tem(usrid,comment));
		System.out.println("0||1");
		n=sc.nextInt();
		}
		obj.print();
		Admin ad=new Admin();
		System.out.println("Enter id to reply");
		int id=sc.nextInt();
		ad.reply(id);
	}

}
