<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<!DOCTYPE html>
<html>
	<header>
		<title>Lista de clientes</title>
		<link type="text/css" rel="styleSheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
		
	</header>
	<body>
	 	
	 	<div id="wrapper">
	 		<div id="header">
	 			<h2>CRM - Customer Relationship Manager</h2>
	 		</div> 		
	 	</div>
	 	
		<div id="container" >
			<div id="content">
				
				<!-- Form de consulta -->
				<form action="list"  method="get" >
					<tr>
						<td><input type="search" name="paramName"/></td>
						<td><input type="submit" value="Search"  class="save"/></td>
					</tr>
				</form>
			 
				<!-- Add botão add custoemr  -->
				<input type="button" value="Add Customer" 
					onclick="window.location.href='showFormForAdd'; return false;" 
					class="add-button"
				/> 	
			
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>   
						<th>Action</th> 
					</tr>
					<c:forEach var="tempCustomer" items="${customers}">
						
						<!-- Criar variavel com link p atualizar -->
						<c:url value="showFormForUpd" var="updateLink">
							<c:param name="customerId" value="${tempCustomer.id}"/>
						</c:url>
						
						<!-- Criar variavel com link p deletar -->
						<c:url value="showFormForDel" var="deleteLink">
							<c:param name="customerId" value="${tempCustomer.id}"/>
						</c:url>
						
						
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>		
							<td>
								<a href="${updateLink}" >Update</a> 
								<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want delete thiscustomer?'))) return false">Delete</a> 
							</td>			
					</c:forEach>
				</table>
			</div>
		
		</div> 
	
	</body>
</html>