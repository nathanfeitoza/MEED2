/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meed2;

import Model.RedeSocial;
import javax.swing.JOptionPane;

/**
 *
 * @author nathan
 */
public class MEED2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int opc = 0;
       RedeSocial rede = new RedeSocial();
       
       while(opc != 6) {
            opc = Integer.parseInt(JOptionPane.showInputDialog(""+
                    "Rede Social Contra Bolsonaro\n\n"+
                    "1 - Cadastrar Pessoa\n"+
                    "2 - Adicionar Amigo\n"+
                    "3 - Fazer Postagem\n"+
                    "4 - Lista Amigos\n"+
                    "5 - Lista Postagens\n"+                   
                    "6 - Sair\n"                    
                    ));
     
           
           switch(opc) {
               case 1:
                   String nome = JOptionPane.showInputDialog("Nome: ");
                   rede.CadastrarPessoa(nome);
                   break;
               case 2:
                   String add_pessoa = JOptionPane.showInputDialog("Nome do amiguinho: ");
                   break;
               case 3:
                   //String add_pessoa = JOptionPane.showInputDialog("Nome do amiguinho: ");
                   break;
               case 4:
                   String pessoa_listar = JOptionPane.showInputDialog("Seu Nome: ");
                   break;
               case 5:
                   String postagens_listar = JOptionPane.showInputDialog("Seu Nome: ");
                   break;
               
           }
       }
    }
    
}
