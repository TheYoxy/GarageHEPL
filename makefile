CC=javac
JAR=jar
APP=Test

All:	$(APP)

$(APP):  compilation
	$(JAR) -cfv Appli.jar out/*/*.class
compilation: 
	@echo Debut de compilation
	$(CC) -d out/ src/*/*.java -Xlint:unchecked
	@echo Fin de compilation
clean:
	rm -rf out/


