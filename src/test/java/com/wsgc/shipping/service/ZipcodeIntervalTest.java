package com.wsgc.shipping.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsgc.shipping.model.RestrictedZipcodes;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.File;
import java.io.IOException;

public class ZipcodeIntervalTest {

    @Autowired
    ZipcodeInterval zipcodeInterval;

    ObjectMapper mapper;

    ClassLoader classLoader;

    @Before
    public void setUp() throws Exception {
        mapper = new ObjectMapper();
        classLoader = getClass().getClassLoader();
        zipcodeInterval = new ZipcodeInterval();
    }

    @After
    public void tearDown() throws Exception {
        mapper = null;
    }

    @Test
    public void optimizeAddValidInput() {
        try {
            RestrictedZipcodes actualrz = mapper.readValue(new File("src/test/resources/ActualValidIntervals.json"),RestrictedZipcodes.class);
            RestrictedZipcodes expectedrz = mapper.readValue(new File("src/test/resources/ExpectedValidIntervals.json"),RestrictedZipcodes.class);
            zipcodeInterval.OptimizeAdd(actualrz);
            Assert.assertTrue("Optimized Zipcode incorrect",expectedrz.equals(actualrz));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}