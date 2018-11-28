package com.llw.demo;

import com.llw.demo.entity.Admin;
import com.llw.express.code.BasicCodeGenerator;
import com.llw.util.KeyGenerateUtil;

import javax.persistence.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @author: llw
 * @date: 2018-11-21
 */
public class Tester {

    public static void main(String[] args) throws Exception {
        System.out.println(KeyGenerateUtil.getUuidKey());
        System.out.println(KeyGenerateUtil.getTimestampWithUuidKey());
        System.out.println(KeyGenerateUtil.getRandomKey(6));
    }

}