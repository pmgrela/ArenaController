# Arena Controller

Aplicación Android diseñada para utilizar Acestream y Sopcast en sistemas Linux. El sistema original está pensado para moverse sobre una Raspberry Pi, para tener un acceso más cómodo.

La aplicación mandará comandos por SSH al terminal para ejecutar la librería p2ptv-pi, además de tener la programación actual en los propios botones de la aplicación. 

Autores:

ablanco adriblabla@gmail.com   
pmgrela pmgrela@gmail.com

## Requisitos Previos
- Tener activado el SSH.
- La IP privada debe ser fija, 192.168.0.16 (en futuras versiones podrá ser personalizada)
- Añadir la siguiente línea a /etc/ssh/sshd_config: 

        KexAlgorithms diffie-hellman-group1-sha1,diffie-hellman-group-exchange-sha1
    
- Instalar la librería p2ptv-pi. Dentro de la aplicación existe un botón para hacerlo.

        https://github.com/alesnav/p2ptv-pi.

## TODO
- Cambios en el aspecto gráfico. Separar los botones en tabs.
- Añadir opciones de onfiguración. Añadir la posibilidad de cambiar usuario, contraseña, ip...
 

Gracias a todos los desarrolladores del p2ptv-pi, tayoken, tarasian666, somosbinarios.es y alesnav.
Dedicado a la abuela María y a Santi
