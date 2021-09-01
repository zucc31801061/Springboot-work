package cn.edu.zucc.pb.bankdispacher.simulator;

import cn.edu.zucc.pb.bankdispacher.EUserCategory;
import cn.edu.zucc.pb.bankdispacher.UserEventQue;
import org.apache.commons.lang3.RandomUtils;

/**
 * 测试用仿真程序，模拟用户的到达
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 16:36
 */
public class UserGenerator {

    private boolean ifwork = true;

    public synchronized UserGenerator setWork(boolean ifwork){
        this.ifwork = ifwork;
        return this;
    }

    /**
     * 模拟产生n个用户
     * @param nCount 产生的用户数，参数小于零一直产生
     */
    public synchronized void start(int nCount){
        boolean bExit = false;
        int index = 0;
        while(!bExit && ifwork){

            //产生一个用户
            //TODO 修改仿真用户到达的比例，按照Vip:Enterprise:Private=1:2:7方式产生
            int x = RandomUtils.nextInt(0,10);
            if(x < 1){
                UserEventQue.getInstance().nextUserArrive(EUserCategory.VIP);
            }
            else if(x < 3){
                UserEventQue.getInstance().nextUserArrive(EUserCategory.ENTERPRISE);
            }
            else {
                UserEventQue.getInstance().nextUserArrive(EUserCategory.PRIVATE);
            }
            //等待一点时间
            waitSomeTime();

            index++;

            if(nCount > 0 && index > nCount){
                bExit = true;
            }
        }
    }

    private void waitSomeTime(){
        //随机500毫秒到5000毫秒之间/10
        try {
            Thread.sleep(RandomUtils.nextInt(50, 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return;
    }

}
