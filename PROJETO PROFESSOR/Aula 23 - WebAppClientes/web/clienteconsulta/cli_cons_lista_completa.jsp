<%-- 
    Document   : cliente consulta
    Created on : 03 de set. de 2025, 20:59:14
    Author     : Adilson Lima
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Clientes"%>
<%@page import="model.DAO.ClientesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Clientes - Completa</title>
        
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">                                           
        <link href="../style/relatorio2.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h2>Clientes - Consulta - Lista Completa</h2>                                                   
                
            <%
                //Instância do Objeto
                ClientesDAO cliDAO = new ClientesDAO();

                List<Clientes> lst = new ArrayList<>();
                lst = cliDAO.consulta_geral();
            %>
                <table>
                    <tr> 
                        <th>Id.</th>
                        <th>Nome do Cliente</th>
                        <th>E-mail</th>
                        <th>Renda</th>
                        <th>Celular</th>
                        <th>Nascimento</th>
                        <th>Alterar</th>
                        <th>Consultar</th>
                        <th>Apagar</th>                    
                    </tr>
            <%    
                int n_reg = 0;
                for (int i = 0; i<=lst.size()-1 ;i++){
            %>        
                    <tr> 
                        <td><%=lst.get(i).getId()%></td>
                        <td><%=lst.get(i).getNome()%></td>
                        <td><%=lst.get(i).getEmail()%></td>
                        <td><%=lst.get(i).getRenda()%></td>
                        <td><%=lst.get(i).getCelular()%></td>
                        <td><%= new SimpleDateFormat("dd/MM/yyyy").format(lst.get(i).getNasc())%></td>
                        <td><a href="../clientealterar/cli_cons_alt.jsp?ident=<%=lst.get(i).getId()%>">📝</a></td>                    
                        <td><a href="cli_cons_id.jsp?ident=<%=lst.get(i).getId()%>">🔍</a></td>                    
                        <td>️<a href="../clienteapagar/cli_apaga.jsp?ident=<%=lst.get(i).getId()%>">🔥</a></td>                                            
                    </tr>                                               
            <%    
                    n_reg++;
                }        
            %>
                    <tfoot>
                        <tr>
                            <th>Registros</th>
                            <th><%=n_reg%></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                        </tr>    
                    </tfoot>
                </table>
                <p><br><a href="../clientecadastrar/index.html">✅ Novo</a></p>
        </div>
    </body>
</html>