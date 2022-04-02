pipeline {
    agent any

    stages {
        stage('submodule update') {
            steps {
                sh 'git submodule init'
                sh 'git submodule update'
            }
        }
        
        stage('build') {
            steps {
                sh 'unset BBPATH'
                sh 'bash -c "source oe-init-build-env; bitbake lora-gateway-image"'
            }
        }
    }
}