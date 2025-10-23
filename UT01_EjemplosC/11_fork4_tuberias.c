//  se crea un tercer proceso. el abuelo espera la terminacion del hijo y el hijo espera la terminaci�n del nieto
//Vamos a hacer que padres e hijos puedan enviar y recibir informaci�n.

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>
int main(void)
{
  pid_t pid, pid2,hijo2_pid,hijo_pid;
  int fd1[2];
  int fd2[2];
  char buffer[80]="";
  char saludoAbuelo[]="Saludo del Abuelo.\0";
  char saludoPadre[]="Saludo del Padre.\0";
  char saludoHijo[]="Saludo del Hijo...\0";
  char saludoNieto[]="Saludo del Nieto.\0";
  pipe(fd1); // pipe para la comunicación de padre a hijo
  pipe(fd2); // pipe para la comunicación de hijo a padre
  pid=fork(); // abuelo crea el hijo
  if(pid==-1) //ha ocurrido un error
  {
     printf("No se ha podido crear el proceso hijo...\n");
     exit(-1);
  }
  if(pid==0) //Proceso hijo,
  {
    pid2=fork(); // soy el hijo creo el nieto
    switch(pid2){
      case -1:
              printf("Error al crear proceso hijo en el HIJO...");
		          exit(-1);
      	      break;
	    case 0: // proceso NIETO
	            //NIETO RECIBE
              close (fd2[1]); //cierro el de escritura
              read (fd2[0], buffer,sizeof(buffer));
              printf("\nEl NIETO RECIBE mensaje de su padre: %s\n", buffer);
              printf("\t\t NIETO envia un mensaje a su padre..\n");
              //NIETO envia a su padre
              close (fd1[0]);
		          write (fd1[1], saludoNieto, strlen(saludoNieto));
              break;
	    default:// proceso padre (hijo)
    	        //HIJO RECIBE del ABUELO
             	close (fd1[1]);//cierro la escritura del fd1
            	read (fd1[0], buffer,sizeof(buffer)); //espera la lectura
    	    	  printf("\nEl HIJO RECIBE mensaje del  ABUELO: %s\n", buffer);

		          //printf("\t\t HIJO envia un mensaje a su hijo..\n");
	   	        //HIJO envia a su hijo al NIETO
	     	      close (fd2[0]);
         	    write (fd2[1], saludoPadre, strlen(saludoPadre));

              //HIJO (PADRE) RECIBE del NIETO
              //close fd1[1]; YA ESTA CERRAdo
        	    read (fd1[0], buffer,sizeof(buffer));
              printf("\nEl HIJO RECIBE mensaje de su hijo (nieto): %s\n", buffer);
              //HIJO envia a su hijo al NIETO
              printf("\t\tHIJO envia un mensaje a su padre..\n");
	            //	close (fd2[0]); ya esta cerrado
        	    write (fd2[1], saludoHijo, strlen(saludoHijo));

    }

  } else {
    //ABUELO envia a su hijo
	  printf ("\nEl abuelo ENVIA un mensaje al HIJO..\n");
	  close (fd1[0]);
    write (fd1[1], saludoAbuelo, strlen(saludoAbuelo));
	  wait(NULL); // ESpera la finalizaci�n del hijo
    //ABUELO RECIBE DE SU HIJO
    close (fd2[1]); //cierro el descriptor de escritura de fd2
    read (fd2[0], buffer,sizeof(buffer));
	  printf("\nEl ABUELO RECIBE mensaje de su HIJO: %s\n", buffer);
  }
  return 0;
}
