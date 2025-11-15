package SalvarImagem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import config.ConectaDB;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Clientes;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;

/**
 *
 * @author alunocmc
 */
@WebServlet(urlPatterns = {"/SalvarImagem"})
@MultipartConfig(maxFileSize = 16177215) //15.4MB

public class SalvarImagem extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SalvarImagem</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Meu Querido Servlet SalvarImagem at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        // Salvar o registro
        
        String message = null;
        
        //Instância do Objeto
        Clientes cli = new Clientes();
        
        //cli.setId(Integer.parseInt( request.getParameter("ident")) );
        cli.setNome(request.getParameter("cliente") );
        cli.setEmail(request.getParameter("email") );
        cli.setRenda(Float.parseFloat(request.getParameter("renda")) );    
        cli.setCelular(request.getParameter("celular") );                
        try {
            cli.setNasc( new SimpleDateFormat("yyyy-MM-dd").parse( request.getParameter("nascimento")) );
        } catch (ParseException ex) {
            message = "ERRO: " + ex.getMessage();            
        }
                
        InputStream inputStream = null; // Input stream da imagem
        // Obtém a parte do arquivo do request
        Part filePart = request.getPart("foto_img"); // Campo do html
        if (filePart != null) {
            // Obtém o input stream do arquivo selecionado
            inputStream = filePart.getInputStream(); // Image To Binary
        }
        
        Connection conn = null;      
        
        // Conecta ao banco de dados
        try{
            conn = ConectaDB.conectar();            
            //            INSERT INTO clientes (nome, email, renda, celular, nasc) VALUES ('Mariazinha', 'ma@umc.br', 24000, '11985855566', '2025-09-26')
            String sql = "Insert into clientes (nome, email, renda, celular, nasc, imagem) values (?, ?, ?, ?, ?, ?)";            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cli.getNome());
            pstmt.setString(2, cli.getEmail());
            pstmt.setFloat(3, cli.getRenda());
            pstmt.setString(4, cli.getCelular());
            pstmt.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(cli.getNasc()));
            if (inputStream != null) {
                // Define o parâmetro BLOB/LONGBLOB
                pstmt.setBlob(6, inputStream);
            }                        

            // Executa o statement
            int row = pstmt.executeUpdate();
            if (row > 0) {
                message = "Cliente / Imagem salva com sucesso no banco de dados!";
            }
        } catch (SQLException ex) {
            message = "ERRO: " + ex.getMessage();            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalvarImagem.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    message = "ERRO: " + ex.getMessage();
                }
            }
            // Redireciona de volta para uma página de status ou exibe a mensagem
            request.setAttribute("Message", message);
            getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
