call mvn clean install -DskipTests -Dsurefire.skipTests=true
call cf push
call cf logs my-thai-star