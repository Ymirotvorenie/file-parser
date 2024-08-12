# **File Parser**

<a href="https://codeclimate.com/github/Ymirotvorenie/file-parser/maintainability"><img src="https://api.codeclimate.com/v1/badges/4e39f22ac36165da3cf2/maintainability" /></a>
<a href="https://codeclimate.com/github/Ymirotvorenie/file-parser/test_coverage"><img src="https://api.codeclimate.com/v1/badges/4e39f22ac36165da3cf2/test_coverage" /></a>

```
Java 21
Gradle 8.7
```


### **Установка**
```
git clone git@github.com:Ymirotvorenie/file-parser.git
./gradlew installDist 
=> ./build/install/file-parser/bin/file-parser.bin
```

### **Запуск утилиты**
```
./build/install/file-parser/bin/file-parser [-afhsV] [-o=<path>] [-p=<prefix>] [<files>...]
```

### **Справка**
```
./build/install/file-parser/bin/file-parser -h
```

### **Зависимости**
```
    implementation("com.google.guava:guava:33.2.1-jre")
    implementation("org.apache.commons:commons-lang3:3.16.0")
    implementation("info.picocli:picocli:4.7.6")
    compileOnly ("org.projectlombok:lombok:1.18.34")
    annotationProcessor ("org.projectlombok:lombok:1.18.34")
```

