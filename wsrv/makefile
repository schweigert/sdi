all:
	javac chat/*.java

del:
	rm chat/*.class

srv: all
	java chat.ChatServerPublisher

cli: all
	java chat.ChatClient

clir: all
	ruby chat.rb
