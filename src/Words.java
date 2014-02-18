import java.util.Arrays;
import java.util.Random;

public class Words {

	private String[] dictionary = { "array", "list", "parse", "variable", "linux",
			"windows", "apple", "microsoft", "tablet", "processor", "keyboard",
			"source", "loop", "mouse", "code", "program", "application" };

	private String chosenWord;
	private String[] letters;
	
	protected void generateWord(){
		chosenWord = chooseWord();
		letters = chosenWord.split("");
	}

	private String chooseWord() {
		Random generator = new Random();
		int indx = generator.nextInt(dictionary.length + 1);
		return dictionary[indx];
	}

	public String getChosenWord() {
		return chosenWord;
	}

	public String[] getLetters() {
		return letters;
	}
	
	
}
