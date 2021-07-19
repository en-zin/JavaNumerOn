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
		do{
	        if(in.hasNextInt()){
	        	answer(in.nextInt());
	        	break;
	        }else{
	        	in.nextLine();
	            System.err.println("半角数字を入力して下さい");
	        }
	    }while(true);
	}
	
	private void check(int answer) {
		int answerLength = String.valueOf(answer).length();
		if(answerLength < 4 || answerLength > 4) {
			System.err.println("4桁の数字を入力して下さい");
			input();
		}
	}
	
	private void jsonConversion(int number) {
		//先頭の数字が0だと0を処理してもらえずエラーをはく
		while(number > 0) {
			answerNumber.add(0,number % 10);
			number /= 10;
		}
		if(answerNumber.size() == 3) {
			answerNumber.add(0,0);
		}
	}
	
	public void answer(int answer) {
		check(answer);
		jsonConversion(answer);
		int eat = 0;
		int bite = 0;
		for(int i = 0; i < numeronNumber.length; i++) {
			if(numeronNumber[i] == answerNumber.get(i)) {
				eat++;
			}else {
				for(int j = 0; j < numeronNumber.length; j++) {
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
