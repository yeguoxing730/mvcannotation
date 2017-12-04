package com.boot.dao;

import com.boot.entity.Demo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/12/16
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
public interface JPADemoRepositoryEntityManager extends CrudRepository<Demo, Long> {
}
