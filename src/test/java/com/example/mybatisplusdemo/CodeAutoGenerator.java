package com.example.mybatisplusdemo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.platform.commons.util.StringUtils;
import java.util.Scanner;

/**
 * @ClassName: CodeAutoGenerator
 * @Description: MyBatis-plus代码自动生成器
 * @Author songxl
 * @Date 2021/3/25
 * @Version 1.0
 */
public class CodeAutoGenerator {

    /**
     * @Author songxl
     * @Description
     * @Date  2021/3/25
     * @Param [tip]
     * @Return java.lang.String
     * @MethodName scanner
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
    public static void main(String[] args) {
       try {
           // 代码生成器
           AutoGenerator mpg = new AutoGenerator();

           // 全局配置
           GlobalConfig gc = new GlobalConfig();
           String projectPath = System.getProperty("user.dir");
           gc.setOutputDir(projectPath + "/src/main/java");
           gc.setOpen(false);                 // 文件生成完成后是否用打开相应的生成路径
           gc.setFileOverride(true);          // 是否覆盖已有文件
           gc.setAuthor("songxl");            // 作者
           gc.setActiveRecord(false);         // 不需要ActiveRecord特性的请改为false
           gc.setEnableCache(false);          // XML 二级缓存
           gc.setBaseResultMap(true);         // XML 是否要有映射ResultMap
           gc.setBaseColumnList(false);        // XML 是否要有基础的列
           gc.setActiveRecord(false);          // AR模式，就是bean有增删改查方法，继承自Model类
           //gc.setSwagger2(true);              //实体属性 Swagger2 注解
           //gc.setIdType(IdType.ID_WORKER) ;   // 主键策略


           // 自定义文件命名，注意 %s 会自动填充表实体属性！
           gc.setEntityName("%s");                  // 实体命名方式
           gc.setControllerName("%sController");    //controller 命名方式
           gc.setServiceName("%sService");          //service接口 命名方式
           gc.setServiceImplName("%sServiceImpl");  //service实现类命名方式
           gc.setMapperName("%sMapper");            // mapper 命名方式
           gc.setXmlName("%sMapper");                // Mapper xml 命名方式
           mpg.setGlobalConfig(gc);




           // 数据源配置
           DataSourceConfig dsc = new DataSourceConfig();
           dsc.setDbType(DbType.MYSQL);
           dsc.setDriverName("com.mysql.cj.jdbc.Driver");
           dsc.setUsername("root");
           dsc.setPassword("lantone");
           dsc.setUrl("jdbc:mysql://192.168.2.236:3306/stu?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8");
           mpg.setDataSource(dsc);


           // 策略配置
           StrategyConfig strategy = new StrategyConfig();
           //        strategy.setTablePrefix(new String[] { "med_" });// 此处可以修改为您的表前缀
           strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
           strategy.setInclude(scanner("表名，多个英文逗号分割").split(",")); // 需要生成的表
           strategy.setSuperServiceClass(null);
           strategy.setSuperServiceImplClass(null);
           strategy.setSuperMapperClass(null);
           mpg.setStrategy(strategy);
           // 包配置
           PackageConfig pc = new PackageConfig();
           pc.setParent("com.example.mybatisplusdemo");
           pc.setController("web");
           pc.setService("service");
           pc.setServiceImpl("service.impl");
           pc.setMapper("mapper");
           pc.setEntity("entity");
           pc.setXml("resources.mapper");
           mpg.setPackageInfo(pc);

           // 执行生成
           mpg.setTemplateEngine(new FreemarkerTemplateEngine());
           mpg.execute();
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }
}
