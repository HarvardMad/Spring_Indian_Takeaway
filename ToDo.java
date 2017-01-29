package com.springapp.product;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by LalinPethiyagoda on 08/10/2016.
 */
public class ToDo {
    private int id;
    private String user;

    @Size(min = 6 , message =" Enter at least 6 characters")
    private String desc;

    private Date targetDate;
    private String isDone;

    public ToDo(){};

    public ToDo(int id,
            String user,
            String desc,
            Date targetDate,
            String isDone){

        this.id=id;
        this.user=user;
        this.desc=desc;
        this.targetDate = targetDate;
        this.isDone = isDone;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getIsDone() {
        return isDone;
    }

    public void setIsDone(String isDone) {
        this.isDone = isDone;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToDo)) return false;

        ToDo toDo = (ToDo) o;

        return id == toDo.id;

    }

    @Override
    public int hashCode() {
        return id;
    }*/

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +

                ", user='" + user + '\'' +
                ", desc='" + desc + '\'' +
                ", targetDate=" + targetDate + '}';
    }
}
