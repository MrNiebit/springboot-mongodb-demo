
package com.example.springbootmongodbdemo.dao;

import com.example.springbootmongodbdemo.entity.DemoEntity;

import java.util.List;

/**
 * <h2>增删改查接口</h2>
 * @author gitsilence
 * date 2021/6/14
 */
public interface DemoEntityDao {

    void saveDemo (DemoEntity demoEntity);

    void removeDemo (String id);

    void updateDemo (DemoEntity demoEntity);

    DemoEntity findDemoById (String id);

    List<DemoEntity> findAll ();

}
