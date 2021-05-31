package com.zhuvar.springEdu.quoters;

import com.zhuvar.springEdu.profilile.Profiling;
import com.zhuvar.springEdu.random.InjectRandomInt;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Data
@RequiredArgsConstructor
@Profiling
@Component
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min = 0, max = 6)
    private int times;
    @NonNull
    private String message;

    @PostConstruct
    public void init() {
        System.out.println("Message by init method");
    }

    @Override
    public void sayQuote() {
        System.out.println(message + times);
    }
}

