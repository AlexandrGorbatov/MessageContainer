package com.message.mvc.dao;

import com.message.mvc.model.Message;

import java.util.List;

/**
 * Created by alex on 24.10.14.
 */
public interface MessageDao {

    public void save(Message message);

    public List getAll();

    public List findByName();

    public List findByDate();

}
