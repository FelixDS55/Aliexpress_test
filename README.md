# Aliexpress_Russia
#### Test for Advanced Search Page: https://aliexpress.ru/
#### Технологии и инструменты:
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="/icons/Intelij_IDEA.png" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="/icons/Java.png" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="/icons/GitHub-Mark.png" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="/icons/JUnit5.png" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="/icons/Gradle.png" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="/icons/Selenide.png" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="/icons/Selenoid.png" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="/icons/Allure_Report.png" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="/icons/Jenkins.png" width="50" height="50"  alt="Jenkins"/></a>
</p>

#### Gradle dependencies:
```
testImplementation 'org.junit.jupiter:junit-jupiter:5.8.1',
            'com.codeborne:selenide:6.10.3',
            'io.qameta.allure:allure-selenide:2.20.1',
            "org.slf4j:slf4j-simple:1.7.32",
            'com.codeborne:pdf-test:1.5.0',
            'org.assertj:assertj-core:3.23.1'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
```
## Подключение Allure
#### build.gradle:
```
plugins {
    id "io.qameta.allure" version "2.11.2"
}
allure {
    report {
        version.set ("2.19.0")
    }
    adapter {
        aspectjWeaver.set(true)
        frameworks {
            junit5 {
                adapterVersion.set("2.19.0")
            }
        }
    }
}
```
#### jenkins:
- Формат сборки в Jenkins: clean test
- Формат отчета выполнения тестов в jenkins выглядит следующим образом:
![Jenkins](https://user-images.githubusercontent.com/81954013/211168281-a3951ecc-e5ea-4e27-95d4-059d04a46936.png)

- Для подключения визуальной составляющей Allure указываем Path: build/allure-results. После выполнения сборки нам доступен следующего формата отчет:
![Allure](https://user-images.githubusercontent.com/81954013/211212955-ded80fdc-ca84-4461-9c26-7ae751776872.png)

## Подключение отчетов о выполнении прохождения тестов в телеграм
#### В телеграм:
- создать бота (сохранить токен)
- добавить бота в нужный чат
- сделать бота админом
- получить chat_id при помощи: https://api.telegram.org/bot{secret_bot}/getUpdates
#### jenkins:
- В разделе "Сборка" добавить шаг сборки "Create/Update Text File"
- Указать File Path: notifications/telegram.json
- Проставить галки для Create at Workspace и Overwrite file
- Добавить telegram.json:
```
{
  base: {
    project: "${JOB_BASE_NAME}",
    environment: "qa.guru",
    comment: "some comment",
    reportLink: "${BUILD_URL}",
    language: "en",
    allureFolder: "allure-report/",
    enableChart: true
  },
  telegram: {
    token: "5936148191:AAHIFConJnr........",
    chat: "-1...............",
    replyTo: ""
  }
}
```
