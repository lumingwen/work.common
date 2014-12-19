/**
 * 
 */
package com.hlvtech.ubing.common.page;

import java.util.List;

import org.apache.log4j.Logger;

import com.github.miemiedev.mybatis.paginator.dialect.Dialect;
import com.github.miemiedev.mybatis.paginator.domain.Order;

/**
 * 自定义分页处理器
 * @author zhangxujun
 * 
 *
 */
public class MySQLDialect extends Dialect {
    
    private final Logger log = Logger.getLogger(getClass());
    
    @Override
    public boolean supportsLimitOffset()
    {
      return true;
    }
    
    @Override
    public boolean supportsLimit()
    {
      return true;
    }
    
    @Override
    public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder)
    {
      if (offset > 0) {
        return sql + " limit " + offsetPlaceholder + "," + limitPlaceholder;
      }
      return sql + " limit " + limitPlaceholder;
    }
    
    @Override
    public String getCountString(String sql)
    {
//	try{
//		CCJSqlParserManager parserManager = new CCJSqlParserManager();
//		PlainSelect plainSelect = (PlainSelect) ((Select) parserManager.parse(new StringReader(sql))).getSelectBody();
//		
//		List<String> list = new ArrayList<String>();
//		list.add(" count(1) ");
//		plainSelect.setSelectItems(list);
//		
//		String newSql = plainSelect.toString();
//		return newSql;
//		
//	}catch(Exception e){
//	    log.error(e.getMessage(), e);
//	    return "select count(1) from (" + sql + ") tmp_count";
//	}

	
	return "select count(1) from (" + sql + ") tmp_count";
    }
    
    @Override
    public String getSortString(String sql, List<Order> orders)
    {
      if ((orders == null) || (orders.isEmpty())) {
        return sql;
      }
      StringBuffer buffer = new StringBuffer(sql+" order by ");
      for (int i=0;i<orders.size();i++){
	  Order order = orders.get(i);
	  if (i>0){
	      buffer.append(",");
	  }
	  buffer.append(order.toString());
      }
      return buffer.toString();
    }


    
    public static void main(String[] args) {
	
//	List<String> list = new ArrayList<String>();
//	list.add(" count(1) ");
//	
//	
//	CCJSqlParserManager parserManager = new CCJSqlParserManager();
//	
//	
//	String statement = IOUtils.toString(new FileInputStream("d:/sql.txt"));
//	
//	PlainSelect plainSelect = (PlainSelect) ((Select) parserManager.parse(new StringReader(statement))).getSelectBody();
//	plainSelect.setSelectItems(list);
//	System.out.println(plainSelect);
	
    }
}
