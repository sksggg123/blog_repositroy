package com.sksggg123.interfacevsabstract.example;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : interfacevsabstract
 * create date  : 2019-08-26 14:34
 */
public class Stop extends StopState {

    @Override
    public String display() {
        return String.format("현재 상태 %s, 상태가 종료된 시간은 %s 입니다.", state, endStopTime());
    }
}
