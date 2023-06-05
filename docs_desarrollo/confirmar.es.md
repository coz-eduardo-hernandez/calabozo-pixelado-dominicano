Los mensajes de confirmación tienen que seguir el formato [convencional v1.0.0](https://www.conventionalcommits.org/es/v1.0.0/):

`<tipo>[alcance opcional]: <descripción>`

` `

`[cuerpo opcional]`

` `

`[pie(s) de página opcionale(s)]`

Hay tipos para el tipo de archivo:

- build : cambia el sistema de compilación
- docs : cambia documentación
- asset : cambia activos como las imágenes o sonidos
- test : cambia las pruebas del código
- ci : cambia la configuración del servicio de integración continua

Si el cambio es del código del juego, entonces los tipos son según la función del cambio:

- feat : agrega funcionalidad al juego
- remove: quita funcionalidad al juego
- change: cambia la funcionalidad del juego
- fix : arregla un problema del juego
- refactor : un cambio que mantiene la funcionalidad del juego
- style : cambia el estilo de escritura del código

Finalmente, hay un tipo que se aplica a cualquier archivo o función:

- revert : revierte una confirmación

Las solicitudes de extracción en GitHub siguen el formato de <tipo>: <descripción>
