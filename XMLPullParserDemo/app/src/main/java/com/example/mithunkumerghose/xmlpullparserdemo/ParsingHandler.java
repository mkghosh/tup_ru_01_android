package com.example.mithunkumerghose.xmlpullparserdemo;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mithun Kumer Ghose.
 */

public class ParsingHandler {

    private List<Student> studentArrayList = new ArrayList<>();
    private Student student;
    private String text;

    public List<Student> getStudents() {
        return studentArrayList;
    }

    public List<Student> parse(InputStream is) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser parser = factory.newPullParser();

            parser.setInput(is, null);

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("student")) {
                            // create a new instance of employee
                            student = new Student();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("student")) {
                            studentArrayList.add(student);
                        }else if (tagname.equalsIgnoreCase("id")) {
                            student.setId(Integer.parseInt(text));
                        }  else if (tagname.equalsIgnoreCase("name")) {
                            student.setName(text);
                        } else if (tagname.equalsIgnoreCase("subject")) {
                            student.setDepartment(text);
                        }
                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }

        } catch (XmlPullParserException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}

        return studentArrayList;
    }
}
