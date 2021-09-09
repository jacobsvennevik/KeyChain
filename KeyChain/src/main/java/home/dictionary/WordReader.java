package home.dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordReader {
	

	public static void Read(String file, WordDictionary dic) throws Exception {
		BufferedReader bufReader = new BufferedReader(new FileReader(file));
	
		try {
			String line = bufReader.readLine();
			while (line != null) {
				deilgate(dic, line);
				line = bufReader.readLine();
			}

			bufReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void deilgate(WordDictionary dic, String line) {
		if(isLetters(line)) {
			if (line.length() == 3) {
				dic.addThreeLetter(line);
			}
			if (line.length() == 4) {
				dic.addFourLetter(line);
			}
			if (line.length() == 5) {
				dic.addFiveLetter(line);
			}
		}
	}

	private static boolean isLetters(String line) {
		return line.matches("[a-zA-Z]+");
	}


}
