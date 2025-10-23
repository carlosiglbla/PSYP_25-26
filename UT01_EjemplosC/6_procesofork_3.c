// modificado el padre espera la terminaci�n del hijo

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(void)
{
  int pid;
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
    exit(1);
  }
  else
  {
    wait(NULL);    //esperando la terminaci�n del hijo
	  printf("soy el padre:\n");
	  printf("PID=%d PPID=%d,ID de grupo= %d \n",getpid(),getppid(),getpgrp());
	  printf("MI hijo es:%d, y termino\n",pid);
  }

  return 0;
}
