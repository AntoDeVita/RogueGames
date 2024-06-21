<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context, javax.naming.InitialContext, javax.naming.NamingException, javax.sql.DataSource, java.sql.Connection, java.sql.SQLException" %>
<%@ page import="java.io.StringWriter, java.io.PrintWriter" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Connessione al Database</title>
</head>
<body>
    <h1>Test Connessione al Database</h1>
    
    <%-- Codice Java per il test della connessione --%>
    <%
        Connection conn = null;
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/gamerogue");
            
            conn = ds.getConnection();
            
            if (conn != null) {
                out.println("<p>Connessione al database stabilita!</p>");
            } else {
                out.println("<p>Connessione al database non riuscita!</p>");
            }
        } catch (NamingException e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            out.println("<p>Errore durante il tentativo di connessione al database: " + e.getMessage() + "</p>");
            out.println("<pre>" + sw.toString() + "</pre>");
        } catch (SQLException e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            out.println("<p>Errore durante il tentativo di connessione al database: " + e.getMessage() + "</p>");
            out.println("<pre>" + sw.toString() + "</pre>");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                out.println("<p>Errore durante la chiusura della connessione: " + e.getMessage() + "</p>");
                out.println("<pre>" + sw.toString() + "</pre>");
            }
        }
    %>

</body>
</html>
