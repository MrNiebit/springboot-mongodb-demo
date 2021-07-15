
package com.example.springbootmongodbdemo.dao;

import com.example.springbootmongodbdemo.entity.DemoEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <h2>Demo Dao 的简单实现 </h2>
 * @author gitsilence
 * date 2021/6/14
 */
@Component
public class DemoEntityDaoImpl implements DemoEntityDao{

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void saveDemo(DemoEntity demoEntity) {
        mongoTemplate.save(demoEntity);
    }

    @Override
    public void removeDemo(String id) {
        mongoTemplate.remove(id);
    }

    @Override
    public void updateDemo(DemoEntity demoEntity) {
        Query query = new Query(Criteria.where("id").is(demoEntity.getId()));
        Update update = new Update();
        update.set("title", demoEntity.getTitle());
        update.set("description", demoEntity.getDescription());
        update.set("by", demoEntity.getBy());
        update.set("url", demoEntity.getUrl());
        mongoTemplate.updateFirst(query, update, DemoEntity.class);
    }

    @Override
    public DemoEntity findDemoById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, DemoEntity.class);
    }

    @Override
    public List<DemoEntity> findAll() {
        return mongoTemplate.findAll(DemoEntity.class);
    }

    @Override
    public List<DemoEntity> findDistinct() {
        // 只能返回title 一个字段，
        List<Object> title = mongoTemplate.findDistinct("title", DemoEntity.class, Object.class);
        title.forEach(System.out::println);
        return new ArrayList<>();
    }

    @Override
    public List<DemoEntity> findDistinct(String status) {
        TypedAggregation<DemoEntity> aggregation = TypedAggregation.newAggregation(DemoEntity.class,
                Arrays.asList(
                        // 筛选条件
//                        TypedAggregation.match(Criteria.where("id").is("aaa")),
                        // 分组过滤条件，first，as里最后包含展示的字段
                        TypedAggregation.group("title").first("title").as("title")
                        .first("url").as("url").first("by").as("by")
                        // 挑选需要的字段
//                        TypedAggregation.project("_id", "title")
                )
        );
        AggregationResults<DemoEntity> aggregate = mongoTemplate.aggregate(aggregation, DemoEntity.class);
        List<DemoEntity> mappedResults = aggregate.getMappedResults();
        return mappedResults;
    }
}
