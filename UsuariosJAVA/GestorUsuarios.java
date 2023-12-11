import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.nio.file.Path;


public class GestorUsuarios 
{

    static String FILE_PATH = "usuariosGuardados.txt";
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

    public static String colorVerde = "\033[0;32m";
    public static String colorAmarillo = "\033[0;33m";
    public static String colorRojo = "\033[0;31m";
    public static String colorVioleta = "\033[0;35m";
    public static String resetColor = "\033[0;37m";

    public static void Msj(String texto)
    {
        System.out.println(texto);
    }

    public static void CrearUsuariosIniciales()
    {
        Usuario userUno = new Usuario("Jose", 20);
        Usuario userDos = new Usuario("Belen", 28);
        Usuario userTres = new Usuario("Stephi", 30);

        listaUsuarios.add(userUno);
        listaUsuarios.add(userDos);
        listaUsuarios.add(userTres);

    }

    public static void IniciarGestor() 
    {
       
        Scanner input = new Scanner(System.in);
     

       // CrearUsuariosIniciales();

        CargarUsuariosDelArchivo();
       
        // userUno.setNombre("Adrian");
        // userTres.setEdad(11);

        
        
        while (true) 
        {
            try{
            Msj("");
            Msj(colorVioleta + "Bienvenidos al Sistema de usarios" + resetColor);
            Msj(colorVioleta + "1." + resetColor + "Agregar un Usuario" + resetColor);
            Msj(colorVioleta + "2." + resetColor + "Editar un Usuario" + resetColor);
            Msj(colorVioleta + "3." + resetColor + "Eliminar un Usuario" + resetColor);
            Msj(colorVioleta + "4." + resetColor + "Mostrar lista de usuarios" + resetColor);
            Msj(colorVioleta + "5." + resetColor + "Salir y Guardar Usuarios" + resetColor);
            Msj(colorVioleta + "Seleccione una opcion" + resetColor);

            int opcion = input.nextInt();

            switch (opcion)
            {
                case 1:
                    // Agregar usuario
                    input.nextLine();
                    Msj(colorAmarillo + "Ingrese el nombre del usuario" + resetColor);
                    String nuevoNombre = input.nextLine();

                    Msj(colorAmarillo + "Ingrese la edad del usuario" + resetColor);
                    int nuevaEdad = input.nextInt();

                    Usuario nuevoUsuario = new Usuario(nuevoNombre, nuevaEdad);
                    listaUsuarios.add(nuevoUsuario);
               

                    Msj(colorVerde + "Usuario Ingresado con Exito" + resetColor);

                    break;

                case 2:
                    // editar usuario por INDICE
                    int indiceEditar = 0;
                    Msj(colorAmarillo + "------LISTADO DE USUARIOS------" + resetColor);
                    for (Usuario u : listaUsuarios) {
                        System.out.println(colorAmarillo + "[" + indiceEditar + "] " + resetColor + u);
                        indiceEditar++;
                    }
                    Msj(colorAmarillo + "-----------------------------" + resetColor);

                    Msj(colorAmarillo + "---SELECCIONE EL INDICE DEL USUARIO A EDITAR---" + resetColor);
                    int opcionNumEditar = input.nextInt();

                    if (opcionNumEditar < listaUsuarios.size() && opcionNumEditar >= 0) {
                        input.nextLine();
                        Msj(colorVerde + "Ingrese el NUEVO NOMBRE del usuario" + resetColor);
                        String nombreEditado = input.nextLine();
                        Msj(colorVerde + "Ingrese la NUEVA EDAD del usuario" + resetColor);
                        int edadEditada = input.nextInt();

                        listaUsuarios.get(opcionNumEditar).setEdad(edadEditada);
                        listaUsuarios.get(opcionNumEditar).setNombre(nombreEditado);
                    } else 
                    {
                        Msj(colorRojo + "---INDICE NO EXISTENTE EN LA LISTA---" + resetColor);
                    }

                    // editar usuario por NOMBRE

                    /*
                     * input.nextLine();
                     * Msj("Ingresa el nombre del usuario a editar");
                     * String nombreAEditar = input.nextLine();
                     * 
                     * Usuario usuarioAEditar = null;
                     * 
                     * for(Usuario u : listaUsuarios)
                     * {
                     * if(u.getNombre().equals(nombreAEditar))
                     * {
                     * usuarioAEditar = u;
                     * break;
                     * }
                     * }
                     * 
                     * if(usuarioAEditar != null)
                     * {
                     * //editar usuario
                     * Msj(colorVerde+"Ingrese el NUEVO NOMBRE del usuario"+resetColor);
                     * String nombreEditado = input.nextLine();
                     * Msj(colorVerde+"Ingrese la NUEVA EDAD del usuario"+resetColor);
                     * int edadEditada = input.nextInt();
                     * 
                     * //actualizar los datos del usuario
                     * 
                     * usuarioAEditar.setNombre(nombreEditado);
                     * usuarioAEditar.setEdad(edadEditada);
                     * 
                     * Msj(colorVerde+"usuario EDITADO EXITOSAMENTE"+resetColor);
                     * 
                     * 
                     * }else
                     * {
                     * Msj(colorRojo+"usuario NO ENCONTRADO"+resetColor);
                     * }
                     */
                    break;

                case 3:

                    // Eliminar usuario por INDICE
                    int indice = 0;
                    Msj(colorAmarillo + "------LISTADO DE USUARIOS------" + resetColor);
                    for (Usuario u : listaUsuarios) {
                        System.out.println(colorAmarillo + "[" + indice + "] " + resetColor + u);
                        indice++;
                    }
                    Msj(colorAmarillo + "-----------------------------" + resetColor);

                    Msj(colorAmarillo + "---SELECCIONE EL INDICE DEL USUARIO A ELIMINAR---" + resetColor);
                    int opcionNum = input.nextInt();

                    if (opcionNum < listaUsuarios.size() && opcionNum >= 0) {
                        // eliminar
                        listaUsuarios.remove(opcionNum);
                        Msj(colorVerde + "Usuario con el indice [" + opcionNum + "] eliminado. " + resetColor);
                    } else {
                        Msj(colorRojo + "---INDICE NO EXISTENTE EN LA LISTA---" + resetColor);
                    }

                    // Eliminar usuario por NOMBRE

                    /*
                     * input.nextLine();
                     * Msj("Ingrese el nombre del usuario a QUITAR");
                     * String nombreAQuitar = input.nextLine();
                     * 
                     * Usuario usuarioAEliminar = null;
                     * 
                     * for(Usuario u: listaUsuarios)
                     * {
                     * if(u.getNombre().equals(nombreAQuitar))
                     * {
                     * usuarioAEliminar = u;
                     * break;
                     * }
                     * }
                     * 
                     * //PREGUNTAR SI ENCONTRE EL USUARIO QUE SE INGRESO POR INPUT
                     * if(usuarioAEliminar != null)
                     * {
                     * //encontre el usuario
                     * listaUsuarios.remove(usuarioAEliminar);
                     * Msj(colorVerde + "Usuario Eliminado" + resetColor);
                     * }else
                     * {
                     * Msj(colorRojo+"Usuario NO ENCONTRADO"+resetColor);
                     * }
                     * 
                     */

                    break;

                case 4:
                    // mostrar lista de usuarios
                    // MOSTRAR LA LISTA
                    Msj(colorAmarillo + "------LISTADO DE USUARIOS------" + resetColor);
                    for (Usuario u : listaUsuarios) {
                        System.out.println(u);
                    }
                    Msj(colorAmarillo + "-----------------------------" + resetColor);
                    break;

                case 5:
                    // Salir
                    GuardarUsuariosEnUnArchivo();
                    Msj(colorRojo + "Saliendo del programa" + resetColor);
                    System.exit(0);
                    break;

                default:
                    Msj("Opcion ingresada INCORRECTA");
                    break;
                }
            } catch (Exception e)         
            {
                Msj(colorRojo+"#####INGRESA UN OPCION VALIDA#####"+resetColor);
                input.nextLine();

                e.printStackTrace();
            }

        }


        
    }


