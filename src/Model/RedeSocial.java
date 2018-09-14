/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import ArvoreBinaria.ArvoreBinaria;
import ListaSimples.ListaSimplesmenteEncadeada;
import ListaVetor.ListaVetor;
import TabelaHash.TabelaHash;

/**
 *
 * @author nathan
 */
public class RedeSocial {
    private TabelaHash<ArvoreBinaria> TabelaUsers = new TabelaHash<>();
    private TabelaHash<ListaVetor> arvores_t = new TabelaHash<>();
    
    protected ArvoreBinaria GerarArvore(String nome_pessoa) {
        ArvoreBinaria arvore_buscar = new ArvoreBinaria();
        arvore_buscar.inserir(null, (String) nome_pessoa);
        return arvore_buscar;
    }
    
    public void CadastrarPessoa(String nome_pessoa){
        ArvoreBinaria arvore = this.GerarArvore(nome_pessoa);
        this.TabelaUsers.adicionar(arvore);
        this.Localizar(nome_pessoa);
         try{
            for (Object object : this.TabelaUsers.obter(arvore)) {
                System.out.println(object);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void Localizar(String nome_pessoa) {
        //System.out.println(this.TabelaUsers.Hash(arvore_buscar.toString()));
        try{
            for (Object object : this.TabelaUsers.obter(this.GerarArvore(nome_pessoa))) {
                System.out.println(object);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
