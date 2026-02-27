pipeline {
    agent any

    // 전역변수 => ${SERVER_IP}
    environment {
        SERVER_IP   = "13.125.156.182"
        SERVER_USER = "ubuntu"
        APP_DIR     = "~/app"
        JAR_NAME    = "jenkins-0.0.1-SNAPSHOT.jar"
    }

    stages {

        /*
        // 연결 확인 = ngrok
        stage('Check Git Info') {
            steps {
                sh '''
                    echo "===Git Info==="
                    git branch
                    git log -1
                '''
            }
        }
        */

        // 감지 = main : push (commit)
        stage('Check Out') {
            steps {
                echo 'Git Checkout'
                checkout scm
            }
        }

        // gradle build => jar파일을 다시 생성
        stage('Gradle Permission') {
            steps {
                sh '''
                    chmod +x gradlew
                '''
            }
        }

        // build 시작
        stage('Gradle Build') {
            steps {
                sh '''
                    ./gradlew clean build
                '''
            }
        }

        // jar파일 전송 = rsync / scp
        stage('Deploy = rsync') {
            steps {
                sshagent(credentials: ['SERVER_SSH_KEY']) {
                    sh """
                        rsync -avz -e 'ssh -o StrictHostKeyChecking=no' \
                        build/libs/*.jar \
                        ${SERVER_USER}@${SERVER_IP}:${APP_DIR}
                    """
                }
            }
        }

        // 실행 명령
        stage('Run Application') {
            steps {
                sshagent(credentials: ['SERVER_SSH_KEY']) {
                    sh """
                        ssh -o StrictHostKeyChecking=no ${SERVER_USER}@${SERVER_IP} << 'EOF'
                        pkill -f "java -jar" || true
                        nohup java -jar ~/app/${JAR_NAME} > log.txt 2>&1 &
EOF
                    """
                }
            }
        }

    }
}
