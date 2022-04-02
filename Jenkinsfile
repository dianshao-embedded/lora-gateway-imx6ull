pipeline {
    agent any

    stages {
        stage('submodule update') {
            steps {
                sh 'git submodule init'
                sh 'git submodule update'
            }
        }
        
        stage('make env') {
            steps {
                sh 'source oe-init-build-env'
            }
        }
        
        stage('build image') {
            steps {
                sh 'bitbake lora-gateway-image'
            }
        }
    }
}