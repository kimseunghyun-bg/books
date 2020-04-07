<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><spring:message code="member.register"/></title>
</head>
<body>
    <h2><spring:message code="term"/></h2>
    <p>약관 내용</p>
    <form action="step2" method="post">
        <label>
            <input type="checkbox" name="agree" value="true"/><spring:message code="term.agree"/>
        </label>
        <input type="submit" value="<spring:message code="next.btn"/>"/>
    </form>
</body>
</html>