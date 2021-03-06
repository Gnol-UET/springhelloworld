/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *   WSO2 Inc. licenses this file to you under the Apache License,
 *   Version 2.0 (the "License"); you may not use this file except
 *   in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.wso2.msf4j.example.repository;


import org.springframework.stereotype.Component;
import org.wso2.msf4j.example.model.User;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * UserRepository class which is extended from AbstractRepository class.
 */
@Component
public class UserRepository extends AbstractRepository<User> {
    public UserRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public void createUser(User user) {
        create(user);
    }

    public void removeUser(User user) {
        remove(user);
    }

    public User findUser(long id) {
        return find(id);
    }

    public List<User> findUsers() {
        return findAll(User.class);
    }
}
