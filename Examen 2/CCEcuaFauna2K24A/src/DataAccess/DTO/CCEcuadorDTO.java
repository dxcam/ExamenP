package DataAccess.DTO;

public class CCEcuadorDTO {

    private int idLocalidad;
    private int idLocaliadPadre;
    private int idLocaliadHijo;
    private String nombre;

    public CCEcuadorDTO() {
    }

    public CCEcuadorDTO(int idLocalidad, int idLocaliadPadre, int idLocaliadHijo, String nombre) {
        this.idLocalidad = idLocalidad;
        this.idLocaliadPadre = idLocaliadPadre;
        this.idLocaliadHijo = idLocaliadHijo;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "\n idLocalidad:      " + getIdLocalidad()      +
                "\n idLocaliadPadre:  " + getIdLocaliadPadre()  +
                "\n idLocaliadHijo    " + getIdLocaliadHijo()   +
                "\n nombre            " + getNombre()           + "\n";
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public int getIdLocaliadPadre() {
        return idLocaliadPadre;
    }

    public void setIdLocaliadPadre(int idLocaliadPadre) {
        this.idLocaliadPadre = idLocaliadPadre;
    }

    public int getIdLocaliadHijo() {
        return idLocaliadHijo;
    }

    public void setIdLocaliadHijo(int idLocaliadHijo) {
        this.idLocaliadHijo = idLocaliadHijo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
