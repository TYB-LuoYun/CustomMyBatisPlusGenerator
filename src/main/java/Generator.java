import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author maqh
 * @date 2019/9/6 16:41
 */
public class Generator {

    /**作者
     *
     */
    private static String Author="ftm";

    /**
     * 数据池
     */
    private static String Url = "jdbc:mysql://-----?&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
    private static String DriverName = "com.mysql.jdbc.Driver";
    private static String UserName = "root";
    private static String Password = "------";


    /**
     * 其他
     */
    private static String BasicPackage = "com.ruoyi.module";
    private static String TablePrefix = "t_";
    private static String MouleName = "sys";










    public static void main(String[] args) {



        // 放模板变量的值
        Map<String,Object> params = new HashMap<>();
        params.put("author",Author);
        params.put("comments","Query分页构造器");
        MyGenerrator.generateFile(params,"PageQuery.java.ftl",BasicPackage+".base",null);
        params.put("comments","Query条件构造器");
        MyGenerrator.generateFile(params,"WrapperQuery.java.ftl",BasicPackage+".base",null);




        generatorByTable();
    }













    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }



    public static void generatorByTable() {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir") ;
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(Author);
        gc.setOpen(false);
        gc.setFileOverride(true);//是否覆盖文件
        gc.setBaseResultMap(true); // xml resultmap
        gc.setBaseColumnList(true); // xml columlist
        gc.setSwagger2(true);  //实体属性 Swagger2 注解

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(Url);
        dsc.setDriverName(DriverName);
        dsc.setUsername(UserName);
        dsc.setPassword(Password);
        dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                if ( fieldType.toLowerCase().contains( "datetime" ) ) {
                    return DbColumnType.DATE;
                }
                return super.processTypeConvert(globalConfig, fieldType);
            }

        });
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
         MouleName = scanner("模块名");
        pc.setParent(BasicPackage);


        pc.setController( MouleName+".controller");
        pc.setEntity( MouleName+".entity" );
        pc.setService(MouleName+".service"   );
        pc.setServiceImpl( MouleName+".service"  +".impl");
        pc.setMapper(MouleName+".mapper" );
        pc.setXml(MouleName+".mapper.xml");
        mpg.setPackageInfo(pc);


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
                HashMap<String, Object> map = new HashMap<>();
                map.put("BasicPackage", BasicPackage);
                map.put("MouleName", MouleName);
                setMap(map);

            }

        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/src/main/resources/mapper/" + packgeName
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);

        // 公共父类
        // 写于父类中的公共字段
        String[] tableNames = scanner("表名，多个英文逗号分割").split(",");
        strategy.setInclude(tableNames);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(TablePrefix);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();


        // 生成Vo对象
        produceViewObject(true, tableNames);
    }




    /**
     * 根据表名生成VO对象,用于mybatis-plus代码生成以后再生成
     *
     * @param isTablePrefix
     * @param tableNames
     */
    private static void produceViewObject(boolean isTablePrefix, String... tableNames) {
        String DEFAULT_OUT_PUT_DIR =System.getProperty("user.dir") + "/src/main/java";
        for (int i = 0; i < tableNames.length; i++) {
            String tableName = tableNames[i];
            tableName = isTablePrefix ? tableName.substring(tableName.indexOf("_") + 1) : tableName;
            String suPkStr = StringUtils.remove(tableName, "_").toLowerCase();
            String outPutDir = DEFAULT_OUT_PUT_DIR+ "/" + (BasicPackage.replace(".", "/")) + "/vo/" + suPkStr
                    + "/";
            String baseFileName =  underline2Camel(tableName, false);
            try {
                Map<String,Object> params = new HashMap<>();
                params.put("author",Author);
                params.put("comments","vo类");
                params.put("MyBasePackage", BasicPackage);
                params.put("MyEntity", baseFileName);
                params.put("MyModuleName",MouleName );
                MyGenerrator.generateFile(params,"Vo.java.ftl",BasicPackage+"."+MouleName+".vo",baseFileName+"Vo.java");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    public static String underline2Camel(String line, boolean... smallCamel) {
        if (StringUtils.isBlank(line)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher = pattern.matcher(line);
        // 匹配正则表达式
        while (matcher.find()) {
            String word = matcher.group();
            // 当是true 或则是空的情况
            if ((smallCamel.length == 0 || smallCamel[0]) && matcher.start() == 0) {
                sb.append(Character.toLowerCase(word.charAt(0)));
            } else {
                sb.append(Character.toUpperCase(word.charAt(0)));
            }

            int index = word.lastIndexOf('_');
            if (index > 0) {
                sb.append(word.substring(1, index).toLowerCase());
            } else {
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }



}
