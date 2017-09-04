#include <stdio.h>
#include <rpc/rpc.h>
#include "hw.h"

/*
   Simple "hello world" program that demonstrates an rpc call.
*/

int main (int argc, char *argv[]) {

	CLIENT *cl;
	char **p;

	if (argc < 2) {
		printf("Usage: client hostname\n");
		printf("Ex: ./client localhost Peterson\n");
		exit(1);
	}

	if(argc < 3) {
		printf("Usage: client username\n");
		printf("Ex: ./client localhost Peterson\n");
	}

	cl = clnt_create(argv[1], CHAT_RPC_PROG, CHAT_RPC_VERS, "tcp");
	if (cl == NULL) {
		clnt_pcreateerror(argv[1]);
		exit(1);
	}

	char* mensagem = malloc(sizeof(char)*140);
	char* package = malloc(sizeof(char)*140);
	int user_size;

	char* user = argv[2];
	user_size = strlen(user);

	while(1){
		fgets(mensagem, 140 - user_size - 1, stdin);

		sprintf(package, "%s:%s", user, mensagem);

		p = putchat_1(&package, cl);
		system("clear");
		p = getchat_1(NULL, cl);
		printf("Chatorama:\n%s\n", *p);
	}

	return 0;
}
