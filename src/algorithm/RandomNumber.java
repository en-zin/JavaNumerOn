package algorithm;
import java.util.Random;
public class RandomNumber {
	private int number[];
	private Random random = new Random();
	RandomNumber() {
		number = new int[4];
	}
	

	public int[] generate() {
		for(int i = 0; i < 4; i++) {
			Loop: while(true){
				number[i] = random.nextInt(10);			
		            for(int j = 0; j < i; j++){
		                //その前までの数値のどれかとかぶっていたら数値代入からやり直し
		                if(number[j] == number[i]) continue Loop;
		            }
		            break;
		        }
		}
		return number;
	}
	
	
}