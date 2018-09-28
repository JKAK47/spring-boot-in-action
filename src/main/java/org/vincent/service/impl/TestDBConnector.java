package org.vincent.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.vincent.service.DBConnector;

/**
 * Created by PengRong on 2018/9/28.
 */
@Component
@Profile(value = {"test"})
public class TestDBConnector implements DBConnector{

    @Override
    public void configure() {
        System.out.println("test db demo");
    }
}
