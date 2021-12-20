package design.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import design.util.DBCon;

/**
 * @author: hekai
 * @Date: 2021/12/1
 */
public class RealOperator implements SqlOperator{

    @Override
    public void execute(String sql) throws SQLException {
        Connection connection=DBCon.getInstance().getConnection();
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.execute();
    }

    @Override
    public String getStringByKeyWord(String key,String sql) {
        String res=null;
        Connection connection=DBCon.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet st=preparedStatement.executeQuery();
            while(st.next()){
                res=st.getString(key);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return res;
    }

    // @Override
    
    // public ResultSet getResultSet(String sql) throws SQLException {
    //     Connection connection=DBCon.getInstance().getConnection();
    //     PreparedStatement statement=connection.prepareStatement(sql);
    //     // System.out.println(sql);
    //     statement.execute();
    //     ResultSet resultSet=statement.executeQuery();
    //     int length=resultSet.getMetaData().getColumnCount();
    //     System.out.println(length);
    //     // ArrayList<String> arrayList=new ArrayList<>(length);
    //     while(resultSet.next()){
    //         int i=1;
    //         while(i<=length){
    //             System.out.println(resultSet.getString(i++));
    //         }
    //     }
    //     return resultSet;
    // }
    
}
