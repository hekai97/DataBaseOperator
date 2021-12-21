package design.remoteapiImp;

import java.rmi.RemoteException;
import java.sql.SQLException;
import design.dao.ProxyOperator;
import design.entity.*;
import design.factory.*;
import design.remoteapi.RemoteInterface;
import design.serverImp.RepositoryImp;
import design.util.Verify;

public class RemoteInterfaceImp implements RemoteInterface {
    private ProxyOperator proxyOperator=new ProxyOperator();
    Verify verify=new Verify();
    @Override
    public void execute(String sql) throws RemoteException,SQLException {
        proxyOperator.execute(sql);
    }
    @Override
    public int verifyUserPassword(int id, String user, String password) throws RemoteException {
        return verify.verifyUserPassword(id, user, password);
    }
    @Override
    public Object[][] getResult(MYOBJECT index, String sql) throws RemoteException {
        Object[][] res=null;
        switch (index) {
            case Student:
                res=new RepositoryImp<Student>().ListToObject(new StudentFactory(), sql);
            break;
            case Teacher:
                res=new RepositoryImp<Teacher>().ListToObject(new TeacherFactory(), sql);
            break;
            case Faculty:
                res=new RepositoryImp<Faculty>().ListToObject(new FacultyFactory(), sql);
            break;
            case Grade:
                res=new RepositoryImp<Grade>().ListToObject(new GradeFactory(), sql);
            break;
            case Course:
                res=new RepositoryImp<Course>().ListToObject(new CourseFactory(), sql);
            break;
            case StudentGradeForStudent:
                res=new RepositoryImp<StudentGradeForStudent>().ListToObject(new StudentGradeFactory(), sql);
            break;
            case StudentGradeForTeacher:
                res=new RepositoryImp<StudentGradeForTeacher>().ListToObject(new StudentGradeForTeacherFactory(), sql);
            break;
            case CourseWithTeacher:
                res=new RepositoryImp<CourseWithTeacher>().ListToObject(new CourseWithTeacherFactory(), sql);
            break;
            default:
                break;
        }
        return res;
    }
    @Override
    public String getStringByKey(String key,String sql) {
        return proxyOperator.getStringByKeyWord(key, sql);
    }

}
