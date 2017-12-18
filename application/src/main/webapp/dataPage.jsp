<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <script src="/webjars/jquery/2.1.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/webjars/angularjs/1.6.4/angular.min.js"></script>
    <script src="/webjars/angularjs/1.6.4/angular-sanitize.min.js"></script>
    <%--<script src="/webjars/angular-xeditable/0.1.8/js/xeditable.min.js"></script>--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-sanitize.min.js"></script>--%>
    <%--<script src="https://vitalets.github.io/angular-xeditable/dist/js/xeditable.js"></script>--%>
    <script src="https://vitalets.github.io/angular-xeditable/dist/js/xeditable.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/2.5.0/ui-bootstrap-tpls.min.js"></script>
    <script src="/js/bnkseekViewController.js"></script>

    <link rel="stylesheet" type="text/css"
          href="https://netdna.bootstrapcdn.com/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="https://vitalets.github.io/angular-xeditable/dist/css/xeditable.css"/>
    <link rel="stylesheet" type="text/css" href="/css/general.css"/>


</head>
<body ng-app="CBRFApp" ng-controller="bnkseekController">


<div class="container">

    <h1>Справочник БИК</h1>
    <div class="row filter-row">
        <div id="filter-panel" class="collapse filter-panel">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form class="form-inline" role="form">
                        <div class="form-group">
                            <label class="filter-col" style="margin-right:0;" for="pref-bik">БИК:</label>
                            <input type="text" class="form-control input-sm" id="pref-bik" ng-model="search.bik"
                                   ng-change="setPage(0)">
                        </div>
                        <div class="form-group">
                            <label class="filter-col" style="margin-right:0;" for="pref-region">Регион:</label>
                            <input type="text" class="form-control input-sm" id="pref-region" ng-model="search.region"
                                   ng-change="setPage(0)">
                        </div>
                        <div class="form-group">
                            <label class="filter-col" style="margin-right:0;" for="pref-pzn">Тип:</label>
                            <select id="pref-pzn" class="form-control" ng-model="search.pzn" ng-change="setPage(0)">
                                <option value="">Не выбрано</option>
                                <option ng-repeat="p in pzn" value="{{p.pzn}}">{{p.name}}</option>
                            </select>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#filter-panel">
            <span class="glyphicon glyphicon-cog"></span> Добавить фильтр
        </button>
        <button type="button" class="btn btn-default" ng-click="addBnkseek()">Add row</button>

    </div>

    <div class="scrolltable">
        <%--<div class="col-md-12" >Идет загрузка данных</div>--%>
        <table class="table table-bordered table-hover table-condensed">
            <tr style="font-weight: bold">
                <td>real</td>
                <td>pzn</td>
                <td>uer</td>
                <td>rgn</td>
                <td>ind</td>
                <td>tnp</td>
                <td>nnp</td>
                <td>adr</td>
                <td>rkc</td>
                <td>namep</td>
                <td>newnum</td>
                <td>telef</td>
                <td>regn</td>
                <td>okpo</td>
                <td>dt_izm</td>
                <td>ksnp</td>
                <td>date_in</td>
                <td>date_ch</td>
                <td>Action</td>
            </tr>
            <tr ng-repeat="bnk in bnkseek">
                <td>
        <span editable-text="bnk.real" e-name="real" e-form="rowform">
          {{ bnk.real }}
        </span>
                </td>
                <td>
        <span editable-select="bnk.pznCode" e-name="pznCode" e-form="rowform"
              e-ng-options="p.pzn as p.name for p in pzn">
          {{ showPzn(bnk) }}
        </span>
                </td>
                <td>
        <span editable-select="bnk.uerCode" e-name="uerCode" e-form="rowform" onbeforesave="checkNotNull($data)"
              e-ng-options="p.uer as p.uername for p in uer">
          {{ showUer(bnk) }}
        </span>
                </td>
                <td>
        <span editable-select="bnk.rgnCode" e-name="rgnCode" e-form="rowform" onbeforesave="checkNotNull($data)"
              e-ng-options="p.rgn as p.name for p in reg">
          {{ showReg(bnk) }}
        </span>
                </td>
                <td>
        <span editable-text="bnk.ind" e-name="ind" e-form="rowform">
          {{ bnk.ind }}
        </span>
                </td>
                <td>
        <span editable-select="bnk.tnpCode" e-name="tnpCode" e-form="rowform"
              e-ng-options="p.tnp as p.fullname for p in tnp">
          {{ showTnp(bnk) }}
        </span>
                </td>
                <td>
        <span editable-text="bnk.nnp" e-name="nnp" e-form="rowform">
          {{ bnk.nnp }}
        </span>
                </td>
                <td>
        <span editable-text="bnk.adr" e-name="adr" e-form="rowform">
          {{ bnk.adr }}
        </span>
                </td>
                <td>
        <span editable-text="bnk.rkc" e-name="rkc" e-form="rowform">
          {{ bnk.rkc }}
        </span>
                </td>
                <td>
        <span editable-text="bnk.namep" e-name="namep" e-form="rowform" onbeforesave="checkNotNull($data)">
          {{ bnk.namep }}
        </span>
                </td>
                <td>
        <span editable-text="bnk.newnum" e-name="newnum" e-form="rowform" e-disabled>
          {{ bnk.newnum }}
        </span>
                </td>
                <td>
        <span editable-text="bnk.telef" e-name="telef" e-form="rowform">
          {{ bnk.telef }}
        </span>
                </td>
                <td>
        <span editable-text="bnk.regn" e-name="regn" e-form="rowform">
          {{ bnk.regn }}
        </span>
                </td>
                <td>
        <span editable-text="bnk.okpo" e-name="okpo" e-form="rowform">
          {{ bnk.okpo }}
        </span>
                </td>
                <td>
        <span editable-bsdate="bnk.dtIzm" e-name="dtIzm" e-form="rowform" e-is-open="opened.dtIzm{{bnk.newnum}}"
              e-ng-click="open($event,'dtIzm', bnk.newnum)" e-datepicker-popup="dd-MMMM-yyyy"
              onbeforesave="checkNotNull($data)">
          {{ bnk.dtIzm | date:'dd-MMMM-yyyy' }}
        </span>
                </td>
                <td>
        <span editable-text="bnk.ksnp" e-name="ksnp" e-form="rowform">
          {{ bnk.ksnp }}
        </span>
                </td>
                <td>
        <span editable-bsdate="bnk.dateIn" e-name="dateIn" e-form="rowform" e-is-open="opened.dateIn{{bnk.newnum}}"
              e-ng-click="open($event,'dateIn', bnk.newnum)" e-datepicker-popup="dd-MMMM-yyyy"
              onbeforesave="checkNotNull($data)">
          {{ bnk.dateIn | date:'dd-MMMM-yyyy' }}
        </span>
                </td>
                <td>
        <span editable-bsdate="bnk.dateCh" e-name="dateCh" e-form="rowform" e-is-open="opened.dateCh{{bnk.newnum}}"
              e-ng-click="open($event,'dateCh', bnk.newnum)" e-datepicker-popup="dd-MMMM-yyyy">
          {{ bnk.dateCh | date:'dd-MMMM-yyyy' }}
        </span>
                </td>


                <td style="white-space: nowrap">
                    <!-- form -->
                    <form editable-form name="rowform" onbeforesave="saveBnk($data)" ng-show="rowform.$visible"
                          class="form-buttons form-inline" shown="inserted == bnk">
                        <button type="submit" ng-disabled="rowform.$waiting" class="btn btn-primary">
                            save
                        </button>
                        <button type="button" ng-disabled="rowform.$waiting" ng-click="rowform.$cancel()"
                                class="btn btn-default">
                            cancel
                        </button>
                    </form>
                    <div class="buttons" ng-show="!rowform.$visible">
                        <button type="button" class="btn btn-primary" ng-click="rowform.$show()">edit</button>
                        <button type="button" class="btn btn-danger" ng-click="removeBnk($index)">del</button>
                    </div>
                </td>
            </tr>
        </table>
    </div>
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
</body>

</html>