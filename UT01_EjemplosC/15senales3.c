
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <fcntl.h>
#include <unistd.h>

void manejador_hijo(int sig);
void manejador_padre(int sig);
int pid_hijo;

int main(void)
{
  pid_hijo=fork();

  switch(pid_hijo){
    case -1:
        printf("Error al crear procesos");
        exit(-1);
        break;
    case 0: //hijo
        signal (SIGUSR1, manejador_hijo); // manejador de señal del hijo
        while(1){
          kill(getppid(),SIGUSR1); // envia señal al padre
          pause();// espera señal de respuesta
          sleep(3); // para que lo muestre mas despacio
        }
        break;
    default: //padre
        signal (SIGUSR1, manejador_padre); // manejador de señal del padre
        while(1){}
        break;
	 }
   return 0;
}

/* Gestión de señal del proceso hijo */
void manejador_hijo(int sig)
{
  printf ("\n Hijo recibe la señal....%d\n",sig);
}

 /* Gestión de señal del proceso padre */
void manejador_padre(int sig)
{
  printf ("\n Padre recibe la señal....%d\n",sig);
  kill(pid_hijo,SIGUSR1); //envia señal al hijo
}
