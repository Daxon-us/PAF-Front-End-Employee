<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>

<title>Payments</title>
</head>
<body>


	<div class="container">
		 <div class="row">
			 <div class="col-8">
			 
				 <h1 class="m-3">Employee details</h1>
				 <form id="formEmployee">
				 
				 	<!-- EmployeeName -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblEmployeeName">Employee Name: </span>
						</div>
						
						<input type="text" id="txtEmployeeName" name="txtEmployeeName">
					</div>
					
					<!-- Type -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblType">Employee Type: </span>
						</div>
						
						<input type="text" id="txtType" name="txtType">
					</div>
					
					<!-- employeeEmail -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblEmployeeemail">Employee Email: </span>
						</div>
						
						<input type="text" id="txtEmployeeEmail" name="txtEmployeeEmail" placeholder="Enter Email">
					</div>
					
					<!-- employeePassword -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblPassword">Employee Password: </span>
						</div>
						
						<input type="text" id="txtEmployeePassword" name="txtEmployeePassword" placeholder="Enter Password">
					</div>

					
					<!-- employeePhone -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblEmployeePhone">Employee Phone: </span>
						</div>
						
						<input type="text" id="txtEmployeePhone" name="txtEmployeePhone" placeholder="Enter Phone">
					</div>




					
					
					<div id="alertSuccess" class="alert alert-success"></div>
 					<div id="alertError" class="alert alert-danger"></div>
					
					
					<input type="button" id="btnSave" value="Save" class="btn btn-primary">
					<input type="hidden" id="hidEmployeeIDSave" name="hidEmployeeIDSave" value="">
				 
				 </form>
			 </div>
		 </div>
		
		 <br>
		 <div class="row">
			 <div class="col-12" id="colPayments">
			
			 </div>
		 </div>
	</div>

</body>
</html>