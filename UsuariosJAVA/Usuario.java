
public class Usuario 
{
    String nombre;
    int edad;

    // CONSTRUCTOR - solo se llama al crearse el objeto de tipo usuario
    public Usuario(String n, int e) 
    {
        this.nombre = n;
        this.edad = e;
    }

    // GETTERS - DEVUELVEN INFORMACIÓN DE LA CLASE "USUARIO"
    public String getNombre()
    {
        return nombre;
    }

    public int getEdad() 
    {
        return edad;
    }

    // SETTERS - Setear y editar el valor de las variables
    public void setNombre(String nuevoNombre)
    {
        this.nombre = nuevoNombre;
    }

    public void setEdad(int edadNueva) 
    {
        this.edad = edadNueva;
    }

    // SOBREESCRIBIR LO QUE JAVA DEVUELVE Y ENTIENDE POR UN OBJETO "USUARIO"
    @Override
    public String toString() 
    {
        return "Nombre [" + nombre + "] , Edad [" + edad + "]";
    }

}
