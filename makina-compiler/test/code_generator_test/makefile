.PHONY: test
test: out/test
	./out/test

out/test: test_driver.c out/test.c out/test.h out
	gcc test_driver.c out/test.c -I "." -std=c99 -Wall -Wextra -o out/test
	
out/test.c:
	java -jar ../../out/artifacts/makina_compiler_jar/makina-compiler.jar test_source.mkna -m "struct machine_data" -e "struct event_data" -i "test_data.h" -o out

out:
	mkdir out

.PHONY: clean
clean:
	rm -rf out
