pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-creds')
        SONAR_TOKEN = credentials('sonar-token')
    }

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/Divakar536/EmployeeManagement.git'
            }
        }

        stage('Unit Test') {
            steps {
                sh './mvnw test'
            }
        }

        stage('Static Code Analysis') {
            steps {
                sh "./mvnw sonar:sonar -Dsonar.projectKey=employee-api -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=$SONAR_TOKEN"
            }
        }

        stage('Build') {
            steps {
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t my-employee-api .'
            }
        }

        stage('Trivy Scan') {
            steps {
                sh 'trivy image --exit-code 0 --severity HIGH,CRITICAL my-employee-api'
            }
        }

        stage('Push to DockerHub') {
            steps {
                sh 'docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
                sh 'docker tag my-employee-api myrepo/my-employee-api:latest'
                sh 'docker push myrepo/my-employee-api:latest'
            }
        }

        stage('Deploy to Kubernetes via ArgoCD') {
            steps {
                sh 'argocd app sync employee-api'
            }
        }
    }
}
