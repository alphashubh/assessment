<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Registration Page</title>
<script></script>
<style>
	.cssClass {
		background-color: red;
	}
</style>
</head>
<body>

<form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/viewtransaction" modelAttribute="vTransaction">

   
</form:form>

</body>
</html> --%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Transaction Details</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
</head>
<form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/viewtransaction" modelAttribute="vTransaction">

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
<body ng-app="myApp">
 <center><h2>Transaction Details</h2></center>
    <div ng-controller="EmpCtrl">
      
      <input type="text" ng-model="search.transactionId" placeholder="Search By TransactionId"/>
       <hr/>

        <table>
        <tr ">
					<th>S.NO</th>
					<th>Transaction Id</th>
					<th>Transaction Description</th>
					<th>Transaction Type</th>
					<th>Transaction Account</th>

				</tr>
            <tr ng-repeat="transaction in t | filter: search">
            	<td>{{$index + 1}}</td>
                <td>{{transaction.transactionId}}</td>
                <td>{{transaction.transactiondescription}}</td>
                <td>{{transaction.transactiontype}}</td>
                <td>{{transaction.transactionAmount}}</td>
            </tr>
        </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.js"></script>
    <script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
            $http({
              method: 'GET',
              url: 'viewtransaction1?msg=${msg}'
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
            	$scope.t = data;
            })
        
           
        })
    </script>
    
    </form:form>
</body>
</html>