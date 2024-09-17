
pipeline {
    agent any
    environment {
            MAVEN_HOME = "C:\\Program Files\\Maven\\apache-maven-3.9.9"  // Adjust path if different
            PATH = "${MAVEN_HOME}\\bin;${env.PATH}"
        }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/emotytto00/TimeCalculator'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Code Coverage') {
            steps {
                jacoco execPattern: '**/target/jacoco.exec'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            jacoco execPattern: '**/target/jacoco.exec'
        }
    }
}

