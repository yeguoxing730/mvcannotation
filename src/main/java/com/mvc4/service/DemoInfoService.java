package com.mvc4.service;

import com.mvc4.entity.DemoInfo;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/17/16
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DemoInfoService {
    public DemoInfo findById(long id);

    public void deleteFromCache(long id);
    public  DemoInfo getDemoInfoById(long id);
    void test();

}
