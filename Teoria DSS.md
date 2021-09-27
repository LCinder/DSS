
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


Componentes vs módulos o bibliotecas software.
- **Módulos**: Se programa con tipos de datos abstractos, no se pueden instanciar, a diferencias de clases.
Es más antigua que los componentes.
  - En Java, la extensión es _.jar_ y está compilado
- __Componentes:__ No tienen herencia de implementación, no aceptan polimorfismo, tienen que comportarse igual siempre.
    - Son unidades de software que pueden desplegarse independientemente-
    - En Java, la extensión es _.war_ y está compilado

Python necesita la librería para usar un módulo, para los componentes no porque es más general

- __Programación basado en componentes:__ Componentes desubicados que proporconan servicios y actúan cuando hace falta__ 
Su mayor debilidad la seguridad ¿por qué? Porque se utilizan componentes basados en terceros, debemos fiarnos que van a ser seguros pero nunca se sabe.



