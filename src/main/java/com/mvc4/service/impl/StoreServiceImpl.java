package com.mvc4.service.impl;

import com.mvc4.bean.OrderBean;
import com.mvc4.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 7/4/16
 * Time: 3:44 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class StoreServiceImpl implements StoreService {
    private final List<OrderBean> receivedOrders = new ArrayList<>();

    @Override
    public void registerOrder(OrderBean order) {
        this.receivedOrders.add(order);
    }

    @Override
    public Optional<OrderBean> getReceivedOrder(String id) {
        return receivedOrders.stream().filter(o -> o.getId().equals(id)).findFirst();
    }
}
