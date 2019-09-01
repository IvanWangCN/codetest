node {
   stage('Git Clone') { // for display purposes
     checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'GitCred', url: 'https://github.com/IvanWangCN/codetest.git']]])
   }
   stage('Build') {
        withMaven(
            maven: 'MAVEN_3.5.4',
            mavenLocalRepo: '.repository') {
                sh "mvn clean install -Dmaven.test.skip=true"
            }
   }
   stage('Test') {
      withMaven(
           maven: 'MAVEN_3.5.4',
           mavenLocalRepo: '.repository') {
               sh "mvn test -DfailIfNoTests=false -Dtest=CodetestApplicationTests,WeatherPetControllerTest,WeatherPetServiceImplTests"
           }
   }
   stage('Deploy') {
      sh '$JAVA_HOME/bin/java -jar $WORKSPACE/server/target/codetest-server-0.0.1-SNAPSHOT.jar'
      sh 'exit 0'
   }
}