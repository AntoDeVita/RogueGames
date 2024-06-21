<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="model.*, java.util.*, control.*"%>
   <% Collection <prodottoBean> p= (ArrayList<prodottoBean>)request.getAttribute("prod"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RogueGames</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>

	
	<div id="main" class="clear">
	
	<h2>Prodotti</h2>
	
		<%
			if (p != null && p.size() != 0) {
				Iterator<?> it = p.iterator();
				while (it.hasNext()) {
					prodottoBean bean = (prodottoBean) it.next();
		%>
		<div class="item">
			<ul>
			<li><a <%=bean.getIdProdotti()%>"></a></li>
			<li><%=bean.getNome()%></li>
			<li>prezzo: &euro;<%=bean.getPrezzo()%></li>
		 </ul>
		</div>
		<%
				}
			} else {
		%>
		
			<h2>No products available</h2>
		<%
			}
		%>

  </div>
</body>
</html>