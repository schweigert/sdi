program CHAT_RPC_PROG {
	version CHAT_RPC_VERS {
	
		string HW(void) = 1;
		string GETCHAT(int) = 2;
		void   PUTCHAT(string) = 3;
		
	} = 1;
} = 0x30000824;
