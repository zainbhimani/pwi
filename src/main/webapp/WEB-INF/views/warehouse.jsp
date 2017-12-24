<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Warehouse Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Warehouse
</h1>

<c:url var="addAction" value="/warehouse/add" ></c:url>

<form:form action="${addAction}" commandName="warehouse">
<table>
	<c:if test="${!empty warehouse.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td>

		<td>
			<form:label path="country">
				<spring:message text="Country"/>
			</form:label>
		</td>
		<td>
			<form:input path="country" />
		</td>

		<c:forEach items="${items}" var="item">
	<tr>
		<td>${item.id}</td>
		<td>${item.name}</td>

	</tr>
	</c:forEach>


		<%--<td>--%>
			<%--<form:label path="warehouses">--%>
				<%--<spring:message text="warehouses"/>--%>
			<%--</form:label>--%>
		<%--</td>--%>
		<%--<td>--%>
			<%--<form:select path="warehouses" items="${warehouses}" multiple="true" itemValue="id"--%>

						 <%--itemLabel="type" class="form-control input-sm" />--%>

		<%--<c:forEach var="warehouse" items="${warehouses}">--%>
			<%--<p>${warehouse.id}</p>--%>
			<%--<p>${warehouse.name}</p>--%>
		<%--</c:forEach>--%>
		<%--</td>--%>
		<%--<form:select path="warehouses" items="${warehouses}" />--%>




	</tr>

	<tr>
		<td colspan="2">
			<c:if test="${!empty warehouse.name}">
				<input type="submit"
					value="<spring:message text="Edit Warehouse"/>" />
			</c:if>
			<c:if test="${empty warehouse.name}">
				<input type="submit"
					value="<spring:message text="Add Warehouse"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Warehouse List</h3>
<c:if test="${!empty listWarehouses}">
	<table class="tg">
	<tr>
		<th width="80">Warehouse ID</th>
		<th width="120">Warehouse Name</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listWarehouses}" var="warehouse">
		<tr>
			<td>${warehouse.id}</td>
			<td>${warehouse.name}</td>
			<td><a href="<c:url value='/warehouse/edit/${warehouse.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/warehouse/remove/${warehouse.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
