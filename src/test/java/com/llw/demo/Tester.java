package com.llw.demo;

import com.llw.demo.entity.Admin;
import com.llw.express.code.BasicCodeGenerator;

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
        Class adminClass = Admin.class;
//        boolean isEntity = false;
//        String tableName = null;
//        for (Annotation annotation : adminClass.getAnnotations()) {
//            System.out.println(annotation);
//            if (annotation.annotationType() == Entity.class) {
//                isEntity = true;
//            }
//            if (annotation.annotationType() == Table.class) {
//                tableName = ((Table) annotation).name();
//            }
//        }
//        System.out.println(isEntity);
//        if (tableName != null) {
//            System.out.println(tableName);
//        }
        for (Field field : adminClass.getDeclaredFields()) {
            System.out.println("======");
            System.out.println(field.getName() + ": " + field.getType());
            System.out.println(field.getType() == String.class);
            System.out.println(field.getType().isPrimitive());
            System.out.println(field.getGenericType().toString().equals("boolean"));
            for (Annotation annotation : field.getAnnotations()) {
//                if (annotation.annotationType() == Column.class) {
//                    System.out.println(((Column) annotation).length());
//                }
//                if (annotation.annotationType() == Id.class) {
//                    System.out.println(field + "是主键");
//                }
//                if (annotation.annotationType() == GeneratedValue.class) {
//                    System.out.println(((GeneratedValue) annotation).strategy());
//                }
            }
        }
        System.out.println(adminClass.getSuperclass() == Object.class);
        System.out.println(adminClass.getSuperclass().getSuperclass() == Object.class);
//        for (Annotation annotation : adminClass.getAnnotations()) {
//            System.out.println(annotation);
//            System.out.println(annotation.annotationType());
//        }
    }

}