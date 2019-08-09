package com.springboot.i18n.springbooti18n.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private static final String USERNAME_KEY = "userName";
    private static final String PASSWORD_KEY = "password";

    @RequestMapping("/get")
    public String getUserName() {
        return messageSource.getMessage(USERNAME_KEY, null, LocaleContextHolder.getLocale()) + " - " + messageSource.getMessage(PASSWORD_KEY, null, LocaleContextHolder.getLocale());

    }
}
