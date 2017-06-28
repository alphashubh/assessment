<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Loan details</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">

<style>
 body{
 Margin: 0 auto;
 Width: 70%;
 background-color: #f7f7f7;
 }
 
 div{
 	
 	 background-color: #dfe3ee;
 	 border-radius:10px;
 }
 h2{
 margin-top: 100px;
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
 td:hover{
 background-color: 	#dfe3ee;
font-weight: bold;
 }
 input:hover{
 background-color: 	#dfe3ee;
 
 }
 </style>
</head>
<body>

<form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/viewHomeloan" >


 <body ng-app="myApp" >
 <center><h2>Loan details</h2></center>
    <div ng-controller="EmpCtrl">
       
      <input type="text" ng-model="search.homeLoanId" placeholder="Search By homeLoanId" maxlength="50"/>
       <hr/>

        <table>
        <th>Sr. No.</th>
        <th>Account Holder Name</th>
        <th>HomeLoan Id</th>
        <th>loan Account Number </th>
        <th>loan Amount</th>
        <th>Company Name</th>
        <th>Designation</th>
      
        
            <tr ng-repeat="homeloan in List | filter: search">
                <td>{{$index + 1}}</td>
                <td>{{data[0].accountHolderName}}</td>
                <td>{{homeloan.homeLoanId}}</td>
                <td>{{homeloan.loanAccountNumber}}</td>
                <td>{{homeloan.loanAmount}}</td>
                 <td>{{homeloan.companyName}}</td>
                  <td>{{homeloan.designation}}</td>
            </tr>
        </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
            $http({
              method: 'GET',
              url: 'viewHomeloan1?msg=${msg}'
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
            	$scope.data = data;
            	$scope.List = data[0].homeLoan;
            })
        
           
        })
    </script>
    </form:form>
</body> 