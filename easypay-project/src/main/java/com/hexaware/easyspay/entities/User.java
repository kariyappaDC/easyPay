package com.hexaware.easyspay.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotBlank(message = "Username must not be blank.")
    @Size(min = 5, max = 50, message = "Username must be between 5 and 50 characters.")
    private String userName;

    @NotBlank(message = "Password must not be blank.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).*$", 
             message = "Password must contain at least one letter, one number, and one special character.")
    private String password;
    
    private String roleName;// USER,ADMIN,CUSTOMER

    @Positive(message = "Role ID must be a positive number.")
    private int roleId;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Employee employee;

    
    
    // Default constructor
    public User() {
        super();
    }

    // Parameterized constructor
    public User(int userId, String userName, String password,String roleName, int roleId) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.roleId = roleId;
        this.roleName = roleName;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
}
