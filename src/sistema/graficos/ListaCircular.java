/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.graficos;

import estructuras.listaDobleCircular.ListaDobleCircular;
import estructuras.listaDobleCircular.NodoLC;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author bruno
 */
public class ListaCircular {
    
    public void graficarLista(ListaDobleCircular lista){
        try{
            if(lista != null){
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("ListaC.txt", false))) {
                    writer.write("digraph G {\n node[shape=record];\n rankdir=LR;");
                    String conexiones = "";
                    
                    if(lista.primero != null){
                        NodoLC tmp = lista.primero;
                        do{
                            writer.write("c"+tmp.capa+"[label=\"{<n>|<data> "+tmp.capa+"|<next>}\"];\n");
                            conexiones +="c"+tmp.capa+":next -> c"+tmp.siguiente.capa+":n;\n c"+tmp.siguiente.capa+":n -> c"+tmp.capa+":next;";
                            tmp = tmp.siguiente;
                        }while(tmp != lista.primero);
                    }
                    writer.write(conexiones+"\n}");
                }
                Runtime.getRuntime().exec("dot.exe -Tsvg ListaC.txt -o ListaC.svg");
                String [] cmd = {"cmd.exe", "/c", "start", "ListaC.svg" };
                Runtime.getRuntime().exec(cmd);
            }
        }catch(Exception ex){sistema.ui.VentanaConfiguracion.txtLog.append("Error Graficando Lista...\n");}
    }
}
