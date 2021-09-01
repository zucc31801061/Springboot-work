package cn.edu.zucc.pb.bankdispacher;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Vip优先选择器，队列中如果有vip，优先处理，其他按照到达时间顺序处理
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 16:21
 */
public class VipFirstSelector implements IUserSelector {
    public UserEvent select(List<UserEvent> events) {
        //TODO 实现vip优先算法的用户选择器
        synchronized (UserEventQue.getInstance()) {
            Collections.sort(events, new Comparator<UserEvent>() {
                public int compare(UserEvent e1, UserEvent e2) {
                    if (e1.getCategory() == EUserCategory.VIP && e2.getCategory() == EUserCategory.VIP) {
                        return e1.getArriveTime().compareTo(e2.getArriveTime());
                    }
                    else if (e1.getCategory() == EUserCategory.VIP) {
                        return -1;
                    }
                    else if (e2.getCategory() == EUserCategory.VIP) {
                        return 1;
                    }
                    else {
                        return e1.getArriveTime().compareTo(e2.getArriveTime());
                    }
                }
            });
        }
        if (!events.isEmpty()) {
            return events.get(0);
        } else {
            return null;
        }
    }
}
