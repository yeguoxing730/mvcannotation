package com.boot.service;

import com.boot.bean.OrderBean;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 7/4/16
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
public interface StoreService {
    public void registerOrder(OrderBean order);
    public Optional<OrderBean> getReceivedOrder(String id);
}
