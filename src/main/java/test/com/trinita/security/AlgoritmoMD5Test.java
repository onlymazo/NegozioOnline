package test.com.trinita.security;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.trinita.security.AlgoritmoMD5;

class AlgoritmoMD5Test {

	@Test
	void test() {
		String pass = AlgoritmoMD5.convertiMD5("Pass01");
		assertNotNull(pass);
		System.out.println(pass);
	}
}
