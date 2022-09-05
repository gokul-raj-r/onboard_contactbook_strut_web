<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
 <div align="center">
    <h2>Contact Creation Page</h2>
    <form action="add">
        <input type = text name ="name" placeholder="Name"><br>
        <input type = text name="num" placeholder="Number"><br>
        <input type = text name ="mail" placeholder="E-mail"><br>
        <input type = text name ="company" placeholder="Company"><br>

        <input type = "submit">
    </form>
 </div>
</body>
</html>
