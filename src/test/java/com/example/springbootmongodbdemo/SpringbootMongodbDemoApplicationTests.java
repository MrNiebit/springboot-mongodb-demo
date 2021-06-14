package com.example.springbootmongodbdemo;

import com.example.springbootmongodbdemo.dao.DemoEntityDao;
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
        demoEntity.setId("asd");
        demoEntity.setDescription("save --- description2");
        demoEntity.setTitle("save -- title2");
        demoEntity.setUrl("save -- url2");
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

}
