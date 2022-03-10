package com.jldt.phantom;


import com.jldt.phantom.core.Fild;
import com.jldt.phantom.core.ModeType;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

/**
 * @Copyright (C), 2018, 上海金皿计算机科技有限公司
 * @ProjectName: Phantom
 * @FileName: GenerationTool
 * @Author: 屈志刚
 * @Date: 2019/5/5/005 上午 11:58
 * @Description:
 * @email ==>> jing9241120@sina.com
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class GenerationTool {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=Hongkong&allowMultiQueries=true";
    private static final String USER = "root";
    private static final String PASSWORD = "Sjp123456";
    private static final String SCHEMA_NAME = "mall";


    /**
     * 运行模式
     */
    private static ModeType TYPE =  ModeType.SINGLE;

    /**
     * 扫描全库
     */
    private static String SCAN_TABLE ="select table_name from information_schema.tables where table_schema='%s'";

    private static String TABLE_NAME = "cms_help";

    private static String  CLASS_NAME_LOWCASE="" ;

    private static String CLASS_NAME_UPCASE="";

    /** 物理目录*/
    private static String  rootPath = "F:\\work\\phantom\\";

    private static String moduleName = "admin";

    private static String createDate = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date());


    private static 	List<Fild> filds ;

    private static VelocityEngine ve;


    private static void init(String talbeName) throws Exception{
        CLASS_NAME_LOWCASE="";
        CLASS_NAME_UPCASE="";
        initVelocity();
        initTable(talbeName);
    }


    /**
     * 初始化velocity相关配置
     * @throws Exception
     */
    private static void   initVelocity() throws Exception{
        ve = new VelocityEngine();
        ve.setProperty("input.encoding", "UTF-8");
        ve.setProperty("output.encoding", "UTF-8");
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class",
                ClasspathResourceLoader.class.getName());
        ve.init();
    }

    private static Connection getConection() throws ClassNotFoundException,
            SQLException {

        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        if (!conn.isClosed()){
            System.out.println("Succeeded connecting to the Database!");
        } else {
            System.err.println("connect filed");
            return null;
        }
        return conn;
    }

    private static List<String> schemaTable() throws SQLException, ClassNotFoundException {
        Connection connection = getConection();
        Statement statement = connection.createStatement();
        String schemaQuery = String.format(SCAN_TABLE, SCHEMA_NAME);
        ResultSet resultSet = statement.executeQuery(schemaQuery);
        List<String> tables = new ArrayList<>();
        while (resultSet.next()){
            tables.add(resultSet.getString(1));
        }
        return tables;
    }

    private static void initTable(String talbeName) throws ClassNotFoundException, SQLException{
        String[] temp = {};
        if(talbeName.startsWith("tbl_")){
            temp = talbeName.substring(4).toLowerCase().split("_");
        }else if(talbeName.startsWith("t_")){
            temp = talbeName.substring(2).toLowerCase().split("_");
        }else{
            temp = talbeName.substring(0).toLowerCase().split("_");
        }

        for (String str : temp) {
            if (str != null && str.trim().length() > 0) {
                // 首字母大写
                CLASS_NAME_UPCASE += str.replaceFirst(str.charAt(0)+ "",
                        (char) ((str.charAt(0) - 32))+"");
            }
        }
        // userAccount UserAccount
        CLASS_NAME_LOWCASE = CLASS_NAME_UPCASE.replaceFirst(CLASS_NAME_UPCASE.charAt(0)+"",
                (char) ((CLASS_NAME_UPCASE.charAt(0) + 32))+"");

        filds=getFileds(talbeName);
    }

    public static void main(String[] args) throws Exception {
        switch (TYPE) {
            case SINGLE:
                buildClass(TABLE_NAME);
                return;
            case LIST:
                List<String> schemaTable = schemaTable();
                for (Iterator<String> iterator = schemaTable.listIterator();iterator.hasNext();){
                    buildClass(iterator.next());
                }
                return;
            default:
        }
    }

    private static void buildClass(String tbaleName) throws Exception {
        init(tbaleName);
        // 生成Entity
        createEntity(tbaleName);
        // 生成Dto
        createDto();
        // 生成mapper
        createMapper(tbaleName);
        // 生成server
        createService();
        // 生成serverImpl
        createServiceImpl();
        // 生成mybatis_xxxxx.xml
        createMybatisXml();
    }

    private static void merge(Template template, VelocityContext ctx,
                              String path) {
        PrintWriter writer = null;
        try {
            File file = new File(path);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            writer = new PrintWriter(file);
            template.setEncoding("UTF-8");
            template.merge(ctx, writer);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }  finally {
            writer.close();
        }
    }

    /**
     * 获取所有字段
     *
     * @param tableName
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private static List<Fild> getFileds(String tableName)
            throws ClassNotFoundException, SQLException {
        List<Fild> list = new ArrayList<Fild>();
        Connection conn = getConection();
        StringBuffer stringBuffer = new StringBuffer();

        Statement statement = conn.createStatement();


        ResultSet fildCommentMapRs = statement.executeQuery("show full columns from " + tableName);

        Map fildCommentMap = new HashMap();
        int resultIndex = 0;
        while(fildCommentMapRs.next()) {


            String remarks = fildCommentMapRs.getString("Comment");
            fildCommentMap.put(resultIndex, remarks);
            resultIndex++;
        }

        ResultSet resultSet = statement.executeQuery("select * from "
                + tableName);
        // 获取列名
        ResultSetMetaData metaData = resultSet.getMetaData();

        for (int i = 0; i < metaData.getColumnCount(); i++) {
            // resultSet数据下标从1开始
            String columnName = metaData.getColumnName(i + 1);
            int type = metaData.getColumnType(i + 1);
            String[] temp = columnName.toLowerCase().split("_");
            String fild = "";
            String property = "";
            for (String str : temp) {
                if (str != null && str.trim().length() > 0) {
                    // 首字母大写
                    property += str.replaceFirst(str.charAt(0) + "",
                            (char) ((str.charAt(0) - 32)) + "");
                }

            }

            // 首字母小写
            fild = property.replaceFirst(property.charAt(0) + "",
                    (char) ((property.charAt(0) + 32)) + "");

            switch (type) {
                case Types.BIT:
                case Types.BIGINT:
                case Types.INTEGER:
                case Types.TINYINT:

                    if(i == 0){
                        list.add(new Fild("Long", fild, null, property, columnName));
                        break;
                    }
                    list.add(new Fild("Integer", fild, fildCommentMap.get(i).toString(),property, columnName));

                    break;
                case Types.FLOAT:
                    list.add(new Fild("Float", fild, fildCommentMap.get(i).toString(), property, columnName));
                    break;
                case Types.DOUBLE:
                case Types.DECIMAL:
                    list.add(new Fild("BigDecimal", fild, fildCommentMap.get(i).toString(), property, columnName));
                    break;
                case -1:
                case Types.CHAR:
                case Types.VARCHAR:
                    list.add(new Fild("String", fild, fildCommentMap.get(i).toString(), property, columnName));
                    break;
                case Types.DATE:
                case Types.TIMESTAMP:
                case Types.TIME:
                    list.add(new Fild("Date", fild, fildCommentMap.get(i).toString(), property, columnName));
                    break;
                default:
                    break;
            }

            System.out.print(columnName + "\t");
        }
        statement.close();
        conn.close();
        System.out.println("list"+list.toString());
        return list;
    }

    /**
     * 获取表所有的列名
     *
     * @param table
     * @return ID,USER_NAME,CONTACT_USER_NAME
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static String getColumns(String table)
            throws ClassNotFoundException, SQLException {
        StringBuffer str = new StringBuffer();
        Connection conn = getConection();
        // 获取所有表名
        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from " + table);
        // 获取列名
        ResultSetMetaData metaData = resultSet.getMetaData();
        for (int i = 0; i < metaData.getColumnCount(); i++) {
            // resultSet数据下标从1开始
            String columnName = metaData.getColumnName(i + 1);
            str.append(columnName + ",");
        }
        String strTem = str.substring(0, str.length() - 1).toString();
        statement.close();
        conn.close();
        return strTem;
    }

    /**
     * 获取表所有的列名 ${userName}
     *
     * @param list
     * @return ${userName}
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static String getProperty(List<Fild> list) {
        StringBuffer str = new StringBuffer();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                str.append("#{" + list.get(i).getFild() + "},");
            }
        }

        String strTem = str.substring(0, str.length() - 1);

        return strTem;
    }

    /**
     * 获取表所有的列名 ${userName}
     *
     * @param columns, filds
     * @return ${userName}
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static String getUpdate(String columns, List<Fild> filds) {
        StringBuffer str = new StringBuffer();
        if (!StringUtils.isBlank(columns) && !CollectionUtils.isEmpty(filds)) {
            String[] columnArray = columns.split(",");

            //去掉 id  和 create_time  update_time
            for (int i = 1; i < columnArray.length; i++) {
                str.append(columnArray[i] + "=#{"
                        + filds.get(i).getFild() + "},");
            }

        }

        String strTem = str.substring(0, str.length() - 1);
        strTem = strTem.replace("create_time=#{createTime},", "");

        return strTem;
    }

    public static String convertDatabaseCharsetType(String in, String type) {
        String dbUser;
        if (in != null) {
            if ("oracle".equals(type)) {
                dbUser = in.toUpperCase();
            } else if ("postgresql".equals(type)) {
                dbUser = "public";
            } else if ("mysql".equals(type)) {
                dbUser = null;
            } else if ("mssqlserver".equals(type)) {
                dbUser = null;
            } else if ("db2".equals(type)) {
                dbUser = in.toUpperCase();
            } else {
                dbUser = in;
            }
        } else {
            dbUser = "public";
        }
        return dbUser;
    }

    private static void getTables(Connection conn) throws SQLException {
        DatabaseMetaData dbMetData = conn.getMetaData();
        // mysql convertDatabaseCharsetType null
        ResultSet rs = dbMetData.getTables(null,
                convertDatabaseCharsetType("root", "mysql"), null,
                new String[] { "TABLE", "VIEW" });

        while (rs.next()) {
            if (rs.getString(4) != null
                    && ("TABLE".equalsIgnoreCase(rs.getString(4)) || "VIEW".equalsIgnoreCase(rs
                    .getString(4)))) {
                String tableName = rs.getString(3).toLowerCase();
                System.out.print(tableName + "\t");
                // 根据表名提前表里面信息：
                ResultSet colRet = dbMetData.getColumns(null, "%", tableName,
                        "%");
                while (colRet.next()) {
                    String columnName = colRet.getString("COLUMN_NAME");
                    String columnType = colRet.getString("TYPE_NAME");
                    int datasize = colRet.getInt("COLUMN_SIZE");
                    int digits = colRet.getInt("DECIMAL_DIGITS");
                    int nullable = colRet.getInt("NULLABLE");
                    // System.out.println(columnName + " " + columnType + " "+
                    // datasize + " " + digits + " " + nullable);
                }

            }
        }
        System.out.println();

        // resultSet数据下标从1开始 ResultSet tableRet =
        // conn.getMetaData().getTables(null, null, "%", new String[] { "TABLE"
        // });
        // while (tableRet.next()) {
        // System.out.print(tableRet.getString(3) + "\t");
        // }
        // System.out.println();

    }

    private static void createEntity(String talbeName) throws ResourceNotFoundException, ParseErrorException, Exception{

        Template actionTpt = ve.getTemplate("template/entity.vm");
        VelocityContext ctx = new VelocityContext();
        ctx.put("CLASS_NAME_LOWCASE", CLASS_NAME_LOWCASE);
        ctx.put("CLASS_NAME_UPCASE", CLASS_NAME_UPCASE);
        ctx.put("talbeName", talbeName);
        ctx.put("moduleName", moduleName);
        ctx.put("fileName",CLASS_NAME_UPCASE +"Entity.java");
        ctx.put("createDate", createDate);
        ctx.put("filds", filds);

        // 生成文件 模板 内容容器 新文件位置

        merge(actionTpt, ctx,
                rootPath+"common-facade"
                        + File.separator +"src"
                        + File.separator +"main"
                        + File.separator +"java"
                        + File.separator +"com"
                        + File.separator +"jldt"
                        + File.separator +"phantom"
                        + File.separator +"facade"
                        + File.separator +"entity"+ File.separator +""
                +moduleName+""+ File.separator +""+CLASS_NAME_UPCASE +"Entity.java");
        System.out.println("success...entity");
    }

    private static void createDto() {

        Template actionTpt = ve.getTemplate("template/dto.vm");
        VelocityContext ctx = new VelocityContext();
        ctx.put("CLASS_NAME_LOWCASE", CLASS_NAME_LOWCASE);
        ctx.put("CLASS_NAME_UPCASE", CLASS_NAME_UPCASE);
        ctx.put("moduleName", moduleName);
        ctx.put("fileName",CLASS_NAME_UPCASE +"Dto.java");
        ctx.put("createDate", createDate);
        ctx.put("filds", filds);

        // 生成文件 模板 内容容器 新文件位置
        merge(actionTpt, ctx, rootPath+"common-facade"
                + File.separator +"src"
                + File.separator +"main"
                + File.separator +"java"
                + File.separator +"com"
                + File.separator +"jldt"
                + File.separator +"phantom"
                + File.separator +"facade"
                + File.separator +"dto"+ File.separator +""
                +moduleName+""+ File.separator +""+CLASS_NAME_UPCASE +"Dto.java");
        System.out.println("success...dto");
    }

    private static void createMapper(String talbeName) throws ResourceNotFoundException, ParseErrorException, Exception{


        Template mapperTmp = ve.getTemplate("template/mapper.vm");
        VelocityContext mapperCtx = new VelocityContext();
        String columns = getColumns(talbeName);
        String property = getProperty(filds);
        String update = getUpdate(columns, filds);
        mapperCtx.put("CLASS_NAME_UPCASE", CLASS_NAME_UPCASE);
        mapperCtx.put("CLASS_NAME_LOWCASE", CLASS_NAME_LOWCASE);
        mapperCtx.put("talbeName", talbeName);
        mapperCtx.put("moduleName", moduleName);
        mapperCtx.put("fileName",CLASS_NAME_UPCASE +"Mapper.java");
        mapperCtx.put("createDate", createDate);
        mapperCtx.put("columns", columns);



        String insertStr = columns.replace(",update_time", "");
        if("id,".equals(columns.substring(0, 3))){
            insertStr = columns.substring(3).replace(",update_time", "");
        }

        // 去掉ID,
        mapperCtx.put("insert", insertStr);

        String insertProStr = property.replace(",#{updateTime}", "");

        if("#{id},".equals(property.substring(0,6))){
            insertProStr = property.substring(6).replace(",#{updateTime}", "");
        }

        // 去掉#{id},
        mapperCtx.put("insertProperty", insertProStr);

        mapperCtx.put("property", property);
        mapperCtx.put("update", update);
        merge(mapperTmp, mapperCtx, rootPath
                + "mbg"+""+ File.separator +"src"
                + File.separator +"main"
                + File.separator +"java"
                + File.separator +"com"
                + File.separator +"jldt"
                + File.separator +"phantom"
                + File.separator +"mapper"
                + File.separator +""+moduleName+""+ File.separator +"mapper"+ File.separator +"" +
                CLASS_NAME_UPCASE +"Mapper.java");
        System.out.println("success...mapper");
    }


    private static void createService() throws ResourceNotFoundException, ParseErrorException, Exception{

        Template serviceTmp = ve.getTemplate("template/service.vm");
        VelocityContext serviceCtx = new VelocityContext();
        serviceCtx.put("CLASS_NAME_UPCASE", CLASS_NAME_UPCASE);
        serviceCtx.put("CLASS_NAME_LOWCASE", CLASS_NAME_LOWCASE);
        serviceCtx.put("moduleName", moduleName);
        serviceCtx.put("fileName",CLASS_NAME_UPCASE +"Service.java");
        serviceCtx.put("createDate", createDate);

        merge(serviceTmp, serviceCtx, rootPath+moduleName
                + File.separator +"src"
                + File.separator +"main"
                + File.separator +"java"
                + File.separator +"com"
                + File.separator +"jldt"
                + File.separator +"phantom"
                + File.separator +"service"+ File.separator +""
                +moduleName+""+ File.separator +""+CLASS_NAME_UPCASE +"Service.java");

        System.out.println("success...server");
    }

    private static void createServiceImpl() throws ResourceNotFoundException, ParseErrorException, Exception{

        Template serviceImplTmp = ve.getTemplate("template/serviceImpl.vm");
        VelocityContext serviceImplCtx = new VelocityContext();
        serviceImplCtx.put("CLASS_NAME_UPCASE", CLASS_NAME_UPCASE);
        serviceImplCtx.put("CLASS_NAME_LOWCASE", CLASS_NAME_LOWCASE);
        serviceImplCtx.put("moduleName", moduleName);
        serviceImplCtx.put("fileName",CLASS_NAME_UPCASE +"Service.java");
        serviceImplCtx.put("createDate", createDate);

        merge(serviceImplTmp, serviceImplCtx, rootPath
                + moduleName+""+ File.separator +"src"
                + File.separator +"main"
                + File.separator +"java"
                + File.separator +"com"
                + File.separator +"jldt"
                + File.separator +"phantom"
                //+ File.separator +""+moduleName+""
                + File.separator +"service"
                + File.separator +"impl"
                + File.separator +"" +
                CLASS_NAME_UPCASE +"ServiceImpl.java");

        System.out.println("success...serviceImpl");
    };

    private static void createMybatisXml() throws ResourceNotFoundException, ParseErrorException, Exception{

        Template MybatisXxxxxTmp = ve.getTemplate("template/mybatis_xml.vm");
        VelocityContext mybatisXxxxxCtx = new VelocityContext();
        mybatisXxxxxCtx.put("CLASS_NAME_UPCASE", CLASS_NAME_UPCASE);
        mybatisXxxxxCtx.put("CLASS_NAME_LOWCASE", CLASS_NAME_LOWCASE);
        mybatisXxxxxCtx.put("moduleName", moduleName);
        mybatisXxxxxCtx.put("fileName",CLASS_NAME_UPCASE +"XmlMapper.xml");
        mybatisXxxxxCtx.put("createDate", createDate);
        mybatisXxxxxCtx.put("filds", filds);

        merge(MybatisXxxxxTmp, mybatisXxxxxCtx, rootPath
                + "mbg"+""+ File.separator +"src"
                + File.separator +"main"
                + File.separator +"resources"
                + File.separator +"com.jldt.phantom.mapper"
                + File.separator +"MYBATIS_"
                + CLASS_NAME_UPCASE +"XmlMapper.xml");

        System.out.println("success...mybatis_xxxxx.xml");
    }


}
