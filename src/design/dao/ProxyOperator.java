package design.dao;

import java.sql.SQLException;

public class ProxyOperator implements SqlOperator{
    private RealOperator realOperator=new RealOperator();
    @Override
    public void execute(String sql) throws SQLException {
        realOperator.execute(sql);
        System.out.println(sql);
    }
    @Override
    public String getStringByKeyWord(String key,String sql) {
        return realOperator.getStringByKeyWord(key, sql);
    }
}
