<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
	<header>
		<title>Lista de clientes</title>
	</header>
	<body>
	 
	 	<div id="wrapper">
	 		<div id="header">
	 			<h2>CRM - Customer Relationship Manager</h2>
	 		</div> 		
	 	</div>
		<div id="container" >
			<div id="content">
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>   
					</tr>
					<c:forEach var="tempCustomer" items="${customers}">
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>					
					</c:forEach>
				</table>
			</div>
		
		</div> 
	
	</body>
</html>