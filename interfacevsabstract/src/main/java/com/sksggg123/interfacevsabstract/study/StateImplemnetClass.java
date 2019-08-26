package com.sksggg123.interfacevsabstract.study;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : interfacevsabstract
 * create date  : 2019-08-26 13:13
 */
public class StateImplemnetClass implements State {

    private String state;

    public StateImplemnetClass(String state) {
        this.state = state;
    }

    @Override
    public String display() {
        return this.state;
    }

    @Override
    public void change(String changeValue) {
        this.state = changeValue;
    }
}