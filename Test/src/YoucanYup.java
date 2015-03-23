
public class YoucanYup {
	
	private static YoucanYup youcanYup ;
	
	public static void ptest() {
		youcanYup.test();
	}
	
	public void test() {
		System.out.println("hehe.");
	}
	
	public static void main(String[] args) {
		youcanYup = new YoucanYup();
		ptest();
	}
	/*public static void main(String[] args) {
		Person p = new Person();
		
		Person m = new Man();
		
		Man m1 = new Man();
		
		p.display();
		m.display();;
		m1.display1();
	}
}

class Person {

	public Person(){}
	
	public void display() {
		System.out.println("I'm a human.");
	}
}

class Man extends Person {
	public Man(){}
	
	public void display() {
		System.out.println("I'm a man.");
	}
	
	public void display1() {
		System.out.println("I'm a man.");
	}*/
} 