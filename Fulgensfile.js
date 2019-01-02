module.exports = {

  config: {
    SchemaVersion: "1.0.0",
    Name: "JavaWebProjectExample",
    Vagrant: {
      Box: 'ubuntu/xenial64',
      Install: 'maven openjdk-8-jdk-headless mysql-client-5.7 docker.io'
    }
  },

  software: {
      javaCode: {
        Source: "mvn",
        Artifact: "target/JavaWebProjectExample.war",
        configFile: {
          Name: "java.properties",
          Content: [{
            Source:"mysql",
            Regexp: ".*db.host.*",
            Line: "\"db.host\": \"$$VALUE$$\""
          }],
          LoadDefaultContent: "src/main/resources/default.properties",
          AttachAsEnvVar: ["JAVA_OPTS", "-Dconfig.properties=$$SELF_NAME$$"]
        }
    },

    mysql: {
      Source: "mysql",
      Mysql: {
        Schema: "java_code",
        Create: [ "./src/db/mysql.dump" ]
      }
    },

    tomcat: {
      Source: "tomcat",
      Deploy: "javaCode"
    }
  }
}
