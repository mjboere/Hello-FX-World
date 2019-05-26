package models;

public class Account {

	private String uid = "";
	private String pwd = "";
		
	public Account() {
		
	}

	public boolean validateLogin(String uid, String pwd){ 
		if  ( (uid.equals(this.uid)) && 
			  (pwd.equals(this.pwd)) ) {
			return true; 
		} else {
			return false;
		}
	}
	
}
