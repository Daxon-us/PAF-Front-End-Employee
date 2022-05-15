 $(document).ready(function()
{
	if ($("#alertSuccess").text().trim() == "")
	 {
	 	$("#alertSuccess").hide();
	 }
	 $("#alertError").hide(); 

}); 


$(document).on("click", "#btnSave", function(event)
{
	//Clear status msges---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	
	//Form validation-------------------
	var status = validateEmployeeForm();
	
	//If not valid
	if (status != true)
	{
		 $("#alertError").text(status);
		 $("#alertError").show();
		return;
	}
	
	//If valid
	$("#formEmployees").submit();
	
	var type = ($("#hidEmployeeIDSave").val() == "") ? "POST" : "PUT";

	$.ajax(
 	{
 		url : "EmployeesService",
 		type : type,
 		data : $("#formEmployees").serialize(),
 		dataType : "text",
 		complete : function(response, status)
 		{
 			onEmployeeSaveComplete(response.responseText, status);
 		}
 	}); 
});



function onEmployeeSaveComplete(response, status)
	{
		if (status == "success")
		{
			 var resultSet = JSON.parse(response);
 			 if (resultSet.status.trim() == "success")
			 {
 				$("#alertSuccess").text("Successfully saved.");
 				$("#alertSuccess").show();
 				$("#divMeterGrid").html(resultSet.data);
 			 } 
 			 else if (resultSet.status.trim() == "error")
			 {
 				$("#alertError").text(resultSet.data);
 				$("#alertError").show();
 			 }
 		} 
 		else if (status == "error")
 		{
 			$("#alertError").text("Error while saving.");
 			$("#alertError").show();
 		} 
 		else
 		{
 			$("#alertError").text("Unknown error while saving..");
 			$("#alertError").show();
 		}
		$("#hidMeterIDSave").val("");
 		$("#formMeter")[0].reset();
}


// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
	$("#hidEmployeeIDSave").val($(this).data("empId"));
	$("#txtEmployeeName").val($(this).closest("tr").find('td:eq(0)').text());
	$("#txtEmployeeType").val($(this).closest("tr").find('td:eq(1)').text());
	$("#txtEmployeeEmail").val($(this).closest("tr").find('td:eq(1)').text());
	$("#txtEmployeePassword").val($(this).closest("tr").find('td:eq(2)').text());
	$("#txtEmployeePhone").val($(this).closest("tr").find('td:eq(3)').text());
}); 


// REMOVE==========================================
$(document).on("click", ".btnRemove", function(event)
{
	 $.ajax(
 		{
 			url : "EmployeesService",
 			type : "DELETE",
 			data : "empId=" + $(this).data("empId"),
 			dataType : "text",
 			complete : function(response, status)
 			{
 				onMeterDeleteComplete(response.responseText, status);
 			}
 		});
}); 

function onEmployeeDeleteComplete(response, status)
{
		if (status == "success")
 		{
 			var resultSet = JSON.parse(response);
 			if (resultSet.status.trim() == "success")
 			{
 				$("#alertSuccess").text("Successfully deleted.");
 				$("#alertSuccess").show();
 				$("#divMeterGrid").html(resultSet.data);
 			} 
 			else if (resultSet.status.trim() == "error")
 			{
 				$("#alertError").text(resultSet.data);
 				$("#alertError").show();
 			}
 		} 
 		else if (status == "error")
 		{
 				$("#alertError").text("Error while deleting.");
 				$("#alertError").show();
 		} 
 		else
 		{
 				$("#alertError").text("Unknown error while deleting..");
 				$("#alertError").show();
 		}
}


function validateItemForm()
{
	//employeeName
	if ($("#txtEmployeeName").val().trim() == "")
	{
		return "Insert Name";
	}
	
	//type
	if ($("#txtEmployeeType").val().trim() == "")
	{
		return "Insert Type";
	}
	
	//Email
	if ($("#txtEmployeeEmail").val() == "")
	{
		return "Insert Emaiail";
	}
	
	//Password
	if ($("#txtEmployeePassword").val() == "")
	{
		return "Insert Password";
	}

	//Phone
	if ($("#txtEmployeePhone").val() == "")
	{
		return "Insert Phone";
	}
	
	return true;
}


// function getPaymentCard(accountID, amount, payMethod, payDate)
// {
	
// 	var payment = "";
// 	payment += "<div class=\"student card bg-light m-2\" style=\"max-width: 10rem; float: left;\">";
// 	payment += "<div class=\"card-body\">";
// 	payment += "accountID: " + accountID + ",";
// 	payment += "<br>";
// 	payment += "Amount: " + amount + ",";
// 	payment += "<br>";
// 	payment += "Pay Method: " + payMethod + ",";
// 	payment += "<br>";
// 	payment += "Date: " + payDate;
// 	payment += "</div>";
// 	payment += "<input type=\"button\" value=\"Remove\" class=\"btn btn-danger remove\">";
// 	payment += "</div>";
	
// 	return payment;
// }

