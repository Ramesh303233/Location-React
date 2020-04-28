<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="updateLoc" method="POST">
<pre>
Id <input type="text" name="id"  value="${location.id}" readOnly="true"/>
Code<input type="text" name="code" value="${location.code}"/>
Name<input type="text" name="name" value="${location.name}"/>
Type:Urban<input type="radio" name="type" value="URBAN" ${location.type=='URBAN'?'checked':''} />
     rural<input type="radio" name="type" value="RURAL" ${location.type=='RURAL'?'checked':''}/>
     
     <input type="submit" value="Update"/>
</pre>

</form>


</body>
</html>