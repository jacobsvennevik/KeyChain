package home.KeyChain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import home.dictionary.WordDictionary;
import home.dictionary.WordReader;

class WordReadertest {
	private static String file;
	private static WordDictionary dic;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		file = "words.txt";
		dic = new WordDictionary();
		WordReader.Read(file, dic);
		
	}
	
	@Test
	void Readtest() throws Exception {
		for (String s: dic.getThreeLetter()) {
			assertEquals(s.length(), 3);
			char[] chars = s.toCharArray();
		    for (char c : chars) {
		        assertTrue(Character.isLetter(c));
		    }
		}
		for (String s: dic.getFourLetter()) {
			assertEquals(s.length(), 4);	
		}
		for (String s: dic.getFiveLetter()) {
			assertEquals(s.length(), 5);	
		}
	}

}
