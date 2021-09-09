package home.dictionary;

import java.util.ArrayList;
import java.util.List;

public class WordDictionary {
	
	
	private List <String> threeLetter;
	private List <String> fourLetter;
	private List <String> fiveLetter;
	
	public WordDictionary(){
		fiveLetter = new ArrayList<String>();
		threeLetter = new ArrayList<String>();
		fourLetter = new ArrayList<String>();
	}

	public List<String> getFiveLetter() {
		return fiveLetter;
	}

	public void addFiveLetter(String s) {
		fiveLetter.add(s);
	}

	public List<String> getThreeLetter() {
		return threeLetter;
	}

	public void addThreeLetter(String s) {
		threeLetter.add(s);
	}

	public List<String> getFourLetter() {
		return fourLetter;
	}

	public void addFourLetter(String s) {
		fourLetter.add(s);
	}
	
	
	
	

}
