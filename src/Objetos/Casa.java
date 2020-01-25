package Objetos;
/**
 *
 * @author Samir Portillo
 */
public class Casa 
{
    private String codigo;
    private int cantidad_cuartos;
    private int cantidad_banos;
    private int precio_x_mes;
    private int deposito;
    private String provincia;
    private String canton;
    private String barrio;
    private String direccion;
    private boolean cochera;
    private boolean patio;
    private boolean amueblado;
    private boolean agua;
    private boolean luz;
    private boolean internet;
    private boolean cable;

    public Casa(String codigo, int cantidad_cuartos, int cantidad_banos, int precio_x_mes, int deposito, String provincia, String canton, String barrio, String direccion, boolean cochera, boolean patio, boolean amueblado, boolean agua, boolean luz, boolean internet, boolean cable) {
        this.codigo = codigo;
        this.cantidad_cuartos = cantidad_cuartos;
        this.cantidad_banos = cantidad_banos;
        this.precio_x_mes = precio_x_mes;
        this.deposito = deposito;
        this.provincia = provincia;
        this.canton = canton;
        this.barrio = barrio;
        this.direccion = direccion;
        this.cochera = cochera;
        this.patio = patio;
        this.amueblado = amueblado;
        this.agua = agua;
        this.luz = luz;
        this.internet = internet;
        this.cable = cable;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad_cuartos() {
        return cantidad_cuartos;
    }

    public void setCantidad_cuartos(int cantidad_cuartos) {
        this.cantidad_cuartos = cantidad_cuartos;
    }

    public int getCantidad_banos() {
        return cantidad_banos;
    }

    public void setCantidad_banos(int cantidad_banos) {
        this.cantidad_banos = cantidad_banos;
    }

    public int getPrecio_x_mes() {
        return precio_x_mes;
    }

    public void setPrecio_x_mes(int precio_x_mes) {
        this.precio_x_mes = precio_x_mes;
    }

    public int getDeposito() {
        return deposito;
    }

    public void setDeposito(int deposito) {
        this.deposito = deposito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isCochera() {
        return cochera;
    }

    public void setCochera(boolean cochera) {
        this.cochera = cochera;
    }

    public boolean isPatio() {
        return patio;
    }

    public void setPatio(boolean patio) {
        this.patio = patio;
    }

    public boolean isAmueblado() {
        return amueblado;
    }

    public void setAmueblado(boolean amueblado) {
        this.amueblado = amueblado;
    }

    public boolean isAgua() {
        return agua;
    }

    public void setAgua(boolean agua) {
        this.agua = agua;
    }

    public boolean isLuz() {
        return luz;
    }

    public void setLuz(boolean luz) {
        this.luz = luz;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public boolean isCable() {
        return cable;
    }

    public void setCable(boolean cable) {
        this.cable = cable;
    }

    

    
}
