node {
   stage('Git Clone') { // for display purposes
     checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'GitCred', url: 'https://github.com/IvanWangCN/codetest.git']]])
   }
   stage('Build') {
        withMaven(
            maven: 'MAVEN_3.5.4',
            mavenLocalRepo: '.repository') {
                sh "mvn clean install"
            }
   }
   stage('Deploy') {
      sh '''
          #!/bin/bash
          PORT=$(sudo netstat -ntulp | grep 8080)
          if [[ -n $PORT ]]; then
                  echo "The server is open, ready to close"
                  RESULT="000"
                  while [[ $RESULT == "000" ]]; do
                          echo "Closing down ..."
                          RESULT=$(curl -X POST 127.0.0.1:8080/actuator/shutdown)
                          sleep 2
                  done
                  echo "Close off success"
          fi
          echo "Being started ..."
          JENKINS_NODE_COOKIE=DONTKILLME
          $JAVA_HOME/bin/java -jar $WORKSPACE/server/target/codetest-server-0.0.1-SNAPSHOT.jar >start.log 2>&1 &

      '''
   }
}