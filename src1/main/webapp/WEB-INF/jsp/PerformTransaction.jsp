
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Perform Transaction</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<style>
	.cssClass {
		color: red;
	}
	
body{
 Margin: 0 auto;
 Width: 60%;
 background-color: #f7f7f7;
 position: relative;
 }
 table{
 position: absolute;
 }
 
 h2{
 margin-top: 100px;
 color: white;
 background-color: #3b5998;
  border-radius:10px;
 }
 
td{
width:500px;
}
span{
color: red;
}
 /*  td:hover{
 background-color: 	#dfe3ee;
font-weight: bold;
Border-radius:10px;

 } */
 button {
 	margin-top: 240px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    width:90px;
    height:50px;
    border: 2px solid #3b5998;
     }

button:hover {
    background-color: #3b5998; /* Green */
    color: white;
}
 </style>

</head>
<body ng-app="myapp">
<div ng-controller="appctrl">
<center><h2 class="h2">Perform Transaction Page</h2></center>

<form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/performtransaction" modelAttribute="Transaction" name="transactionForm">

<table>
    <tr>
    	
        <td >Transaction Description:</td>
        <td><form:input path="transactiondescription"  placeholder="Transaction Description" maxlength="30" ng-model="transactiondescription"
        required="true" ng-pattern="/^[A-Za-z\b \b]{1,30}$/"/></td>
        <td><form:errors path="transactiondescription" cssClass="error" />
        <span ng-show="transactionForm.transactiondescription.$error.required && !transactionForm.transactiondescription.$pristine">Transaction description is required</span>
        <span ng-show="transactionForm.transactiondescription.$error.pattern && !transactionForm.transactiondescription.$pristine">Only Alphabets are required</span>
        </td>
       
    </tr>
    <tr>
    
        <td>Transaction Type :</td>
        <td><form:select  path="transactiontype" maxlength="10" class="form-control" required="true"
						id="transaction type" placeholder="Transaction Type" ng-model="transactiontype">
						<option value="" disabled selected>Select account type</option>
						<option value="deposit">Deposit</option>
						<option value="withdrawl">Withdrawl</option>
						</form:select></td>
        <td><form:errors path="transactiontype" cssClass="error" />
        
        </td>
       
    </tr>
    <tr>
   
        <td>Transaction Amount :</td>
        <td><form:input  path="transactionAmount"  placeholder="Transaction Amount" maxlength="10"  ng-pattern="/^[0-9\b.\b]{1,10}$/" ng-model="transactionAmount" required="true"/>
        </td>
        <td><form:errors path="transactionAmount" cssClass="error" />
        <span ng-show="transactionForm.transactionAmount.$error.required && !transactionForm.transactionAmount.$pristine">Transaction Amount Is Required</span>
        <span ng-show="transactionForm.transactionAmount.$error.pattern && !transactionForm.transactionAmount.$pristine">Numeric Inputs Only</span></td>
       
    </tr>
    <!-- <tr>
    <td></td>
       <td colspan="2"><input type="submit" value="Add"></td>
    </tr> -->
</table>
		<center><button  type="submit" value="Add" >Add</button></center>
	
</form:form>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js">
</script>
<script>
 var app=angular.module('myapp', []);
 app.controller('appctrl', function($scope){
	 $scope.transactiondescription="";
	 $scope.transactiontype=""; 
	 $scope.transactionAmount="";
	 
 })
</script>
</body>

</html>