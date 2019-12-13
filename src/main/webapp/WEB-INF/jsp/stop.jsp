<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Student Details Portal</title>
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
      background-image: url("https://i.makeagif.com/media/12-21-2015/EgD1hy.gif");
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
      <a class="navbar-brand" style="color:white" href="#">Bus Reservation</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a style="color:white" href="${pageContext.request.contextPath}/welcome">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>LOG OUT</a></li>
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
      <h1 style="color:#4c4cff">Book Tickets
      </h1>
      <hr>

      <div id="addEmployee">
		<form:form action="/findbus" method="post"
			modelAttribute="stud">
			<p>
				<label>Boarding Point: </label>
				<form:select class="btn btn-secondary dropdown-toggle" path="source">
				  <option value="Bengaluru">Bengaluru</option>
				  <option value="Mysore">Mysore</option>
				  <option value="Goa" >Goa</option>
				</form:select>
			</p>
			
			<p>
				<label>Drop Point: </label>
				<form:select class="btn btn-secondary dropdown-toggle" path="destination">
				  <option value="Goa" >Goa</option>
				  <option value="Bengaluru">Bengaluru</option>
				  <option value="Mysore">Mysore</option>
				</form:select>
			</p>
			<% String s = java.time.LocalDate.now().toString(); %>
			<p>
				<label>Date of journey:</label>
				<form:input type='date' path="date" min='<%=s%>' required='true'/>
			</p>
			<br>
			<input type="SUBMIT" value="SEARCH BUSES" class="btn btn-success" />
		</form:form>
	</div>
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





