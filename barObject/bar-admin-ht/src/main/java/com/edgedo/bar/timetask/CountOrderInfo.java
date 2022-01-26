package com.edgedo.bar.timetask;

import com.edgedo.bar.queryvo.OrderInfoView;
import com.edgedo.bar.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author:Qiutianzhu
 * @date 2021-05-11 20:01
 * @description:
 */
@Component
public class CountOrderInfo {

    @Autowired
    private OrderInfoService orderInfoService;


    /**
     * @author:Qiutianzhu
     * @Description: 每天0点判断所有的信息
     * @Date: 2021/5/11 20:03
     **/
    @Scheduled(cron = "0 0 0 * * ?")
    public void countOrderUserInfo(){
        //1.统计前一天0点
        Calendar calendarZero = Calendar.getInstance();
        calendarZero.set(calendarZero.get(Calendar.YEAR),calendarZero.get(Calendar.MONTH),calendarZero.get(Calendar.DAY_OF_MONTH)-1,0,0,0);
        Date yesTodayZero = calendarZero.getTime();
        //2.统计前一天的23点
        Calendar calendarTwentyThree = Calendar.getInstance();
        calendarTwentyThree.set(calendarTwentyThree.get(Calendar.YEAR),calendarTwentyThree.get(Calendar.MONTH),calendarTwentyThree.get(Calendar.DAY_OF_MONTH)-1,23,59,59);
        Date yesTodayTwentyThree = calendarTwentyThree.getTime();
        List<OrderInfoView> list = orderInfoService.selectAll(yesTodayZero,yesTodayTwentyThree);
        if (list.size() > 0){
            list.forEach(orderInfoView -> {
                orderInfoView.setChargeback("1");
            });
            orderInfoService.updateList(list);
        }
    }

}
