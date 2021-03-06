package com.dbirtwell.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleErrorController implements ErrorController{

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "ERROR *** TODO: Add Better Error handling";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}