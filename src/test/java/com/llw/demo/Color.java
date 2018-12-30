package com.llw.demo;

import java.util.ArrayList;
import java.util.List;

public enum Color {

    GREEN(1, "绿色"), YELLOW(2, "黄色");

    private int index;

    private String name;

    Color(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println(Color.GREEN);
        System.out.println(Color.GREEN.name);

        List<Color> list = new ArrayList<>();
        list.add(Color.GREEN);


    }

}
