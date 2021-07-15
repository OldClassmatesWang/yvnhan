package com.baizhou.yvnhan;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class YvnhanApplicationTests {

    @Test
    void contextLoads() {//需要构建一个代码生成器对象
        AutoGenerator autoGenerator = new AutoGenerator();
        /*
        配置策略
         */
        // 1、全局配置
        GlobalConfig config = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        config.setOutputDir(projectPath+"/src/main/java");
        config.setAuthor("wanghaipeng");
        config.setOpen(false);  //生成完是否打开资源管理器
        config.setFileOverride(false);  //是否覆盖原来生成的
        config.setServiceName("%sService");  //去Service的I 前缀
        config.setIdType(IdType.ASSIGN_UUID);  //全局ID的生成方式
        config.setDateType(DateType.ONLY_DATE); //设置日期类型
        config.setSwagger2(true);   //自动配置swagger 文档
        autoGenerator.setGlobalConfig(config);

        //2、设置数据源配置
        DataSourceConfig sourceConfig = new DataSourceConfig();
        sourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/yvnhan?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
        sourceConfig.setUsername("root");
        sourceConfig.setPassword("asdfgh123456");
        sourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        sourceConfig.setDbType(DbType.MYSQL);
        autoGenerator.setDataSource(sourceConfig);

        //3、配置包
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("yvnhan");
        pc.setParent("com.baizhou");   //生成com.wang.blog 的模块
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setController("controller");
        pc.setService("service");
        autoGenerator.setPackageInfo(pc);

        //4、策略配置
        StrategyConfig stc = new StrategyConfig();
        stc.setInclude("book_label","user","book","record");   //设置要映射的表明，这里有多少各表名就能映射多少个表
        stc.setNaming(NamingStrategy.underline_to_camel);  //内置包的命名规则  下划线转驼峰命名
        stc.setColumnNaming(NamingStrategy.underline_to_camel);  //内置列的命名规则  下划线转驼峰命名
        stc.setEntityLombokModel(true);  //是否使用Lombok
        stc.setLogicDeleteFieldName("deleted");  //设置逻辑删除的名字
        stc.setVersionFieldName("version"); //设置乐观锁的名字
        //自动填充配置
        TableFill gmt_create = new TableFill("create_time", FieldFill.INSERT);
        TableFill gmt_modified = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmt_create);
        tableFills.add(gmt_modified);
        stc.setTableFillList(tableFills);

        stc.setRestControllerStyle(true);   //开启Controller 的驼峰命名
        stc.setControllerMappingHyphenStyle(true); //在url 中使用下划线

        autoGenerator.setStrategy(stc);

        //执行代码生成器
        autoGenerator.execute();

    }

}
