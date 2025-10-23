//primer ejercicio de tuberias
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
 int  tuberia[2];
 int  pid;
 char cadena[]="Hola, este es un mensaje que voy a enviar. Soy el hijo";
 char lectura[200];

 if (pipe(tuberia)==-1){
   printf("Error en pipe");
   exit(-1);
 }

 pid=fork();
 if (pid == -1){
   printf("Error fork");
   exit(-1);
 }else if (pid==0){
   close(tuberia[0]); //el hijo escribe, así que cerramos la tuberia de lectura
   printf("El hijo escribe....\n");
   write(tuberia[1],cadena,sizeof(cadena));// o bien strlen(cadena)+1
 }else{
   wait(NULL); // espera para que no aprezca el texto, pero son bloqueantes
   close(tuberia[1]); //el padre lee, así que se cierra la escritura
   printf("El padre lee....\n");
   read(tuberia[0],lectura,sizeof(lectura));
   printf("\tEl mensaje leido es:%s\n",lectura);
 }
 return 0;
}



