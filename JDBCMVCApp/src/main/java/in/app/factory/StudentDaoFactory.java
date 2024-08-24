package in.app.factory;

import in.app.dao.IStudentDao;
import in.app.dao.StudentDaoImpl;

public class StudentDaoFactory {
    private StudentDaoFactory() {

    }
    private static IStudentDao studentDao=null;

    public static IStudentDao getStudentDao(){
        if(studentDao==null){
            studentDao=new StudentDaoImpl();
        }
        return  studentDao;
    }
}
