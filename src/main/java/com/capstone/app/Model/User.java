package com.capstone.app.Model;

import java.util.function.Predicate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userId;
	private String password;
	private String name;
	private String office;
	private String position;
	private int level;
	
	public User() {}
	
	public User(int id, String userId, String name, String password, String office, String position) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.office = office;
		this.position = position;
	}
	
	public User(String userId, String name, String password, String office, String position) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.office = office;
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public static boolean isLoggednIn() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    //System.out.println(currentUserName);		    
		}
		
		if (authentication.getName() != null && !authentication.getName().equals("anonymousUser")) {
			//System.out.println("user found");
			return true;
		}	
		else {
			return false;
		}
	}

}
