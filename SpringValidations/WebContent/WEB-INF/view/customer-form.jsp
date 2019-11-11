<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCType html>
<html>
<head>
	<title>Customer form</title>
	<style>
		.error {color:red}
	</style>
</head>
<body>
<i>Fill out the form. Asterisk is reqiuerid!</i>
 <br><br>
	<form:form action="processForm" modelAttribute="customer">
		
		First Name:<form:input path="firstName"/>
		<br><br>
		Last Name: (*)<form:input path="lastName" />
		<form:errors path="lastName" cssClass="error"/>		 	
		<br><br>
		
		Course code:<form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"/>		 	
		<br><br>
		
		Preço: <form:input path="price" />
			<form:errors path="price" cssClass="error"></form:errors>
		<br><br>
		Pais:<form:select path="pais" items="${theCountry}"/>
		
		<br><br>  		
		Languages:<br>
		<form:checkboxes path="language" items="${customer.optionLang}" />
		<br><br>
		<form:radiobuttons path="radioBotao" items="${customer.optionLang}" />
		<br><br>
		<input type="submit" value="Submit" />
	</form:form>
	<br><br>
	<form action="/SpringValidations/">
		<input type="submit" value="Inicio">
	</form>	
</body>
</html>
