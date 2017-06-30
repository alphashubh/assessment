
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Schedule Weekly Training</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
</head>

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
 h4{
 	padding-top:20px;
 	padding-left:20px;
 }
 button {
 	
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
<body ng-app="myApp">
 <center><h2>Schedule Weekly Training</h2></center>
 <div ng-controller="EmpCtrl">
 <center>

 	<h4>Start Date:<input  placeholder="Enter the date" path="scheduleTraining.startDate" ng-model="startDate"></h4>
 	<h3></h3>
 	</center>
 	<center><button ng-click="getschedule(startDate)">Search</button></center>
    
      
 
       <hr/>

        <table>
        <tr ">
					<th>S.NO</th>
					<th>Trainer Name</th>
					<th>College</th>
					<th>Domain</th>
					<th>Start Date</th>
					<th>Duration</th>

				</tr>
            <tr ng-repeat="schedule in t | filter: search">
            	<td>{{$index + 1}}</td>
                <td>{{schedule.trainerInfo.traineName}}</td>
                <td>{{schedule.trainerInfo.collegeName}}</td>
                <td>{{schedule.trainerInfo.domain}}</td>
                <td>{{schedule.startDate}}</td>
                <td>{{schedule.duration}}</td>
            </tr>
        </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.js"></script>
    <script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
        	$scope.getschedule=function(startDate){
        		console.log("11111111111111111111111111110000000000000");
            $http({
              method: 'GET',
              url: 'viewschedule1',
              params:{"startDate":startDate}
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
            	$scope.t = data;
            })
        
        	};
        })
    </script>
</body>
</html>