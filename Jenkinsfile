pipeline {
    agent any

    environment {
        APP_NAME = "springboot-35"
        IMAGE_NAME = "springboot-35:latest"
        PORT = "8181"
    }

    stages {
        stage('Build JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Deploy Container') {
            steps {
                sh '''
                docker stop $APP_NAME || true
                docker rm $APP_NAME || true

                docker run -d \
                  --name $APP_NAME \
                  -p $PORT:8181 \
                  $IMAGE_NAME
                '''
            }
        }
    }
}
