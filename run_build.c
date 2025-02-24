#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Comando invalido\n");
        exit(1);
    }
    else {
        if (strcmp("-b", argv[1]) == 0){
            system("mvn gluonfx:build gluonfx:package -e"); // build
        }
        if (strcmp("-i", argv[1]) == 0) {
            system("mvn gluonfx:install gluonfx:nativerun -e"); // install
        }
        if (strcmp("-a", argv[1]) == 0) {
            system("mvn gluonfx:build gluonfx:package gluonfx:install gluonfx:nativerun -e"); // build and install
        }
    }
}