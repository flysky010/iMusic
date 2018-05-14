package com.ssm.dto.user;

public class User {
	private Integer id;    
    
    private String name;    
    
    private String password;
    
    private Integer state;
    
    private Integer isAdmin;
    
    private String pic;//用户头像
    
    public Integer getId() {    
        return id;    
    }    
    
    public void setId(Integer id) {    
        this.id = id;    
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
        this.password = password == null ? null : password.trim();    
    }

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

}
