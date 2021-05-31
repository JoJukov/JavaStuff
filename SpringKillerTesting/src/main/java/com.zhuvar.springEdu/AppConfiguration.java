package com.zhuvar.springEdu;

import com.zhuvar.springEdu.quoters.TerminatorQuoter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfiguration {

    @Bean
    public TerminatorQuoter terminatorQuoter() {
        return new TerminatorQuoter("hello ");
    }
}
