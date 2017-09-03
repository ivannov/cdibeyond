<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Magazine Manager</title>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/sb-admin-2.css" rel="stylesheet"/>
</head>
<body>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <a href="ArticleServlet"><img src="img/magman.png"/></a>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Articles</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="dataTable_wrapper">
                        <table class="table table-striped table-bordered table-hover">
                            <c:forEach var="article" items="${articles}">
                                <tr>
                                    <td><a href="ArticleServlet?id=${article.id}">${article.title}</a></td>
                                    <td>${article.author.firstName} ${article.author.lastName}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <a href="NewArticleServlet" class="btn btn-success" role="button">Add article</a>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>