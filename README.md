# 工程简介

## Spring Boot 集成 Mongo DB

依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```

配置
```properties
# 要保证 填写的数据库  是用户 的权限之内的
spring.data.mongodb.uri=mongodb://gitsilence:123@192.168.44.130:27017/admin
```


# 延伸阅读

添加普通用户 对test数据库有读写权限，对book数据库只有读权限
```bash
db.createUser({user: "test", pwd: "123", roles: [{role: "readWrite", db: "test"},
{role: "read", db: "book"}]})
```