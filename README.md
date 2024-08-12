# **File Parser**

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

