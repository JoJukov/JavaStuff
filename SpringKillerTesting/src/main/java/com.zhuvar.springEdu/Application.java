package com.zhuvar.springEdu;

import com.zhuvar.springEdu.quoters.TerminatorQuoter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        TerminatorQuoter quoter = context.getBean(TerminatorQuoter.class);
        quoter.sayQuote();


    }
}
