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
                bash -c 'source oe-init-build-env'
            }
        }
        
        stage('build image') {
            steps {
                bash -c 'bitbake lora-gateway-image'
            }
        }
    }
}