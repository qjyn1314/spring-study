package com.study.modu.common.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.study.modu.common.base.BaseObject;

/**
 * <p>
 * Explain:生成mybatis开发代码
 * </p >
 *
 * @author wangjunming
 * @since 2019-12-31 17:50
 */
public class MybatisGenerator extends BaseObject {


    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
//        F:\IDEA\spring-study\spring-morning\src\main\java
//        F:\IDEA\spring-study\spring-afternoon\src\main\java
        String morningurl = "F:\\IDEA\\spring-study\\spring-morning\\src\\main\\java";
        String afternoonurl = "F:\\IDEA\\spring-study\\spring-afternoon\\src\\main\\java";
        gc.setOutputDir(afternoonurl);//这里写你自己的java目录
        gc.setFileOverride(true);//是否覆盖
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("wangjunming");
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/king?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT");
        mpg.setDataSource(dsc);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(new String[]{"ko_user"});
        strategy.setEntityTableFieldAnnotationEnable(true);
        mpg.setStrategy(strategy);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(null);
        /*
         * 下面的包名都根据实际情况编写
         * com.study.modu.web.persistence
         */
        pc.setEntity("com.study.modu.web.persistence.entity");
        pc.setMapper("com.study.modu.web.persistence.mapper");
        pc.setXml("com.study.modu.web.persistence.mapper.xml");
        pc.setService("com.study.modu.web.persistence.service");
        pc.setServiceImpl("com.study.modu.web.persistence.service.impl");
        pc.setController("com.study.modu.web.controller");
        mpg.setPackageInfo(pc);
        // 执行生成
        mpg.execute();
    }


}
