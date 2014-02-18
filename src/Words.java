import java.util.Arrays;
import java.util.Random;

public class Words {

	private String[] words = { "array", "list", "parse", "variable", "linux",
			"windows", "apple", "microsoft", "tablet", "processor", "keyboard",
			"source", "loop", "mouse", "code", "program", "application" };

	private String chosenWord;
	private char[] includedChars;
	
	protected void generateWord(){
		chosenWord = chooseWord();
		includedChars = chosenWord.toCharArray();
	}

	private String chooseWord() {
		Random generator = new Random();
		int indx = generator.nextInt(words.length + 1);
		return words[indx];
	}

	public String getChosenWord() {
		return chosenWord;
	}

	public char[] getIncludedChars() {
		return includedChars;
	}
	
	
}
