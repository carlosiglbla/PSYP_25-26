
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <fcntl.h>

void manejador_hijo(int sig);
void manejador_padre(int sig);

void main(void)
{
 int pid_hijo;
 pid_hijo=fork();

 switch(pid_hijo)
 {
   case -1:
        printf("Error al crear procesos");
        exit(-1);
	    break;
  case 0: //hijo
	    signal (SIGUSR1, manejador_hijo); // manejador de se�al del hijo
        while(1){
            sleep(1);
            kill(getppid(),SIGUSR1); // envia se�al al padre
            pause();// espera se�al de respuesta
		};
	   break;
  default: //padre
        signal (SIGUSR1, manejador_padre); // manejador de se�al del padre
	    while(1){
  	   	     pause();// espera se�al de respuesta
             sleep(1);
             kill(pid_hijo,SIGUSR1); //envia se�al al hijo
		};
   		break;
	 }
     return;
}
/*Gestion de señal del proceso hijo****/
void manejador_hijo(int sig)
{
    printf ("\n Hijo recibe la señal....%d\n",sig);
}
/***********************************/
 /*Gestion de señal del proceso padre****/

void manejador_padre(int sig)
{
    printf ("\n Padre recibe la señal....%d\n",sig);
}
/***********************************/
