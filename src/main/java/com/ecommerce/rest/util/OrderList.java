package com.ecommerce.rest.util;

import com.ecommerce.core.entities.Order;
import com.ecommerce.rest.resources.OrderResource;
import com.ecommerce.rest.resources.asm.OrderResourceAsm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gennt on 2/28/2017.
 */
public class OrderList {

    private List<OrderResource> orderResources;

    public OrderList() {
        orderResources = new ArrayList<>();
    }

    public List<OrderResource> getOrderResources() {
        return orderResources;
    }

    public void setOrderResources(List<OrderResource> orderResources) {
        this.orderResources = orderResources;
    }

    public void orderToResourceList(List<Order> orders){
        for (Order o : orders) {
            orderResources.add(new OrderResourceAsm().toResource(o));
        }
    }
}
