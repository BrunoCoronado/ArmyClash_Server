/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.graficos;

import estructuras.matrizDispersa.Matriz;
import estructuras.matrizDispersa.NodoCelda;
import estructuras.matrizDispersa.NodoColumna;
import estructuras.matrizDispersa.NodoFila;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author bruno
 */
public class MatrizDispersa {
    private int colMax;
    public void graficarMatriz(Matriz matriz){
        try{
            if(matriz != null){
                BufferedWriter writer = new BufferedWriter(new FileWriter("Matriz.txt", false));
                NodoFila tmpF = matriz.primeroFila;
                colMax = matriz.numeroColumnasMaximo();
                String rank = "{rank = same; mt; ";
                writer.write("digraph matriz{\n node [shape=box]\n mt[ label = \"matriz\" group = 1 ];\n");
                //cabeceras de fila
                String cabeceras = "";
                String conexiones = "mt->";
                String conexionesCabeceraCeldas = "";
                while(tmpF != null){
                    cabeceras += "y"+tmpF.numFila+" [label = \"y"+tmpF.numFila+"\" group = 1 ];\n";
                    conexiones += "y"+tmpF.numFila+"\n";
                    if(tmpF.abajo != null){
                        conexiones += "y"+tmpF.numFila+"->";
                    }
                    if(tmpF.derecha != null){
                        conexionesCabeceraCeldas += "y"+tmpF.numFila+"->x"+tmpF.derecha.numColumna+"y"+tmpF.derecha.numFila+"\n";
                    }
                    tmpF = tmpF.abajo;
                }
                writer.write(cabeceras+"\n"+conexiones+"\n");
                //cabeceras de columna
                cabeceras = "";
                conexiones = "mt->";
                NodoColumna tmpC = matriz.primeroColumna;
                while(tmpC != null){
                    cabeceras += "x"+tmpC.numColumna+" [label = \"x"+tmpC.numColumna+"\" group = "+(tmpC.numColumna+1)+" ];\n";
                    rank += " x"+tmpC.numColumna+";";
                    conexiones += "x"+tmpC.numColumna+"\n";
                    if(tmpC.siguiente != null){
                        conexiones += "x"+tmpC.numColumna+"->";
                    }
                    if(tmpC.abajo != null){
                        conexionesCabeceraCeldas += "x"+tmpC.numColumna+"->x"+tmpC.abajo.numColumna+"y"+tmpC.abajo.numFila+"\n";
                    }
                    tmpC = tmpC.siguiente;
                }
                rank += "};";
                writer.write(cabeceras+"\n"+conexiones+"\n");
                writer.write(rank+"\n");
                
                
                String celdas = "";
                conexiones = "";
                rank = "{rank = same;";
                
                tmpF = matriz.primeroFila;
                while(tmpF != null){
                    rank += "y"+tmpF.numFila+";";
                    NodoCelda tmpCelda = tmpF.derecha;
                    while(tmpCelda != null){
                        celdas += "x"+tmpCelda.numColumna+"y"+tmpCelda.numFila+" [ label = \"x:"+tmpCelda.numColumna+"y:"+tmpCelda.numFila+""+tmpCelda.valor.toString()+"\" group = "+(tmpCelda.numColumna+1)+" ];\n";
                        conexiones += añadirConexiones(tmpCelda);
                        rank += " x"+tmpCelda.numColumna+"y"+tmpCelda.numFila+";";
                        tmpCelda = tmpCelda.derecha;
                    }
                    rank += " };\n";
                    if(tmpF.abajo != null){
                        rank += "{rank = same;";
                    }
                    tmpF = tmpF.abajo;
                }
                
                writer.write(celdas+"\n"+conexiones+"\n");
                writer.write(conexionesCabeceraCeldas+"\n");
                writer.write(rank+"\n");
                
                writer.write("}");
                
                writer.close();
                Runtime.getRuntime().exec("dot.exe -Tsvg Matriz.txt -o Matriz.svg");
                String [] cmd = {"cmd.exe", "/c", "start", "Matriz.svg" };
                Runtime.getRuntime().exec(cmd);
            }
        }catch(Exception ex){}
    }
    
    private String añadirConexiones(NodoCelda tmpCelda){
        String conexion = "";
        if(tmpCelda.arriba != null){
            conexion += "x"+tmpCelda.numColumna+"y"+tmpCelda.numFila+"->x"+tmpCelda.arriba.numColumna+"y"+tmpCelda.arriba.numFila+";\n";
        }
        if(tmpCelda.abajo != null){
            conexion += "x"+tmpCelda.numColumna+"y"+tmpCelda.numFila+"->x"+tmpCelda.abajo.numColumna+"y"+tmpCelda.abajo.numFila+";\n";
        }
        if(tmpCelda.derecha != null){
            conexion += "x"+tmpCelda.numColumna+"y"+tmpCelda.numFila+"->x"+tmpCelda.derecha.numColumna+"y"+tmpCelda.derecha.numFila+";\n";
        }
        if(tmpCelda.izquierda != null){
            conexion += "x"+tmpCelda.numColumna+"y"+tmpCelda.numFila+"->x"+tmpCelda.izquierda.numColumna+"y"+tmpCelda.izquierda.numFila+";\n";
        }
        return conexion;
    }
}
