package teledon.model;

import java.io.Serializable;

public class Voluntar implements HasID<String>, Serializable {
    private String ID;
    private String name;
    private String password;

    public Voluntar(String ID, String name, String password) {
        this.ID = ID;
        this.name = name;
        this.password = password;
    }

    public Voluntar(String name, String password) {
        this.ID = "";
        this.name = name;
        this.password = password;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
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

    @Override
    public String toString() {
        return "teledon.model.Voluntar{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
