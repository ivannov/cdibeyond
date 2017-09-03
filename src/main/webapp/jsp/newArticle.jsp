<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
            <h1 class="page-header">New Article</h1>
        </div>
    </div>
    <div class="panel-body">
        <form method="post" action="NewArticleServlet" role="form">
            <fieldset>
                <div class="form-group">
                    <label for="title">Title</label>
                    <input id="title" class="form-control" type="text" name="title">
                </div>
                <div class="form-group">
                    <label for="content">Content</label>
                    <textarea id="content" name="content" class="form-control" rows="20"></textarea>
                </div>
                <button class="btn btn-success" type="submit">Submit</button>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>
