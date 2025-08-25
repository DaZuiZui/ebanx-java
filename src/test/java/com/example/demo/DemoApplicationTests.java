package com.example.demo;

import com.example.demo.config.EbanxApiClient;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author DaZuiZUi
 *         https://github.com/DaZuiZui
 */
@SpringBootTest
class DemoApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Autowired
    private EbanxApiClient ebanxApiClient;

    @Value("${ebanx.integrationKey}")
    private String integrationKey;


    @Test
    void sayHello() {
        log.info("Hello Dazui");
    }

    @Test
    void ebanxInfo(){
        JSONObject jsonObject = ebanxApiClient.testConnection();
        log.info(String.valueOf(jsonObject));
    }



}