    public static void GuardarUsuariosEnUnArchivo()
    {
        try(PrintWriter escritor = new PrintWriter(new FileWriter(FILE_PATH)))
        {
            for(Usuario u : listaUsuarios)
            {
                escritor.println(u.getNombre() + "," + u.getEdad());
            }

            System.out.println(colorVerde+"Usuarios guardados en el archivo: " + FILE_PATH+resetColor);


        }catch(IOException e)
        {
            System.out.println("ERROR AL INTENTAR GUARDAR USUARIOS EN EL ARCHIVO");
            e.printStackTrace();
        }
    }

    //LEER USUARIOS DESDE UN ARCHIVO (SIN DUPLICADOS)
    
    public static void CargarUsuariosDelArchivo() {
        try (BufferedReader lector = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0];
    
                // Check for duplicates
                boolean nombreExistente = false;
                for (Usuario existingUser : listaUsuarios) {
                    if (existingUser.getNombre().equals(nombre)) {
                        nombreExistente = true;
                        break;
                    }
                }
    
                if (!nombreExistente) {
                    int edad = Integer.parseInt(partes[1]);
                    Usuario user = new Usuario(nombre, edad);
                    listaUsuarios.add(user);
                } else {
                    System.out.println(colorRojo + "Usuario duplicado encontrado: " + nombre + resetColor);
                }
            }
    
            System.out.println(colorVerde + "USUARIOS CARGADOS DEL ARCHIVO: " + FILE_PATH + resetColor);
    
        } catch (IOException e) {
            System.out.println(colorRojo + "ERROR AL CARGAR USUARIOS" + resetColor);
            e.printStackTrace();
        }
    }


}

/*
 * // Regular Colors
 * public static final String BLACK = "\033[0;30m"; // BLACK
 * public static final String RED = "\033[0;31m"; // RED
 * public static final String GREEN = "\033[0;32m"; // GREEN
 * public static final String YELLOW = "\033[0;33m"; // YELLOW
 * public static final String BLUE = "\033[0;34m"; // BLUE
 * public static final String PURPLE = "\033[0;35m"; // PURPLE
 * public static final String CYAN = "\033[0;36m"; // CYAN
 * public static final String WHITE = "\033[0;37m"; // WHITE
 * 
 * // Bold
 * public static final String BLACK_BOLD = "\033[1;30m"; // BLACK
 * public static final String RED_BOLD = "\033[1;31m"; // RED
 * public static final String GREEN_BOLD = "\033[1;32m"; // GREEN
 * public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
 * public static final String BLUE_BOLD = "\033[1;34m"; // BLUE
 * public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
 * public static final String CYAN_BOLD = "\033[1;36m"; // CYAN
 * public static final String WHITE_BOLD = "\033[1;37m"; // WHITE
 * 
 * 
 */