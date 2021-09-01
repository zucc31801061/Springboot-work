package cn.edu.zucc.pb.bankdispacher;

import cn.edu.zucc.pb.bankdispacher.simulator.BankCounter;
import cn.edu.zucc.pb.bankdispacher.simulator.UserGenerator;

import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * 主控程序，让仿真程序和实际的调度程序运行起来
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 16:54
 */
public class Main {
    static ArrayList<BankCounter> counterList = new ArrayList<>(5);
    static UserGenerator userGenerator = new UserGenerator();
    static int usernum = 100;//用户数量

    public static void main(String[] args) {
        //TODO 实现从配置文件 bank.properties加载counter.count配置项
        ResourceBundle resourceBundle = ResourceBundle.getBundle("bank");
        int counterCount = Integer.parseInt(resourceBundle.getString("counter.count"));

        //创建n个柜台，仿真银行开门
        for(int i = 0; i < counterCount; i++){
            Thread counterThread = new Thread("Counter-" + i){
                @Override
                public void run() {
                    BankCounter counter = new BankCounter();
                    counter.start();
                    Main.counterList.add(counter);
                }
            };
            counterThread.start();
        }

        //开始启动用户产生仿真
        Thread userGenerator = new Thread("UserGenerator"){
            @Override
            public void run() {
                UserGenerator user = new UserGenerator();
                user.start(usernum);
                Main.userGenerator = user;
            }
        };
        userGenerator.start();

        /**TODO 如果这里什么都不做，那么主线程就退出了，上面启动的所有仿真线程还活着
            这个是不好的设计，请修改这个main方法，是否可以做到可以控制所有的仿真线程在
            仿真运行比如100个用户后可以恰当的退出
         */
        //que?:没懂，如果没运行100个用户就到下班时间了呢？以及什么是恰当的退出？
        while (true){
            synchronized (UserEventQue.class){
                if (UserEventQue.count>=10){
                    System.out.println("接待的客户已达" + UserEventQue.count + "人，将关闭其它线程");
                    Main.userGenerator.setWork(false);
                    for (BankCounter bc : Main.counterList) {
                        bc.setWork(false);
                    }
                    return;
                }
                else {
                    Thread.yield();
                }
            }
        }
    }
}
