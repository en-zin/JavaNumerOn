package algorithm;

public class RandomNumber {

	

	public int[] generate() {
		int	number[] = {0,1,2,3,4,5,6,7,8,9};
		int numeronNumber[] = new int[4];
		
		for(int i = 0; i < number.length; i++) {
			int shuffle = (int)(Math.random() * (double)number.length);
			int set = number[i];
			number[i] = number[shuffle];
			number[shuffle] = set;
		}
		
		for(int i = 0; i < numeronNumber.length; i++) {
			numeronNumber[i] = number[i];
		}
		
		return numeronNumber;
	}
	
	
}