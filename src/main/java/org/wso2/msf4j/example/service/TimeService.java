package org.wso2.msf4j.example.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by MinhTu on 8/13/2016.
 */
@Component
public class TimeService implements Serializable {
    public String sleepTime(final Long time) throws InterruptedException {
        Thread.sleep(time);
        return "done";
    }

    public DeferredResult<String> timeSleepAsync(Long time) throws InterruptedException { //DeferredResult<String>
        ExecutorService executorService = Executors.newCachedThreadPool();
        DeferredResult<String> deferredResult = new DeferredResult<>();

        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(time);
                deferredResult.setResult("ok");
            } catch (Exception e) {
                deferredResult.setErrorResult(e);
                Thread.currentThread().interrupt();
            }

        }, executorService);

        return deferredResult;
    }


}
