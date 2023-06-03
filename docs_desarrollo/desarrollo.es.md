# Calabozo Pixelado Dominicano

Este documento describe como empezar a desarrollar este proyecto. Para más información ve a el [wiki](https://github.com/coz-eduardo-hernandez/calabozo-pixelado-dominicano/wiki)

Calabozo Pixelado Dominicano fue derivado de [Shattered Pixel Dungeon](https://github.com/00-Evan/shattered-pixel-dungeon) versión 2.1.0, disponible bajo la licencia [GPLv3)](https://www.gnu.org/licenses/gpl-3.0.html). Una traducción no oficial de la licencia está disponible en el archivo [../LICENCIA.txt](../LICENCIA.txt)

Está escrito de Java, y corre en Android, iOS, y sistemas operativos de escritorio

## Prerequisitos
- [Git](https://git-scm.com/downloads), el programa de control de versiones para registrar los cambios al proyecto
- [Una cuenta de GitHub](https://github.com/), para halar y empujar el repositorio
- [JDK 17 LTS](https://www.oracle.com/java/technologies/downloads/#java17) para usar Gradle desde al línea de comandos (opcional)
- [Android Studio](https://developer.android.com/codelabs/basic-android-kotlin-compose-install-android-studio?hl=es-419#0) >= Flamingo | 2022.2.1, el ambiente de desarrollo usado para el proyecto. IntelliJ debería funcionar también pero la documentación asume Android Studio
- [XCode](https://developer.apple.com/xcode/), para desarrollar para iOS y MacOS (opcional si no vas a desarrollar para estas plataformas)
- Un teléfono Android para probar cambios (opcional)
- Un teléfono iOS para probar cambios (opcional)

## Copiando el código
Bifurca el [repositorio](https://github.com/coz-eduardo-hernandez/calabozo-pixelado-dominicano) usando el botón 'fork' en la parte superior-derecha en GitHub

## Vinculando a Git y Android Studio
1. Abre Android Studio, y en la barra superior ve a 'File -> Settings'
2. En la ventana Settings ve a 'Version Control -> Git'
3. Verifica si Git fue detectado automáticamente
4. Si Git no se detectó automáticamente, abre 'Path to Git executable' al archivo bin/git.exe de la instalación de Git
5. Presiona 'Test' para verificar que Git funciona

## Incluyendo el proyecto en Android Studio
- Selecciona 'File -> New -> Project from Version Control'
- Desde ahí llena la información requerida y presiona el botón 'Clone' en el fondo

## Compilando y corriendo el código
Para compilar y correr el código se debe seleccionar una 'configuración', lo que define que ejecutable se producirá. Desde la instalación, Android Studio tiene la configuración para Android desde la instalación, aunque vas a tener que seguir más pasos para correr en un dispositivo real en vez de uno emulado

Para agregar una configuración de escritorio
- Abre el desplegable de configuración y elige 'Edit Configurations...'
- Presiona '+'para agregar una nueva configuración
- Selecciona 'Gradle'
- En 'Task and arguments' escribe 'debug'
- En 'Gradle project' escribe 'calabozo-pixelado-dominicano:desktop'
- Nombra la configuración como 'escritorio:depurar'
- Presiona 'OK'

Selecciona la configuración deseada, y presiona el triángulo verde para compilar y correr el programa. También puedes escribir en la línea de comandos desde el directorio base del proyecto `./gradlew <configuración>

