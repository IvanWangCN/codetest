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
      sh 'sudo cp -f $WORKSPACE/server/target/codetest-server-0.0.1-SNAPSHOT.jar /codetest'
      sh 'sudo java -jar /codetest/codetest-server-0.0.1-SNAPSHOT.jar'
   }
}