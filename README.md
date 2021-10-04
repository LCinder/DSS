
---

# Tema 1 : Desarrollo basado en componentes y servicios


---
### 27/09/21

*Sistema software extensible independientemente:* Utilizar sistemas de terceros que extienden la funcionalidad de mi software sin crear dependencias con mi aplicación.


**Sistema software abierto:**
1. Múltiples hilos ejecutándose independientemente.
2. Software de tipo reactivo: Pensado para estar en funcionamiento continuo, para reaccionar a entradas, mensajes, etc. Nunca termina.
3. Extensibles independientemente.
4. Admiten entradas en tiempo de ejecución: En caliente.

---
**Componente software**

Interfaces que muestra un contrato con unos requisitos a cumplir en la ejecución de ese software, y **no** tiene dependencias ocultas con otros complonentes. Las dependencias si hay son explícitas y docmentadas.
Diferencia con POO: No se accede al estado interno de los objetos (con referencias, etc), aquí estña prohibido.

Gracias a eso se puede desarrollar las cosas por separado y se pueden crear componentes para terceros.
Extensión lógica de los PDO para la creación de aplicaciones industriales

Pensados para ser ejecutados distribuidamente.
Cualquier componente se asocia con otro que esté situado en cualquier lugar del mndo y se puede incluir en cualquier instante de la ejecución.
La aplicación no pierde integridad en los datos, no hay que comprobar nada porque las propiedades anteriores se seguirán cumpliendo.

Los objetos son unidades de instanciación de un patrón o clase
No tienen ni ligadura dinámica ni nada parecido pporque si no no se comportan
igual en situaciones diferentes, no serán independientes ni estarán deacoplados.




**Componentes vs módulos o bibliotecas software.**
- **Módulos**: Se programa con tipos de datos abstractos, no se pueden instanciar, a diferencias de clases.
  Es más antigua que los componentes.
    - En Java, la extensión es _.jar_ y está compilado
- __Componentes:__ No tienen herencia de implementación, no aceptan polimorfismo, tienen que comportarse igual siempre.
    - Son unidades de software que pueden desplegarse independientemente-
    - En Java, la extensión es _.war_ y está compilado

Python necesita la librería para usar un módulo, los componentes no porque son más generales

- __Programación basado en componentes:__ Componentes desubicados que proporconan servicios y actúan cuando hace falta__
  Su mayor debilidad la seguridad ¿por qué? Porque se utilizan componentes basados en terceros, debemos fiarnos que van a ser seguros pero nunca se sabe.


Un módulo de software con recursos debe cumplir los 7 criterios de Mayer

- Debe poder ser utilizado por otros programas
- Por usuarios, sin intervención de los desarrolladores que los crearon
- Deben incluir la especiicación de todas las dependencias de ese componente con otros
- Debe proporcionar información precisa de la informaicon que ofrece
- Se debe poder utilziar slamente conociendo sus especificaciones, desde la vista hasta las dependencias
- Tiene que poder componerse facilmente con otros componenertes
- Se debe poder integrar en otros softwares de manera suave y facilmente

Una intercaz es un conuntos de atributos, métodos que se pieden llamar de forma pulicar y puede definir un conjunto de eventos a los que el 
componente puede responder, en la práctica 1 el evento es la pulsacion del boton.
Tiene metodos, una signatura es la especificación del número de parametros que tiene un metodo.
Hay que especifficar lo suficiente pero no demasiado

Interoperabilidad: Propiedad de software de comunicarse con otros compoentes software
sin entrar en el detalle de parac¡metros. tipos de para etros, a traves de los cuales
se establece la comunicacion,, sin saber nada de bajo nivel. Un metodo es interoperable
si se puede llamar a un metodo independienetemente de si estoy en un dispositivo de 32 o 64 bits.
Esto permite definir interfaces de componentes de fomar estandar sin depemder de ninguna reporesenacion concreta
Es muy importante para la gestion del mantenimiento y evolucion del software. Lo unico que se puede
mantener son compponentes interoperables.

Un componente puede tener muchas intercaes pero puede ser complicado
No permite herencia asada en liadura dinamica, no son clases que puedan
instanciarse, pero si se puede tener un mecanismo de herencia en las interfaces,
solo en la interfaz. Vamos a considerar que hay herencia mutiple, no 
hay problema en heredar de varias cosas, igual que Java.
Cualquier sotware que sea compatible por la JVM debe publicarse en un directorio
para que cualquier aplicacion del mundo pueda localuzarlo

Un componente se puede vender, y  es importante:
- Parte ténica
- Parte de marketing
- Parte matemática, es un _invariante_ 

**Conceptos de Programación orientada a componentes**

- Composición tardía: Se une  los demás componentes en el momento que sea, incluso cuando es necesario, no antes. En la práctica 1, el _eager_ por ejemplo.  
- Entorno: Debe ser independiente del entorno, Windows, ...
- Eventos: Debe ser capaz de responder a eventos, son interactivos.
- Reutilización: Hay diferentes tipos: Caja negra, etc.
- Contratos: Interfaz
- Polimosfismo: 3 tipos 
  - Reemplazar una cosa por otra
  - Parametrización, un componente parametrizado es como un conjunto de componentes. Si tienes una rueda, hay diferentes tipos de ruedas: para invierno, verano, etc.
  - Ligadura dinámica: Incomptible con componentes software
  - Confiabilidad: _ISO-25000C._ Si es confiable es porque puedes depender de él. En avión, miles de personas dependen de que el componente
    software funcione bien, debe ser **robusto**, si falla al menos debe poder tener un mecanismo de fallos.
    Debe poder demostrrse que su funcionamiento es correcto en cualquier traza de ejecución. Debe ser **seguro** y
  **no hackeable**
- Reflexivo: Debe ser capaz de automodificarse



---

### Seminario 1


- Especificación de interfaces: Agrupa operaciones relacionadas, 
  pudiéndose modificar o refactorizar. Permite el subtipado.
  
- Especificación de operaciones: Debe incluir al menos una operación que no necesite servicios de otras operaciones, sea independiente.
  - Incluye la relación entra entradas salidas y el estado del componente.
  - Garantiza la transparencia de lals relaciones entre el objeto del componente y otros componentes.





***

## Práctica 1


- **Servlet:** Código que se ejecuta en el servidor como consecuencia de una petición del lciente.
Es el equivalente de _applet_ en el servidor.

- **Bean:** Clase de Java gestionado por _JSF._

  - _eager:_
    - _true:_ Siempre activo, consume recursos.
    - _false:_ se activa cuando de recibe petición del cliente.
  - ManagedProperty: 

h:body
h:form
h: commandButton id="..." value style actionListener

