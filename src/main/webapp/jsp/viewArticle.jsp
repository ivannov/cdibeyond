<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Magazine Manager</title>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/font-awesome.min.css" rel="stylesheet"/>
</head>
<body>
<jsp:useBean id="article" class="com.vidasoft.magman.model.Article" scope="request" />
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <a href="ArticleServlet"><img src="img/magman.png"/></a>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">${article.title}</h1>
            <p class="lead">
                by ${article.author.firstName} ${article.author.lastName}
            </p>
            <p><i class="fa fa-clock-o"></i> Posted on <fmt:formatDate value="${article.pubshishDateAsDate}" pattern="dd MMMM yyyy"/> </p>
            <hr>
            <p>${article.content}</p>

<!--        Add that once the add comment to article is implemented
            <hr>

            <div class="well">
                <h4>Leave a Comment:</h4>
                <form role="form">
                    <div class="form-group">
                        <textarea class="form-control" rows="3"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div> -->

            <hr>

            <c:forEach var="comment" items="${article.comments}">
                <div class="media">
                    <div class="media-body">
                        <h4 class="media-heading">${comment.author.userName}
                            <small><fmt:formatDate value="${comment.createdAsTimestamp}" pattern="dd MMMM, hh:mm" /></small>
                        </h4>
                        ${comment.content}
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

</div>
</body>