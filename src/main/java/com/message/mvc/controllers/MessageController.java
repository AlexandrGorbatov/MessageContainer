package com.message.mvc.controllers;

import com.message.mvc.model.Message;
import com.message.mvc.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
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
    public ModelAndView getAllMessages(Model model) {
        List<Message> messages = messageService.getAll();
        model.addAttribute("messages", messages);
        return new ModelAndView("messages", "messages", messages);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveMessage(@ModelAttribute Message message) {
        Message newMessage = new Message();
        newMessage.setUserName(message.getUserName());
        newMessage.setMessageText(message.getMessageText());
        newMessage.setCreatedDate(new Date());
        messageService.save(newMessage);
        return new ModelAndView("redirect:/");
    }


    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public ModelAndView findMessagesByName(HttpServletRequest request) {
        if (!request.getParameter("userName").isEmpty()) {
            return new ModelAndView("messages", "messages", messageService.findByName(request.getParameter("userName")));
        }
        String dateFrom = request.getParameter("dateFrom");
        String dateTo = request.getParameter("dateTo");
        if (!dateFrom.isEmpty() && !dateTo.isEmpty()) {
            return new ModelAndView("messages", "messages", messageService.findByDate(dateFrom, dateTo));
        }
        return new ModelAndView("messages", "messages", Collections.EMPTY_LIST);
    }


}
