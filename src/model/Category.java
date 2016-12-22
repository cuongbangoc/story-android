package model;


import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class Category implements KvmSerializable{
	private int id;
	private String name;
	private String description;
	public Category(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public Category() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

    public Object getProperty(int i) {
        if(i == 0){
            return id;
        }else
            if(i == 1) {
                return name;
            }else
                
                    return description;
                
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
                name = o.toString();
                break;
            case 2 : 
                description = o.toString();
                break;
        }
    }

    public void getPropertyInfo(int i, Hashtable hshtbl, PropertyInfo info) {
        switch (i) {
        case 0:
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "id";
            break;
        case 1:
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "name";
            break;
        case 2 : 
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "description";
        default:
            break;
        }
    }
	
	
}
