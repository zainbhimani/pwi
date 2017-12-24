<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Item Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Item
</h1>

<c:url var="addAction" value="/item/add" ></c:url>

<form:form action="${addAction}" commandName="item">
<table>
	<c:if test="${!empty item.name}">
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
			<form:label path="itemType">
				<spring:message text="Item Type"/>
			</form:label>
		</td>
		<td>
			<form:input path="itemType" />
		</td>

		<td>
			<form:label path="size">
				<spring:message text="Size"/>
			</form:label>
		</td>
		<td>
			<form:input path="size" />
		</td>

		<td>
			<form:label path="inStock">
				<spring:message text="In Stock"/>
			</form:label>
		</td>
		<td>
			<form:input path="inStock" />
		</td>

		<td>
			<form:label path="avgQty">
				<spring:message text="Avg Qty"/>
			</form:label>
		</td>
		<td>
			<form:input path="avgQty" />
		</td>

		<td>
			<form:label path="inTransit">
				<spring:message text="In Transit"/>
			</form:label>
		</td>
		<td>
			<form:input path="inTransit" />
		</td>

		<td>
			<form:label path="MOQ">
				<spring:message text="MOQ"/>
			</form:label>
		</td>
		<td>
			<form:input path="MOQ" />
		</td>

		<td>
			<form:label path="QPB">
				<spring:message text="QPB"/>
			</form:label>
		</td>
		<td>
			<form:input path="QPB" />
		</td>

		<td>
			<form:label path="reorderPoint">
				<spring:message text="reorderPoint"/>
			</form:label>
		</td>
		<td>
			<form:input path="reorderPoint" />
		</td>


	</tr>

	<tr>
		<td colspan="2">
			<c:if test="${!empty item.name}">
				<input type="submit"
					value="<spring:message text="Edit Item"/>" />
			</c:if>
			<c:if test="${empty item.name}">
				<input type="submit"
					value="<spring:message text="Add Item"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Items List</h3>
<c:if test="${!empty listItems}">
	<table class="tg">
	<tr>
		<th width="80">Item ID</th>
		<th width="120">Item Name</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listItems}" var="item">
		<tr>
			<td>${item.id}</td>
			<td>${item.name}</td>
			<td><a href="<c:url value='/item/edit/${item.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/item/remove/${item.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
