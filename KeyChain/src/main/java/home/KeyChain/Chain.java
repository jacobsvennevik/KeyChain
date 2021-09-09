package home.KeyChain;

import java.util.ArrayList;
import java.util.List;

import home.password.Password;

public class Chain {

	private List<Password> passwordList;
	private String name;

	public Chain(String name) {
		passwordList = new ArrayList<>();
		this.name = name;
	}

	public List<Password> getPasswords() {
		return passwordList;
	}

	public void add(Password p) {
		if (!passwordList.contains(p))
			passwordList.add(p);
	}

	public String getName() {
		return name;
	}

	public Boolean contains(String webbsite) {
		for(Password p: getPasswords()) {
			if(p.getWebbsite() == webbsite) {
				return true;
			}
		}
		return false;
	}




}
