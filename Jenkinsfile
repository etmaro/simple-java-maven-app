pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
            args '-p 8000:8000' 
        }
    }
    stages {
        stage('Construir') {
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        stage('Probar') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deployar') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
    }
}
