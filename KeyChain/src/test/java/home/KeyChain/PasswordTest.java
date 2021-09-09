package home.KeyChain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import home.password.Password;

class PasswordTest {

	
	
	@Test
	void passwordTest() throws Exception {
		Password p = new Password("hallo", 4);
		assertEquals(p.getWebbsite(), "hallo");
		assertFalse(p.getPassword().isBlank());
		p.setPassword("hei");
		assertEquals(p.getPassword(), "hei");
	}

}
