
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <fcntl.h>
#include <unistd.h>

void manejador(int sig);

int main(void)
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
	   signal (SIGUSR1, manejador); // manejador de señal del hijo
       while(1){};
	   break;
  default: //padre
  	   	sleep(1);
		kill(pid_hijo,SIGUSR1);
		sleep(1);
		kill(pid_hijo,SIGUSR1);
		sleep(1);

 }
 return 0;
}
/*Gesti�n de se�al del proceso hijo****/
void manejador(int sig)
{
    printf ("\n Hijo recibe la señal....%d\n",sig);
}
