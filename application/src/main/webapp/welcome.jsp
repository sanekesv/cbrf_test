<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
  <script src="webjars/jquery/2.1.1/jquery.min.js"></script>
  <script src="webjars/angularjs/1.3.8/angular.min.js"></script>
  <script src="/js/indexPageController.js"></script>

  <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="/css/general.css"/>


</head>
<body ng-app="CBRFApp" ng-controller="indexPageController">
<div class="container">

  <input type="button" class="btn btn-default" ng-click="loadDbf()" value="Загрузить">
</div>
<div class="invisible load">
  <div class="loader"></div>
</div>
</body>

</html>