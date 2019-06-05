<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "org.json.simple.JSONObject"%>
<%@ page import = "org.json.simple.JSONArray"%>
<%@ page import = "java.io.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
    JSONObject jso = (JSONObject) request.getAttribute("jsonObject");
	JSONArray ja = (JSONArray) jso.get("detail");
	for(Object itr:ja)
	{
		JSONObject obj=(JSONObject)itr;
		out.print(obj.get("fname").toString()+" ");
		out.print(obj.get("lname").toString()+"<br/>");
	}
	//out.prinln("<p style='color:blue'>"+jso+"</p>");
	//out.println("<table>""<tr>"+ +"</tr>""</table>");
    
%>
</body>
</html>