package com.message.mvc.dao;

import com.message.mvc.model.Message;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.*;

/**
 * Created by Ale3x on 26.10.2014.
 */
public class MessageDaoImplTest {

    private static final int USER_ID = 1;
    private static final String USER_NAME = "Alex";
    private static final String DATE_FROM = "2014-05-20";
    private static final String DATE_TO = "2014-06-01";

    private MessageDaoImpl messageDao = new MessageDaoImpl();

    private SessionFactory sessionFactory;
    private Session session = null;
    private Query query;
    private Criteria criteria;

    @Before
    public void init() {
        sessionFactory = mock(SessionFactory.class);
        session = mock(Session.class);
        query = mock(Query.class);
        criteria = mock(Criteria.class);
        messageDao.setSessionFactory(sessionFactory);
    }

    @Test
    public void saveMessage() {
        final Message message = createMessage();

        when(sessionFactory.getCurrentSession()).thenReturn(session);
        doAnswer(new Answer() {
            public Object answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                Message msg = (Message) args[0];
                msg.setId(USER_ID);

                return null;
            }
        })
                .when(session).persist(message);

        messageDao.save(message);


        Assert.assertNotNull(message);
        Assert.assertEquals(message.getUserName(), USER_NAME);
        Assert.assertEquals(message.getId(), USER_ID);

    }

    @Test
    public void getAllMessages() {

        ArrayList<Message> messages = new ArrayList<Message>();
        messages.add(new Message());
        messages.add(new Message());
        messages.add(new Message());
        messages.add(new Message());

        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createQuery("from Message")).thenReturn(query);
        when(query.list()).thenReturn(messages);

        Assert.assertNotNull(messages);
        Assert.assertEquals(messages.size(), 4);

    }

    @Test
    public void findMessageByName() {
        ArrayList<Message> messages = new ArrayList<Message>();
        messages.add(new Message());
        messages.add(new Message());
        messages.add(new Message());

        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createQuery("from Message where userName =" + "'" + USER_NAME + "'")).thenReturn(query);
        when(criteria.list()).thenReturn(messages);

        Assert.assertNotNull(messages);
        Assert.assertEquals(messages.size(), 3);

    }

    @Test
    public void findMessagesByDate() {
        ArrayList<Message> messages = new ArrayList<Message>();
        messages.add(new Message());
        messages.add(new Message());

        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createQuery("from Message where createdDate between " + DATE_FROM + " AND " + DATE_TO)).thenReturn(query);

        when(criteria.list()).thenReturn(messages);

        Assert.assertNotNull(messages);
        Assert.assertEquals(messages.size(), 2);
    }


    private Date getDate(String dateStr) throws ParseException {
        DateFormat converter = new SimpleDateFormat("yyyy-MM-dd");
        return converter.parse(dateStr);
    }


    private Message createMessage() {
        final Message message = new Message();
        message.setCreatedDate(new Date());
        message.setUserName(USER_NAME);
        message.setMessageText("Test text");
        return message;
    }


}
