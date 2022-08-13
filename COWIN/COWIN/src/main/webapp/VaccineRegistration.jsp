<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COWIN - Vaccine Registration</title>
</head>
<body>
	<h1>COWIN - Vaccine Center Creation</h1>
	<form action="VaccineRegistrationServlet" method = "post">
	<table>
		<tr><td>User Name</td><td><input type="text" name="userName"/></td></tr>
		<tr><td>Vaccine Dose</td><td>
			<select name="vaccineDose" style="width:150px">  
				<option Value = "1">First Dose</option>  
				<option Value = "2">Second Dose</option> 
			</select>  
		</td></tr>
		<tr><td>State</td><td>
			<select name="state" id = "state" style="width:250px">  
				<option>Select State</option>  
				<jsp:include page="/StateServlet"/>
			</select>  
		</td></tr>
		<tr><td>District</td><td>
			<select name="district" style="width:250px">  
				<option>Select District</option>  	
				<jsp:include page="/DistrictServlet">
					<jsp:param name="stateID" value="2"/>
				</jsp:include>
			</select>  
		</td></tr>
		<tr><td>Vaccine Center</td><td>
			<select name="vaccineCenter" style="width:250px">  
				<option>Select Vaccine Center</option>  	
				<jsp:include page="/VaccineCenterServlet"/>
			</select>  
		</td></tr>
		<tr><td colspan="2"><input type="submit" value="Register Vaccine"/></td></tr>
	</table>
	</form>
</body>
</html>
