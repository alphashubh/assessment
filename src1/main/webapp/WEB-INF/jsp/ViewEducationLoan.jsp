<html>
<head>
    <title>Education Loan details</title>

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
<body ng-app="myApp">



    <div ng-controller="EmpCtrl">
    
    <h2>Account Number-{{data[0].accountNumber}}</h2>
       
      <input type="text" ng-model="search.educationLoanId" placeholder="Search By Name"/>
       <hr/>

        <table>
        <tr>
                <th>S.NO</th>
                <th>Account Holder Name</th>
                <th>Education Loan Id</th>
                <th>EduLoan Amount</th>
                <th>Course Name</th>
                <th>Father Name</th>
                
            </tr>
            <tr ng-repeat="employee in List | filter: search">
                <td>{{$index + 1}}</td>
                <td>{{data[0].accountHolderName}}</td>
                <td>{{employee.educationLoanId}}</td>
                <td>{{employee.eduLoanAmount}}</td>
                <td>{{employee.courseName}}</td>
                <td>{{employee.fatherName}}</td>
                
            </tr>
        </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
            $http({
              method: 'GET',
              url: 'viewEducationloan?msg=${msg}'
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
            	$scope.data = data;
            	$scope.List = data[0].apply;
            })
        
           
        })
    </script>
</body>
</html>