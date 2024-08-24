package app.factory;

import app.dao.IStudentDao;
import app.dao.StudentDaoImpl;

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
