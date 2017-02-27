package com.ecommerce.rest.resources;

import com.ecommerce.core.entities.Client;
import com.ecommerce.core.entities.Order;
import com.ecommerce.rest.util.ProductSet;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

/**
 * Created by gennt on 2/24/2017.
 */
public class OrderResource extends ResourceSupport {

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public Order toOrder(){
        Order o = new Order();
        o.setDate(this.date);
        return o;
    }
}
