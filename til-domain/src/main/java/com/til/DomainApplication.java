package com.til;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DomainApplication {
    // ----Test Code----
    private final TestBean testBean;

    @Autowired
    public DomainApplication(TestBean testBean) {
        this.testBean = testBean;
    }

    @PostConstruct
    public void dependencyTest() {
        testBean.dependencyTest();
    }
    // ------------------

    public static void main(String[] args) {
        SpringApplication.run(DomainApplication.class, args);
    }
}
