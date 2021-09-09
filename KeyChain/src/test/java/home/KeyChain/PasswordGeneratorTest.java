package home.KeyChain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import home.password.PasswordGenerator;



class PasswordGeneratorTest {
	


	
	@Test
	void testPasswordGenerator() {
		for (int i=0; i < 10; i++) {
			String p = PasswordGenerator.passwordGenerator(14);
			assertNotEquals(p, null);
			assertTrue(p.length() <= 14);
		}
		
	}


}
