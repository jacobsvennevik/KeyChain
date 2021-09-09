package home.password;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import home.dictionary.WordDictionary;
import home.dictionary.WordReader;

public class PasswordGenerator {

	
	public static String passwordGenerator(int length) {
		WordDictionary dic = new WordDictionary();
		String password = "";
		try {
			WordReader.Read("words.txt", dic);
		} catch (Exception e) {
			e.printStackTrace();
		}
		while (password.length() < length) {
			String w = randWord(length - password.length(), dic);
			password += w;
			if (length - password.length() > 1) {
				password += "-";
			}

		}
		return password;
	}

	private static List<String> getWordDic(int length, WordDictionary dic) {
		if(length >= 12 || length == 10 ) {
			return dic.getFiveLetter();
		}
		else {
			if (length <= 2) {
					List<String> list = new ArrayList<>();
					list.addAll(Arrays.asList(
							"1", "2", "3", "4",
							"5"));
					return list;
				}
			
			if(length % 2 == 0 || length == 3) {
				return dic.getThreeLetter();
			}
			else {
				return dic.getFourLetter();
			}
		}
		}

	

	private static String randWord(int wordLength, WordDictionary dic) {
			Random r = new Random();
			List<String> wordList = getWordDic(wordLength, dic);
			int randIndex = r.nextInt(wordList.size());
			String randWord = wordList.get(randIndex);
			return randWord;
		}


	}

