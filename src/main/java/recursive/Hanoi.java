package recursive;

import java.util.Scanner;

public class Hanoi {

	int count = 0;//전체 횟수

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Hanoi towerOfHanoi = new Hanoi();

		towerOfHanoi.moveHanoiTower("1", "2", "3", n);

		towerOfHanoi.showResult();

	}

	public void moveHanoiTower(String first, String center, String last, int n) {
		//first : 원반들이 있던 탑
		//center : 중간 위치 탑
		//last : 원반들을 옮길 목적지 탑

		if (n == 1) {
			++count;
			System.out.println(n + " : " + first + " -> " + last);

		} else {
			moveHanoiTower(first, last, center, n - 1);
			//마지막탑을 보조탑으로 이용하여 첫번째탑에 있는 n-1개의 원반들을 중간에 있는 탑으로 이동한다.
			++count;
			System.out.println(n + " : " + first + " -> " + last);
			moveHanoiTower(center, first, last, n - 1);
			//첫번째탑을 보조탑으로 이용하여 중간탑에 있는 n-1개의 원반들을 목적지 탑으로 이동한다.
		}

	}

	public void showResult() {

		System.out.println("총 이동 횟수 : " + count);

	}

}
