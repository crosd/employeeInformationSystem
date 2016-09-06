<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath}/resources/css/jquery_dataTables.css">

<script src="${ pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${ pageContext.request.contextPath}/resources/js/jquery_dataTables.js"></script>

<script src="${ pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</head>
<body>
	<jsp:include page="bar.jsp" />
	<div class=" col-md-6 col-md-offset-3 panel panel-default" style="margin-top: 4%">
	<div class="panel-heading">
	<h2 class="">employee Detail:</h2>
	</div >
	<div class= "panel-body">
		<form:form action="${pageContext.request.contextPath }/employee" method="POST"  modelAttribute="employee">

		<div class="form-group">
				<form:label path="firstName"  for ="firstName">First Name</form:label>
				<form:input path="firstName"  class="form-control" placeholder="first name" required="required"/>
		</div>
		<div class="form-group">
				<form:label path="lastName" for ="lastName">Last Name</form:label>
				<form:input path="lastName" class="form-control" placeholder=" Last name" />
		</div>
		<div class="form-group">
				<form:label path="cName" for ="cName">company name:</form:label>
				<form:input path="cName" class="form-control"  placeholder="company name"/>
		</div>	
		<div class="form-group">
				<form:label path="department" for ="department">Department</form:label>
				<form:input path="department" class="form-control" placeholder="Department" />
		</div>	
		
				<td colspan="2"><input class="btn btn-info col-md-1 col-md-offset-11" type="submit" value="Save" />
				<form:hidden path="id"/>
		</form:form> 
	</div>
	</div>
</body>
</html>