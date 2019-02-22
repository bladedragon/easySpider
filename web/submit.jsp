<%--
  Created by IntelliJ IDEA.
  User: 11566
  Date: 2018/3/24
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输入学号</title>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

            <fieldset>
                <legend>查询课表</legend>

                <form action="KebiaoServlet" method="post">
                    请输入学号：<input type="text" name="number" value=""></br>
                    </label> <input type="submit" name="submit" value="登陆">提交</input>
                </form>
            </fieldset>

        </div>
    </div>
</div>
</body>
</html>
