package se.iths.Skeppokaj.login;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * @author Kråkan
 *
 */
public class LoginManagerTest {

	LoginManager loginManager;

	@Before
	public void defineLoginManager(){
		loginManager = new LoginManager("","");
	}

	@Ignore
	//@Test
	public void validateEmptyUserTest() {
		loginManager = new LoginManager(null,"admin");

		assertFalse(loginManager.validate());
	}

	@Ignore
	//@Test
	public void validateEmptyPwdTest() {
		loginManager = new LoginManager("Sofia",null);

		assertFalse(loginManager.validate());
	}

	@Test
	public void validateNoUserNameTest() {
		loginManager = new LoginManager("","admin");

		assertFalse(loginManager.validate());
	}

	@Test
	public void validateNoPwdTest() {
		loginManager = new LoginManager("Sofia","");

		assertFalse(loginManager.validate());
	}

	@Test
	public void validateValidUserPwdTest() {
		loginManager = new LoginManager("Sofia","admin");

		assertTrue(loginManager.validate());
	}
}
