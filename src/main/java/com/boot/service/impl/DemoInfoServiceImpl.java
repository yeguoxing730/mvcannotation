package com.boot.service.impl;

import com.boot.dao.DemoInfoRepository;
import com.boot.dao.JDBCTemplateDemoDao;
import com.boot.entity.DemoInfo;
import com.boot.service.DemoInfoService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/17/16
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class DemoInfoServiceImpl  implements DemoInfoService {
    @Resource
    private DemoInfoRepository demoInfoRepository;
    @Resource
    private JDBCTemplateDemoDao jdbcTemplateDemoDao;

    @Resource
    private org.springframework.data.redis.core.RedisTemplate<String,String> redisTemplate;
    //keyGenerator="myKeyGenerator"
    @Cacheable(value="demoInfo") //缓存,这里没有指定key.
    @Override
    public DemoInfo findById(long id) {
        System.out.println("DemoInfoServiceImpl.findById()=========从数据库中进行获取的....id="+id);
        DemoInfo demoInfo =     demoInfoRepository.findOne(id);
        return  demoInfo;
    }
    @CacheEvict(value="demoInfo")
    @Override
    public void deleteFromCache(long id) {
        System.out.println("DemoInfoServiceImpl.delete().从缓存中删除.");
    }

    @Override
    public void test() {
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("mykey4", "random1="+Math.random());
        System.out.println(valueOperations.get("mykey4"));
    }
    @Cacheable(value="getDemoInfoById") //缓存,这里没有指定key.
    @Override
    public DemoInfo getDemoInfoById(long id){
        //demoRepository.findOne(id);//在demoRepository可以直接使用findOne进行获取.
        System.out.println("DemoInfoServiceImpl.getDemoInfoById()=========从数据库中进行获取的....id="+id);
        return jdbcTemplateDemoDao.getDemoInfoById(id);
    }
}
