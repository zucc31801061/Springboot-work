package cn.edu.zucc.pb.bankdispacher;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 时间优先选择器，按照到达时间顺序处理
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 16:21
 */
public class TimeFirstSelector implements IUserSelector {
    public UserEvent select(List<UserEvent> events) {
        //TODO 实现到达时间优先算法的用户选择器
        if (!events.isEmpty()) {
            synchronized (TimeFirstSelector.class) {
                listSort(events);
                System.out.println("队列中的顾客有"+events.size()+"人");

                return events.get(0);
            }
        }
        else {
            return null;
        }
    }
    public static void listSort(List<UserEvent> events){
        Collections.sort(events, new Comparator<UserEvent>() {
            public int compare(UserEvent e1, UserEvent e2) {
                return  e1.getArriveTime().compareTo(e2.getArriveTime());
            }
        });
    }
}
