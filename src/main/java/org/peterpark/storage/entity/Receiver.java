package org.peterpark.storage.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Description:
 *
 * @author: peter
 * @date: 2018/12/10.
 */

@Component
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private final CountDownLatch countDownLatch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        countDownLatch.countDown();
    }
}
