package com.community.services.service.order;

import com.community.services.pojo.orders.Orders;

public interface OrderService {

    boolean SaveOrder(Orders orders);

    Orders findOrderById(int id);
}
