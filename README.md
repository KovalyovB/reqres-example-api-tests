# Проект по автоматизации тестирования API для сайта [«Reqres»](https://reqres.in/)

<div align="center">
  <img src="docs/images/reqres_api.png" alt="reqres_api" width="1000"/>
</div>

> Reqres - сервис, предоставляющий публичный API для практики тестирования и разработки

---

## 📋 Содержание

- [🛠️ Технологии и инструменты](#️-технологии-и-инструменты)
- [✅ Примеры автоматизированных тест-кейсов](#-примеры-автоматизированных-тест-кейсов)
- [⚙️ Сборка Jenkins](#️-сборка-jenkins)
- [💻 Запуск автотестов](#-запуск-автотестов)
- [📊 Allure отчет](#-allure-отчет)
- [🧪 Интеграция Allure TestOps](#-интеграция-allure-testops)
- [🔗 Интеграция с Jira](#-интеграция-с-jira)
- [📨 Уведомления в Telegram](#-уведомления-в-telegram)
- [🧰 Стек технологий](#-стек-технологий)

---

## 🛠️ Технологии и инструменты

| 🧩 Инструмент | 🎯 Назначение |
|---|---|
| ☕ **Java** | Язык написания автотестов |
| 🧪 **JUnit 5** | Фреймворк модульного тестирования |
| 🐘 **Gradle** | Система автоматической сборки |
| 🏗️ **Jenkins** | Удалённый запуск с выбором параметров тестирования |
| 📊 **Allure** | Формирование отчетов о пройденных тестах |
| 📨 **Telegram Bot** | Отправка отчетов о тестировании в мессенджер |
| 🧬 **Allure TestOps** | Интеграция с системой управления тестированием |
| 🔗 **Jira Software** | Интеграция с трекером задач |

---

## ✅ Примеры автоматизированных тест-кейсов

- 👥 Получение списка пользователей
- ➕ Создание пользователей
- ✏️ Обновление данных пользователя

---

## ⚙️ Сборка [Jenkins](https://jenkins.qa.guru/view/java_students/job/42_kovalyov_final_api_tests/)

<div align="center">
  <!-- 🖼️ Сюда вставь скриншот сборки Jenkins -->
  <img src="docs/images/jenkins_api.png" alt="Jenkins Build" width="800"/>
</div>

---

## 💻 Запуск автотестов

### ☁️ Удалённый запуск (Selenoid)

Запуск тестов в Selenoid с использованием конфигурации по умолчанию:

```bash
./gradlew clean test
```

### 🖥️ Локальный запуск

Запуск тестов в локальном браузере без удалённого подключения и с отключённым Headless-режимом:

```bash
./gradlew clean test -Dremote= -Dheadless=false
```

---

## 📊 [Allure](https://jenkins.qa.guru/view/java_students/job/42_kovalyov_final_api_tests/4/allure/) отчет

### 🏠 Основная страница
<div align="center">
  <img src="docs/images/jenkins_api.png" alt="jenkins_api" width="800"/>
</div>

### 🧾 Тест-кейсы

<div align="center">
  <img src="docs/images/allure_api_tests.png" alt="allure_api_tests" width="800"/>
</div>

---

## 🧪 Интеграция [Allure TestOps](https://allure.qa.guru/project/5429/test-cases?treeId=0)

### 🤖 Авто-тесты

<div align="center">
  <img src="docs/images/testOps_auto.png" alt="testOps_auto" width="800"/>
</div>

### 👨‍🔧 Ручные тесты

<div align="center">
  <img src="docs/images/testOps_manual.png" alt="testOps_manual" width="800"/>
</div>

---

## 🔗 Интеграция с [Jira](https://jira.qa.guru/browse/MUL-72)

Результаты автопрогонов автоматически отображаются прямо в задаче Jira — статус тестов, ссылки на Allure отчет и подробная информация о прохождении. 🚀

<div align="center">
  <img src="docs/images/jira_api.png" alt="jira_api" width="800"/>
</div>

---

## 📨 Уведомления в Telegram

По итогам каждого прогона в Telegram-бот отправляется отчет со статистикой прохождения тестов. 📬

<div align="center">
  <img src="docs/images/Screenshot_4.png" alt="telegram" width="300"/>
</div>

---

## 🧰 Стек технологий

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white)
![Allure](https://img.shields.io/badge/Allure-FF5722?style=for-the-badge&logo=allure&logoColor=white)
![Selenoid](https://img.shields.io/badge/Selenoid-00A98F?style=for-the-badge&logo=selenium&logoColor=white)
![Telegram](https://img.shields.io/badge/Telegram-26A5E4?style=for-the-badge&logo=telegram&logoColor=white)
![Jira](https://img.shields.io/badge/Jira-0052CC?style=for-the-badge&logo=jira&logoColor=white)

</div>
