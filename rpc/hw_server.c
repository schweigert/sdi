#include <rpc/rpc.h>
#include "hw.h"

#include <stdio.h>
#include <stdlib.h>

/* 
   Hello world RPC server -- it just returns the string.
*/

char** hw_1_svc(void* a, struct svc_req* req) {
	static char msg[256];
	static char *p;

	printf("getting ready to return value\n");
	strcpy(msg, "Hello world");
	p = msg;
	printf("Returning...\n");

	return(&p);
}

char chat_msgs[1000][64];
int chat_nmsgs = 0;


char** getchat_1_svc(int* position, struct svc_req* req) {
	return NULL;
}

void* putchat_1_svc(char** sms, struct svc_req* req){
	char* txt = *sms;
	
	int i;
	for(i = 0; txt[i] != "\0"; i++){
		chat_msgs[chat_nmsgs][i] = txt[i];
	}
}
