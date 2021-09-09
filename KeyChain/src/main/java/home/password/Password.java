package home.password;

import java.util.Random;

public class Password {

	private String password;
	private int encryption;
	private String website;

	public Password(String password, String website) throws Exception {
		if(checkIfBlank(website)) {
			throw new Exception("Webbsite can't be null or blank");
		}
		this.password = password;
		this.website = website;

	}
	


	public Password(String website, int length) throws Exception {
		if(checkIfBlank(website)) {
			throw new Exception("Webbsite can't be null or blank");
		}
		password = PasswordGenerator.passwordGenerator(length);
		this.website = website;
	}
	
	// for text file 
	public Password(String password, String website, String encrption) {
		this.password = password;
		this.website = website;
		this.encryption = Integer.parseInt(encrption); 
		Cipher.decrypt(this);
		
	}
	
	private boolean checkIfBlank(String webbsite) {
		if(webbsite == null || webbsite.isBlank()) {
			return true;
					
		}
		return false;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEncryption() {
		return encryption;
	}

	public void setEncryption(int encryption) {
		this.encryption = encryption;
	}

	public String getWebbsite() {
		return website;
	}

	public void setWebbsite(String website) {
		this.website = website;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Password) {
			Password p = (Password) obj;
			return this.getWebbsite().equals(p.getPassword());
		}
		return false;
	};

	@Override
	public String toString() {
		return String.format("%20s %20s %20s \r\n", getWebbsite(), getPassword(), getEncryption());
	}
	
	
	




	


	

}
