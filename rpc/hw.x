program HELLO_WOLRD_PROG {
	version HELLO_WORLD_VERS {
		string HW(void) = 1;
		string GETCHAT(int) = 2;
		void   PUTCHAT(string) = 3;
	} = 1;
} = 0x30000824;
