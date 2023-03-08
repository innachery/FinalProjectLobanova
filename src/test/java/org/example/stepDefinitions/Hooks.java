package org.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.BaseClass;

public class Hooks extends BaseClass {
    @Before
    public void setup() {
        initializeDriver();
    }

    @After
    public void close() {
        closeBrowser();
    }
}
