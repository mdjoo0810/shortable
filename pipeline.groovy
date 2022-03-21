pipeline {
    agent any

    triggers {
        pollSCM('*/3 * * * *')
    }

    environment {
        imagename = "shortabledokcer/shortable_app"
        registryCredential = 'SHORTABLE_DOCKER_HUB'
        dockerImage = ''
    }

    stages {
        // git에서 repository clone
        stage('Prepare') {
            steps {
                echo 'Clonning Repository'
                git url: 'https://github.com/mdjoo0810/shortable',
                        branch: 'main',
                        credentialsId: 'SHORTABLE_GITHUB'
            }
            post {
                success {
                    slackSend channel: '#ci-cd', color: 'good', message: "GITHUB Clone에 성공하였습니다."
                }
                failure {
                    slackSend channel: '#ci-cd', color: 'danger', message: "GITHUB Clone에 실패하였습니다."
                }
            }
        }

        // gradle build
        stage('Bulid Gradle') {
            //   agent any
            steps {
                echo 'Bulid Gradle'
                dir('.') {
                    sh """
                ./gradlew clean build --exclude-task test
                """
                }
            }
            post {
                success {
                    slackSend channel: '#ci-cd', color: 'good', message: "Gradle 빌드가 성공하였습니다."
                }
                failure {
                    slackSend channel: '#ci-cd', color: 'danger', message: "Gradle 빌드가 실패하였습니다."
                }
            }
        }

        // docker build
        stage('Bulid Docker') {
            //   agent any
            steps {
                echo 'Bulid Docker'
                script {
                    dockerImage = docker.build imagename
                }
            }

            post {
                success {
                    slackSend channel: '#ci-cd', color: 'good', message: "Docker 빌드가 성공하였습니다."
                }
                failure {
                    slackSend channel: '#ci-cd', color: 'danger', message: "Docker 빌드가 실패하였습니다."
                }
            }
        }

        // docker push
        stage('Push Docker') {
            //   agent any
            steps {
                echo 'Push Docker'
                script {

                    docker.withRegistry('', registryCredential) {
                        dockerImage.push("1.0")  // ex) "1.0"
                    }
                }
            }
            post {
                success {
                    slackSend channel: '#ci-cd', color: 'good', message: "Docker 이미지가 성공적으로 배포되었습니다."
                }
                failure {
                    slackSend channel: '#ci-cd', color: 'danger', message: "Docker 이미지 배포에 실패하였습니다."
                }
            }
        }

        stage('SSH SERVER') {
            steps {
                echo 'SSH'
                sshagent(['SHORTABLE_APP_INS_1']) {
                    sh 'ssh -o StrictHostKeyChecking=no root@141.164.40.94 "whoami"'
                    sh "ssh -o StrictHostKeyChecking=no root@141.164.40.94 'docker pull shortabledokcer/shortable_app:1.0'"
                    sh "ssh -o StrictHostKeyChecking=no root@141.164.40.94 'docker run shortabledokcer/shortable_app:1.0'"
                }
            }
            post {
                success {
                    slackSend channel: '#ci-cd', color: 'good', message: "서버 인스턴스가 배포되었습니다."
                }
                failure {
                    slackSend channel: '#ci-cd', color: 'danger', message: "서버 인스턴스가 배포에 실패하였습니다."
                }
            }
        }
    }
}