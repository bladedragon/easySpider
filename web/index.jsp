<%@ page import="java.util.ArrayList" %>
<%@ page import="spidertools.Kebiao" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.google.gson.JsonElement" %>
<%@ page import="com.google.gson.reflect.TypeToken" %>
<%@ page import="java.lang.reflect.Type" %>
<%@ page import="com.google.gson.JsonArray" %>
<%@ page import="com.google.gson.JsonParser" %>
<%@ page import="com.google.gson.stream.JsonReader" %><%--
  Created by IntelliJ IDEA.
  User: 11566
  Date: 2018/3/22
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>爬虫课表</title>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <table>
                <caption>课表</caption>
                <tbody>
                <%
                    Gson gson = new Gson();
//            Type type = new TypeToken<ArrayList<Kebiao>>() {}.getType();
//            ArrayList<Kebiao> kebiao = gson.fromJson((JsonElement) request.getAttribute("gkebiao"),type);
                    ArrayList<Kebiao> kebiao = new ArrayList<>();
                    JsonArray array = new JsonParser().parse((String) request.getAttribute("gkebiao")).getAsJsonArray();
                    //注意传入的是json字符串要用（String）

                    for (final JsonElement elem : array) {
                        kebiao.add(new Gson().fromJson(elem, Kebiao.class));
                    }
                %>
                <table border="1">
                    <tr>
                        <th>教学班</th>
                        <th>课程名</th>
                        <th>分类</th>
                        <th>类别</th>
                        <th>状态</th>
                        <th>老师</th>
                        <th>星期</th>
                        <th>时间</th>
                        <th>课时</th>
                        <th>地点</th>
                    </tr>
                    <tr><% if (kebiao == null) {
                        System.out.println("...");
                    } else {
                        for (int i = 0; i < kebiao.size(); i++) {
                            Kebiao kb = kebiao.get(i); %>
                        <td rowspan='1'><%=kb.getClassnum()%>
                        </td>
                        <td rowspan='1'><%=kb.getClassname()%>
                        </td>
                        <td rowspan='1'><%=kb.getClassify()%>
                        </td>
                        <td rowspan='1'><%=kb.getType()%>
                        </td>
                        <td rowspan='1'><%=kb.getState()%>
                        </td>
                        <td rowspan='1'><%=kb.getTeacher()%>
                        </td>
                        <%--<%for(int j=0;j<kb.getWeek().size();j++){%>--%>
                        <%--<td><%=kb.getWeek().get(j)%></td>--%>
                        <%--<%}%>--%>
                        <%--<%for(int j=0;j<kb.getTime().size();j++){%>--%>
                        <%--<td><%=kb.getTime().get(j)%></td>--%>
                        <%--<%}%>--%>
                        <%--<%for(int j=0;j<kb.getWeeks().size();j++){%>--%>
                        <%--<td><%=kb.getWeeks().get(j)%></td>--%>
                        <%--<%}%>--%>
                        <%--<%for(int j=0;j<kb.getPlace().size();j++){%>--%>
                        <%--<td><%=kb.getPlace().get(j)%></td>--%>
                        <%--<%}%>--%>
                        <td><%=kb.getWeek()%>
                        </td>
                        <td><%=kb.getTime()%>
                        </td>
                        <td><%=kb.getWeeks()%>
                        </td>
                        <td><%=kb.getPlace()%>
                        </td>
                    </tr>
                    <% }
                    }%></table>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
