
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

### 18/10/21

- DLL: Solución para las llamadas que no pueden ser recibidas poor la máquina solicitante.
- DCOM: Versión de Microsoft para implementar DCE, con diferentes capas, 
una que se encarga de objetos e interfaces, etc. 3 en total: responsabilidad de cliente, 
del servidor y la que permite la comunicacio  entre las 2.
- CORBA: Modulo que permite interoperabilidad entre maquinas remotas
- Despues surgio la Virtual Machine, con Java y .NET, donde una maquina virtual
tiene una implementacion para una plataforma, y todas se comunican entre si, es muy lento
porque hay que compilar antes
- Stub: Adapta la llamada de objeto CORBA a un objeto que es transmitido a traves de ORB
- IDL: Leguaje parecido a JAva que cuando se compila genera stubs y skeletons, que otra maquina podra isntalar
- DCOM vs CORBA: Los clientes se comunican para acceder a una operacion, mientras que en CORBA
se utiliza una referencia textual que no depende de ninguna maquina, de manera que el servidor
parece un objeto local en la maquina del cliente, permitiendo herencia multiple tambien
- Los componentes permiten instalarse en la plataforma de cmponentes para que puedan interactuar entre ellos,
como JavaBeans

---

## Tema 2
- **Middleware:** No es adecuado para desarrollar software con criticidad temporal.
- **SOA:** Desarrollar aplicaciones juntando servicios, es un estilo arquitectonico

**Business process modeling:** Es transparente, otorga independencia de sistemas de plataformas
- permite integrar imklementaciones basadas en las TIC gradualmente evitando la encadenacion de un sistema a una plataforma
- Esta oritentado a flujos y tareas de trabajo mas que  a objetos, entidades, etc. Lo mas importante
son los procesos no los objetos
- Eriksson- Penken: Es UML con cosas extra: modelar procesos, modelas lanes de provesos y modelar seuencias de tareeas
Tiene estereotipos que definen procesos dentro de un negocio, utilliza valores con etiquetas y restriccciones, _constraints_
- Los CU tienen una linea diagonal en el circulo que indica que es representativo de un negocio


- **SpringBoot:** Integra REST y persistencia
- _Autowired:_ Le doy la responsabilidad a Spring para buscar Beans para crear una entidad, o lo que sea
- En un archivo estan definidos los Beans y el modelo de Datos, no como con Jersey que estaba separado
Hay que poner especificamente que beans tiene que seleccionar el framework, y para ello se _cualifican_ con _Qualifier_

---

## Tema 3: Computación Ubicua

- **Computación pervasiva:** Los dispositivos se conectan entre ellos y no necesitan intervencion humana
  - Los dispositivos deben ser conscientes del contexto para actuar en consecuencia
  - Tiene que haber un middleware pervasivo
  - Tiene que haber un soporte de bajo nivel para la movilidad,
  no debe haber nonguna alteracion si el dispositivo se mueve
  - Debe haber soporte a la movilidad: Se debe poder iniciar una aplicacion en un dispositivo, y se debe poder
  continuar en cualquier otro dispositivo (de laptop a movil) es decir, es 
  ubicua, sin perder informacion
  - Soporte para la pervasividad: Los dispositivos deben ser colaborativos, 
  permitiendo escalabilidad ilimitada
  - M2M: Sistema permasivo puro vs IoT: Debe pasar necesariamente por internet
  - No existe un estandar internacional para sistemas CU: esto daña la interoperabilidad, y no se puede
  certificar la calidad de un software
  - La pervasividad hace que sea muy compleja
  - La comunicacion tiene que ser P2P: jerarquia completamente horizontal
  - Se tiene una colaboracion SOA multinivel: servicios con granularidad de fina a gruesa
  - **Espacio ubicuo:** Esta lleno de dispositivos pervasivos, siendo transparente a los usuarios
  - Los usuarios no tienen que entender que hacen individualmente, los dispositivos son
  colaboraivos, inician tareas autonomamente, son proactivos, no esperan comandos de usuarios, 
  ellos mismos inician actividades
- **¿Como llevar a cabo la consciencia del contexto?**
  - Se pretende unir los componentes software distribuidos e IA
  - En un contexto fisico, la ubicacion es muy importante
  - En un entorno de ejecucion de aplicaciones voluble, que debe ser capaz
  de hacer predicciones dentro de un contextoEl contexto no puede modificar el contexto de los componentes, 
  pero estos si deben ser capaces de actuar de forma distinta a su contexto
  - Un contexto en CU son las propiedades que caracterizan la forma de ejecutarse de las 
  aplicaciones software, o las relaciones entre componenetes y los dispositivos del espacio pervasivo
  - El contexto propicia la proactividad de los servicios del sistema, ademas reduce
    la participacion de los usuarios, y es necesario para llegar a la Inteligencia Ambiental
  - A las ontologias les falta la parte de inteligencia, tienen que dar un significado de relaciones semanticas
  - IoT: Vision orientada a las cosas, vision orientada a internet y vision orientada a la semantica
  - Programacion tradicional vs Computacion Ubicua: Computacion consciente de su contexto, estandarizacion
- Queremos **ejecutar la información** por dispositivos sin intervención humana
- Si no se utiliza semantica es un servicio sensible al contexto
- Web Semántica:
  - Se necesitan notaciones para poder determinar conceptos, como OWL
  - RDF: Modelo de datos para definir recursos y relaciones entre ellos, existen lenguajes ontológicos que se han ido definiendo.
