/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.msf4j.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wso2.msf4j.example.exception.InvalidNameException;
import org.wso2.msf4j.example.repository.UserRepository;
import org.wso2.msf4j.example.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

/**
 * HelloService class to be injected to Hello resource through Spring
 */
@Component
public class HelloService {
    @Autowired
    UserRepository userRepository;

    public String hello(String name) throws InvalidNameException {
        if (isNumericValue(name)) {
            throw new InvalidNameException(name + " is an invalid name");
        }
        return "Hello " + name;
    }

    private boolean isNumericValue(String value) {
        Pattern pattern = Pattern.compile("^(0|[1-9][0-9]*)$");
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public User getUser(long id) {
        User user = userRepository.findUser(id);
        return user;
    }

    public void sleepplease(int time) throws InterruptedException {
        sleep(time);
    }
}
