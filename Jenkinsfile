pipeline {
    agent any

    stages {
        stage('submodule update') {
            steps {
                git submodule init
                git submodule update
            }
        }
        
        stage('make env') {
            steps {
                source oe-init-build-env
            }
        }
        
        stage('build image') {
            steps {
                bitbake lora-gateway-image
            }
        }
    }
}