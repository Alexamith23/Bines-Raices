package Datos;
import Objetos.Persona;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Samir Portillo
 */
public class Archivo_RegistroPersonas 
{
    private String ruta = "D:\\Documents\\NetBeansProjects\\Bienes raices Alex\\src\\Datos\\personas.txt";
    public  boolean insertarPersona(Persona persona) 
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
               String human = persona.getCedula()+","+persona.getNombre()+","+persona.getApellido1()+","+persona.getTelefono()+","+persona.getUser()+","+persona.getPassword()+","+persona.getTipo();             
               FileWriter fw = new FileWriter(file, true);
               BufferedWriter bw = new BufferedWriter(fw); 
               bw.write(human+"\n");
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
    
    public ArrayList <Persona> sacarPersona() 
    {    
        ArrayList <Persona> listaPersonas = new ArrayList<>();
        String res = "";
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
                        int cedula, telefono, tipo;
                        String nombre, apellido, user, password;               
                        cedula = Integer.parseInt(arreglo[0]);
                        nombre = arreglo[1];
                        apellido = arreglo[2];
                        telefono = Integer.parseInt(arreglo[3]);
                        user = arreglo[4];
                        password = arreglo[5];
                        tipo = Integer.parseInt(arreglo[6]);
                        Persona persona = new Persona(cedula, nombre, apellido, telefono, user, password, tipo);                    
                        listaPersonas.add(persona);
                   }                  
                }
          } 
        catch (Exception e) 
          {
              System.out.println(e);
          }
        return listaPersonas;         
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
