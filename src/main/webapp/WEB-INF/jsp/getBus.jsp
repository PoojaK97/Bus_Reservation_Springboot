<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bus Reservation Portal</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      background-color: #4c4cff;
      color: white;
      padding: 15px;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #4c4cff;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>



<nav class="navbar navbar-light" style="color:white">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" style="color:white" href="#">Bus Reservation Portal</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a style="color:white" href="${pageContext.request.contextPath}/welcome">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span></a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <jsp:include page="menu.jsp" />
    </div>
    <div class="col-sm-8 text-left"> 
      <h1 style="color:#4c4cff">Bus Details</h1>
      		<p>
				<label>Boarding Point: ${stud.getSource()}</label>
			</p>
			<p>
				<label>Dropping Point: ${stud.getDestination()}</label>
			</p>
			<p>
				<label>Date: ${stud.getDate()}</label>
			</p>
		      <table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Select</th>
			      <th scope="col">Bus ID</th>
			      <th scope="col">Bus Name</th>
			      <th scope="col">Source</th>
			      <th scope="col">Destination</th>
			      <th scope="col">Rating</th>
			      <th scope="col">Departure</th>
			      <th scope="col">Arrival</th>
			      <th scope="col">Cost</th>
			    </tr>
			    <c:forEach var="listValue" items="${students}">
					<tr>
				  <td><input type=radio name="id"value='${listValue.busId}'/></td>
				  <td>${listValue.busId}</td>
			      <td>${listValue.name}</td>
			      <td>${listValue.source}</td>
			      <td>${listValue.destination}</td>
			      <td>${listValue.rating}</td>
			      <td>${listValue.departure}</td>
			      <td>${listValue.arrival}</td>
			      <td>${listValue.price}</td>
			       </tr>
			  </c:forEach>
			  </thead>
			  <tbody>
			  </tbody>
			  </table>
			  <form action="${pageContext.request.contextPath}/bookconfirm">
		         <button type="submit" class="btn btn-success">Select Bus</button>
		      </form>
      <hr>
    </div>
    <div class="col-sm-2 sidenav">

    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Created by Pooja Kumari, Vineet Patil, Kruthika K</p>
</footer>

</body>
</html>



