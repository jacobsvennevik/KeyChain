package home.password;

import java.util.Random;

public class Cipher {
	
	static int num_chars = 26;

	public static void encrypt(Password p, int shiftLength ){
		String encryptedPassword = "";
		for(char c : p.getPassword().toCharArray()) {
			char newC= shiftChar(c, shiftLength);
			encryptedPassword += String.valueOf(newC);
		}
		p.setPassword(encryptedPassword);
		p.setEncryption(shiftLength+p.getEncryption());
	}

	public static void decrypt(Password p) {
		int shiftLength = p.getEncryption();
		encrypt(p, -shiftLength);
	}

	public static int randEncryption() {
		Random rand = new Random(); 
		int r = rand.nextInt(10); 
		return r;
	}

	public static char shiftChar(char c, int steps){
		char offset = 'a';
		if(!Character.isLetter(c)) {
			if(Character.isDigit(c)) {
				offset = '0';
			}
			else {
				return c;	
			}
		}
		if(Character.isUpperCase(c)) {
			offset = 'A';
		}
		int index = c-offset;
		index = nextIndex(index, steps);
		return (char) (offset+index);
	}

	private static int nextIndex(int index, int steps) {
		index += steps;
		index = index % num_chars;
		if(index<0)
			index += num_chars;
		return index;
	}

}
