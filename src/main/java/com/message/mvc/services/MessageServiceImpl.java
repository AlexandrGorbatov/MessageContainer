package com.message.mvc.services;

import com.message.mvc.dao.MessageDao;
import com.message.mvc.dao.MessageDaoImpl;
import com.message.mvc.model.Message;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by alex on 24.10.14.
 */

@Service
public class MessageServiceImpl implements MessageService {
    private static final Logger log = Logger.getLogger(MessageServiceImpl.class);
    private static final String DATE_FORMAT = "MM/dd/yyyy";

    @Autowired
    private MessageDao messageDao;

    @Override
    @Transactional
    public void save(Message message) {
        messageDao.save(message);
    }

    @Override
    @Transactional
    public List getAll() {
        return messageDao.getAll();
    }

    @Override
    @Transactional
    public List findByName(String userName) {
        return messageDao.findByName(userName);
    }

    @Override
    @Transactional
    public List findByDate(String dateFrom, String dateTo) {
        Date startDate = getDateFromString(dateFrom);
        Date endDate = getDateFromString(dateTo);
        return messageDao.findByDate(startDate, endDate);
    }


    private static Date getDateFromString(String input) {
        Date result = null;
        if (input != null) {
            input = input.trim();
            if (!"".equals(input)) {
                SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
                try {
                    result = format.parse(input);
                } catch (Exception ex) {
                    log.error("Exception on parsing date string. Exception:" + ex);
                }
            }
        }
        return result;
    }
}
