/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_desafio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import static jdk.nashorn.tools.ShellFunctions.input;

/**
 *
 * @author Pc
 */
public class Projeto_Desafio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> dados = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        List<String> caracterFecha = new ArrayList<>();
        char dadosLinha [] = null;;
        String caminhoSalvar = null;
        int ultimaPosicao = 0;
        boolean valida = true;    
        
        String caminho;
        System.out.println("DIGITE O CAMINHO ONDE O TXT ESTA SALVO!!");
        caminho = input.nextLine();
        
        File arquivo = new File(caminho);
        if (arquivo.exists()) {
            String CaracterFinish[] = new String[4];
            CaracterFinish[0] = ")";
            CaracterFinish[1] = "]";
            CaracterFinish[2] = "}";
            CaracterFinish[3] = ">";
            
            String CaracterOpen[] = new String[4];
            CaracterOpen[0] = "(";
            CaracterOpen[1] = "[";
            CaracterOpen[2] = "{";
            CaracterOpen[3] = "<";
            
            String abc = "";
            
            String dadosConta = "";
            try {
                BufferedReader in = new BufferedReader(new FileReader(arquivo));

                while (in.ready()) {
                   dadosConta = (in.readLine());
                   dados.add(dadosConta);
                }
                
                
                for (int a = 0; a < dados.size(); a++) {
                 String mensagem = "OK!";
                 dadosLinha = dados.get(a).toCharArray();
                 Pilha minhaPilha = new Pilha(dadosLinha.length);

                    for (int i = 0 ; i < dadosLinha.length; i++) {
                        String letra =""+ dadosLinha[i];
                        
                        
                        if ( i ==0 && (letra == CaracterFinish[0] || letra == CaracterFinish[1] ||
                                letra == CaracterFinish[2] || letra == CaracterFinish[3])) {
                            mensagem = "Invalido!";
                        }

                        if (letra.equals(CaracterOpen[0])|| letra.equals(CaracterOpen[1]) ||
                                letra.equals(CaracterOpen[2]) || letra.equals(CaracterOpen[3])) {   
                             
                             minhaPilha.push(letra);
                        }
                        else{
                            if ((letra.equals(CaracterFinish[0])|| letra.equals(CaracterFinish[1]) ||
                                letra.equals(CaracterFinish[2]) || letra.equals(CaracterFinish[3]))) {
                                valida = minhaPilha.isEmpty();
                                if (!valida) {
                                    abc = minhaPilha.a[minhaPilha.top];
                                String montagem = abc+letra;
                                if (montagem.equals("[]")) {
                                    minhaPilha.pop();
                                    minhaPilha.peek();
                                    
                                }else{
                                    
                                if (montagem.equals("()")) {
                                    minhaPilha.pop();
                                    minhaPilha.peek();
                                }
                                else{
                                if (montagem.equals("{}")) {
                                    minhaPilha.pop();
                                    minhaPilha.peek();
                                }else{
                                if (montagem.equals("<>")) {
                                    minhaPilha.pop();
                                    minhaPilha.peek();
                                }
                                else{
                                     mensagem = "Invalido!";
                                }
                                }
                                }
                                }
                                }
                                else{
                                    mensagem = "Invalido!";
                                 
                                }
                                
                            }
                            else{
                                 mensagem = "Invalido!";
                                 
                            }
                        }
                    }
                    FileWriter fw = new FileWriter("./src/Arquivo-Check.txt",true);
                    in.close();
                    fw.write(dados.get(a) + " - " + mensagem + "\n");
                    fw.close();
                    
                
                    System.out.println(dados.get(a) + " - " + mensagem);
                    
                    
                   
                }
                
                in.close();
            } catch (IOException ex) {   
        }
            
    }
        System.out.println(" ARQUIVO TEXTO CHECK SALVO NA PASTA : /src/Arquivo-Check.txt");
  }
    
  
}
