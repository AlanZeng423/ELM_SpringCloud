package com.neusoft.mapper;

import com.neusoft.po.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface OrdersMapper {
    @Insert("insert into orders(userId,businessId,orderDate,orderTotal,daId,orderState) values(#{userId},#{businessId},#{orderDate},#{orderTotal},#{daId},0)")
    @Options(useGeneratedKeys = true, keyProperty = "orderId", keyColumn = "orderId")
    public int saveOrders(Orders orders);

    public Orders getOrdersById(Integer orderId);

    public List<Orders> listOrdersByUserId(String userId);

    @Update("update orders set orderState=1 where orderId=#{orderId}")
    public int updateOrderState(Integer orderId);

    @Update("update orders set orderState = #{orderState} where orderId = #{orderId}")
    public int updateOrder(@Param("orderId") Integer orderId, @Param("orderState") Integer orderState);

    @Update("update orders set orderTotal = #{orderTotal} where orderId = #{orderId}")
    public int updateOrders(@Param("orderId") Integer orderId, @Param("orderTotal") double orderTotal);
}
