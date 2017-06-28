<html>
<head>
<title>Home</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
<style>
body {
	Margin: 0 auto;
	Width: 70%;
	background-color: #f7f7f7;
}

.operation {
	Margin: 100px 200px;;
}

button {
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
	width: 400px;
	height: 40px;
	border: 2px solid #3b5998;
	display: inline-table;
	background-color:#dfe3ee;
	border-radius:10px;
	
}


button:hover {
	
	background-color: #3b5998;
}

.table td{
text-align:center;
color: white;
}

h2 {
	margin-top: 100px;
	color: white;
	background-color: #3b5998;
	border-radius: 10px;
}

div {
	border-radius: 10px;
	background-color: #dfe3ee;
}

th{
background-color:#8b9dc3;
border-radius: 10px;
}
td {
	border-radius: 10px;
	background-color: #f7f7f7;
}

td a:hover{
color: white;
}

td:hover {
	font-weight: bold;
}

input:hover {
	background-color: #dfe3ee;
}
</style>
</head>
<body ng-app="myApp">


	<div ng-controller="EmpCtrl">

		<h2 align="center">Welcome</h2>
		<h3>

			<hr />

			<table>
			<tr ">
					<th>S.NO</th>
					<th>Account Number</th>
					<th>Account Type</th>
					<th>Account Holder Name</th>
					<th>Account Balance</th>

				</tr>
				<tr ng-repeat="user in List | filter: search">
					<td>{{$index + 1}}</td>
					<td>{{user.accountNumber}}</td>
					<td>{{user.accountType}}</td>
					<td>{{user.accountHolderName}}</td>
					<td>{{user.accountBalance}}</td>

				</tr>
			</table>

		</h3>
	</div>
	
		<table class="table">
			<tr>
				<td><button>
						<a
							href="performtransaction?msg=${msg}">Perform
							Transaction</a>
					</button></td>
			
					<td>
				<button>
						<a
							href="viewtransaction?msg=${msg}">View
							Transaction</a>
					</button></td></tr>
			<tr>
				<td><button>
						<a
							href="addEducationLoan?msg=${msg}">Apply
							Education Loan</a>
					</button></td>
				<td><button>
						<a
							href="view?msg=${msg}">View
							Education Loan</a>
					</button></td>
			</tr>

			<tr>
				<td><button>
					<a
						href="applyHomeLoan?msg=${msg}">Apply
						Home Loan</a>
				</button></td>
				<td><button>
					<a
						href="viewHomeloan?msg=${msg}">View
						Home Loan</a>
				</button></td>
			</tr>
			tr>
				<td><button>
					<a
						href="scheduletraining">Schedule Training</a>
				</button></td>
				
			</tr>
		</table>
	

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	<script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
            $http({
              method: 'GET',
              url: 'homepage?accountNumber=${msg}'
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
           $scope.List = data;
            })
         })
    </script>

</body>
</html>