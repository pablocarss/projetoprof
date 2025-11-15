<%-- 
    Document   : cliente consulta ID
    Created on : 05 de set. de 2025, 20:59:14
    Author     : Adilson Lima
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Clientes"%>
<%@page import="model.DAO.ClientesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Clientes</title>
        <link href="../style/geral.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <h2>Clientes - Consulta Nome</h2>
            <%
                //Instância do Objeto
                ClientesDAO cliDAO = new ClientesDAO();            
                List<Clientes> lst = new ArrayList<>();

                String nome = request.getParameter("cliente");            
                lst = cliDAO.consulta_nome(nome);

                if (lst == null){
                    out.println("Cliente não localiza!");
                }else{           
                    int n_reg = 0;
                    for (int i = 0; i<=lst.size()-1 ;i++){
                        out.println("<br><br> <b>Identificador......:</b> " + lst.get(i).getId());
                        out.println("<br> <b>Nome do Cliente:</b> " + lst.get(i).getNome());
                        out.println("<br> <b>Email:</b> " + lst.get(i).getEmail());
                        out.println("<br> <b>Renda:</b> " + lst.get(i).getRenda());
                        n_reg++;
                    }         
                     out.println("<br><br> <b>Registros: </b> " + n_reg );
                }
            %>
        </div>
    </body>
</html>