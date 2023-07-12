# Pruebas del programa

Se alienta la creación de pruebas unitarias y de integración, pero no es un requisito. Esta recomendación es mucho más fuerte para pruebas de errores pasados y para código nuevo. Sin embargo, asegurarse que los cambios pasen las pruebas actuales si es necesario

Las pruebas unitarias están en los directorios <módulo>/src/utest. Estas son pruebas que prueban las funciones privadas y protegidas de una clase de manera aislada; no depende de que ningún componente externo como otras clases, archivos, información transmitida por una red o interacción con el usuario. Si uno de estos elementos es necesario para la prueba, se simula

Las pruebas de integración están en los directorios <módulo>/src/itest. Estas envuelven al menos dos componentes internos o externos

Las pruebas unitarias deben correr antes que las de integración. Se recomienda que se corran las pruebas unitarias antes de cada confirmación, y las pruebas de integración antes de cada solicitud de extracción

Una forma de crear las pruebas para código que no esta preparado para las mismas es:

1. Crea una abstracción (sea una interface o clase abstracta) de cada componente a probar
2. Agrega una forma de inyectar la dependencias (preferiblemente en el constructor, sino una función 'setter' de la instancia). No se debe agregar inyección de dependencias sólo para las pruebas, pero de todas maneras es probable que el código sea mejor si se usan
3. Crea pruebas unitarias para lo que quieres, inyectando cualquier dependencia con una imitación
4. Crea pruebas de integración

Las pruebas usan la librería JUnit que facilita el crear pruebas, y Mockito que facilita simular objetos y grabar las interacciones con el objeto simulado lo que permite hacer una mayor variedad de pruebas

## Derechos de autor
Copyright (C) 2023 Eduardo Hernández
Este es un programa libre bajo la GNU General Public License en su versión 3, o si lo desea una versión posterior
Para los términos completos vea [LICENCIA.txt](../LICENCIA.txt) o vaya a https://www.gnu.org/licenses

