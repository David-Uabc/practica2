package pract2;
//import java.util.ArrayList; tenia mucho en mente este paquete para capturar pero no supe como utilizarlo ya que creo que es mucho mas facil para
//crear estos menus de captura
import java.util.Scanner;

//videos con los que me apoye para realizar la practica tome algunas ideas de esos videos
//https://www.youtube.com/watch?v=3xEQIM1vTt0&list=LL&index=2&ab_channel=heltonsmithbustossaez
//https://www.youtube.com/watch?v=bl7lgZ62w9s&list=LL&index=4&t=438s&ab_channel=Shakmuria

public class Main {
	
	public static void main(String args[]) {
  int opc=0;
  Scanner opciones= new Scanner(System.in);
  //visto en arreglos 2 el viernes
  Estudiante Alumnos[] = new Estudiante[10]; //pongo mi arreglo de 10 ya que tengo que inicializar 5 y capturar 5 mas     
  Alumnos[0] = new Estudiante("David", 1269352, "Espanol",100);
  Alumnos[1] = new Estudiante("Claudia",1269353,"Historia",50 );
  Alumnos[2] = new Estudiante("Mauricio",1269354, "Geografia", 95);
  Alumnos[3] = new Estudiante("Mayco", 1269355, "Calculo Diferencial", 30);
  Alumnos[4] = new Estudiante("Shente", 1269356, "Cal.Multivariable", 80);
        
  do{  //MENU       
  System.out.println("[1]_Capturar Alumnos");
  System.out.println("[2]_Mostrar Alumno");
  System.out.println("[3]_Cambiar calificacion");
  System.out.println("[4]_Salir");
  System.out.print("Ingrese la opcion a solicitar: ");
  opc = opciones.nextInt();
  switch(opc)
 {
  case 1:                
 
   //Capturar estudiantes que solo capturare mediante el teclado
  for(int i = 5; i<10; i++)
 {
  Alumnos[i] = new Estudiante(CapturaEntrada.capturarCadena("Nombre"), 
  CapturaEntrada.capturarEntero("Numero de control"),
  CapturaEntrada.capturarCadena("Materia"), 
  CapturaEntrada.capturarDoble("Calificacion"));
 }
  break;
 
 case 2: 
   //IMPRIME ALUMNOS CAPTURADOS Y INICIALIZADOS
  for(int i = 0; i<10; i++) 
 {
  System.out.println("***************************");
  System.out.println();
  System.out.println("Datos");
  System.out.println();
  System.out.println("Nombre: " + Alumnos[i].getNombre());
  System.out.println();
  System.out.println("Numero. Control: " + Alumnos[i].getNumControl());
  System.out.println();
  System.out.println("Materia: "+ Alumnos[i].getMateria());
  System.out.println();
  System.out.println("Calificacion: " + Alumnos[i].getCalificacion());
  System.out.println();
  System.out.println("Estado de la materia: " + Alumnos[i].asignarEstado());
  System.out.println();
  System.out.println("***************************");
}
 break;
 
 case 3: //Cambiar calificacion //solo cambiaremos las calificaciones de los capturados y si quiere cambiar la de los- 
	 // ya establecidos junto los nuevos cambie dentro del for donde dice int i=5 a int i=0 para que los tome encuenta

  for(int i = 5 ; i<10; i++){
	  
  Alumnos[i].setCalificacion(CapturaEntrada.capturarDoble("Introduce calficacion nueva para " + Alumnos[i].getNombre()));
}

 break;
 
 }//switch cierre
 }while(opc != 4);  
  System.out.println("*************Gracias por visitar el programa************* ");
 }
}
  
class Estudiante {
    String nombre;
    int numControl;
    String materia;
    double calificacion;
    String estadoDemateria;
    
    public Estudiante(String nombre, int numControl, String materia, double calificacion){ 
        setNombre(nombre);
        setNumControl(numControl);
        setMateria(materia);
        setCalificacion(calificacion);
        asignarEstado();
    }
    //setters
    public void setNombre(String nombre){ 
    		this.nombre = nombre;
    }
    
    public void setNumControl(int numControl) {
            this.numControl = numControl;
    }
    
    public void setMateria(String materia){ 
            this.materia = materia;
    }
  
    public void setCalificacion(double calificacion) {
        	this.calificacion = calificacion;
    }
    
    
    //getters para devolver lo equivalente en las variables 
    public String getNombre(){ 
    	return nombre;
     }
        
      public int getNumControl(){
                return numControl;
       }
     public String getMateria(){ 
    	return materia;
        }
    public double getCalificacion()  {
            return calificacion;
        }
    
    //metodo para asignar aprobado o reprobado del estudiante mediante el ingreso de su calificacion 
    public String asignarEstado() 
    {
        if(calificacion >= 60){estadoDemateria = "Aprobado";
        }else{estadoDemateria = "Reprobado";
        }
        return estadoDemateria;
    }
    
  //Metodo que cambia la calificacion del alumno solo lo hare con los capturados desde la terminal
    public void camCali(double CaliNueva) 
    {
        calificacion = CaliNueva;
    }    
}
	//reutilizado de taller 2 o 3
	class CapturaEntrada{
	
    public static int capturarEntero(String msg){ 
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextInt());
    }

    public static float capturarFlotante(String msg){  
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextFloat());
    }

    public static double capturarDoble(String msg){  
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextDouble());
    }

    public static String capturarCadena(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextLine());
    }
}