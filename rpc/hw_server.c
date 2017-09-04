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




static char chat_msgs[1000][140];
static char chat_resp[140000];
int  chat_nmsgs = 0;

char** getchat_1_svc(void* a, struct svc_req* req) {

	static char* ret = chat_resp;

	int i, j, k = 0;
	for(i = 0; i < chat_nmsgs; i++){
		for(j = 0; chat_msgs[i][j] != '\0'; j++){
			chat_resp[k] = chat_msgs[i][j];
			chat_resp[k+1] = '\n';
			chat_resp[k+2] = '\0';
			k++;
		}
		k++;
	}

	printf("Returning: %s", chat_resp);

	return(&ret);

}

void* putchat_1_svc(char** sms, struct svc_req* req){
	char* txt = *sms;

	int i;
	for(i = 0; txt[i] != '\0'; i++){
		chat_msgs[chat_nmsgs][i] = txt[i];
		chat_msgs[chat_nmsgs][i+1] = '\0';
		if(chat_msgs[chat_nmsgs][i] == '\n' && chat_msgs[chat_nmsgs][i+1] == '\0'){
			chat_msgs[chat_nmsgs][i] = '\0';
		}
	}
	printf("Mensagem recebida:\n%s\n---\n", chat_msgs[chat_nmsgs]);
	chat_nmsgs ++;

}
