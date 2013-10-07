package algorithm.probability;

import java.util.Random;

public class shuffle {
	
	public void shuffleArray(int[] array){
		
		Random rand = new Random();
		for(int j = 0; j < array.length; j++){
			int index = j + rand.nextInt(array.length-1-j);
			int temp = array[index];
			array[index] = array[j];
			array[j] = temp;
		}
	}

}
