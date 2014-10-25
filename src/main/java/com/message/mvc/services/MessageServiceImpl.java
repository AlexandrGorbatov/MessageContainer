package com.message.mvc.services;

import com.message.mvc.dao.MessageDao;
import com.message.mvc.dao.MessageDaoImpl;
import com.message.mvc.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Created by alex on 24.10.14.
 */

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDaoImpl messageDao;



    @Override
    @Transactional
    public void save(Message message) {
        if (message != null) {
            messageDao.save(message);
        }
    }

    @Override
    @Transactional
    public List getAll() {
        return messageDao.getAll();
    }

    @Override
    @Transactional
    public List findByName() {
        return null;
    }

    @Override
    @Transactional
    public List findByDate() {
        return null;
    }
}
