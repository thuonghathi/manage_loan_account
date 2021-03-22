setup java_home environment variable
setup maven_home environment variable

Open with 'intellij idea' and install cucumber plugin

Run project with comment: mvn clean verify  <it will run follow config from TestRunner.java file>

after run you can see report at: target/cucumber-report-html/cucumber-html-reports/failures-overview.html

//-------------------------------------
About FW:
Test case implement at: src/test/java/testcases <inside file have tag ex: @login, @register,..>
config run with tag or with file in: src/test/java/configuration/TestRunner.java

