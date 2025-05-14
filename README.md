# Мобильная Информационно-справочная система "Пациенты больницы"

Мобильное приложение для врачей, позволяющее просматривать список пациентов, их историю болезни и редактировать медицинские данные (для ведущих врачей).  
Разработано в **Android Studio** с использованием стандартного сборщика **Gradle**.

---

## 📌 Возможности
- Просмотр списка пациентов больницы.
- Поиск пациентов по id.
- Редактирование истории лечения (для ведущего врача).
- Имитация синхронизации данных с сервером больницы (реализовано с помощью SQLite)

---

## ⚙️ Зависимости проекта
Проект использует стандартные библиотеки Android и следующие зависимости (указаны в `build.gradle`):
```gradle
dependencies {
    implementation 'androidx.fragment:fragment:1.4.1'
    implementation "androidx.cardview:cardview:1.0.0"
    implementation 'androidx.appcompat:appcompat:1.4.1'
    implementation 'com.google.android.material:material:1.6.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.3'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
}
```
### 
## 🚀 Запуск проекта

- Клонируйте репозиторий: git clone https://github.com/winfeo/University_coursework.git
- Откройте проект в Android Studio: запустите Android Studio и выберите File → Open и укажите папку с проектом.
- Запустите приложение: подключите Android-устройство или запустите эмулятор. Нажмите Run 'app' или сочетание клавиш Shift + F10

#### Пояснение про команду для запуска:
В Android-разработке проект обычно запускается **через интерфейс Android Studio** (кнопка Run), но технически Gradle поддерживает и командную строку. Например:
```bash
./gradlew installDebug
```
