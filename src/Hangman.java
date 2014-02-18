import java.util.Scanner;

public class Hangman {

	Words words;
	private int count;
	private boolean guessed = false; //has the word been guessed
	private int numGuessed = 0; //number of letters correctly guessed
	private String[] copy;
	private String[] wrongGuesses = new String[26]; //array of letter guessed wrong

	public static void main(String[] args) {

		Hangman game = new Hangman();
	}

	public void run() {

		words = new Words();
		words.generateWord();
		String word = words.getChosenWord();
		
		String[] letters = words.getIncludedChars(); //The word stored as an array of chars
		copy = new String[letters.length]; //Where the correct guesses are displayed
		
		while (guessed == false) {
			System.out.println("Please choose a letter");
			Scanner input = new Scanner(System.in);
			
			String letter = input.next();

			checkLetter(letters, copy, letter);
		}
	}

	private void checkLetter(String[] letters, String[] copy, String a) {

		for (int i = 0; i < letters.length; i++) {
			if (letters[i] == a) {
				count++;
				copy[i] = letters[i];			
			}else{
				
			}
		}
		
	}

	private void checkGuessed(String[] copy) {

		for (int i = 0; i < copy.length; i++) {
			if (!copy[i].equals(" ")) {
				numGuessed++;
			}
		}

		if (numGuessed == copy.length) {
			guessed = true;
		}
	}

}
