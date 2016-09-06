<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${ pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath}/resources/css/jquery_dataTables.css">
<script src="${ pageContext.request.contextPath}/resources/js/jquery.js"></script>
<!--  <script src="${ pageContext.request.contextPath}/resources/js/jquery_dataTables.js"></script>-->

<script src="${ pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<body class= "background-color: #fcf0;">
<jsp:include page="bar.jsp" />
<div class="col-md-6 col-md-offset-3" style ="clor:brown">
<h3>employees Information Table</h3>
<table id ="studTable" border="1" class="table table-striped" >
	<thead>
		<tr>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Company Name</th>
			<th>department</th>
			
			<th >Manupulation</th>
		</tr>
	</thead>
	
	<tbody>
			<c:forEach var="row" items="${employeeList}">
			
			<tr>
				<td>"${row.firstName }"</td>
				<td>"${row.lastName }"</td>
				<td>"${row.cName }"</td>
				<td>"${row.department }"</td>
				
				<td>
					<button class="btn btn-success" onClick="editStud(${row.id})"  >
						<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
					</button>
					<button class="btn btn-danger" onClick="deleteStud(${row.id})">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
				</td>
				
			
			</c:forEach>
	</tbody>
</table>


<c:forEach var="i" begin="0" end="${pageCount-1 }">
   
   <a href="${pageContext.request.contextPath}/listemployee/?offset=${i}">${i+1}</a>
</c:forEach>



</div>

<script type="text/javascript">
		function editStud(id){
			location.href = "${pageContext.request.contextPath}/employee/" + id + "/edit";
		}
	
		function deleteStud(id){
			var r = confirm("Are you sure you want to delete this recored?");
			if (r == true) {
				window.location = "${pageContext.request.contextPath}/" + id + "/delete";
			} 
		}
		
		$(document).ready(function(){
		    $('#studTable').DataTable();
		});
		
		
	</script>
</body>
</html>