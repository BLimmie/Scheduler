package servlet;

import java.util.ArrayList;

/**
 * Created by brian on 6/7/2018.
 */
public class ArrayResponse {
    private Course[] response;


    public ArrayResponse(ArrayList<Course> courses) {
        response = (Course[])courses.toArray();
    }
}
