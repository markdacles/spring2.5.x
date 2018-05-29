import java.util.*;
import java.util.stream.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

@WebServlet(value = "/addContact")
public class AddContact extends HttpServlet{
   	
   	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

			Personnel p = new PersonnelService().findById(Long.parseLong(request.getParameter("personnelid")));
			Contact contact = new Contact(request.getParameter("landline"),request.getParameter("mobile"),request.getParameter("email"));
	        p.getContact().add(contact);
	        new ContactService().addContactToPersonnel(p);

	       	response.sendRedirect("/contactmgt?personnelId="+Long.parseLong(request.getParameter("personnelid")));

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {

    	request.setAttribute("personnelid", request.getParameter("personnelid"));

    	request.getRequestDispatcher("newcontactform.jsp").forward(request,response);

    }
}