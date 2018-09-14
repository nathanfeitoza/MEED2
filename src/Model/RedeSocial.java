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
    
    public void CadastrarPessoa(String nome_pessoa){
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.inserir(null, (String) nome_pessoa);
        this.TabelaUsers.adicionar(arvore);
        System.out.println(this.TabelaUsers.Hash(arvore));
        this.Localizar(nome_pessoa);
        /*try{
            for (Object object : this.TabelaUsers.obter(nome_pessoa)) {
                ArvoreBinaria arvore = new ArvoreBinaria();
                Arvores a = (Arvores) object;
                arvore.inserir(a, (String) object);
                ListaVetor<ArvoreBinaria> lista = new ListaVetor<>();
                lista.adicionar(arvore);
                this.arvores_t.adicionar(lista);
            }
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }*/
    }
    
    public void Localizar(String nome_pessoa) {
        ArvoreBinaria arvore_buscar = new ArvoreBinaria();
        arvore_buscar.inserir(null, (String) nome_pessoa);
        try{
            for (Object object : this.TabelaUsers.obter(arvore_buscar)) {
                System.out.println(object);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
