# Proyecto prueba tecnica

---
## Información general

### Ramas
- automation_qa_web
~~~
git checkout automation_qa_web
~~~
- automation_qa_api
~~~
git checkout automation_qa_api
~~~
- automation_qa_mobile
~~~
git checkout automation_qa_mobile
~~~

### Pipeline (Jenkins)
El Pipeline fue creado en Jenkins propio, es un Multibranch Pipeline. Por ende, cada rama ejecutable posee un Jenkinsfile que varía en el Stage "Obtener fuentes".

### Análisis SonarQube
El análisis de SonarQube al código de cada rama, se hace a través de la integración de Jenkins con SonarQube, es por ello, por lo que el archivo Jenkinsfile para cada rama posee un Stage "Analisis SonarQube" que se ejecuta luego de construir el proyecto en el Stage previo, el análisis se va a ejecutar siempre que se ejecute el pipeline.

Por otra parte, el análisis de SonarQube se guarda en una cuenta propia, y se crearon 3 proyectos para que allí se almacene los resultados de acuerdo a cada rama, dicha configuración puede verse en el archivo sonar-project.properties.
