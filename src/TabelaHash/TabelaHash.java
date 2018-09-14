/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaHash;
import ArvoreBinaria.ArvoreBinaria;
import ListaVetor.ListaVetor;
import ListaSimples.ListaSimplesmenteEncadeada;
import java.util.Iterator;
/**
 *
 * @author Nathan H. Feitoza
 */
public class TabelaHash <Tipo> {
    private ListaVetor<Object> primaria;
    private int capacidadeInicial = 26;
   /**
    * Construtor normal da tabela
    */
    public TabelaHash() {
        this.primaria = new ListaVetor<>(this.capacidadeInicial);
    }
    /**
     * Constutor com uma capacidade máxima definida pelo usuário
     * @param capacidade 
     */
    public TabelaHash(int capacidade) {
        this.capacidadeInicial = capacidade;
        this.primaria = new ListaVetor<>(capacidade);
    }
    /**
     * Função de geração do hash
     * @param valor
     * @return 
     */
    public int Hash(String valor) {
        int cod = 1;
        int lista_len = this.capacidadeInicial;
        
        for(int i = 0; i < valor.length(); i++) {
            cod = 31 * 2 + valor.toLowerCase().charAt(i);
        }
       int hash = cod % lista_len;
       return Math.abs( hash );
    }
    /**
     * Método de adicção
     * @param valor 
     */
    public void adicionar(Tipo valor) {
        int indice = this.Hash(""+valor);
        
        try {
          ListaSimplesmenteEncadeada lista = (ListaSimplesmenteEncadeada) this.primaria.obter(indice);
          lista.adicionar(valor);
          this.primaria.adicionar(indice, lista);
            
        } catch(Exception e) {
            ListaSimplesmenteEncadeada<Tipo> lista_secundaria = new ListaSimplesmenteEncadeada<>();
            lista_secundaria.adicionar(valor);
            this.primaria.adicionar(indice, lista_secundaria);
        }
    }
    /**
     * Metódo que obtem a lista dentro de uma posição da tabela
     * @param elemento
     * @return
     * @throws Exception 
     */
    public ListaSimplesmenteEncadeada obter(Tipo elemento) throws Exception {
        int indice = this.Hash(""+elemento);
        ListaSimplesmenteEncadeada lista = null;
        try {
            lista = (ListaSimplesmenteEncadeada) this.primaria.obter(indice);
        } catch(Exception e) {
            throw new Exception("Posição não encontrada");
        }
        return lista;
    }
    /**
     * Obtem a lista
     * @param valor
     * @return 
     */
    public ListaSimplesmenteEncadeada obterLista(ListaSimplesmenteEncadeada valor) {
        return valor;
    } 
    /**
     * Remove um elemento da tabela
     * @param elemento 
     */
    public void remover(Tipo elemento){
        int indice = this.Hash(""+elemento);
       ListaSimplesmenteEncadeada lista = (ListaSimplesmenteEncadeada) this.primaria.obter(indice);

            if(lista.tamanho() == 1) {
                this.primaria.remover(indice);
            } else {
                lista.remover(elemento);
            }
    }
    /**
     * Metódo que limpa a tabela
     */
    public void removerTodos(){
        this.primaria.limpar();
    }
    /**
     * Obtem todos os elementos da tabela
     * @return 
     */
    public ListaVetor obertTodos() {
        return this.primaria;
    }
    
}
