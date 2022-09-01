import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class MyGenerrator {
    private static String FtlDir ="\\src\\main\\resources\\templates";
    public static void main(String[] args) throws IOException {
        // 放模板变量的值
        Map<String,Object> params = new HashMap<>();
        params.put("author","ftm");
        params.put("date","2022-06-03");
        params.put("comments","freemarker模板");
        generateFile(params,"PageQuery.java.ftl","top.anets.base",null);
    }





    public static void generateFile(Map<String,Object> params,String ftl,String packageRef,String fileName)   {
        params.put("package",packageRef);
        params.put("date",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        String s = packageRef.replaceAll("\\.", Matcher.quoteReplacement(File.separator));
        String JavaDir = "\\src\\main\\java\\"+s;
        try{
        Configuration configuration = new Configuration(new Version("2.3.3"));
        configuration.setDefaultEncoding("utf-8");
        String absolutePath = System.getProperty("user.dir") + FtlDir;

            // 加载.ftl配置文件所在路径
            configuration.setDirectoryForTemplateLoading(new File(absolutePath));
            //给文件赋值
            Template template = configuration.getTemplate(ftl);
            File target = new File( System.getProperty("user.dir") + JavaDir);
            if(target.exists()==false){
                target.mkdirs();
            }
            // 文件输出路径
            FileOutputStream file = null;
            if(StringUtils.isNotBlank(fileName)){
                file = new FileOutputStream(new File(target,fileName));
            }else{
                file =  new FileOutputStream(new File(target,ftl.substring(0,ftl.lastIndexOf("."))));
            }
            OutputStreamWriter out = new OutputStreamWriter(file, "utf-8");
            template.process(params,out);
            out.close();
        }catch (IOException | TemplateException exception) {
            exception.printStackTrace();
        }
    }
}
