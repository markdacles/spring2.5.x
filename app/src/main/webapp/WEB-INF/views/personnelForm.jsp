<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>Personnel Form</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    </head>

    <body>
        <h2>Add Personnel</h2>
        <hr/>
        <br>

        <form action = "/processPersonnel" method = "POST">
            First Name:
                <input type = "text" name = "fname"><br/> 
            Middle Name:
                <input type = "text" name = "mname" maxlength="20"/><br/>
            Last Name:
                <input type = "text" name = "lname" maxlength="20"/><br/>
            Barangay:
                <input type = "text" name = "barangay" maxlength="20"/><br/>
            City:   
                <input type = "text" name = "city" maxlength="20"/><br/>
            Birthday:
                <input type = "date" name = "birthday"/><br/><br/>
            GWA:
                <input type = "number" min="1" max="5" step = "0.01" name = "gwa"/><br/>
            Date Hired:
                <input type = "date" name = "date_hired"/><br/><br/>

            <!-- Input landline with jquery for add and remove-->
                Landline:
                <input type="button" id="landline" value="+"/>
                 <script>
                    $("#landline").click(function(){ 
                        $("#contactNumber").append('<input type="hidden" name="contactType" value="Landline"/>Landline: ' + '<input type="text" name="contactDetails"/>' + '<button class="delete">Remove</button><br>');
                    });
                </script> 

            <!-- Input mobile with jquery for add and remove-->
            <br>Mobile:
            <input type="button" id="mobile" value="+"/>
            <script>
                $("#mobile").click(function(){ 
                    $("#contactNumber").append('<input type="hidden" name="contactType" value="Mobile"/>Mobile: ' + '<input type="text" name="contactDetails"/>' + '<button class="delete">Remove</button><br>');
                });
            </script>
            <!-- Input email with jquery for add and remove-->
            <br>Email:
            <input type="button" id="email" value="+"/>
            <script>
                $("#email").click(function(){ 
                    $("#contactNumber").append('<input type="hidden" name="contactType" value="Email"/>E-mail: ' + '<input type="text" name="contactDetails"/>' + '<button class="delete">Remove</button><br>');
                });
            </script>

           <div id="contactNumber">
                <br>
                <c:forEach var="c" items="${contact}">
                    <div>${c.contactType}: <input type="text" value="${c.contactDetails}" name="contactDetails"/> 
                    <input type="hidden" value="${c.id}" name="contactId">
                    <input type="hidden" value="${c.contactType}" name="contactType"/>
                    <button class="delete">Remove</button> <!--form:errors class="error" path="contacts"/--></div>
                </c:forEach>
            </div>

            <br>
            Roles:<br>
                <c:forEach items="${roleList}" var="r">
                    <input type="checkbox" name="checkedRoles" value="<c:out value='${r.roleId}'/>"/><c:out value="${r.role}"/><br/>
                </c:forEach>
<br/>

            <input type = "submit" value = "Add Person" />
        </form>
        <br>
         <form action="personnelmgt">
            <button type="submit">Back</button>
        </form>
    </body>
</html>