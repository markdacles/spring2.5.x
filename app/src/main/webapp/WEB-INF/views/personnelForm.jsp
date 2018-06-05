<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>${requestStatus}</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>

    <body>
        <h2>Personnel Form</h2>
        <hr/>
        <br>

        <form action = "/processPersonnel" method = "POST">
            First Name:
                <input type = "text" name = "fname" value="${personnel.name.fname}" maxlength="20"><br/> 
            Middle Name:
                <input type = "text" name = "mname" value="${personnel.name.mname}" maxlength="20"/><br/>
            Last Name:
                <input type = "text" name = "lname" value="${personnel.name.lname}" maxlength="20"/><br/>
            Barangay:
                <input type = "text" name = "barangay" value="${personnel.address.brgy}" maxlength="20"/><br/>
            City:   
                <input type = "text" name = "city" value="${personnel.address.city}" maxlength="20"/><br/>
            Birthday:
                <input type = "date" name = "birthday" value="${personnel.birthday}" /><br/><br/>
            GWA:
                <input type = "number" min="1" max="5" step = "0.01" name = "gwa" value="${personnel.gwa}"/><br/>
            Date Hired:
                <input type = "date" name = "date_hired" value="${personnel.dateHired}"/><br/><br/>

            Landline: 
                <input type="button" value="+" id="addLandline"/> </br> 
            Mobile: 
                <input type="button" value="+" id="addMobile"/> </br>
            Email: 
                <input type="button" value="+" id="addEmail"/> <br>
            <br>
            <div id = "contactSection">
            <c:forEach items="${personnel.contact}" var="c">
                <div>
                    <input type="hidden" name="contactType" value="${c.contactType}"/>${c.contactType} : 
                        <input type="text" name="contactDetails" value="${c.contactDetails}"/><input type='button' id='remove-button' value='-'><br>
                </div>
            </c:forEach>
            </div>

            <script>
                $("#addLandline").click(function() {
                    $("#contactSection").append('<div>' + '<input type="hidden" name="contactType" value="Landline"/>Landline : ' + '<input type="text" name="contactDetails"/>' + "<input type='button' id='remove-button' value='-'><br></div>");
                });

                $("#addMobile").click(function() {
                       $("#contactSection").append('<div>' + '<input type="hidden" name="contactType" value="Mobile"/>Mobile : ' + '<input type="text" name="contactDetails"/>' +  "<input type='button' id='remove-button' value='-'><br></div>");
                });

                $("#addEmail").click(function() {
                   $("#contactSection").append('<div>' + '<input type="hidden" name="contactType" value="Email"/>Email : ' + '<input type="text" name="contactDetails"/>' +  "<input type='button' id='remove-button' value='-'><br></div>");
                });

                $(document).on('click', '#remove-button', function() {
                        $(this).closest("div").remove();
                });
            </script> 

            <br>
            Roles:<br>

                <c:forEach items="${roleList}" var="r">
                    <c:set var="checked" value="${personnel.roles.contains(r) ? 'checked' : ''}"/>
                    <input type="checkbox" name="checkedRoles" value="${r.roleId}" ${checked}/>${r.role}<br/>
                </c:forEach>
            <br/>
            <input type = "hidden" name="pid" value="${personnel.id}">
            <input type = "hidden" name="requestStatus" value="${requestStatus}">
            <input type = "submit" value = "${requestStatus}" />
        </form>
        <br>
         <form action="/listPersonnel">
            <button type="submit">Back</button>
        </form>
    </body>
</html>