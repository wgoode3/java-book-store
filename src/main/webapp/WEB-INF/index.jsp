<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
    
        <div class="jumbotron">
		    <h1>${title}</h1>
		    <h3>${subtitle}</h3>        
        </div>
        
	    <div class="alert alert-info">
	       Page views: ${pageViews} 
	       <a href="/reset" class="float-right">reset</a>
	    </div>
	    
	    <div class="row">
	       <div class="col">
			    <form action="/books/add" method="post">
			        <div class="form-group"> 
			             <label>Title</label>
			             <input type="text" name="title" class="form-control">
			             <p class="text-danger">${titleError}</p>
			        </div>
			        <div class="form-group"> 
                         <label>Author</label>
                         <input type="text" name="author" class="form-control">
                         <p class="text-danger">${authorError}</p>
                    </div>
                    <div class="form-group"> 
                         <label>Pages</label>
                         <input type="number" name="numPages" class="form-control">
                         <p class="text-danger">${pagesError}</p>
                    </div>
                    <div class="form-group"> 
                         <label>Price</label>
                         <input type="number" name="price" step="0.01" class="form-control">
                         <p class="text-danger">${priceError}</p>
                    </div>

			        <input type="submit" value="Add Book" class="btn btn-primary" />
			    </form>
	       
	       </div>
	       <div class="col">
			    <table class="table table-striped">
			        <tr>
			            <th>Title</th>
			            <th>Author</th>
			            <th>Pages</th>
			            <th>Price</th>
			        </tr>
			        <c:forEach items="${books}" var="book">
			            <tr>
			                <td>${book.title}</td>
			                <td>${book.author}</td>
			                <td>${book.numPages}</td>
			                <td>$${book.price}</td>
			            </tr>
			        </c:forEach>
			    </table>
           
           </div>
	    </div>
    </div>
</body>
</html>