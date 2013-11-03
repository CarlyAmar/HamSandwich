all: 
	 find . -name "*.java" -print | xargs javac
	 mv *.class ~/Games/HamSandwich/bin
	 mv ~/Games/HamSandwich/mob/*.class ~/Games/HamSandwich/bin/
clean: 
	 find . -name "*.class" -type f -exec /bin/rm -fv -- {} +
modified:
	
