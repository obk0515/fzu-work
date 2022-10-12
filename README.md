# 项目环境及结构

- 编程语言：java

- 框架：springboot+mybatis-plus+maven

- 工具：sqlyog、intellij idea

## 项目结构说明

- controller层：因为不是实际开发，因此将算法放在`test.java.com.fzu.AlgorithmApplicationTests`里，可以直接运行；因此RollcallController就只是个摆设；
- entity：放学生实体类
- mapper层：继承BaseMapper
- service层：继承IService、ServiceImpl，使用mybatis-plus提供的方法，添加自己的方法
- utils：提供三个能力类
- application.yml：配置，改为自己的数据库
- AlgorithmApplicationTests：要运行的代码；提供1门课点名和5门课点名方法，在控制台输出点名方案及对应E值；虽然5门课打印出来的都是一张表的学生，但由于5门课相互独立，且每次运行完都会初始化学生表，因此5门课使用一张学生表并不会造成结果异常，实际开发会避免这种情况。
- pom.xml：相关依赖

## 需修改部分

src/main/resources/application.yml

## 运行

src/test/java/com/fzu/AlgorithmApplicationTests.java

call：普通点名（1门课）

callByScore：根据绩点点名（1门课）

testE：调用5次普通点名

testE1：调用5次根据绩点点名

虽然5门课打印出来的都是一张表的学生，但由于5门课相互独立，且每次运行完都会初始化学生表，因此5门课使用一张学生表并不会造成结果异常，实际开发会避免这种情况。

##结果

生成的数据集在`逃课人员.txt`
E和点名方案打印在控制台，实际开发会return给前端