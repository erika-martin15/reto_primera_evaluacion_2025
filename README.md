# Trattoria By Janariak - Digitalización de un Negocio

Este repositorio contiene el proyecto completo del **Reto de la Primera Evaluación** para el sistema de gestión del restaurante italiano **Trattoria**. El proyecto está dividido en varios módulos que cubren diferentes aspectos del desarrollo de software.

## Tabla de Contenidos

- [Descripción del Proyecto](#-descripción-del-proyecto)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [Requisitos Previos](#-requisitos-previos)
- [Instalación y Configuración](#-instalación-y-configuración)
- [Uso del Sistema](#-uso-del-sistema)
- [Características Principales](#-características-principales)
- [Estructura de Directorios](#-estructura-de-directorios)
- [Licencia](#-licencia)

## Descripción del Proyecto

**Trattoria** es un sistema integral de gestión para restaurantes italianos que permite:

- Gestionar clientes, empleados y pedidos
- Administrar el catálogo de platos (entrantes, platos principales, postres y bebidas)
- Realizar pedidos y calcular precios totales
- Generar backups de pedidos en formato XML
- Visualizar y gestionar mesas del restaurante
- Acceder al sistema desde aplicaciones de escritorio (Windows Forms) y móviles (Android)

El proyecto está diseñado como un reto académico que demuestra competencias en múltiples áreas del desarrollo de software.

## Estructura del Proyecto

El proyecto está organizado en los siguientes módulos:

### 1. **Apicación de Consola**
Sistema de gestión de base de datos que permite:
- Conexión a base de datos MySQL
- CRUD completo de clientes, empleados, pedidos y platos
- Generación de backups XML de pedidos
- Aplicación de consola para gestión del restaurante

### 2. **TPV**
Aplicaciones de escritorio desarrolladas en C#:
- **GestionJanariak**: Sistema principal de gestión con interfaz gráfica
  - Añadir clientes
  - Crear pedidos
  - Buscar pedidos
  - Menú de inicio con navegación

### 3. **Aplicación Móvil para Android**
Aplicación móvil Android desarrollada en Java:
- Login de usuarios
- Visualización del menú del restaurante
- Categorización de productos (entrantes, platos principales, postres, bebidas)
- Detalle de productos
- Interfaz adaptada para dispositivos móviles

### 4. **Sistema ERP**
Base de datos del restaurante en formato comprimido que contiene:
- Estructura de tablas para clientes, empleados, pedidos, platos
- Datos de ejemplo para pruebas

### 5. **Requisitos Técnicos**
Documentación de los requisitos mínimos (hardware y software) en formato PDF.

## 🛠 Tecnologías Utilizadas

### Backend
- **Java 11+**: Lenguaje principal para el módulo de Acceso a Datos
- **MySQL**: Base de datos relacional
- **JDBC**: Conexión a base de datos
- **Java XML API**: Generación de backups XML

### Desktop
- **C# (.NET Framework)**: Desarrollo de aplicaciones Windows Forms
- **Windows Forms**: Framework de interfaz gráfica

### Mobile
- **Java**: Desarrollo de aplicación Android
- **Android SDK**: Framework de desarrollo móvil
- **Gradle**: Sistema de construcción

### Base de Datos
- **MySQL**: Sistema de gestión de bases de datos

## Requisitos Previos

Para ejecutar este proyecto necesitarás:

### Acceso a Datos (Java)
- Java JDK 11 o superior
- MySQL Server 8.0 o superior
- MySQL Connector/J (driver JDBC)
- IDE compatible con Java (Eclipse, IntelliJ IDEA, NetBeans)

### DI (C#)
- Visual Studio 2019 o superior
- .NET Framework 4.7.2 o superior
- Windows OS

### PMDM (Android)
- Android Studio Arctic Fox o superior
- Android SDK (API 21 o superior)
- JDK 11 o superior
- Dispositivo Android o emulador

### Base de Datos
- MySQL Server 8.0 o superior
- MySQL Workbench (opcional, para gestión visual)

## Instalación y Configuración

### 1. Configuración de la Base de Datos

1. Instala MySQL Server si no lo tienes instalado
2. Importa la base de datos desde `SGE/Base de Datos de Trattoria By Janariak.zip`
3. Crea un usuario con tus credenciales (y posteriormente modifica `ConectorBD.java`)

### 2. Configuración del Módulo de Acceso a Datos

1. Abre el proyecto en tu IDE Java preferido
2. Asegúrate de tener el driver MySQL Connector/J en el classpath
3. Verifica la configuración de conexión en `Acceso a Datos/src/Conector/ConectorBD.java`
4. Compila el proyecto
5. Ejecuta `Main.java` desde `Acceso a Datos/src/Main/Main.java`

### 3. Configuración de las Aplicaciones C# (DI)

1. Abre la solución en Visual Studio:
   - `DI/GestionJanariak/GestionJanariak.sln`
2. Restaura los paquetes NuGet si es necesario
3. Compila la solución (Build > Build Solution)
4. Ejecuta el proyecto (F5)

### 4. Configuración de la Aplicación Android (PMDM)

1. Abre Android Studio
2. Selecciona "Open an existing Android Studio project"
3. Navega a `PMDM/JanariakTrattoriaApp`
4. Sincroniza el proyecto con Gradle (Sync Project with Gradle Files)
5. Configura un dispositivo Android o emulador
6. Ejecuta la aplicación (Run > Run 'app')

## Uso del Sistema

### Módulo de Acceso a Datos (Consola Java)

Al ejecutar `Main.java`, se mostrará un menú interactivo con las siguientes opciones:

```
---Restaurante---
0 --> SALIR
1 --> Ver clientes
2 --> Ver empleados
3 --> Insertar pedido
4 --> Consultar pedidos
5 --> Generar backup de pedidos
```

**Funcionalidades:**
- **Ver clientes**: Muestra la lista completa de clientes registrados
- **Ver empleados**: Muestra la lista de empleados del restaurante
- **Insertar pedido**: Permite crear un nuevo pedido seleccionando platos de la carta
- **Consultar pedidos**: Muestra todos los pedidos realizados
- **Generar backup**: Crea un archivo XML con todos los pedidos (`backup_pedidos.xml`)

### Módulo DI - GestionJanariak (Windows Forms)

La aplicación de escritorio proporciona una interfaz gráfica intuitiva para:

- **Menú de Inicio**: Pantalla principal con acceso a todas las funcionalidades
- **Añadir Cliente**: Formulario para registrar nuevos clientes
- **Crear Pedido**: Interfaz para realizar pedidos con selección visual de platos
- **Buscar Pedido**: Búsqueda y visualización de pedidos existentes

### Módulo PMDM (Android)

La aplicación móvil incluye:

- **Login**: Autenticación de usuarios
- **Menú Principal**: Visualización de categorías de productos
- **Categorías**: 
  - Entrantes
  - Platos principales
  - Postres
  - Bebidas
- **Detalle de Producto**: Información completa de cada plato

## Características Principales

### Gestión de Datos
- CRUD completo de entidades (Clientes, Empleados, Pedidos, Platos)
- Conexión robusta a base de datos MySQL
- Patrón Repository para acceso a datos
- Generación automática de backups XML

### Interfaz de Usuario
- Aplicaciones de escritorio con Windows Forms
- Aplicación móvil Android nativa
- Diseño intuitivo y fácil de usar
- Recursos gráficos personalizados

### Funcionalidades de Negocio
- Gestión completa del ciclo de pedidos
- Cálculo automático de precios totales
- Categorización de platos
- Gestión de clientes y empleados
- Visualización de mesas del restaurante

## Estructura de Directorios Detallada

```
reto_primera_evaluacion_2025/
│
├── Acceso a Datos/          # Módulo Java - Gestión de BD
│   ├── src/
│   │   ├── Clases/          # Entidades del dominio
│   │   ├── Conector/        # Conexión a BD
│   │   ├── Ficheros/        # Generación de backups XML
│   │   ├── Main/            # Punto de entrada
│   │   └── Repositorios/    # Patrón Repository
│   └── bin/                 # Archivos compilados
│
├── DI/                      # Módulo C# - Interfaces Gráficas
│   ├── GestionJanariak/     # Aplicación principal
│
├── PMDM/                    # Módulo Android
│   └── JanariakTrattoriaApp/
│       └── app/
│           └── src/main/
│               ├── java/    # Código fuente Java
│               └── res/      # Recursos (layouts, imágenes)
│
├── SGE/                     # Base de Datos
│   └── Base de Datos de Trattoria By Janariak.zip
│
├── SI/                      # Documentación
│   └── Sistemas Informáticos.pdf
│
├── LICENSE.md               # Licencia del proyecto
└── README.md                # Este archivo
```

## Configuración de Conexión a Base de Datos

Si necesitas modificar la configuración de conexión, edita el archivo:

```java
Acceso a Datos/src/Conector/ConectorBD.java
```

Y ajusta los siguientes parámetros:

```java
"jdbc:mysql://localhost:3306/Janariak?serverTimezone=Europe/Madrid"
"root"  // Usuario
"root"  // Contraseña
```

## Notas Adicionales

- El proyecto utiliza módulos Java, asegúrate de tener `module-info.java` configurado correctamente
- Los backups XML se generan en el directorio raíz del proyecto Java
- Las imágenes y recursos están organizados en las carpetas `Resources/` e `Imagenes/`
- La base de datos debe estar corriendo antes de ejecutar cualquier módulo que la requiera

## Licencia

Este proyecto está bajo la licencia especificada en `LICENSE.md`. Todos los derechos reservados © 2025 JANARIAK.

## Contribuidores

Proyecto desarrollado como parte del Reto de la Primera Evaluación por el grupo Janariak.
