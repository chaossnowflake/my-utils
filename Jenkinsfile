pipeline {
    agent any
    environment {
        SONAR_TOKEN = credentials('sonar-token')
        GITHUB_PAT = credentials('github-pat')
    }
    stages {
        stage('Clean Workspace') {
          steps {
              deleteDir() // wipes out everything in the current workspace
          }
        }
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
                sh 'printenv'
                script {
                  def version = sh(returnStdout: true, script: './mvnw help:evaluate -Dexpression=project.version -q -DforceStdout').trim()
                  echo "version=$version"

                  def commitMessage = sh(returnStdout: true, script: 'git log -1 --pretty=%B').trim()
                  echo "git last commit message=$commitMessage"

                  def skipRelease = (commitMessage ==~ /^(JIRA:MAINT-000000)\s.+$/)

                  if (skipRelease) {
                    echo "*** Skipping release ***"
                  } else {
                    if ('main'.equals(env.BRANCH_NAME)) {
                      echo "*** Deploying to release repo ***"
                      withCredentials([gitUsernamePassword(credentialsId: 'git-basic', gitToolName: 'git-tool')]) {
                        sh '''
                          ./mvnw release:prepare -DscmCommentPrefix="JIRA:MAINT-000000 "
                          ./mvnw release:perform
                        '''
                      }
                    } else {
                      echo "*** Deploying to snapshot repo ***"
                      sh '''
                        ./mvnw deploy
                      '''
                    }
                  }
                }
            }
        }
    }
}