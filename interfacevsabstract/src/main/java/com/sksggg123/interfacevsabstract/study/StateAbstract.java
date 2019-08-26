package com.sksggg123.interfacevsabstract.study;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : interfacevsabstract
 * create date  : 2019-08-26 13:16
 */
abstract public class StateAbstract {

    private String state;

    public StateAbstract(String state) {
        this.state = state;
    }

    abstract String display();

    void change(String changeValue) {
        this.state = changeValue;
    }
}
