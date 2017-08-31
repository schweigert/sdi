#include <stdio.h>
#include <rpc/rpc.h>
#include "hw.h"

/* 
   Simple "hello world" program that demonstrates an rpc call.
*/

int main (int argc, char *argv[]) {

	CLIENT *cl;
	char **p;
	
	if (argc != 2) {
		printf("Usage: client hostname\n");
		exit(1);
	}

	cl = clnt_create(argv[1], CHAT_RPC_PROG, CHAT_RPC_VERS, "tcp");
	if (cl == NULL) {
		clnt_pcreateerror(argv[1]);
		exit(1);
	}
	
	char* mensagem = malloc(sizeof(char)*64);

	while(1){
		scanf("%s", mensagem);
		p = putchat_1(&mensagem, cl);
	}
	

	printf("Back from hello world\n");
	if (p == NULL) {
		clnt_perror(cl,argv[1]);
		exit(1);
	}

	printf("Returned string=%s\n", *p);

	return 0;
}
