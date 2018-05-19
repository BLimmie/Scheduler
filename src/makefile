JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Grid.java \
	Major.java \
	User.java \
	Course.java \
	Requirement.java \
	ANDList.java \
	ORList.java \
	CoursesCount.java \
	UnitCount.java \
	Quarter.java \
	Driver.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
