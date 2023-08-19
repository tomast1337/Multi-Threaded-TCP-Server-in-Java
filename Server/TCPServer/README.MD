Nicolas Vycas Nery

To run java server:
```
mvn clean install
mvn exec:java -Dexec.mainClass="nicolas.vycas.nery.server.App"
```

You cna set a custom port by passing setting the environment variable PORT, like this:
```
export PORT=8080
```