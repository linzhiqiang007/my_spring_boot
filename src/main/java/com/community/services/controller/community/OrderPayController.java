package com.community.services.controller.community;

import com.community.services.pojo.orders.Orders;
import com.community.services.service.order.OrderService;
import com.community.services.service.thread.ThreadService;
import com.community.services.utils.DateUtils;
import com.community.services.utils.HttpUtils;
import com.community.services.utils.JSONResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("order")
public class OrderPayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ThreadService threadService;

    @RequestMapping("saveOrder")
    @ResponseBody
    public JSONResultUtil<Object> SaveOrder(Orders orders) {
        orderService.SaveOrder(orders);
        return JSONResultUtil.ok();
    }

    /**
     * 查询指定订单详情
     * @param id
     * @return
     */
    @RequestMapping("findOrderById")
    public Orders findOrderById(@RequestParam int id){
        return orderService.findOrderById(id);
    }

    /**
     * 多线程并发任务启动
     * @param count
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("threadTest")
    public JSONResultUtil<Object> threadTest(@RequestParam @Valid Integer count,@RequestParam @Valid String url_path) throws InterruptedException {
        CountDownLatch countDownLatchStart = new CountDownLatch(1); //开始锁
        CountDownLatch countDownLatchEnd = new CountDownLatch(count); //结束锁
        ExecutorService exec = Executors.newFixedThreadPool(10); //前十名
        List<String> list = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            final int NO = index + 1;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 如果当前计数为零，则此方法立即返回。
                        // 等待
                        countDownLatchStart.await();
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("No." + NO + " arrived");
                        String s = HttpUtils.doGet(url_path);
                        if (!s.equals("")){
                            list.add("接口URL：" + url_path + " thread_count: " + count + " " + DateUtils.formatDateTime(new Date()));
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        // 每个选手到达终点时，end就减一
                        countDownLatchEnd.countDown();
                    }
                }
            };
            exec.submit(run);
        }
        System.out.println("Game Start");
        // begin减一，开始游戏
        countDownLatchStart.countDown();
        // 等待end变为0，即所有选手到达终点
        countDownLatchEnd.await();
        System.out.println(countDownLatchEnd.getCount());
        System.out.println("Game Over");
        exec.shutdown();
        //JSONResultUtil jsonResultUtil = 0;
        //jsonResultUtil.ok().setData(list);
        JSONResultUtil jsonResultUtil = new JSONResultUtil(list.size()>0);
        jsonResultUtil.setData(list);
        return jsonResultUtil;
    }

    @RequestMapping("trons")
    public JSONResultUtil<Object> OrdersTrons(@RequestParam(defaultValue = "0") Integer order_id) {
        Boolean aBoolean = threadService.updateStatusByOrderId(order_id);
        if (aBoolean){
            return JSONResultUtil.ok();
        }else {
            return JSONResultUtil.error("order_id = "+order_id+" 支付异常~");
        }
    }

    @RequestMapping("test")
    public void OrderTest(){

    }


}
