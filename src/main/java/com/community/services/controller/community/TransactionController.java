package com.community.services.controller.community;

import com.community.services.pojo.area.Area;
import com.community.services.pojo.city.City;
import com.community.services.pojo.provinces.Provinces;
import com.community.services.pojo.provinces.ProvincesExample;
import com.community.services.service.address.AddressService;
import com.community.services.utils.RedisTemplateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private RedisTemplateUtils redisTemplateUtils;

    @Autowired
    private AddressService addressService;

    private Logger logger = LoggerFactory.getLogger("TransactionController.class");

    @RequestMapping("/addressList")
    public List<ProvincesExample> AddressList() {
        List<ProvincesExample> provincesExampleList = new ArrayList<>();
        try {
            if (redisTemplateUtils.get("addressList") == null) {
                logger.info(getObject("Hello")+"");
                provincesExampleList = addressService.AddressList();
                redisTemplateUtils.set("addressList", provincesExampleList);
            } else {
                logger.info(getObject("Hello")+"");
                provincesExampleList = (List<ProvincesExample>) redisTemplateUtils.get("addressList");
            }
            return provincesExampleList;
        }catch (Exception e){
            e.printStackTrace();
            return provincesExampleList;
        }
    }

    /**
     * 开启分布式事务
     * @param str
     * @return
     */
    public Object getObject(String str) {
        /*
         *  执行带有返回值<Object>的事务管理
         */
        Object execute = transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                try {
                    //....... 业务代码  ----> 一般处理订单的分布以及仓储远程rpc调用获取最终结果
                    List<Provinces> provinces = addressService.provincesList();
                    List<City> cities = addressService.CityList();
                    List<Area> areas = addressService.AreaList();
                    return "业务代码 -- yes : " + str + ";" + provinces + ";" + cities + ";" + areas;
                    //return "业务代码 -- yes : ";
                } catch (Exception e) {
                    //回滚
                    transactionStatus.setRollbackOnly();
                    return "回滚 " + str;
                }
            }
        });
        return execute;
    }

    /**
     * 保存支付订单
     */
    /*protected PayOrder savePayReq(final PayOrder payOrder) {
        PayOrder order = (PayOrder) this.transactionTemplate
                .execute(new TransactionCallback() {
                    @Override
                    public Object doInTransaction(TransactionStatus status) {
                        // 查看是否已经存在支付订单，如果已经存在则返回订单主键
                        PayOrder payOrderTemp = payOrderDAO.findOrder(String
                                .valueOf(payOrder.getPayOrderId()));

                        // 由支付渠道类型(PayChannelType)转换得到交易类型(PayType)
                        if (payOrder.getPayChannelId().equalsIgnoreCase(PAY_CHNL_ACT_BAL)) {// 账户余额支付
                            payOrder.setPayType("3");
                        } else if (payOrder.getPayChannelId().equalsIgnoreCase(PAY_CHNL_FAST_PAY)) {// 联通快捷支付
                            payOrder.setPayType("4");
                        } else {// 网银网关支付
                            payOrder.setPayType("2");
                        }

                        // 比对新的支付金额与原订单金额是否一致，如不一致则提示错误
                        if (payOrderTemp == null) {
                            String orderId = payOrderDAO.save(payOrder);
                            payOrder.setPayOrderId(orderId);
                            return payOrder;
                        } else {
                            return payOrderTemp;
                        }
                    }
                });
        if ("2".equals(order.getOrderState())) {// 2：表示支付成功
            throw new EpaymentBizException(StatusCode.DQSystem.PAY_FAIL,
                    "同一订单不能重复支付");
        } else if (payOrder.getPayAmt().longValue() != order.getPayAmt()
                .longValue()) {
            throw new EpaymentBizException(StatusCode.DQSystem.PAY_FAIL,
                    "交易金额与原订单不一致");
        } else {
            return payOrder;
        }

    }*/

}
