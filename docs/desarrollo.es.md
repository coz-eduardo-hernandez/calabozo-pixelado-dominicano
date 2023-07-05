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

Selecciona la configuración deseada, y presiona el triángulo verde para compilar y correr el programa. También puedes escribir en la línea de comandos desde el directorio base del proyecto `./gradlew <configuración>`

## Estructura de archivos y directorios
Este es un resumen de cómo estan organizados los archivos. Aunque el resumen no tiene todos los archivos, puede
parecer mucho, pero después de entender la organización es fácil recordar dónde está todo

El nivel superior del repositorio tiene los siguientes archivos:
- AUTORES.md : resumen histórico del desarrollo
- GRACIAS.md : personas que han asistido al desarrollo
- LICENCIA.txt : traducción no official al español de la GPLv3
- LICENSE.txt : GPLv3 en inglés
- README.md : introducción multilenguaje a LEEME.es.md
- build.gradle : guión de configuración de la construcción del programa
- gradle.properties : guión de configuración del constructor
- gradlew : guión de invocación de Gradle para POSIX
- gradlew.bat : guión de invocación de Gradle para Windows
- settings.gradle : guión de configuración de construcción global
- .gitignore : especifica archivos ignorados por git

El nivel superior tiene los siguientes directorios:
- core/ : fuente del programa usado por todas las plataformas
- SDP-classes/ : librería para juegos para Android
- services/ : código para obtener actualizaciones desde internet
- android/ : empaquetamiento para Android
- ios/ : empaquetamiento para iOS
- desktop/ : empaquetamiento para Linux, MacOS y Windows
- docs/ : documentación

Además según tu uso, puedes tener los siguientes directorios en el nivel superior:
- .git/ : información del repositorio, si clonaste el código con git
- .gradle/ : información que Gradle guarda al correr
- gradle/ : el programa que corren los guiones de invocación para llamar a Gradle
- .idea/ : información guardada por IntelliJ IDEA, en el que se basa Android Studio

Dentro de cada directorio con archivos fuente pueden estar:
- .gradle/ : igual que arriba, correspondiente al directorio
- build.gradle : igual que arriba, correspondiente al directorio
- src/ : archivos fuente
- build/ : archivos temporales de compilación
- libs/ : dependencias

Algunos archivos y directorios son dependientes de la plataforma:
- android/proguard-rules.pro : reglas para optimizar al programa final
- desktop/macos-entitlements.plist : permisos requeridos en MacOS
- desktop/notarize.sh : guión para automatizar la notarización por Apple
- ios/assets/ : imágenes y música que acompañan al programa
- ios/Info.plist : información acerca programa para el ecosistema de iOS
- ios/robovm.xml : configuración de RoboVM
- ios/robovm.properties : valores a reemplazar en la configuración de RoboVM

Las fuentes principales del programa están en:
- core/src/java/com/coz/calabozopixeladodominicano/ : código fuente
- core/src/assets : imágenes y sonidos del programa
- code/src/src_assets : fuentes de las imágenes y sonidos

## Flujo y estructura del programa
El punto de entrada depende de la plataforma:
- En Android el punto de inicio está en
android/java/com/coz/calabozopixeladodominicano/android/AndroidLauncher.java en la función onCreate(), ya que el programa
corre como una actividad de la clase android.app.Activity
- En iOS inicia en ios/java/com/coz/calabozopixeladodominicano/ios/IOSLauncher.java en la función main()
- En el escritorio inicia den escritorio, el inicio es
desktop/java/coz/calabozopixeladodominicano/desktop/DesktopLauncher.java en la función main()

El empaquetamientode cada plataforma configura el ambiente el resto del programa, como la máquina virtual de Java,
la plataforma, los directorios y crea la ventana. Al final todas las plataformas crean una instancia de la clase
CalabozoPixeladoDominicano, donde inicia realmente el juego

En el programa depende de libGDX con LWJGL3; en todas las plataformas el ciclo del juego sigue el
[ciclo de vida de libGDX](https://libgdx.com/wiki/app/the-life-cycle) donde las funciones se llaman en diferentes
momentos:
1. CalabozoPixeladoDominicano.create() al principio
2. CalabozoPixeladoDominicano.resize() al principio y al cambiar el tamaño de la ventana
3. CalabozoPixeladoDominicano.render() cada vez que se va a dibujar el programa. Procesa la lógica del juego
4. CalabozoPixeladoDominicano.pause() cuando la aplicación se inactiva, deja de estar visible o termina
5. CalabozoPixeladoDominicano.resume() cuando la aplicación se reactiva o vuelve a visibilizarse
6. CalabozoPixeladoDominicano.dispose() al terminar

render(), pause(), resume() y dispose() se heredan sin cambios desde la clase Game en
SPD-classes/src/main/java/watabou/noosa/Game.java. CalabozoPixeladoDominicano tiene otras funciones no detalladas
aquí

render() llama a Game.step() -> Game.update() -> Scene.update(). Scene.update() localizado en
SPD-classes/src/main/java/watabou/noosa/Scene.java. Scene.update() es heredado sin cambios desde la clase
Group en SPD-classes/src/main/java/watabou/noosa/Group.java el cual llama update() en todos sus miembros

El programa está dividido en escenas, y sólo existe una escene activa en todo momento. Estas escenas son clases
derivadas de Scene. En CalabozoPixeladoDominicano.create() se apunta a la primera escena, y al llamar los métodos
de la clase se usa la función heredada Group.add() para agregar miembros a la escena, que son instancias de la
clase Gizmo en SPD-classes/src/main/java/watabou/noosa/Gizmo.java. La misma clase Group hereda de la clase Gizmo

CalabozoPixeladoDominicano tiene otras funciones para manejar la escena, tales como switchScene() para cambiar la
escena

A partir de aquí se pueden crear clases derivadas de Gizmo, agregarse a la escena con Group.add(), usar sus
propios constructores y se llamaran las funciones derivadas de Gizmo en sus respectivos momentos

A final de cuentas, el juego inicia con la escena a la que se apunta en CalabozoPixeladoDominicano.create(), se
agregan instancias derivadas de Gizmo con Scene.add(), y se procesa la lógica al llamar Gizmo.update() en los
miembros de la escena a la que se apunta

Para saber más de cómo funciona el juego, revisa el código de la escena que te interesa :)

