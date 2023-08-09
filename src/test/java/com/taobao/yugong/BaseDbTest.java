package com.taobao.yugong;

import com.taobao.yugong.common.model.DataSourceConfig;
import com.taobao.yugong.common.model.DbType;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author agapple 2014年2月25日 下午11:38:06
 * @since 1.0.0
 */
public class BaseDbTest {

    public DataSourceConfig getOracleConfig() {
        DataSourceConfig config = new DataSourceConfig();
        config.setUsername("test");
        config.setPassword("test");
        config.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:test");
        config.setEncode("UTF-8");
        config.setType(DbType.ORACLE);

        return config;
    }

    public DataSourceConfig getMysqlConfig() {
        DataSourceConfig config = new DataSourceConfig();
        config.setUsername("test");
        config.setPassword("test");
        config.setUrl("jdbc:mysql://127.0.0.1:3306");
        config.setEncode("UTF-8");
        config.setType(DbType.MYSQL);

        return config;
    }
    
    public static Map<String,String[]> getTablePKs(){
        String tablepks  ="HZJY.BUSINESS_INFO&id";
        if(StringUtils.isBlank(tablepks)){
            return null;
        }else{
            Map<String,String[]> tps=new HashMap();
            String[] tables=tablepks.split("\\|");
            for(String table:tables){
                String[] tablev=table.split("&");
                String tableName=tablev[0];
                String[] pks=new String[tablev.length-1];
                for(int i=1;i<tablev.length;i++){
                    pks[i-1]=new String(tablev[i]).toUpperCase().toString();
                }
                tps.put(new String(tableName).toUpperCase().toString(), pks);
            }
            return tps;
        }
    }
    
    public static void main(String[] args) {
        Map<String, String[]> tablePKs = getTablePKs();
        for (String key : tablePKs.keySet()) {
            System.out.println(key+" - "+ String.join("-", tablePKs.get(key)));
        }
    }
}
