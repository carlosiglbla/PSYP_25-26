// modificado se crea un tercer proceso. el abuelo espera la terminacion del hijo y el hijo espera la terminaci�n del nieto

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main(void)
{
  pid_t pid, pid2,hijo2_pid,hijo_pid;
  pid=fork();
  if(pid==-1) { //ha ocurrido un error
     printf("No se ha podido crear el proceso HIJO...\n");
     exit(-1);
  } else if(pid==0) {//Proceso hijo,
    pid2=fork(); // soy el hijo creo el nieto
    switch(pid2){
      case -1:  //ERROR
    		        printf("Error al crear proceso hijo en el NIETO...");
                exit(-1);
                break;
  	  case 0:   //Proceso NIETO
  		          printf("\nSoy el proceso NIETO PID=%d, mi padre es PPID=%d, grupo=%d\n",getpid(),getppid(), getpgrp());
  		          break;
  	  default:  //Proceso HIJO
  	  	        hijo2_pid=wait(NULL); //esperando la terminacion de mi hijo (NIETO)
  		          printf("\nSoy el proceso HIJO PID=%d, mi padre es PPID=%d, grupo=%d\n",getpid(),getppid(), getpgrp());
  		          printf("Mi hijo(nieto): %d termino.\n", hijo2_pid);  //puedo poner pid2 printf("Mi hijo es:%d\n",pid2);
  	 }
  } else {
	     hijo_pid=wait(NULL);    //esperando la terminacion del hijo
	     printf("\nSoy el proceso ABUELO PID=%d , mi padre es PPID=%d, grupo=%d\n", getpid(), getppid(), getpgrp());
       printf("Mi hijo (HIJO) =%d termino\n", hijo_pid); // puedo poner pid printf("Mi hijo es:%d\n",pid);
  }
  return 0;
}
