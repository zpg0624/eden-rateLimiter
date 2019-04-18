package com.eden.guavaspringbootdemo.demo;

import com.google.common.base.MoreObjects;
import com.google.common.base.Splitter;

/**
 * @created by eden
 * @since 2019-04-18 上午 11:29:27
 */

public class MoreObjectsDemo {


    private String name;

    private Integer age;


    public static void main(String[] args) {

        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper(MoreObjectsDemo.class)
                .add("name", "zhansan")
                .add("age", 12);



        System.out.println(stringHelper);

        System.out.println("================================");
        String a = MoreObjects.firstNonNull("bb", "vv");

//        String c = MoreObjects.<String>firstNonNull(null, "c");

        System.out.println(a);

        System.out.println("================================");
       Splitter.on(",").omitEmptyStrings()
                .split("a, b, d,aaaaa")
                .forEach(System.out::println);
        System.out.println("================================");




    }



}
