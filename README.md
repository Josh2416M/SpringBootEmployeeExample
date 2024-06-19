
Automation 

// POM.xml 

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.7.2</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.nike.reports</groupId>
	<artifactId>bw</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<name>bw</name>
	<description>generate bw report and upload to box</description>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
        	<groupId>org.springframework.boot</groupId>
        	<artifactId>spring-boot-starter-mail</artifactId>
    	</dependency>
		<dependency>
    		<groupId>com.box</groupId>
    		<artifactId>box-java-sdk</artifactId>
    		<version>3.6.0</version>
		</dependency>
		<dependency>
                <groupId>com.sun.mail</groupId>
                <artifactId>javax.mail</artifactId>
                <version>1.6.2</version>
        </dependency>
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>4.1.4</version>
		</dependency>
				<!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
		<dependency>
			<groupId>io.github.bonigarcia</groupId>
			<artifactId>webdrivermanager</artifactId>
			<version>5.2.0</version>
		</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-api</artifactId>
			<version>1.7.36</version>
		</dependency>
		<dependency>
			<groupId>ch.qos.logback</groupId>
			<artifactId>logback-classic</artifactId>
			<version>1.2.11</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.itextpdf/font-asian -->
		<dependency>
			<groupId>com.itextpdf</groupId>
			<artifactId>font-asian</artifactId>
			<version>7.1.13</version>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.itextpdf/sign -->
		<dependency>
			<groupId>com.itextpdf</groupId>
			<artifactId>sign</artifactId>
			<version>7.1.13</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.itextpdf/pdftest -->
		<dependency>
			<groupId>com.itextpdf</groupId>
			<artifactId>pdftest</artifactId>
			<version>7.1.13</version>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.itextpdf/pdfa -->
		<dependency>
			<groupId>com.itextpdf</groupId>
			<artifactId>pdfa</artifactId>
			<version>7.1.13</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.itextpdf/layout -->
		<dependency>
			<groupId>com.itextpdf</groupId>
			<artifactId>layout</artifactId>
			<version>7.1.13</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.itextpdf/kernel -->
		<dependency>
			<groupId>com.itextpdf</groupId>
			<artifactId>kernel</artifactId>
			<version>7.1.13</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.itextpdf/io -->
		<dependency>
			<groupId>com.itextpdf</groupId>
			<artifactId>io</artifactId>
			<version>7.1.13</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.itextpdf/hyph -->
		<dependency>
			<groupId>com.itextpdf</groupId>
			<artifactId>hyph</artifactId>
			<version>7.1.13</version>
			<scope>test</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.itextpdf/styled-xml-parser -->
		<dependency>
			<groupId>com.itextpdf</groupId>
			<artifactId>styled-xml-parser</artifactId>
			<version>7.1.13</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.itextpdf/svg -->
		<dependency>
			<groupId>com.itextpdf</groupId>
			<artifactId>svg</artifactId>
			<version>7.1.13</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.itextpdf/forms -->
		<dependency>
			<groupId>com.itextpdf</groupId>
			<artifactId>forms</artifactId>
			<version>7.1.13</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.itextpdf/barcodes -->
		<dependency>
			<groupId>com.itextpdf</groupId>
			<artifactId>barcodes</artifactId>
			<version>7.1.13</version>
		</dependency>	
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>





----------------------------------------------------------------------------------------------------------------------------------------------------



Jenkinsfile: 

@Library('cop-pipeline-step') _

pipeline {
    agent any
    
    parameters{
        choice(
            name: 'BRANCH_TO_BUILD',
            choices: ['main','branch1','branch2','email','upload'],
            description: 'Select the branch to build' 
            )
    }
    
    tools {
        maven "Maven 3.5.4"
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out latest repo'
                script {
                    checkout([$class: 'GitSCM', branches: [[name: "*/${BRANCH_TO_BUILD}"]], extensions: [], userRemoteConfigs: [[credentialsId: 'a.libproxy', url: 'https://github.com/org-suborg/bw.git']]])
                }
            }
        }
        stage('Setup') {
		  steps {
			echo "Set up"
        script 	{
				 withCerberus([sdbPath: 'app/library/passwords',sdbKeys: [ 'app.generic.username': 'user','app.generic.password': 'pass']]) 
				    {
					  sh "sed -i \"s/{username}/${user}/g\" ${workspace}/src/main/resources/application.properties"
					  sh "sed -i \"s/{password}/${pass}/g\" ${workspace}/src/main/resources/application.properties"
				    }
				}
			}
		}
	    stage('Build') {
            steps {
                sh 'echo "Building the selected branch: ${selectedBranch}"'
                sh "sudo apt-get update -y"
                sh "sudo apt --fix-broken install -y"
                sh "sudo apt-get install -y fonts-liberation libatk-bridge2.0-0 libatk1.0-0 libatspi2.0-0 libgbm1 libgtk-3-0 libu2f-udev libvulkan1 libxcomposite1 libxdamage1 libxfixes3 libxkbcommon0 libxrandr2 xdg-utils"
                sh "wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb"
                sh "sudo apt-get install -f"
                sh "sudo dpkg -i google-chrome-stable_current_amd64.deb"
                sh "Xvfb :99 & export DISPLAY=:99"
                sh "mvn clean install"
            }
    	}
    }
    		post {
    		
        success {
            echo 'This will run only if successful'
        }
        failure {
            emailext subject: "Build Failure: ${currentBuild.fullDisplayName}",
            body: "The build failed. Please check the console output for details.",
            to: "josephmanda22@gmail.com",
            attachLog: true
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
        }
    }
}

---------------------------------------------------------------------------------------------------------------------------------------------------=

application.properties:


# XPATH list
url=
login_username_element=email-field
login_password_element=password-field
analytics_tab=//a[normalize-space()='Analytics']
cookies_ok_button=//button[contains(text(),'OK')]
apps_dropdown=(//div[@class='sz-select__single-value css-1dimb5e-singleValue'])[2]
calendar_dropdown=//span[@class='picker-arrow']
last_30_days_tab=//span[normalize-space()='Last 30 Days']
last_180_days_tab=//span[normalize-space()='Last 6 Months']
click_outside=//div[@class='main-container filters-container container-fluid']
user_profile=//p[@class='chakra-text pill-text css-1tm6w6s']
logout=log-out-button
id1=//div[@id="react-select-3-option-2"]
id2=//div[@id="react-select-3-option-4"]
# following values are local to individual's system with their credentials
#webdriver.chrome.driver=/Users/name/Downloads/chromedriver

#provide your own Hello email id
username={username}
#provide your own Hello password
password={password}

spring.mail.host=mailhost.nike.com
fromEmail = NoReply_EXDashboard@gamil.com
toEmail =josephmanda22@gmail.com
