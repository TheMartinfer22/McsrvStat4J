# McsrvStat4J

## 📖 Features

- Can get all entries of McsrvStat.
- Simplicity in the construction of getters

## 🤔 How to use?
You should only call the main class and pass the ip of the server, then it will return the methods.
```java
String ip = new McsrvStat4J().getStatus("hypixel.net").getIp();
```

## ⚡️ How to compile project?

```sh
mvn clean compile assembly:single 
```

## 📚 Libraries used

- OpenFeign
- OpenFeign-Gson