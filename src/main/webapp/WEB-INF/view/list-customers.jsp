<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Customers</title>

<!-- Reference our style sheet -->
   <link type="text/css"
         rel="stylesheet"
         href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
  <div id="wrapper">
     <div id="header">
        <h2>CRM-Customer Relationship Manager</h2>
     </div>
  </div>
  
  <div id="container">
    <div id="content">
        <!-- add our html table here -->
        <table>
           <tr>
               <th>First Name</th>
               <th>Last Name</th>
               <th>Email</th>
           </tr>
           
           <!-- loop over and print the customers -->
           <c:forEach var="tempCustomer" items="${customers}">
           <tr>
                <td>${tempCustomer.firstName}</td>
                <td>${tempCustomer.lastName}</td>
                <td>${tempCustomer.email}</td>
           </tr>
           </c:forEach>
        </table>
    </div>
  </div>

</body>
</html>