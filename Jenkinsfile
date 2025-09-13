pipeline {
    agent any
    environment {
        SONAR_TOKEN = credentials('sonar-token')
        GITHUB_PAT = credentials('github-pat')
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh '''
                  ls -la
                  printenv
                  ./mvnw -version
                  ./mvnw clean test package
                '''
            }
        }
        stage('Deploy') {
            steps {
                sh '''
                    printenv

                '''
            }
        }

    }
}