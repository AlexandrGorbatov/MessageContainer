package com.message.mvc.controllers;

import com.message.mvc.model.Message;
import com.message.mvc.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * Created by alex on 24.10.14.
 */
@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainPage(@ModelAttribute Message message) {
        return new ModelAndView("main", "messages", message);
    }


    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public ModelAndView getAllMessages() {
        List messages = messageService.getAll();
        return new ModelAndView("messages", "messages", messages);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveMessage(@ModelAttribute Message message) {
        Message newMessage = new Message();
        newMessage.setUserName(message.getUserName());
        newMessage.setMessageText(message.getMessageText());
        newMessage.setCreatedDate(new Date());
        messageService.save(newMessage);
        return new ModelAndView("main");
    }


}
