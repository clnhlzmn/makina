.PHONY: test
test: out/test
	./out/test

out/test: test_driver.c out/test.c out/test.h out
	gcc test_driver.c out/test.c -I "." -std=c99 -Wall -Wextra -Werror -o out/test -g
	
out/test.c:
	java -jar ../../makina-compiler/out/artifacts/makina_compiler_jar/makina-compiler.jar test_source.mkna -o out

out:
	mkdir out

.PHONY: clean
clean:
	rm -rf out
