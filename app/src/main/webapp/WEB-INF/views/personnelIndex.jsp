<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>Manage Personnel</title>
    </head>

    <body>
        <h2>Manage Personnel</h2>
         <hr/>
        <form action="/addPersonnel">
            <button type="submit">Add Personnel</button>
        </form>

        <div>
            <table border = "1" width = "100%">
                <tr bgcolor = "#D3D3D3">
                    <th><a href = "/personnelmgt?sortby=<c:out value='id'/>" >ID</a></th>
                    <th><a href = "/personnelmgt?sortby=<c:out value='name'/>" >Name</a></th>
                    <th><a href = "/personnelmgt?sortby=<c:out value='address'/>" >Address</a></th>
                    <th><a href = "/personnelmgt?sortby=<c:out value='bday'/>" >Birthday</a></th>
                    <th><a href = "/personnelmgt?sortby=<c:out value='gwa'/>" >GWA</a></th>
                    <th><a href = "/personnelmgt?sortby=<c:out value='datehired'/>" >Date Hired</a></th>
                    <th>Contact</th>
                    <th>Roles</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>

                <c:forEach items = "${personnelList}" var = "p">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name.lname}, ${p.name.fname} ${p.name.mname}</td>
                        <td>${p.address.brgy}, ${p.address.city}</td>
                        <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${p.birthday}" /></td>
                        <td>${p.gwa}</td>
                        <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${p.dateHired}" /></td>
                        <td>
                            <c:forEach items = "${p.contact}" var = "c">
                                ${c.contactType}: ${c.contactDetails}
                            </c:forEach>
                        <td><a href = "/proles?personnelId=<c:out value='${p.id}'/>" >View Roles</a></td>
                        <td><a href = "/updatePersonnel?personnelId=<c:out value='${p.id}'/>" >Update Person</a></td>
                        <td valign="bottom">
                            <form name="${p}" action="/deletePersonnel?personnelid=<c:out value='${p.id}'/>" method="POST">
                                <a href="javascript:document.forms['${p}'].submit()">Delete Personnel</a>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <br>
         <form action="/">
            <button type="submit">Back</button>
        </form>
    </body>
</html>