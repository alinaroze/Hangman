import java.util.Scanner;

public class Hangman {

	Words words;
	private int count;
	private boolean guessed = false;
	private int numGuessed = 0;

	public static void main(String[] args) {

		Hangman game = new Hangman();
	}

	public void run() {

		words = new Words();
		words.generateWord();
		
		String word = words.getChosenWord();
		char[] letters = words.getIncludedChars();

		while (guessed == false) {
			System.out.println("Please choose a letter");
			Scanner input = new Scanner(System.in);
			
			char letter = input.next().charAt(0);

			checkLetter(letters, letter);
		}
	}

	private void checkLetter(char[] letters, char a) {

		for (int i = 0; i < letters.length; i++) {
			if (letters[i] == a) {
				count++;
				letters[i] = 0;
				
				
			}
		}
		
	}

	private void checkGuessed(char[] letters) {

		for (int i = 0; i < letters.length; i++) {
			if (letters[i] == 0) {
				numGuessed++;
			}
		}

		if (numGuessed == letters.length) {
			guessed = true;
		}
	}

}
