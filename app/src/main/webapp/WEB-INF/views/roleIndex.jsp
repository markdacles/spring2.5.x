<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>Manage Roles</title>
    </head>

    <body>
        <h2>Manage Roles</h2>
         <hr/>
        <form action="/manageRoles">
            <button type="submit">Manage Roles</button>
        </form>

        <div>
            <table border = "1" width = "100%">
                <tr bgcolor = "#D3D3D3">
                    <th><a href = "/rolemgt?personnelId=<c:out value='${personnel.id}'/>&sortby=<c:out value='id'/>" >ID</a></th>
                    <th><a href = "/rolemgt?personnelId=<c:out value='${personnel.id}'/>&sortby=<c:out value='role'/>" >Role Name</a></th>
                    <th>Delete</th>
                </tr>

                <c:forEach items = "${roleList}" var = "r">
                    <tr>
                        <td>${r.roleId}</td>
                        <td>${r.role}</td>
                        <td>
                            <a href = "/deleteRole?roleid=<c:out value='${r.roleId}'/>" >Delete Role</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <br>
         <form action="index.jsp">
            <button type="submit">Back</button>
        </form>
    </body>
</html>