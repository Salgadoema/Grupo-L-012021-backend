package ar.edu.unq.desapp.grupoL012021.backenddesappapl.model;

import javax.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Integer id;


    @Column
    private String platform;

    @Column
    private String password;

    @Column
    private String token;




    public Users() {
        super();
    }

    public Users(Integer id,  String platform,String password, String token) {
        this.id = id;
        this.platform= platform;
        this.password = password;
        this.token= token;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getToken(){return this.token;}
    public void setToken(String token) {
        this.token=token;
    }
}
