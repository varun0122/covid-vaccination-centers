<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COWIN - Vaccine Center Creation</title>
</head>
<body>
	<h1>COWIN - Vaccine Center Creation</h1>
	<form action="SaveVaccineCenterServlet" method = "post">
	<table>
		<tr><td>Center Name</td><td><input type="text" name="centerName"/></td></tr>
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
		<tr><td colspan="2"><input type="submit" value="Register Vaccine Center"/></td></tr>
	</table>
	</form>
</body>
</html>