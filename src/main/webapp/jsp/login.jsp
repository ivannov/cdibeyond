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
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Welcome to Magazine Manager</h3>
                </div>
                <div class="panel-body">
                    <form method="post" action="LoginServlet" role="form">
                        <fieldset>
                            <c:if test="${not empty message}"><div class="form-group alert alert-danger"><c:out value="${message}"/></div></c:if>
                            <div class="form-group">
                                <input type="text" name="userName" class="form-control" placeholder="User name"/>
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" class="form-control" placeholder="Pasword"/>
                            </div>
                            <button class="btn btn-lg btn-success btn-block" type="submit">Login</button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>