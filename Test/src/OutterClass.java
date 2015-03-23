
public class OutterClass {
	
	
	
	public static void main(String[] ars) {
		Outter1 o = new Outter1(5, "b");
		o.change();
		System.out.println(o.getNum());
		System.out.println(o.getStr());
	}
}

class Outter1 {
	private int num;
	private String str;

	public Outter1(int num, String str) {
		this.num = num;
		this.str = str;
	}
	
	public int getNum() {
		return num;
	}
	
	public String getStr() {
		return str;
	}
	
	public class InnerClass {
		private int _num;
		private String _str;
		
		public InnerClass(){
			_num = 0;
			_str = "a";
		}
	}
	
	public void change() {
		num = new InnerClass()._num;
		str = new InnerClass()._str;
	}
}
