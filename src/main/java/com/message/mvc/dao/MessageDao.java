package com.message.mvc.dao;

import com.message.mvc.model.Message;

import java.util.Date;
import java.util.List;

/**
 * Created by alex on 24.10.14.
 */
public interface MessageDao {

    public void save(Message message);

    public List getAll();

    public List findByName(String userName);

    public List findByDate(Date dateFrom, Date dateTo);

    public Message findById(int id);

}
