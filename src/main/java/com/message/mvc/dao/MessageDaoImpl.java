package com.message.mvc.dao;

import com.message.mvc.model.Message;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * Created by alex on 24.10.14.
 */
@Repository
public class MessageDaoImpl implements MessageDao {
    private static final Logger log = Logger.getLogger(MessageDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void save(Message message) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(message);
        log.info("Message saved successfully, Message Details=" + message.getId());
    }

    @Override
    public List getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List messageList = session.createQuery("from Message").list();
        if (messageList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        return messageList;
    }

    @Override
    public List findByName() {
        return null;
    }

    @Override
    public List findByDate() {
        return null;
    }
}
