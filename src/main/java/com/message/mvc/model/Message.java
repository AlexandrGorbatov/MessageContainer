package com.message.mvc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by alex on 24.10.14.
 */
@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "message_text")
    private String messageText;

    @Column(name = "created_date")
    private Date createdDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageBody) {
        this.messageText = messageBody;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createDate) {
        this.createdDate = createDate;
    }
}
