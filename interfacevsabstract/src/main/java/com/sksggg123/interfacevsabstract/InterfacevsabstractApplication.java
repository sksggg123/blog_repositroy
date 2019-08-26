package com.sksggg123.interfacevsabstract;

import com.sksggg123.interfacevsabstract.example.Run;
import com.sksggg123.interfacevsabstract.example.Stop;
import com.sksggg123.interfacevsabstract.study.State;
import com.sksggg123.interfacevsabstract.study.StateAbstract;
import com.sksggg123.interfacevsabstract.study.StateExtendsClass;
import com.sksggg123.interfacevsabstract.study.StateImplemnetClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterfacevsabstractApplication {

    private static StateImplemnetClass normal;

    public static void main(String[] args) {
        SpringApplication.run(InterfacevsabstractApplication.class, args);

        // 시작상태 설정
        Run run = new Run();

        // sleep으로 시간과 종료 시간을 주기위한 로직
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
