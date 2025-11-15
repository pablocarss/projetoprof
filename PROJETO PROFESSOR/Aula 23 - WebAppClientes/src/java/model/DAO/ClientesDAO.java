/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.*;
import model.Clientes;
import config.ConectaDB;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Base64;
/**
 *
 * @author alunocmc
 */
public class ClientesDAO {
    //Atributos
    
    //Métodos
    //+ cadastrar( Cliente ): boolean
    public boolean cadastrar( Clientes cli ) throws ClassNotFoundException{
        Connection conn = null;
        try{
            conn = ConectaDB.conectar();
            Statement stmt = conn.createStatement();
            //            INSERT INTO clientes (nome, email, renda, celular, nasc) VALUES ('Mariazinha', 'ma@umc.br', 24000, '11985855566', '2025-09-26')
            String sql = "Insert into clientes (nome, email, renda, celular, nasc) values ('" + cli.getNome()
                                                                        + "', '" +cli.getEmail()
                                                                        + "', " +cli.getRenda()
                                                                        + ", '" +cli.getCelular()
                                                                        +  "', '" + new SimpleDateFormat("yyyy-MM-dd").format(cli.getNasc()) + "')";
            stmt.executeUpdate(sql); //Insert, Update, Delete
            conn.close();
            return true;
        }catch(SQLException ex){
            System.out.println("Erro - SQL: " + ex);
            return false;
        }
    }

    public List consulta_geral() throws ClassNotFoundException, ParseException{
        List lst = new ArrayList<>();        
        Connection conn = null;
        try{
            conn = ConectaDB.conectar();
            Statement stmt = conn.createStatement();
            String sql = "select * from clientes order by pk_id asc;";            
            ResultSet rs = stmt.executeQuery(sql); //Select
            
            int n_reg = 0;
            while(rs.next()){
                Clientes cli = new Clientes();
                cli.setId(Integer.parseInt( rs.getString("pk_id") ) );
                cli.setNome(rs.getString("nome") );
                cli.setEmail(rs.getString("email") );
                cli.setRenda(Float.parseFloat(rs.getString("renda")) ); 
                cli.setCelular(rs.getString("celular") );                
                cli.setNasc( new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("nasc")));
                
                lst.add(cli);
                n_reg++;                
            }           
            conn.close();            
            if (n_reg == 0){
                return null;
            }else{
                return lst;
            }                      
        }catch(SQLException ex){
            System.out.println("Erro - SQL: " + ex);
            return null;
        }
    }
    
    public Clientes consulta_id( Clientes cli ) throws ClassNotFoundException, ParseException, IOException{                
        Connection conn = null;
        try{
            conn = ConectaDB.conectar();
            Statement stmt = conn.createStatement();
            String sql = "select * from clientes WHERE pk_id = " + cli.getId() ;            
            ResultSet rs = stmt.executeQuery(sql); //Select
            
            if(rs.next()){                
                cli.setId(Integer.parseInt( rs.getString("pk_id") ) );
                cli.setNome(rs.getString("nome") );
                cli.setEmail(rs.getString("email") );
                cli.setRenda(Float.parseFloat(rs.getString("renda")) ); 
                cli.setCelular(rs.getString("celular") );
                cli.setNasc( new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("nasc")));
                cli.setImagem(rs.getBlob("imagem"));
                
                //1. Ler o Blob como um inputStream
                String imageUrl = null;
                InputStream in = rs.getBinaryStream("imagem"); //Foto do DB
                if (in != null){
                    //2. Converter o InputStream para Base64
                    byte[] bytes = in.readAllBytes();
                    String base64Img = Base64.getEncoder().encodeToString(bytes);
                    imageUrl = "data:image/jpeg;base64," + base64Img;
                }
                cli.setImagem_url(imageUrl);
                
                conn.close();
                return cli;
            }else{
                conn.close();
                return null;
            }                 
        }catch(SQLException ex){
            System.out.println("Erro - SQL: " + ex);
            return null;
        }        
    }
    
    public List consulta_nome( String p_nome ) throws ClassNotFoundException{
        List lst = new ArrayList<>();        
        Connection conn = null;
        try{
            conn = ConectaDB.conectar();
            Statement stmt = conn.createStatement();
            //            SELECT * FROM clientes WHERE nome like 'maria%'
            String sql = "select * from clientes WHERE nome like '%" + p_nome + "%'";            
            ResultSet rs = stmt.executeQuery(sql); //Select
            
            int n_reg = 0;
            while(rs.next()){
                Clientes cli = new Clientes();
                cli.setId(Integer.parseInt( rs.getString("pk_id") ) );
                cli.setNome(rs.getString("nome") );
                cli.setEmail(rs.getString("email") );
                cli.setRenda(Float.parseFloat(rs.getString("renda")) ); 
                cli.setCelular(rs.getString("celular") );
                
                lst.add(cli);
                n_reg++;                
            }           
            conn.close();            
            if (n_reg == 0){
                return null;
            }else{
                return lst;
            }                      
        }catch(SQLException ex){
            System.out.println("Erro - SQL: " + ex);
            return null;
        }
    }
    
    public boolean excluir( int p_id ) throws ClassNotFoundException{
        Connection conn = null;
        try{
            conn = ConectaDB.conectar();
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM clientes WHERE pk_id = " + p_id;
            int result = stmt.executeUpdate(sql); //Insert, Update, Delete
            conn.close();
            
            if (result > 0){ 
                return true;
            }else{
                return false;
            }            
            
        }catch(SQLException ex){
            System.out.println("Erro - SQL: " + ex);
            return false;
        }
    }
    
    public boolean alterar( Clientes cli ) throws ClassNotFoundException{
        Connection conn = null;
        try{
            conn = ConectaDB.conectar();
            Statement stmt = conn.createStatement();
            String sql = "UPDATE clientes SET nome='" + cli.getNome() 
                                        + "', email='" + cli.getEmail() 
                                        + "', renda=" + cli.getRenda() 
                                        + ", celular='" + cli.getCelular() 
                                        + "', nasc='" + new SimpleDateFormat("yyyy-MM-dd").format(cli.getNasc()) + "'"
                                        + " WHERE pk_id = " + cli.getId();           
            stmt.executeUpdate(sql); //Insert, Update, Delete
            conn.close();
            return true;
        }catch(SQLException ex){
            System.out.println("Erro - SQL: " + ex);
            return false;
        }
    }

}
