package home.KeyChain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import home.password.Cipher;
import home.password.Password;

class CipherTest {
	
	static Password p;
	static Password p1;
	static Password p2;
	static Password p3;
	static Password p4;


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		p = new Password("cbc", "test");
		p1 = new Password("CBC", "test");
		p2 = new Password("c'Ba", "test");
		p3 = new Password("test", 14);
		p4 = new Password("test", 5);
		
	}

	
	@Test 
	void encryptTest() throws Exception {
		String p4Before = p4.getPassword();
		Cipher.encrypt(p4,3);
		assertNotEquals(p4Before, p4.getPassword());;
		assertEquals(p4.getEncryption(), 3);
		String p3Before = p3.getPassword();
		Cipher.encrypt(p3,6);
		assertNotEquals(p3Before, p3.getPassword());;
		assertEquals(p3.getEncryption(), 6);
	}
	
	@Test 
	void shiftCharTest() {
		char c = Cipher.shiftChar('a', 1);
		assertEquals(c, 'b');
		char c1 = Cipher.shiftChar('3', 1);
		assertEquals(c1, '4');
		char c2 = Cipher.shiftChar('z', 3);
		assertEquals(c2, 'c');
		char c4 = Cipher.shiftChar('3', -1);
		assertEquals(c4, '2');
		char c5 = Cipher.shiftChar('b', -2);
		assertEquals(c5, 'z');
		
		
	}
	@Test
	void decryptTest() throws Exception {
			Cipher.encrypt(p, 3);
			Cipher.decrypt(p);
			assertEquals(p.getPassword(), "cbc");
			Cipher.encrypt(p1,1);
			Cipher.decrypt(p1);
			assertEquals(p1.getPassword(), "CBC");
			Cipher.encrypt(p2,10);
			Cipher.decrypt(p2);
			assertEquals(p2.getPassword(), "c'Ba");
			
			String p3Before = p3.getPassword();
			Cipher.encrypt(p3,3);
			Cipher.decrypt(p3);
			assertEquals(p3Before, p3.getPassword());;
			String p4Before = p4.getPassword();
			Cipher.encrypt(p4,6);
			Cipher.decrypt(p4);
			assertEquals(p4Before, p4.getPassword());
	
			
		}
	}


