<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Registration Form</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  <script src="http://code.jquery.com/jquery-2.1.3.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
<c:if test="${requestScope.error ne null}">
        <strong style="color: red;"><c:out
                value="${requestScope.error}"></c:out></strong>
</c:if>
<h1>${formName}</h1>
<form action="<c:url value="/register"/>" method="POST">
  <div class="form-group">
    <label for="exampleInputLastname">Last Name</label>
    <input type="text" name="surname" class="form-control" id="exampleInputLastname" placeholder="Surname">
  </div>
  <div class="form-group">
    <label for="exampleInputFirstname">Name</label>
    <input type="text" name="name" class="form-control" id="exampleInputFirstname" placeholder="Name">
  </div>
  <div class="form-group">
    <label for="exampleInputFirstname">Username</label>
    <input type="text" name="userName" class="form-control" id="exampleInputFirstname" placeholder="Username">
  </div>
  <div class="form-group">
    <label for="exampleInputFirstname">Password</label>
    <input type="password" name="password" class="form-control" id="exampleInputFirstname" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="exampleInputFirstname">Email</label>
    <input type="text" name="email" class="form-control" id="exampleInputFirstname" placeholder="Email">
  </div>
  <div class="form-group">
    <label for="exampleInputAge">Age</label>
    <input type="number" name="age" class="form-control" id="exampleInputAge" placeholder="Age">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</div>
</body>
</html>