Propicia la fusion de modelos, RDF indica el formato con el que los datos esta escritos
  El validador descompone la tripleta en sujeto, objeto y predicado
    - Ideas: Tener un registro de datos mundial. Solo da formato, el siginficado lo da OWL
    - Integración del conocimiento (Knowledge Integration): Sirve para poder juntar
    datos de BBDD diferentes, sin intervencion humana
    - Se necesita una ontologia y un end-point para modelar semanticamente datos
    - RDF y la ontologia estan en correspondencia continua para formar un OWL
    - Los objetos pueden relacionar individuos o clases
    - OWL DL pierde compatibilidad con RDF
    - OWL supone la hipotesis del mundo cerrado o unico
    - En las clases OWL definidas como suficiente (only), solamente los elementos de la misma clase definen una propiedad


  - Esto se propuso para poder realizar consultas a BBDD, SPARQL esta pensado para integrarse
  con estos lenguajes
  - Protege utiliza OWL-DL(descriptive logic)
  - URIs: Generalizacion de URL. Permite acceder a cualquier objeto, no solo paginas webs como hace URL.

---
---

### Seminario 1


- Especificación de interfaces: Agrupa operaciones relacionadas, 
  pudiéndose modificar o refactorizar. Permite el subtipado.
  
- Especificación de operaciones: Debe incluir al menos una operación que no necesite servicios de otras operaciones, sea independiente.
  - Incluye la relación entra entradas salidas y el estado del componente.
  - Garantiza la transparencia de las relaciones entre el objeto del componente y otros componentes.

Línea de Uso: Discontinua, para un tipo necesito otro tipo.


Ejercicios:

1 - Establecer contexto: Context : GetionClientes
consigue DetallesCliente(in_cliente: identificacionCliente) : DetallesCliente
pre:: clientes -> exists(c|c.id = in_cliente) // | = tal que, en cada c(cliente) existe al menos un id que es igual al parametro de entrada cliente
pos:: let cliente = clientes select(c|c.id = in_cliente)

result.nombre = cliente.nombre and // aqui = es como ==
result.codigoPostal = cliente.CodigPostal and
result.correo = cliente.correo and
---

3 - Context:: IStudentManagement
getStudentDetails(_in_stu_:studentIdentifier):StudentDetails
pre:: student implies exist (s|s.id student = _stu_) // in_stu = stu
post:: let student = students -> select (s|s.id = stu) in 

result.name = stu.name

result.email = stu.email

result.postCode = stu.postCode


4-
- a:Context::FlightInvariant
  - self.duration < 4
- b:  -Context::FightInv
  - self.maxNumberPassengers  < 500 or passengers.size  < 500
- c: Context::FightInv
  - self.age >= self.minAge
- d: self.duration = self.ArrivalTime - self.DepartureTime or
  - self.duration = destination.depart - origin.departure
- e: - self origin.name |= self destionation.name
- f: - self.origin.name = "Amsterdam"

5- 
Context::IHotelMgt
makeReservation(in_res:ReservationDetails, in_cust:CusId, out resRef:string):bool
pre::customer-> exist(c:Customer | c.id=cus) // c recorre todos los clientes hasta que coincida un id
Hotel -> exist(h:Hotel | h.id = res.HotelId)
RoomType -> exist(rt:RoomType | rt.name = res.rtName)
reseration -> exist(r:Reservation | r.HotelId = res.hotelId,
r.DateRange = res.DateRange, r.claimId -> r.allocation -> empty) // Página 22 seminario, Reserva y Room tiene una relación llamada _allocation_


***

## Práctica 1


- **Servlet:** Código que se ejecuta en el servidor como consecuencia de una petición del lciente.
Es el equivalente de _applet_ en el servidor.

- **Bean:** Clase de Java gestionado por _JSF._

  - _eager:_
    - _true:_ Siempre activo, consume recursos.
    - _false:_ se activa cuando de recibe petición del cliente.
  - ManagedProperty: 

`h:body
h:form
h: commandButton id="..." value style actionListener`

`home.xhtml` y `faces-config.xml `van siempre dentro de WEB_INF

Si quiero ir a otra pagina pagina2.xhtml pulsando un boton seria
`h:commandButton action="pagina2" value="Pagina 2"`
Otra manera mejor seria crear un `ManageBean`

Las paginas se recargan directamente de una a otra en la misma pagina,
si quiero que se cambie la ruta se hace con `action="pagina1?faces-redirect=true"`



## Práctica 2: RESTful

- Marshalling: Envia lso datos empaquetados para el servidor, es un stub
- Unmarchalling: Desempaqueta los datos del cliente y los transforma para leerlos, es un skeleton 

### Spring
- Repository = DAO
- Inyecta codigo dentro de un codigo base
- Sigue MVC

### BPEL
- BPEL contiene WSDL
- Toda orquestacion es en si un servicio
- Existe la coreografia de orquestaciones
- Coreografia vs orquestaicciones: Facilidad de dinamicidad?

### Práctica 3
- Eclipse Photon, Ode Server
- Incluir libreria Tomcat-juli
- Quitr java.endorse en arguments
- Arrancr Ode y crear nuevo proyecto BPEL
- 










