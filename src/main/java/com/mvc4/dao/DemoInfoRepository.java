package com.mvc4.dao;

import com.mvc4.entity.DemoInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/17/16
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DemoInfoRepository  extends CrudRepository<DemoInfo,Long> {
}
