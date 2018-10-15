package com.springboot.i18n.springbooti18n.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gaoyan
 * @date 2018/10/15 10:44
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/get")
    public String getUserName(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        log.info("username " + userName);
        log.info("password " + password);
        return messageSource.getMessage(userName, null, LocaleContextHolder.getLocale()) + " - " + messageSource.getMessage(password, null, LocaleContextHolder.getLocale());

    }
}
