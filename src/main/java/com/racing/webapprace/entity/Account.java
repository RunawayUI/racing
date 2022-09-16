package com.racing.webapprace.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.Instant;

//@NamedQueries(
//        @NamedQuery(name = "Account.queryByEmail", query = "from Account a where a.email = ?")
//)
@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "login", nullable = false, length = 50)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @NotNull(message = "имя не может быть пустым")
    @Email(message = "ошибка формата почты")
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "active")
    private Integer active;

    @Column(name = "created")
    private Instant created;

    @Column(name = "link_pic_small", length = 250)
    private String linkPicSmall;

    @Column(name = "link_pic", length = 250)
    private String linkPic;

    @Column(name = "helmet_pic", length = 250)
    private String helmetPic;

    @Column(name = "nimb_lic")
    private Integer nimbLic;

    @Column(name = "team", length = 70)
    private String team;

    @Column(name = "points")
    private Integer points;

    @Lob
    @Column(name = "about")
    private String about;

    @Column(name = "tel", length = 70)
    private String tel;

    @Column(name = "vk", length = 100)
    private String vk;

    @Column(name = "facebook", length = 100)
    private String facebook;

    @Column(name = "inst", length = 100)
    private String inst;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getLinkPicSmall() {
        return linkPicSmall;
    }

    public void setLinkPicSmall(String linkPicSmall) {
        this.linkPicSmall = linkPicSmall;
    }

    public String getLinkPic() {
        return linkPic;
    }

    public void setLinkPic(String linkPic) {
        this.linkPic = linkPic;
    }

    public String getHelmetPic() {
        return helmetPic;
    }

    public void setHelmetPic(String helmetPic) {
        this.helmetPic = helmetPic;
    }

    public Integer getNimbLic() {
        return nimbLic;
    }

    public void setNimbLic(Integer nimbLic) {
        this.nimbLic = nimbLic;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getVk() {
        return vk;
    }

    public void setVk(String vk) {
        this.vk = vk;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInst() {
        return inst;
    }

    public void setInst(String inst) {
        this.inst = inst;
    }



    public Account(String firstName, String lastName, String about) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.about = about;
    }
//    @ElementCollection(targetClass = Account.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "account_role", joinColumns = @JoinColumn(name = "id_account"))
//    private Set<Role> roles;

    public Account(Integer id) {
        this.id = id;
    }

    public Account(Integer id, String firstName, Integer points) {
        this.id = id;
        this.firstName = firstName;
        this.points = points;
    }

    public Account() {
    }

    public Account(Integer id, String firstName, String lastName, String email, String about, String tel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.about = about;
        this.tel = tel;
    }


}