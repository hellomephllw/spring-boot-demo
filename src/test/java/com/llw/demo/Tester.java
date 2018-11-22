package com.llw.demo;

import com.llw.express.code.BasicCodeGenerator;

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
        String str1 = "abcd? ef? ghij?";

        System.out.println(str1.substring(0, str1.length() - 1));

        String str2 = "com.llw.demo.entity.Shop";

        String str3 = str2.split("entity")[1];
        System.out.println(str2.split("entity")[1].split("\\.").length);


        for (String s : str3.split("\\.")) {
            System.out.println(s);
        }
    }

}