
package com.example.springbootmongodbdemo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * <h2></h2>
 * @author gitsilence
 * date 2021/6/14
 */
@Data
// 把当前类声明为 mongodb 的文档，可以通过collation参数指定这个类对应文档
@Document(collection = "demo_entity_test")
public class DemoEntity {

    /*
     * @Id，主键，不可重复，可以在定义的列名上标注，需要自己生成并维护不重复的约束
    * 如果自己不设置@Id注解 mongo会自动生成一个唯一主键，并且插入效率远高于
    * 自己设置的主键
    * */


    /*
    * @Transient 该注解标注的，将不会被录入到数据库中，只作为JavaBean 属性
    * */

//    @Transient
//    @Id
    private String id;

    private String title;

    private String description;

    private String by;

    private String url;

}
