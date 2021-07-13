package algorithm;
import java.util.ArrayList;
import java.util.Arrays; //配列を表示させるやつ
import java.util.List;
import java.util.Scanner;
public class Numeron {
	private int numeronNumber[];
	private List<Integer> answerNumber = new ArrayList<>();
	private RandomNumber randomNumber = new RandomNumber();
	
	Numeron() {
		numeronNumber = randomNumber.generate();
	}
	
	public void start() {
		System.out.println("Numer0n");
		System.out.println("４桁の被らない数字を入力して下さい");
		input();
	}
	
	private void input() {
		answerNumber.clear();
		Scanner in = new Scanner(System.in);
		answer(in.nextInt());
		in.close();
	}
	
	private void jsonConversion(int number) {
		while(number > 0) {
			answerNumber.add(0,number % 10);
			number /= 10;
		}
	}
	
	public void answer(int answer) {
		jsonConversion(answer);
		int eat = 0;
		int bite = 0;
		for(int i = 0; i < 4; i++) {
			if(numeronNumber[i] == answerNumber.get(i)) {
				eat++;
			}else {
				for(int j = 0; j < 4; j ++) {
					if(numeronNumber[i] == answerNumber.get(j)) {
						bite++;
					}
				}	
			}
		}
		result(eat,bite);
	}
	
	public void result(int eat, int bite) {
		if(eat == 4) {
			System.out.println("全問正解!! 答えは" + answerNumber);
			System.exit(0);
		}
		System.out.printf(eat + "eat" + "," + bite + "bite");
		System.out.printf(Arrays.toString(numeronNumber));
		input();
	}
}
