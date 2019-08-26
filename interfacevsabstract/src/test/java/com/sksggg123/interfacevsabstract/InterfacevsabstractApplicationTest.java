package com.sksggg123.interfacevsabstract;

import com.sksggg123.interfacevsabstract.example.Run;
import com.sksggg123.interfacevsabstract.example.Stop;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : interfacevsabstract
 * create date  : 2019-08-26 14:36
 */
public class InterfacevsabstractApplicationTest {

    @Test
    void 시작_종료_메소드호출() {
        // 시작상태 설정
        Run run = new Run();

        // sleep으로 시간과 종료 상태 변경
        for (int i = 0; i <3 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 종료상태 설정
        Stop stop = new Stop();

        // 시작상태값
        System.out.println(run.display());
        System.out.println(run.startRunTime());

        // 종료상태값
        System.out.println(stop.display());
        System.out.println(stop.endStopTime());
    }

}