package com.community.services.mapper.orders;

import com.community.services.pojo.orders.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrdersMapper {

    boolean SaveOrder(Orders orders);

    Orders findOrderById(int id);

    Boolean updateStatusByOrderId(@Param("id") Integer id,@Param("order_state") int order_state);

}
