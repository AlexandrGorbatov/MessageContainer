package com.message.mvc.dao;

import com.message.mvc.model.Message;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by alex on 24.10.14.
 */
@Repository
public class MessageDaoImpl implements MessageDao {
    private static final Logger log = Logger.getLogger(MessageDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


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
        log.info("Message list got successfully, Message Details=" + messageList.size());
        return messageList;
    }

    @Override
    public List findByName(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        List messageList = session.createCriteria(Message.class).add(Restrictions.eq("userName", userName)).list();
        if (messageList.isEmpty()) {
            log.info("Message list is empty, Message Details=" + messageList.size());
            return Collections.EMPTY_LIST;
        }
        log.info("Message list got successfully, Message Details=" + messageList.size());
        return messageList;
    }

    @Override
    public List findByDate(Date dateFrom, Date dateTo) {
        Session session = this.sessionFactory.getCurrentSession();
        List messageList = session.createCriteria(Message.class).add(Restrictions.between("createdDate", dateFrom, dateTo)).list();
        if (messageList.isEmpty()) {
            log.info("Message list is empty, Message Details=" + messageList.size());
            return Collections.EMPTY_LIST;
        }
        log.info("Message list got successfully, Message Details=" + messageList.size());
        return messageList;
    }

    @Override
    public Message findById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Message) session.createCriteria(Message.class).add(Restrictions.eq("id", id));
    }


}
