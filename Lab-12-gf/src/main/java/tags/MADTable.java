package tags;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;
import model.SortMethod;
import requests.SortRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MADTable extends TagSupport {
    public int doStartTag() {
        JspWriter jw = pageContext.getOut();
        try {
            jw.println("<table border=\"1\">" +
                    "<tr>" +
                    "<th>Name</th><th>Speed</th>" +
                    "</tr>");

            SortRequest sortRequest = new SortRequest();
            ArrayList<SortMethod> methods = sortRequest.selectSorts();

            for (SortMethod method : methods) {
                jw.print("<tr><td>" + method.getName() + "</td><td>" + method.getSpeed() + "</td></tr>");
            }
            jw.println("</table>");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return EVAL_BODY_INCLUDE;
    }
}
