#!groovy
import java.text.SimpleDateFormat

def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def date = new Date()
def timestamp = dateFormat.format(date).toString()
def CORREOS = "fabian_guzmans@outlook.com"

pipeline {
    agent any
    stages {
        stage('Obtener Fuentes') {
            steps {
                git branch: 'automation_qa_api', url: 'https://github.com/FabianGuzmanS/exito-test-bdd.git'
            }
        }
        stage('Compilar proyecto') {
            steps {
                bat ".\\gradlew assemble"
            }
        }
        stage('Analisis SonarQube') {
            steps{
                script {
                    scannerHome = tool 'SonarQubeScanner-4.7'
                }
                withSonarQubeEnv('sonarqube_server-9.8')
                {
                    bat "${scannerHome}/bin/sonar-scanner.bat"
                }
            }
        }
        stage('Ejecutar tests'){
            steps {
                script {
                    try {
                        bat 'gradle clean test aggregate'
                        echo 'Test ejecutados sin fallo'
                        currentBuild.result = 'SUCCESS'
                    } catch(ex) {
                        echo 'Test Ejecutados con Fallo'
                        currentBuild.result = 'UNSTABLE'
                    }
                }
            }
        }
    }
}