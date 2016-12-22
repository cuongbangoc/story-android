package model;


import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class Story implements KvmSerializable{
	private int id;
	private int idCategory;
	private String name;
	private String content;
        private String language;
	private String note;

    public Story(int id, int idCategory, String name, String content, String language, String note) {
        this.id = id;
        this.idCategory = idCategory;
        this.name = name;
        this.content = content;
        this.language = language;
        this.note = note;
    }

    public Story() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Object getProperty(int i) {
       switch(i){
           case 0 : 
               return id;
           case 1 : 
               return idCategory;
           case 2 : 
               return name;
           case 3 : 
               return content;
           case 4 : 
               return language;
           case 5 : 
               return note;
           default:
               return note;
       }
    }

    public int getPropertyCount() {
        return 5;
    }

    public void setProperty(int i, Object o) {
        switch(i){
            case 0 : 
                id = Integer.parseInt(o.toString());
                break;
            case 1 : 
                idCategory = Integer.parseInt(o.toString());
                break;
            case 2 : 
                name = o.toString();
                break;
            case 3 : 
                content = o.toString();
                break;
            case 4 :
                language = o.toString();
                break;
            case 5 : 
                note = o.toString();
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
                pi.type = PropertyInfo.INTEGER_CLASS;
                pi.name = "idCategory";
                break;
            case 2 : 
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "name";
                break;
            case 3 : 
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "content";
                break;
            case 4 : 
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "language";
                break;
            case 5 : 
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "note";
                break;
        }
    }
	
	
	
}
