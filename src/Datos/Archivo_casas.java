/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Objetos.Casa;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Samir Portillo
 */
public class Archivo_casas 
{
    private String ruta = "D:\\Documents\\NetBeansProjects\\Bienes raices Alex\\src\\Datos\\casas.txt";
    public  boolean insertarCasa(Casa casa) 
    {
        boolean res = false;
        File file = new File(ruta);
        try
        {
            if(!file.exists())
            {
                file.createNewFile();
            }
            if(file.exists())
            {
               String home = casa.getCodigo()+","+casa.getCantidad_cuartos()+","+casa.getCantidad_banos()+","+casa.getPrecio_x_mes()+","+casa.getDeposito()
               +","+casa.getProvincia()+","+casa.getCanton()+","+casa.getBarrio()+","+casa.getDireccion()+","+casa.isCochera()+","+casa.isPatio()
               +","+casa.isAmueblado()+","+casa.isAgua()+","+casa.isLuz()+","+casa.isInternet()+","+casa.isCable();
               
               FileWriter fw = new FileWriter(file, true);
               BufferedWriter bw = new BufferedWriter(fw); 
               bw.write(home+"\n");
               bw.close();
               res = true;
            }  
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return res;
    }

    public ArrayList <Casa> sacarCasa() 
    {    
        ArrayList <Casa> listaCasas = new ArrayList<>();
        String res = "";
        String res2 = "";
        try 
          {
            File file = new File(ruta);       
            if(file.exists())
                {
                   FileReader f = new FileReader(file);
                   BufferedReader b = new BufferedReader(f);
                   while( (res = b.readLine())!= null )
                   {                                         
                        String[] arreglo = res.split(",");
                        int cuartos, banos, mes, deposito;
                        String codigo,provincia, canton, barrio, dirrecion;
                        boolean cochera, patio, amueblado, agua, luz, internet, cable;  
                        codigo = arreglo[0];
                        cuartos = Integer.parseInt(arreglo[1]);
                        banos = Integer.parseInt(arreglo[2]);
                        mes = Integer.parseInt(arreglo[3]);
                        deposito = Integer.parseInt(arreglo[4]);
                        // me dejo los strings
                        provincia = arreglo[5];
                        canton = arreglo[6];
                        barrio = arreglo[7];
                        dirrecion = arreglo[8];
                        // me dejo los bool
                        cochera = Boolean.parseBoolean(arreglo[9]);
                        patio = Boolean.parseBoolean(arreglo[10]);
                        amueblado = Boolean.parseBoolean(arreglo[11]);
                        agua = Boolean.parseBoolean(arreglo[12]);
                        luz = Boolean.parseBoolean(arreglo[13]);
                        internet = Boolean.parseBoolean(arreglo[14]);
                        cable = Boolean.parseBoolean(arreglo[15]);       
                        Casa casa = new Casa(codigo,cuartos,banos,mes,deposito,provincia,canton,barrio,dirrecion,cochera,patio,amueblado,agua,luz,internet,cable); 
                        listaCasas.add(casa);
                   }                  
                }
          } 
        catch (Exception e) 
          {
              System.out.println(e);
          }
        return listaCasas;         
    }
     public  boolean editarCasaDados(Casa casa,String cod)
    {
        String leer = "";
        int indice;
        ArrayList <Casa> listaCasas = new ArrayList<>();
        boolean res = false;
        try 
        {
            File file = new File(ruta);
            if(file.exists())
            {
                FileReader f = new FileReader(file);
                BufferedReader b = new BufferedReader(f);
                while((leer = b.readLine())!= null)
                   {                     
                        String[] arreglo = leer.split(",");
                        int cuartos, banos, mes, deposito;
                        String codigo,provincia, canton, barrio, dirrecion;
                        boolean cochera, patio, amueblado, agua, luz, internet, cable;  
                        codigo = arreglo[0];
                        cuartos = Integer.parseInt(arreglo[1]);
                        banos = Integer.parseInt(arreglo[2]);
                        mes = Integer.parseInt(arreglo[3]);
                        deposito = Integer.parseInt(arreglo[4]);
                        // me dejo los strings
                        provincia = arreglo[5];
                        canton = arreglo[6];
                        barrio = arreglo[7];
                        dirrecion = arreglo[8];
                        // me dejo los bool
                        cochera = Boolean.parseBoolean(arreglo[9]);
                        patio = Boolean.parseBoolean(arreglo[10]);
                        amueblado = Boolean.parseBoolean(arreglo[11]);
                        agua = Boolean.parseBoolean(arreglo[12]);
                        luz = Boolean.parseBoolean(arreglo[13]);
                        internet = Boolean.parseBoolean(arreglo[14]);
                        cable = Boolean.parseBoolean(arreglo[15]);       
                        Casa casas = new Casa(codigo,cuartos,banos,mes,deposito,provincia,canton,barrio,dirrecion,cochera,patio,amueblado,agua,luz,internet,cable); 
                        listaCasas.add(casas);
                   }  
                for (Casa objeto : listaCasas) 
                {
                    if(objeto.getCodigo().equals(cod))
                    {
                        
                         indice = listaCasas.indexOf(objeto);
                         listaCasas.set(indice, casa);                     
                    }                 
                }
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("");
                bw.close();
                for (Casa casaO : listaCasas) 
                   {
                       FileWriter fw2 = new FileWriter(file, true);
                       BufferedWriter bw2 = new BufferedWriter(fw2);
                       String home = casaO.getCodigo()+","+casaO.getCantidad_cuartos()+","+casaO.getCantidad_banos()+","+casaO.getPrecio_x_mes()+","+casaO.getDeposito()
                       +","+casaO.getProvincia()+","+casaO.getCanton()+","+casaO.getBarrio()+","+casaO.getDireccion()+","+casaO.isCochera()+","+casaO.isPatio()
                       +","+casaO.isAmueblado()+","+casaO.isAgua()+","+casaO.isLuz()+","+casaO.isInternet()+","+casaO.isCable(); 
                       bw2.write(home+"\n");
                       bw2.close();                          
                    }
                
                res = true;
            }             
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return res;
    }

    public boolean eliminarCasa(String cod) 
    {
        String leer = "";
        int indice = 0;
        ArrayList <Casa> listaCasas = new ArrayList<>();
        boolean res = false;
        try 
        {
            File file = new File(ruta);
            if(file.exists())
            {
                FileReader f = new FileReader(file);
                BufferedReader b = new BufferedReader(f);
                while((leer = b.readLine())!= null)
                   {                     
                        String[] arreglo = leer.split(",");
                        int cuartos, banos, mes, deposito;
                        String codigo,provincia, canton, barrio, dirrecion;
                        boolean cochera, patio, amueblado, agua, luz, internet, cable;  
                        codigo = arreglo[0];
                        cuartos = Integer.parseInt(arreglo[1]);
                        banos = Integer.parseInt(arreglo[2]);
                        mes = Integer.parseInt(arreglo[3]);
                        deposito = Integer.parseInt(arreglo[4]);
                        // me dejo los strings
                        provincia = arreglo[5];
                        canton = arreglo[6];
                        barrio = arreglo[7];
                        dirrecion = arreglo[8];
                        // me dejo los bool
                        cochera = Boolean.parseBoolean(arreglo[9]);
                        patio = Boolean.parseBoolean(arreglo[10]);
                        amueblado = Boolean.parseBoolean(arreglo[11]);
                        agua = Boolean.parseBoolean(arreglo[12]);
                        luz = Boolean.parseBoolean(arreglo[13]);
                        internet = Boolean.parseBoolean(arreglo[14]);
                        cable = Boolean.parseBoolean(arreglo[15]);       
                        Casa casas = new Casa(codigo,cuartos,banos,mes,deposito,provincia,canton,barrio,dirrecion,cochera,patio,amueblado,agua,luz,internet,cable); 
                        listaCasas.add(casas);
                   }  

                for (Casa objeto : listaCasas) 
                {
                    if(objeto.getCodigo().equals(cod))
                    {                                 
                         indice = listaCasas.indexOf(objeto);                        
                    }                       
                }
                listaCasas.remove(indice);
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("");
                bw.close();
                for (Casa casaO : listaCasas) 
                   {
                       FileWriter fw2 = new FileWriter(file, true);
                       BufferedWriter bw2 = new BufferedWriter(fw2);
                       String home = casaO.getCodigo()+","+casaO.getCantidad_cuartos()+","+casaO.getCantidad_banos()+","+casaO.getPrecio_x_mes()+","+casaO.getDeposito()
                       +","+casaO.getProvincia()+","+casaO.getCanton()+","+casaO.getBarrio()+","+casaO.getDireccion()+","+casaO.isCochera()+","+casaO.isPatio()
                       +","+casaO.isAmueblado()+","+casaO.isAgua()+","+casaO.isLuz()+","+casaO.isInternet()+","+casaO.isCable(); 
                       bw2.write(home+"\n");
                       bw2.close();                          
                    }
                
                res = true;
            }             
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return res;
    }
}