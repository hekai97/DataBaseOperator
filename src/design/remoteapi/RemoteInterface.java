package design.remoteapi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
public interface RemoteInterface extends Remote {
    public void execute(String sql) throws RemoteException,SQLException;
    public int verifyUserPassword(int id,String user, String password) throws RemoteException;
    public enum MYOBJECT{Student,Teacher,Faculty,Grade,Course,StudentGradeForStudent,StudentGradeForTeacher,CourseWithTeacher};
    public Object[][] getResult(MYOBJECT index, String sql) throws RemoteException;
    public String getStringByKey(String key,String sql) throws RemoteException;
}