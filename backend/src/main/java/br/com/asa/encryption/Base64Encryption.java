package br.com.asa.encryption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Base64;

public class Base64Encryption {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public String encodePassword(String pass_word) throws NullPointerException {
		String encodedPassword = null;
		try {
		encodedPassword = Base64.getEncoder().encodeToString(pass_word.getBytes());
		} catch(NullPointerException exp) {
			logger.error(exp.toString(), exp);
		}
		return encodedPassword;
	}
}