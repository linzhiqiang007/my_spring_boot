/*
package com.community.services.controller;

import com.community.services.service.Api.APIException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/test")
@RestController
public class testController {

    @Value("aaa")
    private String aaa;

    @Value("jdbc.driverClassName")
    private String qqq;

    @RequestMapping("/index")
    public String index(@RequestParam @Valid String name) {
        try {
            if (!"".equals(name)) {
                return "hello_word " + aaa + " " + qqq;
            }else {
                return null;
            }
        }catch (APIException a){
            a.getMessage();
        }
        return null;
    }

    @ExceptionHandler(APIException.class)
    public static String APIExceptionHandler(APIException e) {
        return e.getMessage();
    }
}
*/
