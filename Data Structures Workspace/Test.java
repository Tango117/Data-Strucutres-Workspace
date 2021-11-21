public class Test{
	public static void main(String[] args) {

		A obj = new B ( 10 );
		obj.update(5);
		System.out.println(obj.num);
	}

	public class A{
		public int num;
		public A (int n){
			num = n;
		}
		public void update(int n){
			num = num + n;
		}
	}

	public class B extends A{
		public int num;
		public B (int n){
			num = n;
		}
		public void update(int n){
			num = num * n;
		}
	}
}
