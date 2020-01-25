/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Archivo_RegistroPersonas;
import Interfaz.CRUD_casa;
import Objetos.Persona;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
   
/**
 *
 * @author Samir Portillo
 */
public class RegistroLog 
{
    private Archivo_RegistroPersonas registroD = new Archivo_RegistroPersonas(); 
    private ArrayList <Persona> listaPersonas = new ArrayList<>();
    public String registrarPer(Persona persona)
    {
        String res = "Algo salió mal";
        if(validar_cedula_y_usuario(persona) != 0)
        {
            res = "Lo siento, el numero de cédula o tu nombre de usuario ya existen";
        }
        else
        {
            if(registroD.insertarPersona(persona))
            {
                res = "Te has registrado con exito";
            }
        }
        
        return res;
    }

    private int validar_cedula_y_usuario(Persona persona) 
    {
        int contador = 0;
        listaPersonas = registroD.sacarPersona();
        if(listaPersonas.size() != 0)
        {
            for (Persona per : listaPersonas)
            {
                if(per.getCedula() == persona.getCedula() || per.getUser().equals(persona.getUser()))
                {
                    contador++;
                }
            }
        }
        listaPersonas.clear();
        return contador;
       
    }
    
    public boolean validar(String user, String password)
    {
        boolean valor = false;
        listaPersonas = registroD.sacarPersona();
        if(listaPersonas.size() != 0)
        {
            for (Persona per : listaPersonas)
            {
                if(per.getUser().equals(user) && per.getPassword().equals(password))
                {
                    valor = true;
                    break;
                }
            }
        }
        listaPersonas.clear();
        return valor;
    }

}
