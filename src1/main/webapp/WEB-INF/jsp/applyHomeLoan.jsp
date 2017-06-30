<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <html>
  <head>
  <title>Apply Home Loan</title>
     <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
  
  <style>
	.error {
		color: red;
	}
	body{
 Margin: 0 auto;
 Width: 90%;
 background-color: #f7f7f7;
 }
 
/*  div{
 	
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
/* .C:hover{
 font-weight: bold;

} */
 td{
  border-radius:10px;
	background-color: 	#f7f7f7;
	
 }
 tr{
 height:10px;
 }
/*  td:hover{
 background-color: 	#dfe3ee;
font-weight: bold;
 } */
 input:hover{
 background-color: 	#dfe3ee;
 
 }
  button {
 	margin-top: 20px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    width:90px;
    height:50px;
    border: 2px solid #3b5998;
     }
span{
color: 	red;
 
 }
button:hover {
    background-color: #3b5998; /* Green */
    color: white;
}</style>
  </head>
<body ng-app="myApp">
  <div ng-controller="AppCtrl">
  <center><h2>Home Loan Application</h2></center>
  
  <form:form method="POST" commandName="/BaseCodeSlice_BankManagementSystem/mvc/applyHomeLoan" modelAttribute="homeLoan" name="userForm">

  <table>
<tr>
 
	<td>
  <table>
     
   <tr>
   

          <td class="C">Loan Amount :</td>
          <td><form:input   path="loanAmount" placeholder="Loan Amount" ng-pattern="/^[0-9/b./b]{1,15}$/" maxlength="15" ng-model="loanAmount" required="true" />
        
          </td>
          <td><form:errors path="loanAmount" cssClass="error" />
           <span ng-show="userForm.loanAmount.$error.required && !userForm.loanAmount.$pristine" >Enter Loan Amount.</span> 
          <span ng-show="userForm.loanAmount.$error.pattern && !userForm.loanAmount.$pristine" >Only Numeric input.</span>
          </td>

      </tr>
      <tr>
      
          <%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");%>
          <td class="C">Loan Apply Date  :</td>
          <td><form:input path="loanApplyDate" type="hidden" value="<%= df.format(new java.util.Date())%>"  disabled="disabled"/><%= df.format(new java.util.Date())%></td>
       
          <td><form:errors path="loanApplyDate" cssClass="error" /></td>
      </tr>
      <tr>
          <td class="C">Duration of the loan  :</td>
         <td><form:select  path="loanDuration" maxlength="2" class="form-control"
						id="loan Duration" placeholder="Loan Duration" ng-model="loanDuration" required="true">
						<option value="" disabled selected>Select Loan Duration</option>
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="15">15</option>
						<option value="20">20</option>
						</form:select></td>
						 <td><form:errors path="loanDuration" cssClass="error" />
<!-- 						  <span ng-show="userForm.loanDuration.$required && !userForm.loanDuration.$pristine" >Enter Loan Duration.</span> 
 -->						 </td>
         
          
      </tr>
      <tr>
          <td class="C">Annual Income   :</td>
          <td><form:input   path="annualIncome" placeholder="Annual Income" ng-pattern="/^[0-9\b.\b]{1,15}$/" maxlength="15" ng-model="annualIncome" required="true"/></td>
          <td><form:errors path="annualIncome" cssClass="error" />
           <span ng-show="userForm.annualIncome.$error.required && !userForm.annualIncome.$pristine" >Enter Annual Income.</span> 
          <span ng-show="userForm.annualIncome.$error.pattern && !userForm.annualIncome.$pristine" >Only Numeric input.</span>
          </td>
      </tr>
      
       </table>
    </td>
    <td>
    <table>
      <tr>
          <td class="C">Company Name   :</td>
          <td><form:input path="companyName" placeholder="Company Name" ng-pattern="/^[A-Za-z\b \b]{1,40}$/" maxlength="40" ng-model="companyName" required="true"/></td>
          <td><form:errors path="companyName" cssClass="error" />
            <span ng-show="userForm.companyName.$error.required && !userForm.companyName.$pristine" >Enter Company Name.</span> 
          <span ng-show="userForm.companyName.$error.pattern && !userForm.companyName.$pristine" >Only Alphabets are allowed.</span>
          </td>
      </tr>
      <tr>
          <td class="C">Designation   :</td>
          <td><form:input path="designation" placeholder="Designation" ng-pattern="/^[A-Za-z\b \b]{1,40}$/" maxlength="40" ng-model="designation" required="true"/></td>
          <td><form:errors path="designation" cssClass="error" />
            <span ng-show="userForm.designation.$error.required && !userForm.designation.$pristine" >Enter Designation.</span> 
          <span ng-show="userForm.designation.$error.pattern && !userForm.designation.$pristine" >Only Alphabets are allowed.</span>
          </td>
      </tr>
      <tr>
          <td class="C">Total Exp   :</td>
          <td><form:input ng-pattern="/^[0-9\b.\b]{1,15}$/" maxlength="15" path="totalExperience" placeholder="Total Exp" ng-model="totalExperience" required="true"/></td>
          <td><form:errors path="totalExperience" cssClass="error" />
           <span ng-show="userForm.totalExperience.$error.required && !userForm.totalExperience.$pristine" >Enter Total Experience.</span> 
          <span ng-show="userForm.totalExperience.$error.pattern && !userForm.totalExperience.$pristine" >Only Numeric input.</span>
          </td>
      </tr>
      <tr>
          <td class="C">Exp with Current company  :</td>
          <td><form:input  path="currentExperience" placeholder="Exp with Current"  ng-pattern="/^[0-9\b.\b]{1,15}$/" maxlength="15" ng-model="currentExperience" required="true"/></td>
          <td><form:errors path="currentExperience" cssClass="error" />
           <span ng-show="userForm.currentExperience.$error.required && !userForm.currentExperience.$pristine" >Enter Current Experience.</span> 
          <span ng-show="userForm.currentExperience.$error.pattern && !userForm.currentExperience.$pristine" >Only Numeric input.</span>
          </td>
      </tr>
       </table>
   <td>
    </tr>
    </table>
     <!--  <tr>
          <td colspan="2"><input type="submit" value="Apply Loan"></td>
      </tr> -->
  
  <center><button type="submit" value="Apply Loan" ng-disabled="userForm.$invalid" >Apply</button></center>
  </form:form>
  </div>
  
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script>
	var app = angular.module('myApp', []);
	
	app.controller('AppCtrl', function($scope){
		//console.log(data);
    	//$scope.data = data;
    	
		$scope.loanAmount = "";
	})
</script>
  </body>
  </html> 