/*

 */
import java.io.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author kubaj
 */
@WebServlet("/timezone")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String input = request.getParameter("zone");
        Set<String> zones = ZoneId.getAvailableZoneIds();
        
        String text = null;
        for (String s : zones) {
            if(s == null) {
                text = "Neplatna jmeno";
                break;
            } else {
                ZoneId zone = ZoneId.of(input);
                ZonedDateTime now = ZonedDateTime.now(zone);
                text = "Cas: " + now;
            }
        }
        out.println("<html><body>");
        out.println(text);
        out.println("</body></html>");
    }
           
    
    
}

