package org.wso2.msf4j.example.interfaceController;

import org.springframework.web.context.request.async.DeferredResult;

import javax.ws.rs.PathParam;
import java.io.Serializable;

/**
 * Created by Administrator on 8/19/2016.
 */
public interface ITime extends Serializable {
    public String timeSleep(final Long time) throws InterruptedException;

    public DeferredResult<String> timeSleepAsync(Long time) throws InterruptedException;
}
