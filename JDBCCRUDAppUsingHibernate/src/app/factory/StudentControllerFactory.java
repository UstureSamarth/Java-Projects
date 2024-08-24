package app.factory;

import app.controller.IStudentController;
import app.controller.StudentControllerImpl;

public class StudentControllerFactory {
    private StudentControllerFactory() {

    }
    private static  IStudentController studentController=null;

    public static IStudentController getStudentController(){
        if(studentController==null){
           studentController=new StudentControllerImpl();
        }
        return  studentController;
    }

}
