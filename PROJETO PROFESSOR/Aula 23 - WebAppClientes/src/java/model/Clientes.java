/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Blob;
import java.util.Date;

/**
 *
 * @author Adilson Lima
 */
public class Clientes {
    //Atributos
    private int id;
    private String nome;
    private String email;
    private float renda;
    private String celular;
    private Date nasc;
    private java.sql.Blob imagem;
    private String imagem_url;  //código da Base 64 - String
    
    // Métodos
    public void setId(int p_id) {
        this.id = p_id;
    }
    public void setNome(String p_nome) {
        this.nome = p_nome;
    }
    public void setEmail(String p_email) {
        this.email = p_email;
    }
    public void setRenda(float p_renda) {
        this.renda = p_renda;
    }  
    public void setCelular(String p_celular) {
        this.celular = p_celular;
    }
    public void setNasc(Date p_nasc) {
        this.nasc = p_nasc;
    }
    public void setImagem(Blob p_imagem) {
        this.imagem = p_imagem;
    } 
    public void setImagem_url(String p_imagem_url) {
        this.imagem_url = p_imagem_url;
    }    

    public int getId() {
        return this.id;    
    }
    public String getNome() {
        return this.nome;
    }
    public String getEmail() {
        return this.email;
    }
    public float getRenda() {
        return this.renda;
    }
    public String getCelular() {
        return this.celular;
    }
    public Date getNasc() {
        return this.nasc;
    }
    public Blob getImagem() {
        return this.imagem;
    }   
    public String getImagem_url() {
        return this.imagem_url;
    }
    
}
