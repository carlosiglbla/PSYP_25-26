// primer ejercicio de tuberias MODIFICADO
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
int main(void)
{
 int  tuberia[2];
 int  pid;
 char cadena[]="Hola soy el padre";
 char lectura[20];

 if (pipe(tuberia)==-1){
   printf("Error en pipe");
   exit(-1);
 }
 if ((pid=fork())==-1){
   printf("Error fork");
   exit(-1);
 } else if (pid==0){
   close(tuberia[1]);
   printf("El hijo lee....\n");
   read(tuberia[0],lectura,sizeof(lectura));
   printf("\tEl mensaje leido es:%s\n",lectura);
 } else {
	 wait(NULL); // espera pero...
	 printf("El padre escribe....\n");
   write(tuberia[1],cadena,sizeof(cadena));// o bien strlen(cadena)+1
 }
return 0;
}


