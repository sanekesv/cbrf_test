<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
  <script src="/webjars/jquery/2.1.1/jquery.min.js"></script>
  <script src="/webjars/angularjs/1.3.8/angular.min.js"></script>
  <script src="/webjars/angular-xeditable/0.1.8/js/xeditable.min.js"></script>
  <script src="/js/bnkseekViewController.js"></script>

  <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="/webjars/angular-xeditable/0.1.8/css/xeditable.css"/>
  <link rel="stylesheet" type="text/css" href="/css/general.css"/>


</head>
<body ng-app="CBRFApp" ng-controller="bnkseekController">
<div class="container">
  <%--<div class="col-md-12" >Идет загрузка данных</div>--%>
  <table class="table table-bordered table-hover table-condensed">
    <tr style="font-weight: bold">
      <td style="width:35%">Name</td>
      <td style="width:20%">Status</td>
      <td style="width:20%">Group</td>
      <td style="width:25%">Edit</td>
    </tr>
    <tr ng-repeat="bnk in bnkseek">
      <td>
        <!-- editable username (text with validation) -->
        <span editable-text="bnk.namep" e-name="namep" e-form="rowform">
          {{ bnk.namep || 'empty' }}
        </span>
      </td>
      <td>
        <%--<!-- editable status (select-local) -->--%>
        <span editable-select="bnk.pznCode" e-name="pznCode" e-form="rowform" e-ng-options="p.pzn as p.name for p in pzn">
          {{ showPzn(bnk) }}
        </span>
      </td>
      <%--<td>--%>
        <%--<!-- editable group (select-remote) -->--%>
        <%--<span editable-select="bnk.group" e-name="group" onshow="loadGroups()" e-form="rowform" e-ng-options="g.id as g.text for g in groups">--%>
          <%--{{ showGroup(bnk) }}--%>
        <%--</span>--%>
      <%--</td>--%>
      <td style="white-space: nowrap">
        <!-- form -->
        <form editable-form name="rowform" onbeforesave="saveBnk($data, bnk.vkey)" ng-show="rowform.$visible" class="form-buttons form-inline" shown="inserted == bnk">
          <button type="submit" ng-disabled="rowform.$waiting" class="btn btn-primary">
            save
          </button>
          <button type="button" ng-disabled="rowform.$waiting" ng-click="rowform.$cancel()" class="btn btn-default">
            cancel
          </button>
        </form>
        <div class="buttons" ng-show="!rowform.$visible">
          <button type="button" class="btn btn-primary" ng-click="rowform.$show()">edit</button>
          <%--<button type="button" class="btn btn-danger" ng-click="removeUser($index)">del</button>--%>
        </div>
      </td>
    </tr>
  </table>
    <ul ng-if="pages.length" class="pagination">
      <li ng-class="{disabled:currentPage === 1}">
        <a ng-click="setPage(1)">First</a>
      </li>
      <li ng-class="{disabled:currentPage === 1}">
        <a ng-click="setPage(currentPage - 1)">Previous</a>
      </li>
      <li ng-repeat="page in pages" ng-class="{active:currentPage === page}">
        <a ng-click="setPage(page)">{{page}}</a>
      </li>
      <li ng-class="{disabled:currentPage === totalPages}">
        <a ng-click="setPage(currentPage + 1)">Next</a>
      </li>
      <li ng-class="{disabled:currentPage === totalPages}">
        <a ng-click="setPage(totalPages)">Last</a>
      </li>
    </ul>
</div>
<%--<div class="invisible load">--%>
  <%--<div class="loader"></div>--%>
<%--</div>--%>
</body>

</html>