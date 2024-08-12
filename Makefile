setup:
	./gradlew wrapper --gradle-version 8.7

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean installDist

help:
	./build/install/file-parser/bin/file-parser -h


lint:
	./gradlew checkstyleMain

report:
	./gradlew jacocoTestReport

test:
	./gradlew test


.PHONY: build