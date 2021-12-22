package com.example.entity;
import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "User",schema = "public")
@SequenceGenerator(schema = "public",name = "generator", sequenceName = "user_id_seq")

public class UserEntity implements Serializable {


    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "userid", nullable = false)
    private long userId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "lastname", nullable = false)
    private String lastName;
    @Column(name = "mail", nullable = false)
    private String userMailAddress;
    @Column(name = "phonenumber", nullable = false)
    private String userPhone;
    @Column(name = "recorddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordDate;
    @Column(name = "UserName", nullable = false,length = 20)
    private String userName;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserMailAddress() {
        return userMailAddress;
    }

    public void setUserMailAddress(String userMailAddress) {
        this.userMailAddress = userMailAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserEntity() {
    }

    public UserEntity(long userId, String name, String lastName, String userMailAddress, String userPhone, Date recordDate, String userName) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.userMailAddress = userMailAddress;
        this.userPhone = userPhone;
        this.recordDate = recordDate;
        this.userName = userName;
    }
}
