/*
 * Susan Hatem
 * 311
 * HW 1108
 * https://github.com/ProgrammerSusan/Hashing
 */

import java.util.Random;

public class Hash {	
	public static void main(String[] args) {
		
		Random r = new Random(97);
		int[] randomArray = new int[40];
		int val = 10;
		for(int i = 0; i < randomArray.length; i++) {
			randomArray[i] = val;
			val++;
		}
		int max = randomArray.length - 1;
		for(int i = 0; i < inputArray.length; i++) {
			int m = r.nextInt(max+1);
			inputArray[i] = randomArray[m];
			randomArray[m] = randomArray[max];
			max--;
		}
		hashing();
		printArray();
	}
	
	private static int size = 8;
	private static int[] hashTable = new int[size], inputArray = new int[20];
	private static double count = 0;
	
	public static void hashing() { 
		for (int i = 0; i < inputArray.length; i++) {
		    int key = inputArray[i];
		    insert(key);
		    count++;
		    if (count/size >= .75) {
		      size *= 2;
		      int[] temp = new int[size];
		      for(int j = 0; j < hashTable.length; j++) {
		    	  boolean col = false;
		    	  int ind = hashTable[j] % size;
		    	  while(!(col)) {
		    		  if(temp[ind] == 0) {
		    			  temp[ind] = hashTable[j];
		    			  col = true;
		    		  }
		    		  else {
		    			  ind++;
		    		  }
		    	  }
		      }
		      hashTable = temp;
		    }
		}
	}
	
	//separated pseudo-code for cleanliness
	public static void insert(int key) {
	    boolean collision = false;
	    int index = key % size;
		while(!(collision)) {
	    		 if(hashTable[index] == 0) {
			    	hashTable[index] = key;
			    	collision = true;
			 }
			 else {
			    	index = (index + 1) % size;
			 }
	    }
	}
	
	public static void printArray() { 
		for(int i = 0; i < size; i++) {
			System.out.print(hashTable[i] + " ");
		}
	}
}
