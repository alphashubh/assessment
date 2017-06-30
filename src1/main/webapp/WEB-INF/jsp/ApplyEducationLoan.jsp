<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Apply Education Loan</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<style>
	.cssClass {
		background-color: red;
	}
	body{
 Margin: 0 auto;
 Width: 90%;
 background-color: #f7f7f7;
 }
 
 /* div{
 	
 	 background-color: #dfe3ee;
 	 border-radius:10px;
 	 height: 410px;
 } */
 h2{
	Margin-top:100px;
 color: white;
 background-color: #3b5998;
  border-radius:10px;
 }
th{
background-color:#8b9dc3;
border-radius: 10px;
}
 td{
  border-radius:10px;
	background-color: 	#f7f7f7;
	
 }
 tr{
 height:10px;
 }
 /* td:hover{
 background-color: 	#dfe3ee;
font-weight: bold;
 } */
 input:hover{
 background-color: 	#dfe3ee;
 
 }
 span{
color: 	red;
 
 }
  button {
 	margin-top: 20px;
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
<body ng-app="myApp">
<div ng-controller="appController">
<form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/addEducationLoan" modelAttribute="loan" name="userForm">

<center><h2>Loan Aplication</h2></center>

<table>
<tr>
	<td>
<table>
	
    <tr>
        <td>Loan Amount :</td>
        <td><form:input path="eduLoanAmount" placeholder="Loan Amount" maxlength="15" ng-model="eduLoanAmount" required="true" ng-pattern="/^[0-9\b.\b]{1,15}$/"/>
       	</td>
        <td><form:errors path="eduLoanAmount" cssClass="error" />
         <span ng-show="userForm.eduLoanAmount.$error.required && !userForm.eduLoanAmount.$pristine" class="help-block">Required Field.</span>
        <span ng-show="userForm.eduLoanAmount.$error.pattern && !userForm.eduLoanAmount.$pristine" class="help-block">Invalid Input</span></td>
    </tr>
   
    <tr>
          <%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");%>
          <td class="C">Loan Apply Date  :</td>
          <td><form:input path="eduLoanApplyDate" type="hidden" value="<%= df.format(new java.util.Date())%>"  disabled="disabled"/><%= df.format(new java.util.Date())%></td>
       
          <td><form:errors path="eduLoanApplyDate" cssClass="error" /></td>
      </tr>
      <tr>
       
        <td>Loan Duration:</td>
        <td><form:select  path="eduLoanDuration" maxlength="10" class="form-control"
						id="education loan"  >
						<option value="" disabled selected>Select Loan Duration</option>
						<option value="5">5</option>
						<option value="10">10</option>
						</form:select></td>
        <td><form:errors path="eduLoanDuration" cssClass="error" /></td>
    </tr>
    
     <tr>
        <td>Father's Annual Income :</td>
        <td><form:input path="fatherAnnualIncome" placeholder="Annual Income" maxlength="15" ng-model="fatherAnnualIncome" required="true" ng-pattern="/^[0-9\b.\b]{1,15}$/" />
        
        </td>
        <td><form:errors path="fatherAnnualIncome" cssClass="error" />
        <span ng-show="userForm.fatherAnnualIncome.$error.required && !userForm.fatherAnnualIncome.$pristine" class="help-block">Required Field.</span>
        <span ng-show="userForm.fatherAnnualIncome.$error.pattern && !userForm.fatherAnnualIncome.$pristine" class="help-block">Invalid Input.</span></td>
    </tr>
   
    </table>
    </td>
    <td>
    <table>
   
     <tr>
        <td>Course Fee :</td>
        <td><form:input path="courseFee" placeholder="Course Fee" maxlength="15" ng-model="courseFee" required="true" ng-pattern="/^[0-9\b.\b]{1,15}$/"/>
        
        </td>
        <td><form:errors path="courseFee" cssClass="error" />
        <span ng-show="userForm.courseFee.$error.required && !userForm.courseFee.$pristine" class="help-block">Required Field.</span>
        <span ng-show="userForm.courseFee.$error.pattern && !userForm.courseFee.$pristine" class="help-block">Invalid Input.</span></td>
    </tr>
     <tr>
        <td>Course Name :</td>
        <td><form:input path="courseName" placeholder="Course Name" maxlength="40" ng-model="courseName" required="true" ng-pattern="/^[A-Za-z\b \b]{1,30}$/"/>
        
        </td>
        <td><form:errors path="courseName" cssClass="error" />
        <span ng-show="userForm.courseName.$error.required && !userForm.courseName.$pristine" class="help-block">Required Field.</span>
         <span ng-show="userForm.courseName.$error.pattern && !userForm.courseName.$pristine" class="help-block">Invalid Input.</span></td>
    </tr>
     <tr>
        <td>Father's Name :</td>
        <td><form:input path="fatherName"  placeholder="Father's Name" maxlength="40" ng-model="fatherName" required="true" ng-pattern="/^[A-Za-z\b \b]{1,30}$/"/>
        
        </td>
        <td><form:errors path="fatherName" cssClass="error" />
        <span ng-show="userForm.fatherName.$error.required && !userForm.fatherName.$pristine" class="help-block">Required Field.</span>
        <span ng-show="userForm.fatherName.$error.pattern && !userForm.fatherName.$pristine" class="help-block">Invalid Input.</span></td>
    </tr>
     <tr>
        <td>Id Card Number :</td>
        <td><form:input path="idCardNumber"  placeholder="ID Number" maxlength="16" ng-model="idCardNumber" required="true" ng-pattern="/^[0-9]{1,16}$/"/>
        
        </td>
        <td><form:errors path="idCardNumber" cssClass="error" />
        <span ng-show="userForm.idCardNumber.$error.required && !userForm.idCardNumber.$pristine" class="help-block">Required Field.</span>
        <span ng-show="userForm.idCardNumber.$error.pattern && !userForm.idCardNumber.$pristine" class="help-block">Invalid Input.</span></td>
    </tr>
    
   </table>
   <td>
    </tr>
   <!--  <tr>
        <td colspan="2"><input type="submit" value="Add"></td>
    </tr> -->
</table>
<center><button type="submit" value="Add" ng-disabled="userForm.$invalid">Add</button></center>

</form:form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script>
var app = angular.module('myApp', []);
app.controller('appController', function($scope){
	
	$scope.eduLoanAmount = "";
	$scope.fatherAnnualIncome = "";
	$scope.courseFee = "";
	$scope.courseName = "";
	$scope.fatherName = "";
	$scope.idCardNumber = "";
	 
})


</script>
</body>
</html>