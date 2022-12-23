pipeline {
  agent any
  stages {
    stage('BDD Test') {
      parallel {
        stage('BDD Test') {
          steps {
            bat 'mvn clean test'
          }
        }

        stage('Sleep') {
          steps {
            sleep 100
          }
        }

      }
    }

  }
}