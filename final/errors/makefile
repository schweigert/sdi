all:
	javac *.java

tests: all
	java Tests < in_test

run: all
	java App < in

in:
	ruby in.rb > in

bench: in run
