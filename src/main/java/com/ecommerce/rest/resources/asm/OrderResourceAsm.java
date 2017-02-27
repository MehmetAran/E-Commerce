package com.ecommerce.rest.resources.asm;

import com.ecommerce.core.entities.Order;
import com.ecommerce.core.entities.Product;
import com.ecommerce.rest.controller.OrderController;
import com.ecommerce.rest.controller.ProductController;
import com.ecommerce.rest.resources.OrderResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
/**
 * Created by gennt on 2/26/2017.
 */
public class OrderResourceAsm extends ResourceAssemblerSupport<Order, OrderResource>{

    public OrderResourceAsm() {
        super(OrderController.class, OrderResource.class);
    }

    @Override
    public OrderResource toResource(Order order) {
        OrderResource res = new OrderResource();
        res.setDate(order.getDate());
        res.add(linkTo(OrderController.class).slash(order.getId()).withSelfRel());

        Set<Product> e = order.getProduct();
        for (Product p : e) {
            res.add(linkTo(ProductController.class).slash(p.getId()).withRel("products"));
        }
        return res;
    }
}
