<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>${requestStatus}</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>

    <body>
        <h2>Manage Roles</h2>
        <hr/>
        <br>

        <form action = "/processRole" method = "POST">
            <div id = "roleSection">
            <c:forEach items="${roleList}" var="r">
                <div>
                        <input type="hidden" name="oldrid" value="${r.roleId}"/>
                        Role# ${r.roleId}: <input type="text" name="oldroles" value="${r.role}"/><br>
                </div>
            </c:forEach>
            <br>
            </div>
            <br>
            <input type="button" value="Add Role" id="addNewRole"/>
            <script>
                $("#addNewRole").click(function() {
                    $("#roleSection").append('<div>New Role: <input type="text" name="newroles"/>' + "<input type='button' id='remove-button' value='-'><br></div>");
                });
                $(document).on('click', '#remove-button', function() {
                        $(this).closest("div").remove();
                });
            </script> 
            <input type = "hidden" name="requestStatus" value="${requestStatus}">
            <input type = "submit" value = "Save Changes" />
        </form>
        <br>
         <form action="/listRoles">
            <button type="submit">Back</button>
        </form>
    </body>
</html>