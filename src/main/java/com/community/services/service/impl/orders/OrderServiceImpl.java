package com.community.services.service.impl.orders;

import com.community.services.mapper.orders.OrdersMapper;
import com.community.services.pojo.orders.Orders;
import com.community.services.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public boolean SaveOrder(Orders orders) {
        return ordersMapper.SaveOrder(orders);
    }

    @Override
    public Orders findOrderById(int id) {
        return ordersMapper.findOrderById(id);
    }
}
