import java.util.Scanner;

/**
 * A game of hangman with a special picture reward
 * 
 * @author Alina Rozenbaum
 * 
 */
public class PictureHangman {

	Words words;
	private String word;// String where generated word is stored
	private boolean guessed; // has the word been guessed

	private int guessRight; // number of letters correctly guessed
	private int guessWrong;// number of letters incorrectly guessed
	private int indx; // index of the array of wrong letters

	private String[] letters;// Array where letters of generate word are stored
	private String[] copy; // array where correct guesses appear
	private String[] wrongGuesses; // array of wrong guesses

	public static void main(String[] args) {

		System.out
				.println("Hello and welcome to the game of PICTURE HANGMAN!\n\n"
						+ "In this game you will be guessing a word (Duh.) and as you guess...\n"
						+ "...More and more of a picture will appear.\n\n"
						+ "You can either guess it letter by letter, or guess the whole word.\n"
						+ "BUT BE WARNED!!...You only have TWENTY (20) wrong guesses...\n"
						+ "Before you LOSE the game.\n\n"
						+"NOTE: The words will only consist of letters.\n"
						+"HOWEVER, you can input symbols, so be careful!"
						+"Ready to begin??!! Go!!\n\n");

		PictureHangman game = new PictureHangman();
		game.run();
		
	}// end main

	/**
	 * Runs the hangman game
	 */
	public void run() {

		initialize();
		
		print();

		while (guessed == false) {
			if (guessWrong == wrongGuesses.length) {
				lose();
			}

			guess(word, letters);
		}// end while

		win();
	}// end run

	/**
	 * Initializes all the class variables and the game
	 */
	private void initialize() {
		guessed = false; // has the word been guessed
		guessRight = 0; // number of letters correctly guessed
		guessWrong = 0;

		wrongGuesses = new String[20]; // array of wrong guesses
		indx = 0;// index of the array of wrong letters

		words = new Words();// new Words object
		words.generateWord(); // generates a new word

		// Stores generated word as a String
		word = words.getChosenWord();
		// The word is stored as an array of letters
		letters = words.getLetters();
		// Where the correct guesses are displayed
		copy = new String[letters.length];

		// Initalizes the array with spaces
		for (int i = 0; i < copy.length; i++) {
			copy[i] = " __";
		}
	}// end initialize

	/**
	 * Prompts the user to guess a word or letter
	 * 
	 * @param word
	 *            - The generated word
	 * @param letters
	 *            - The array of letters in the generated word
	 */
	private void guess(String word, String[] letters) {
		System.out.println("\n\n\n Please choose a letter or guess the word.");
		Scanner input = new Scanner(System.in);

		String guess = input.next();

		// If the input String is longer than 1, it's a word
		if (guess.length() > 1) {
			checkWord(word, guess, letters);
		}// end if

		// otherwise search for the letter
		checkLetter(letters, copy, guess);
		
		print();
	}// end guess

	/**
	 * Checks if the word entered is the same as the generated word
	 * 
	 * @param word
	 *            - The generated word
	 * @param guess
	 *            - The user's guess
	 */
	private void checkWord(String word, String guess, String[] letters) {

		if (word.equalsIgnoreCase(guess)) {
			for (int i = 0; i < letters.length; i++) {
				copy[i] = letters[i];
			}
			win();
		} else {
			// Adds one to the number of incorrect guesses
			guessWrong++;
			// Adds the letter to the array of wrong guesses
			wrongGuesses[indx] = guess;
			// Prompts the user to guess again
			System.out
					.println("This is not the word you're looking for. Try again.");
			guess(word, letters);
		}// end if-else
	}// end checkWord

	/**
	 * Checks to see if the generated word contains that letter
	 * 
	 * @param letters
	 *            - The array of letters in the generated word
	 * @param copy
	 *            - The array of correct guesses
	 * @param guess
	 *            - The guessed letter being checked
	 */
	private void checkLetter(String[] letters, String[] copy, String guess) {

		boolean found = false;

		for (int i = 0; i < letters.length; i++) {

			// Checks if the letter is in the array:
			if (letters[i].equalsIgnoreCase(guess)) {
				guessRight++; // Adds one to the number of correct guesses
				found = true; // If letter is found, sets to true

				// Puts the letter found in its corresponding spot
				copy[i] = letters[i];
			}// end if
		}// end for

		// If the letter was not found:
		if (found == false) {
			// Adds one to the number of incorrect guesses
			guessWrong++;
			// Adds the letter to the array of wrong guesses
			wrongGuesses[indx] = guess;
			indx++; // Moves the index up one for the next wrong guess
		}// end if

	}// end checkLetter

	/**
	 * Was the word correctly guessed?
	 * 
	 * @param copy
	 *            - The array of correct guesses
	 */
	private void checkGuessed(String[] copy) {

		if (guessRight == copy.length) {
			guessed = true;
		}// end if
	}// end checkGuessed

	/**
	 * The win condition
	 */
	private void win() {
		print();

		System.out.println("\n\n\n ***Congradulations! You have guessed the word!\n"
				+ " Would you like to play again?");
		Scanner input = new Scanner(System.in);
		String ans = input.next();

		if (ans.equalsIgnoreCase("yes"))
			run();
		else
			System.out.println("Well then, goodbye!");
		System.exit(0);
	}// end win

	private void lose() {
		print();

		System.out.println("I'm sorry, you couldn't guess the word. :(\n"
				+ " Would you like to play again?");
		Scanner input = new Scanner(System.in);
		String ans = input.next();

		if (ans.equalsIgnoreCase("yes"))
			run();
		else
			System.out.println("Well then, goodbye!");
		System.exit(0);
	}

	/**
	 * Prints the results so far
	 */
	private void print() {

		System.out.println(" The length of the word is: " + word.length());

		System.out.println("\n Number of incorrect guesses: " + guessWrong);

		System.out.println("\n Incorrect guesses: ");
		for (int i = 0; i < wrongGuesses.length; i++) {
			if(wrongGuesses[i] != null){
					System.out.print(wrongGuesses[i] + ", ");
			}
		}

		System.out.println("\n Letters guessed so far: \n");
		for (int i = 1; i < copy.length; i++) {
			System.out.print(" "+ copy[i]);
		}

	}
}
