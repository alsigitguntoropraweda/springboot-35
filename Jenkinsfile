pipeline {
    agent any

    environment {
        APP_NAME = "springboot-35"
        JAR_PATH = "target"
        PORT = "8181"
    }

    stages {

        stage('Build') {
            steps {
                sh '''
                mvn clean package -DskipTests
                '''
            }
        }

        stage('Stop App (if running)') {
            steps {
                sh '''
                pkill -f ${APP_NAME}.jar || true
                '''
            }
        }

        stage('Run App') {
            steps {
                sh '''
                nohup java -jar ${JAR_PATH}/*.jar \
                  --server.port=${PORT} \
                  > app.log 2>&1 &
                '''
            }
        }
    }

    post {
        success {
            echo "APP RUNNING at http://localhost:${PORT}"
        }
        failure {
            echo "PIPELINE FAILED"
        }
    }
}
