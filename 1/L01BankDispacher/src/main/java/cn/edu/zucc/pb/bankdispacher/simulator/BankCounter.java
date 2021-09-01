package cn.edu.zucc.pb.bankdispacher.simulator;

import cn.edu.zucc.pb.bankdispacher.EUserCategory;
import cn.edu.zucc.pb.bankdispacher.UserEvent;
import cn.edu.zucc.pb.bankdispacher.UserEventQue;
import org.apache.commons.lang3.RandomUtils;

/**
 * 银行柜台办理业务仿真程序
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 16:49
 */
public class BankCounter {
    int worktime = 20;//工作时间
    private boolean ifwork = true;

    public synchronized BankCounter setWork(boolean ifwork){
        this.ifwork = ifwork;
        return this;
    }

    /**
     * 模拟柜台开始办理业务
     */
    public synchronized void start(){
        //TODO 增加柜台下班的控制
        long start = System.currentTimeMillis();
        //while(true)柜台一直不下班
        while(ifwork){
            UserEvent userEvent = UserEventQue.getInstance().dispatchUser();

            //等待一点时间,模拟在办理或者等待
            //TODO 实现不同业务类型等待不同时间
            if (userEvent!=null){
                System.out.println(userEvent.getSeq() + "号" + userEvent.getCategory().toString().substring(0, 3) + "客户到达");
                waitSomeTime(userEvent.getCategory());
                System.out.println("\t\t\t\t\t\t\t\t" + userEvent.getSeq() + "号" + userEvent.getCategory().toString().substring(0, 3) + "客户办理完成");
            }
            if ((System.currentTimeMillis() - start) / 1000 >= worktime) {
                this.setWork(false);
                System.out.println("到达下班时间，窗口关闭");
                break;
            }
        }
    }

    private void waitSomeTime(EUserCategory category){
        //随机2秒到12秒之间/10
        try {
            //等待时间
            switch (category) {
                case VIP:
                    Thread.sleep(RandomUtils.nextInt(200, 400));
                    break;
                case PRIVATE:
                    Thread.sleep(RandomUtils.nextInt(400, 600));
                    break;
                case ENTERPRISE:
                    Thread.sleep(RandomUtils.nextInt(600, 800));
                    break;
                default:
                    break;
            }
            //办理时间
            Thread.sleep(RandomUtils.nextInt(400, 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
