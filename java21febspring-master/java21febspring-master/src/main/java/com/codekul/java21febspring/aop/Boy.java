package com.codekul.java21febspring.aop;

import org.springframework.stereotype.Component;

@Component
public class Boy {

    public int study1(int i){
        System.out.println("In boy study");
        return i;
    }

//    public void exc(){
//         int i=10/0;
//        System.out.println(i);
//    }
}
