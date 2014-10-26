package com.message.mvc.services;

import com.message.mvc.model.Message;

import java.util.List;

/**
 * Created by alex on 24.10.14.
 */
public interface MessageService {

    public void save(Message message);

    public List getAll();

    public List findByName(String userName);

    public List findByDate(String dateFrom, String dateTo);
}
