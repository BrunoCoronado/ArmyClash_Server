/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.graficos;

import estructuras.arbolBinario.Arbol;
import estructuras.arbolBinario.NodoA;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author bruno
 */
public class ArbolBinario {
    
    Arbol arb;
    String contenido = "";
    String relaciones = "";
    public void graficarArbol(Arbol arbol){
        try{
            contenido = "";relaciones = "";
            BufferedWriter writer = new BufferedWriter(new FileWriter("ABB.txt", false));
            arb = arbol;
            writer.write("digraph G {\n");
            contenido(arb.raiz);
            writer.write(contenido);
            writer.write(relaciones);
            writer.write("}");
            writer.close();
            Runtime.getRuntime().exec("dot.exe -Tsvg ABB.txt -o ABB.svg");
            String [] cmd = {"cmd.exe", "/c", "start", "ABB.svg" };
            Runtime.getRuntime().exec(cmd);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void contenido(NodoA tmp){
        if(tmp != null){
            contenido += "nodo"+tmp.tropa.getId()+"[label = \"ID: "+tmp.tropa.getId()+" \\nTipo: "+tmp.tropa.getNombre()+"  \\nPosX: "+tmp.tropa.getPosicionX()+" \\nPosY: "+tmp.tropa.getPosicionY()+"\\nVida: "+tmp.tropa.getVida()+"\\nAtaque: "+tmp.tropa.getAtaque()+"\\nMoviento: "+tmp.tropa.getAlcanceMovimiento()+"\\nA. Ataque:"+tmp.tropa.getAlcanceAtaque()+"\"]\n";
            if(tmp.padre != null){
                relaciones += "\"nodo"+tmp.padre.tropa.getId()+"\"" + "->"+"\"nodo"+tmp.tropa.getId()+"\"\n";
            }
            contenido(tmp.izq);
            contenido(tmp.der);
        }   
    }
}
