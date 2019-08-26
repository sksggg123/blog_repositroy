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
abstract class StopState implements State {

    private static final String STOP_STATE = "Stop!!";
    protected String state;
    protected static Date date = new Date();

    public StopState() {
        this.state = STOP_STATE;
    }

    public String endStopTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
