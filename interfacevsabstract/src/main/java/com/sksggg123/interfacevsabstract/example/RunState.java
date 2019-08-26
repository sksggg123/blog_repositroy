package com.sksggg123.interfacevsabstract.example;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : interfacevsabstract
 * create date  : 2019-08-26 14:19
 */
abstract class RunState implements State {

    private static final String RUN_STATE = "Run!!";
    protected String state;
    protected static Date date = new Date();

    public RunState() {
        this.state = RUN_STATE;
    }

    public String startRunTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
