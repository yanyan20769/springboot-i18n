package com.springboot.i18n.springbooti18n.config;

import com.springboot.i18n.springbooti18n.constant.Constants;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author gaoyan
 * @date 2018/10/15 11:35
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = StringUtils.isEmpty(request.getHeader(Constants.MY_LANGUAGE))
                ? request.getParameter(Constants.MY_LANGUAGE)
                : request.getHeader(Constants.MY_LANGUAGE);
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language)) {
            String[] strs = language.split("_");
            locale = new Locale(strs[0], strs[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }

}
