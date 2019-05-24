
public class Test {
	public static void main(String[] args) {
		int a = 5;
		System.out.println(a > 5 ? 10.9 : 9);
		char x = 'x';
		System.out.println(false? 10 : x);
		System.out.println(false? 10.1 : x);
		System.out.println(false? a : x);
		System.out.println(false? x : 97);
		System.out.println(false? x : 10.1);
		System.out.println(true? x : a);
	}
}
