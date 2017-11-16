all:
	javac *.java

test:
	ruby test.rb

run: all
	java App < in

in:
	ruby in.rb > in

bench: in run

clear_test:
	rm *.txt
	echo "TIME IN MS TO RESTORE BACKEND" > "backend.txt"
	echo "TIME IN MS TO RESTORE FRONTEND" > "frontend.txt"
	echo "TIME IN MS TO FINISH ONLY 1 SOLUTION. EACH CASE NEEDS AT LEAST 2 EXECUTIONS IF THERE IS NO ERROR" > "solution_time.txt"
	echo "END TIME SOLUTION" > "solution_final_time.txt"

run_without_compile:
	java App < in
