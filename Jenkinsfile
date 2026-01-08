pipeline {
    agent any

    environment {
        HOST = "localhost"
        APP_NAME = "springboot-35"
        IMAGE = "springboot-35:latest"
        PORT = "8181"
    }

    stages {
        stage('Build') {
            steps {
                sh '''
                chmod +x mvnw
                ./mvnw clean package -DskipTests
                '''
            }
        }

        stage('Deploy via SSH') {
            steps {
                sh '''
                ssh $HOST "
                  docker stop $APP_NAME || true &&
                  docker rm $APP_NAME || true &&
                  docker build -t $IMAGE . &&
                  docker run -d --name $APP_NAME -p $PORT:8181 $IMAGE
                "
                '''
            }
        }
    }
}
