package com.zlt.gllys.conf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by zhangletian on 16/8/10.
 */
@Component
public class CommandLineRunnerConf implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
        //new SocketProxy().startProxy();
    }
}
