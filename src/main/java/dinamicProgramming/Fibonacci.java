package dinamicProgramming;


public class Fibonacci {
	int[] f;
	Fibonacci(){
		f = new int[101];
		memoInit();
	}

	public int fib(int n) {
		if (f[n] != 0)
			return f[n];
		else {
			if (n == 1 || n == 2) {
				f[n] = 1;
			} else {
				f[n] = fib(n - 1) + fib(n - 2);
			}
		}
		return f[n];

	}

	private void memoInit() {
		for (int i = 0; i < f.length; i++) {
			f[i] = 0;
		}
	}
}
