pipeline {
  agent any

  stages {
    
    stage('Publish') {
      steps {
        withCredentials([usernamePassword(
        credentialsId: 'github-publish-maven', 
        passwordVariable: 'MVN_PASSWORD', 
        usernameVariable: 'MVN_USERNAME')]) {

          withMaven(mavenSettingsFilePath: 'settings.xml') {
            sh """
              ./mvnw deploy \
                  -Drepo.id=github \
                  -Drepo.login=${MVN_USERNAME} \
                  -Drepo.pwd=${MVN_PASSWORD} \
                  -Drevision=1.${BUILD_NUMBER}
            """
          }  
        }
      }
    } // Publish

    stage('Post') {
      steps {
        script {
          jacoco()
          junit 'target/surefire-reports/*.xml'
          def pmd = scanForIssues tool: [$class: 'Pmd'], pattern: 'target/pmd.xml'
          publishIssues issues: [pmd]
        }
      }
    } // Post

  }
}