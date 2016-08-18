package org.wso2.msf4j.example.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by MinhTu on 8/15/2016.
 */
@Entity
@Table(name = "person")
public class Person {
    @Id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;

    private String name;
    private int age;
    private String sex;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
