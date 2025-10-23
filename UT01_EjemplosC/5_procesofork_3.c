
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
int main(void)
{
 pid_t pid;
 pid=fork();
  if(pid==-1) //ha ocurrido un error
  {
     printf("No se ha podido crear el proceso hijo...\n");
     exit(-1);
   }
 if(pid==0)
  {
	 printf("soy el hijo:\n");
	 printf("PID=%d PPID=%d,ID de grupo= %d \n",getpid(),getppid(),getpgrp());
   // el hijo se sale pero el padre se está echando una siesta...
   // y se convierte en Zombie
   exit(1);
 }
  else
    {
   sleep(60);
	 printf("\nsoy el padre:\n");
	 printf("PID=%d PPID=%d,ID de grupo= %d \n",getpid(),getppid(),getpgrp());
	 printf("El PID de mi hijo es:%d\n",pid);
    }
    return 0;
}
