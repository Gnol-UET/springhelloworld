package org.wso2.msf4j.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.wso2.msf4j.example.interfaceController.ITime;
import org.wso2.msf4j.example.service.TimeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.Serializable;

/**
 * Created by MinhTu on 8/13/2016.
 */
@Component
@Path("/sleep")
public class TimeController implements ITime, Serializable {

    @Autowired
    private TimeService sleepTimeService;

    @GET
    @Path("/BIO/{time}")
    public String timeSleep(@PathParam("time") Long time) throws InterruptedException {
        return sleepTimeService.sleepTime(time);
    }

    @GET
    @Path("/NIO/{time}")
    public DeferredResult<String> timeSleepAsync(@PathParam("time") Long time) throws InterruptedException {
        return sleepTimeService.timeSleepAsync(time);
    }
}
