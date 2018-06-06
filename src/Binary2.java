import java.util.Scanner;

public class Binary2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String letters = "";
		StringBuilder binaryTemp = new StringBuilder();
		StringBuilder binaryFull = new StringBuilder();
		String[] fullCode = new String[4];
		String[][] splitCode = new String[4][2];
		BinarySplitter split = new BinarySplitter();
		int counter =0;

		// word input and checking if it's 4 letters
			System.out.println("Please input 4 letters");
			letters = scan.next();
			
			// checking for only letters
			boolean allLetters = letters.chars().allMatch(Character::isLetter);
			while(allLetters == false) {
				System.out.println("Your input should only contain letters.");
				letters = scan.next();
				allLetters = letters.chars().allMatch(Character::isLetter);
			}
			// end of checking for only letters

			while(letters.length() < 4 || letters.length() > 4) {
				System.out.println("Wrong input, please input 4 letters");
				letters = scan.next();
				
			}
			letters = letters.toUpperCase();
			System.out.println("Your word is: " + letters);
		// end of word input and letter checking
		
		
		byte[] bytes = letters.getBytes();
		
		//extract byte values and store them in array
		for (byte b : bytes) {
			int val = b;
			for (int i = 0; i < 8; i++) {
				binaryTemp.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}
			if(counter < 4) {
				binaryFull.append(binaryTemp + " ");
				fullCode[counter] = binaryTemp.toString();
				binaryTemp.setLength(0);
			}
			counter++;
		}
		//end of byte extractions
		
		// cutting the byte in two
		for(int i = 0; i < fullCode.length; i++) {
			System.out.println("The [" + i + "] element is: " + fullCode[i]);
		}
		for(int i = 0; i < 4; i++) {
			splitCode[i][0] = split.firstHalf(fullCode[i]);
			splitCode[i][1] = split.secondHalf(fullCode[i]);
			
		}
		// end of cutting the byte in two

		// testing splitCode array
//		for(int i =0; i < 4; i++) {
//			for(int j = 0; j < 2; j++) {
//				System.out.println("This is element [" + i + "] " + " [" + j + "]: " + splitCode[i][j]);
//			}
//		}
		
		System.out.print("[" + 0 + "] " + " [" + 0 + "]: " + splitCode[0][0] + " | ");
		System.out.println(" [" + 0 + "] " + " [" + 1 + "]: " + splitCode[0][1] + " | ");
		System.out.print("[" + 1 + "] " + " [" + 0 + "]: " + splitCode[1][0] + " | ");
		System.out.println(" [" + 1 + "] " + " [" + 1 + "]: " + splitCode[1][1] + " | ");
		System.out.print("[" + 2 + "] " + " [" + 0 + "]: " + splitCode[2][0] + " | ");
		System.out.println(" [" + 2 + "] " + " [" + 1 + "]: " + splitCode[2][1] + " | ");
		System.out.print("[" + 3 + "] " + " [" + 0 + "]: " + splitCode[3][0] + " | ");
		System.out.println(" [" + 3 + "] " + " [" + 1 + "]: " + splitCode[3][1] + " | ");

		// end of splitCode array testing
		
		System.out.println("Text : " + letters);
		System.out.println("'" + letters + "' to binary: " + binaryFull);
	    System.out.println("Text in byte: " + bytes.toString());
	    String s = new String(bytes);
	    System.out.println("Text Decryted : " + s);
	    
	}

}
