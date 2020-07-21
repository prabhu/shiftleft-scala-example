pipeline {
    agent { docker { image 'mozilla/sbt:latest' } }
    stages {
        stage('build') {
            steps {
                sh 'sbt package'
            }
        }
        stage('ShiftLeft NextGen Analysis') {
            steps {
                sh 'curl https://cdn.shiftleft.io/download/sl > ${WORKSPACE}/sl && chmod a+rx ${WORKSPACE}/sl'
                sh '${WORKSPACE}/sl analyze --no-diagnostic --force --app ShiftLeftScalaExample --tag branch=${BRANCH_NAME} --java --cpg target/scala-2.11/shiftleft-scala-example_2.11-1.0-SNAPSHOT.jar'
            }
        }
    }
}
