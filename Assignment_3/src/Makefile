# A simple makefile with variables
JAVASRC = greet.java
SOURCES = README makefile ${JAVASRC}
MAINCLASS = greet
CLASSES = greet.class
JARFILE = runGreetings
JARCLASSES = ${CLASSES}
all: ${JARFILE}
${JARFILE}: ${CLASSES}
	echo "Main-class: ${MAINCLASS}" > Manifest
	jar cvfm ${JARFILE} Manifest ${JARCLASSES}
	rm Manifest
	chmod +x ${JARFILE}

${CLASSES}: ${JAVASRC}
	javac -Xlint ${JAVASRC}
clean:
	rm ${CLASSES} ${JARFILE}
.PHONY: clean all
