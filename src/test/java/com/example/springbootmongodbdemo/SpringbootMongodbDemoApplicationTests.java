package com.example.springbootmongodbdemo;

import com.example.springbootmongodbdemo.dao.DemoEntityDao;
import com.example.springbootmongodbdemo.dao.DemoEntityDaoImpl;
import com.example.springbootmongodbdemo.entity.DemoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMongodbDemoApplicationTests {

    @Autowired
    private DemoEntityDao demoEntityDao;

    @Test
    void save() {
        DemoEntity demoEntity = new DemoEntity();
//        demoEntity.setId(2L);
        demoEntity.setId("fff");
        demoEntity.setDescription("save --- description2");
        demoEntity.setTitle("save -- fff");
        demoEntity.setUrl("save -- url");
        demoEntity.setBy("save -- by2");
        demoEntityDao.saveDemo(demoEntity);
    }

    @Test
    void findAll () {
        List<DemoEntity> demoEntities = demoEntityDao.findAll();
        demoEntities.forEach(System.out::println);
    }

    @Test
    public void update () {
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setId("asd");
        demoEntity.setDescription("update --- description");
        demoEntity.setBy("update --- by");
        demoEntity.setUrl("update --- url");
        demoEntity.setTitle("update --- title");
        demoEntityDao.updateDemo(demoEntity);
    }

    @Test
    public void findById () {
        DemoEntity demo = demoEntityDao.findDemoById("asd");
        System.out.println(demo);
    }

    /**
     * 去重，这种方法只会返回一个字段，就是去重的那个字段
     */
    @Test
    public void findDistinct () {
        List<DemoEntity> distinct = demoEntityDao.findDistinct();
        distinct.forEach(System.out::println);
    }

    /**
     * 去重查询，返回List<实体> 根据分组的原理，可以设置条件、排序
     */
    @Test
    public void findDistinct2 () {
        List<DemoEntity> distinct = demoEntityDao.findDistinct(null);
        distinct.forEach(System.out::println);
    }

}
