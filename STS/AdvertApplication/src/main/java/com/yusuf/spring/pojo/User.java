package com.yusuf.spring.pojo;


//primary also refering to foreign column is primarykey Joined column is used
public class User extends Person {
    
    private String name;
    
   private String password;
   private Email email;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}
}