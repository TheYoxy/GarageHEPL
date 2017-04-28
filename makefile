CC=javac
JAR=jar
APP=Test

All:	$(APP)

$(APP):  Identifiable People Vehicules TestVehicules
	$(JAR) -cvmf MANIFEST.MF Appli.jar -C out/ .

compilation: 
	@echo Debut de compilation
	$(CC) -d out/ src/*/*.java -Xlint:unchecked
	@echo Fin de compilation

Vehicules:	src/Vehicules/*.java
	@echo Compilation Vehicules
	$(CC) -d out/ -cp out/ src/Vehicules/*.java -Xlint:unchecked
TestVehicules:	src/test/*.java
	@echo Compilation TestVehicules
	$(CC) -d out/ -cp out/ src/test/*.java -Xlint:unchecked
Identifiable:   src/Authenticate/*.java
	@echo Compilation Authenticate
	$(CC) -d out/ -cp out/ src/Authenticate/*.java -Xlint:unchecked
People:	src/People/*.java
	@echo Compilation People
	$(CC) -d out/ -cp out/ src/People/*.java -Xlint:unchecked
clean:
	rm -rf out/
	@mkdir out

