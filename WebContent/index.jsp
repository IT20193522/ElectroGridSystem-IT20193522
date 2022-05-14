<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Users/jquery-3.2.1.min.js"></script>
<script src="Users/users.js"></script>
</head>
<body>
<div class = "contanier">
<div class="row">
		<div class="col-lg-12">
			<div class="card m-b-32">
				<div class="card-body">

					<form id="formUser" name="formUser" method="post"
						action="index.jsp">

						<label>Name</label> <input id="name"
							name="name" type="text"
							class="form-control form-control-sm">
							<br> 
							<label>Date</label><input id="date"
							name="date" type="text"
							class="form-control form-control-sm">
							<br>
							<label>NIC</label><input id="nic"
							name="nic" type="text"
							class="form-control form-control-sm">
						
							<br><label>Password</label> <input id="password" name="password"
							type="text" class="form-control form-control-sm"> 
							
							
							 <br>
							 <input id="btnSave" name="btnSave" type="button" value="Save"
							class="btn btn-primary"> <input type="hidden"
							id="iduser" name="iduser" value="">
					</form>
					<br>
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					<br> <br>
					
					<div id="divUserGrid">
						<%
						User empObj = new User();
											out.print(empObj.readUser());
						%>
					</div>
				</div>
</div>
</div>
</div>

</div>
</body>
</html>