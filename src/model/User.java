package model;


import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class User implements KvmSerializable{
	private int id;
	private String username;
	private String password;
	public User(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public User() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    public Object getProperty(int i) {
        switch(i){
            case 0 : return id;
            case 1 : return username;
            case 2 : return password;
            default: return password;
        }
    }

    public int getPropertyCount() {
        return 3;
    }

    public void setProperty(int i, Object o) {
        switch(i){
            case 0 : 
                id = Integer.parseInt(o.toString());
                break;
            case 1 : 
                username = o.toString();
                break;
            case 2 :
                password = o.toString();
                break;
        }
    }

    public void getPropertyInfo(int i, Hashtable hshtbl, PropertyInfo pi) {
        switch(i){
            case 0 : 
                pi.type = PropertyInfo.INTEGER_CLASS;
                pi.name = "id";
                break;
            case 1 :
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "username";
                break;
            case 2 : 
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "password";
                break;
        }
    }
	
	
}
