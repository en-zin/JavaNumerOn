package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Numeron {
	private int numeronNumber[];
	private List<Integer> answerNumber = new ArrayList<>();
	private RandomNumber randomNumber = new RandomNumber();
	private NumericRender in = new NumericRender();
	
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
		for(int i = 1; i < 4; i++) {
			try {
				answer(in.intRead());
			} catch(Exception e) {
				System.err.println("半角数字を入力して下さい");
			}
		}
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
		input();
	}
}
