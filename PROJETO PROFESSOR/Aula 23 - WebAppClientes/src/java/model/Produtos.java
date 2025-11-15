/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Eu
 */
public class Produtos {
    // Atributos
    private int id;
    private String produto;
    private float valor;
    private int qtd;
    
    // Métodos
    public void setId(int p_id) {
        this.id = p_id;
    }
    public void setProduto(String p_produto) {
        this.produto = p_produto;
    }
    public void setValor(float p_valor) {
        this.valor = p_valor;
    }
    public void setQtd(int p_qtd) {
        this.qtd = p_qtd;
    }

    public int getId() {
        return this.id;
    }
    public String getProduto() {
        return this.produto;
    }
    public float getValor() {
        return this.valor;
    }
    public int getQtd() {
        return this.qtd;
    } 

    public Produtos(int p_id, String p_produto, float p_valor, int p_qtd) {
        this.id = p_id;
        this.produto = p_produto;
        this.valor = p_valor;
        this.qtd = p_qtd;
    }
    public Produtos() {
    }
    
    
}
