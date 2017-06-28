<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Schedule Training</title>
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
 	margin-top: 500px;
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
<center><h2 class="h2">Schedule Training Page</h2></center>

<form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/scheduletraining" modelAttribute="schedule" name="transactionForm">

<table>
    <tr>
    	
        <td >Trainer Id:</td>
        <td><form:input path="trainerInfo.trainerId"  placeholder="TrainerId" maxlength="30" ng-model="trainerId"
        required="true" /></td>
     
    </tr>
  <tr>
    	
        <td >Trainer Name:</td>
        <td><form:input path="trainerInfo.traineName"  placeholder="traineName" maxlength="30" ng-model="traineName"
        required="true" /></td>
     
    </tr>    
    <tr>
    	
        <td >College Name:</td>
        <td><form:input path="trainerInfo.collegeName"  placeholder="collegeName" maxlength="30" ng-model="collegeName"
        required="true" /></td>
     
    </tr>
    <tr>
    	
        <td >Domain:</td>
        <td><form:input path="trainerInfo.domain"  placeholder="domain" maxlength="30" ng-model="domain"
        required="true" /></td>
     
    </tr>
    <tr>
    	
        <td >Start Date:</td>
        <td><form:input path="scheduleTraining.startDate"  placeholder="startDate" maxlength="30" ng-model="startDate"
        required="true" /></td>
     
    </tr>
    <tr>
    	
        <td >Duration:</td>
        <td><form:input path="scheduleTraining.duration"  placeholder="duration" maxlength="30" ng-model="duration"
        required="true" /></td>
     
    </tr>
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