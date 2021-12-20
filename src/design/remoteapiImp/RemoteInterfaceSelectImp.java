package design.remoteapiImp;

import java.rmi.RemoteException;

import design.entity.Course;
import design.entity.Faculty;
import design.entity.Grade;
import design.entity.Student;
import design.entity.Teacher;
import design.factory.CourseFactory;
import design.factory.FacultyFactory;
import design.factory.GradeFactory;
import design.factory.StudentFactory;
import design.factory.TeacherFactory;
import design.remoteapi.RemoteInterfaceSelect;
import design.serverImp.RepositoryImp;

public class RemoteInterfaceSelectImp implements RemoteInterfaceSelect{
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
            default:
                break;
        }
        return res;
    }
}
