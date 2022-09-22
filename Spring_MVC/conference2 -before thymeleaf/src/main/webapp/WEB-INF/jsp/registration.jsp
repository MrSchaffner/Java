<%--
  Created by IntelliJ IDEA.
  User: Razer
  Date: 6/14/2022
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>registration.jsp</h1>
<!-- I18N contents filled in from resources/../messages.properties-->
<form:form modelAttribute="registration"> <!--usded to be called commandName now called modelAttribute-->
    <table>
        <tr>
            <td>
                <spring:message code="name"/>:
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Add Registration">
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>
