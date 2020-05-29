package com.community.services.service.impl.thread;

import com.community.services.mapper.orders.OrdersMapper;
import com.community.services.service.thread.ThreadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    private OrdersMapper ordersMapper;

    private Logger logger = LoggerFactory.getLogger(ThreadServiceImpl.class);

    @Override
    public Boolean updateStatusByOrderId(Integer order_id) {
        try {
            if (ordersMapper.findOrderById(order_id) == null){
                logger.info("order_id="+order_id+" 该订单不存在！");
                return false;
            }
            // todo 调用事务方法
            updateStatusOrder(order_id);
            // todo 调用第三方接口生成订单号 -- 仓储物流... 微信回调
            logger.info("仓储物流 -- START ... ");
            Thread.sleep(10000);
            logger.info("仓储物流 -- END ... ");
            // todo  默认成功 ~~
            // todo  查询第三方是否生成物流订单号或者物流仓储那边已经确认 -- 更新订单状态 -- 发货 or 支付成功
            if (true) {
                ordersMapper.updateStatusByOrderId(order_id, 4);
                logger.info("order_state=" + 4 + "-更新状态成功 -- success order_id: " + order_id);
            } else {
                // todo 添加库存
                logger.info(order_id + "-添加库存成功");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 开启事务使用Order更新状态
     *
     * @param order_id
     * @return
     */
    @Transactional
    public boolean updateStatusOrder(Integer order_id) {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        // 获取容器
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 容器中获取TransactionTemplate
        //TransactionTemplate transactionTemplate = (TransactionTemplate) context.getBean("transactionTemplate");

        /*transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Boolean doInTransaction(TransactionStatus transactionStatus) {
                try{
                    // todo 支付成功
                    logger.info(order_id + "-支付成功");
                    // todo 扣减库存
                    logger.info(order_id + "-扣减库存成功");
                    // todo 更新订单一个中间订单的状态 -- 待发货
                    ordersMapper.updateStatusByOrderId(order_id, 3);
                    logger.info("order_state=" + 3 + "-更新状态成功 -- success order_id"+order_id);
                    return true;
                }catch (Exception e){
                    logger.error("更新失败... order_id"+order_id);
                    e.printStackTrace();
                    return false;
                }
            }
        });*/
        try{
            // todo 支付成功
            logger.info(order_id + "-支付成功");
            // todo 扣减库存
            logger.info(order_id + "-扣减库存成功");
            // todo 更新订单一个中间订单的状态 -- 待发货
            ordersMapper.updateStatusByOrderId(order_id, 3);
            logger.info("order_state=" + 3 + "-更新状态成功 -- success order_id: "+order_id);
            return true;
        }catch (Exception e){
            logger.error("更新失败... order_id"+order_id);
            e.printStackTrace();
            return false;
        }
    }
}
