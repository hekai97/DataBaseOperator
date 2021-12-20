package design.dao;

import java.sql.SQLException;

/**
 * @author: hekai
 * @Date: 2021/12/1
 */
public interface SqlOperator {
    public void execute(String sql) throws SQLException;
    public String getStringByKeyWord(String key,String sql);
}