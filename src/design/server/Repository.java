package design.server;

import design.factory.ModelFactory;
import java.util.List;

/**
 * @author: hekai
 * @Date: 2021/11/27
 */
public interface Repository<E> {
    public List<E> getResult(ModelFactory factory,String sql);
    public int getTableNameLength(String sql);
    public Object[][] ListToObject(ModelFactory factory,String sql);
}