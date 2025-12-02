# JanariakTrattoriaApp - Aplicación Móvil para Android

Aplicación móvil Android desarrollada en Java para el restaurante italiano **Trattoria**. Permite a los clientes visualizar el menú del restaurante, explorar productos por categorías, ver detalles de cada plato y gestionar un carrito de compras.

## Descripción

**JanariakTrattoriaApp** es una aplicación nativa para Android que ofrece una experiencia completa de navegación por el menú del restaurante. Los usuarios pueden explorar los diferentes platos organizados por categorías, consultar información detallada de cada producto y realizar pedidos mediante un sistema de carrito de compras.

## Características Principales

- **Sistema de Login**: Pantalla de inicio con autenticación de usuario
- **Navegación por Categorías**: Filtrado de productos por categorías (Entrantes, Principales, Postres, Bebidas)
- **Detalle de Productos**: Visualización completa de cada plato con descripción, ingredientes e imagen
- **Carrito de Compras**: Gestión de pedidos con cálculo automático de totales
- **Interfaz Intuitiva**: Diseño moderno y fácil de usar con Material Design
- **Gestión de Estado**: Patrón Singleton para el carrito de compras compartido entre actividades

## Estructura del Proyecto

```
JanariakTrattoriaApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/janariaktrattoriaapp/
│   │   │   │   ├── LoginActivity.java          # Pantalla de login
│   │   │   │   ├── MainActivity.java           # Menú principal con categorías
│   │   │   │   ├── DetalleProductoActivity.java # Detalle de producto
│   │   │   │   ├── CarritoActivity.java        # Gestión del carrito
│   │   │   │   ├── adapters/
│   │   │   │   │   ├── AdapterProducto.java    # Adapter para lista de productos
│   │   │   │   │   └── AdapterCarrito.java     # Adapter para carrito
│   │   │   │   ├── models/
│   │   │   │   │   └── Producto.java           # Modelo de datos
│   │   │   │   └── utils/
│   │   │   │       └── GestorCarrito.java      # Gestor Singleton del carrito
│   │   │   ├── res/                             # Recursos (layouts, imágenes, strings)
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   └── build.gradle.kts
├── build.gradle.kts
└── settings.gradle.kts
```

## Tecnologías Utilizadas

- **Java 11**: Lenguaje de programación
- **Android SDK**: Framework de desarrollo móvil
- **Material Design Components**: Componentes de interfaz de usuario
- **RecyclerView**: Listas eficientes y reciclables
- **Gradle**: Sistema de construcción
- **AndroidX Libraries**: Bibliotecas modernas de Android

## Requisitos Previos

Para compilar y ejecutar esta aplicación necesitarás:

- **Android Studio** (Arctic Fox o superior)
- **Android SDK** con API Level 30 (Android 11) o superior
- **JDK 11** o superior
- **Gradle** 7.0 o superior (incluido en Android Studio)
- Dispositivo Android físico o emulador con Android 11+

## Instalación y Configuración

### 1. Clonar o Descargar el Proyecto

Asegúrate de tener el proyecto en tu máquina local.

### 2. Abrir en Android Studio

1. Abre Android Studio
2. Selecciona **File > Open**
3. Navega hasta la carpeta `PMDM/JanariakTrattoriaApp`
4. Selecciona el proyecto y haz clic en **OK**

### 3. Sincronizar el Proyecto

1. Android Studio detectará automáticamente el proyecto Gradle
2. Si aparece un mensaje de sincronización, haz clic en **Sync Project with Gradle Files**
3. Espera a que se descarguen las dependencias

### 4. Configurar el Emulador o Dispositivo

**Opción A: Emulador Android**
1. Ve a **Tools > Device Manager**
2. Crea un nuevo dispositivo virtual (AVD) con Android 11 o superior
3. Inicia el emulador

**Opción B: Dispositivo Físico**
1. Habilita las **Opciones de Desarrollador** en tu dispositivo Android
2. Activa la **Depuración USB**
3. Conecta el dispositivo por USB
4. Autoriza la conexión cuando aparezca el diálogo

### 5. Ejecutar la Aplicación

1. Selecciona el dispositivo o emulador desde el menú desplegable
2. Haz clic en el botón **Run** (▶) o presiona **Shift + F10**
3. La aplicación se compilará, instalará y ejecutará automáticamente

## Uso de la Aplicación

### Pantalla de Login

Al iniciar la aplicación, se muestra la pantalla de login:
- Introduce cualquier usuario y contraseña (la validación actual solo verifica que no estén vacíos)
- Haz clic en el botón de login para acceder al menú principal

### Menú Principal

La pantalla principal muestra:
- **Botones de Categorías**: Filtra productos por categoría
  - Entrantes
  - Principales
  - Postres
  - Bebidas
- **Lista de Productos**: Muestra los productos de la categoría seleccionada
- **Botón de Carrito**: Muestra la cantidad de productos añadidos
- **Botón Volver**: Regresa a la pantalla de login

### Detalle de Producto

Al hacer clic en un producto:
- Se muestra información completa:
  - Nombre del plato
  - Descripción
  - Lista de ingredientes
  - Precio
  - Imagen del producto
- Botón para añadir al carrito
- Botón para volver al menú

### Carrito de Compras

En la pantalla del carrito puedes:
- Ver todos los productos añadidos
- Eliminar productos individuales
- Ver el total de productos
- Ver el precio total calculado automáticamente
- Vaciar todo el carrito
- Volver al menú principal

## Catálogo de Productos

La aplicación incluye un catálogo completo con 16 productos:

### Entrantes (4)
- Provoletta - 8.50€
- Focaccia - 6.00€
- Carpaccio - 12.50€
- Tabla de Embutidos - 14.00€

### Platos Principales (4)
- Lasaña Boloñesa - 13.50€
- Pizza Margarita - 11.00€
- Risotto de Hongos - 14.50€
- Spaghetti Carbonara - 12.50€

### Postres (4)
- Tiramisú - 6.50€
- Cannoli - 5.50€
- Panna Cotta - 5.00€
- Copa de Helado - 4.50€

### Bebidas (4)
- Agua - 1.50€
- Moretti - 3.00€
- Prosecco - 4.50€
- Limoncello - 5.00€

## Arquitectura y Patrones de Diseño

### Patrón Singleton
El `GestorCarrito` utiliza el patrón Singleton para garantizar que solo exista una instancia del carrito en toda la aplicación, permitiendo que todas las actividades compartan el mismo estado.

### Modelo-Vista-Adaptador (MVA)
- **Modelo**: Clase `Producto` que representa los datos
- **Vista**: Layouts XML y Activities
- **Adaptador**: `AdapterProducto` y `AdapterCarrito` para conectar datos con vistas RecyclerView

### Actividades
- **LoginActivity**: Punto de entrada de la aplicación
- **MainActivity**: Actividad principal con navegación por categorías
- **DetalleProductoActivity**: Muestra información detallada de un producto
- **CarritoActivity**: Gestiona el carrito de compras

## Configuración del Proyecto

### Versión Mínima de SDK
- **minSdk**: 30 (Android 11)
- **targetSdk**: 36
- **compileSdk**: 36

### Dependencias Principales
- `androidx.appcompat:appcompat`
- `com.google.android.material:material`
- `androidx.constraintlayout:constraintlayout`
- `androidx.recyclerview:recyclerview`

## Personalización

### Añadir Nuevos Productos

Para añadir nuevos productos, edita el método `cargarTodosLosProductos()` en `MainActivity.java`:

```java
todosLosProductos.add(new Producto(
    "Nombre del Plato",
    "Descripción del plato",
    "• Ingrediente 1\n• Ingrediente 2",
    precio,
    R.drawable.imagen_recurso,
    "Categoria"
));
```

### Modificar Categorías

Las categorías disponibles son:
- "Entrantes"
- "Principales"
- "Postres"
- "Bebidas"

Para añadir nuevas categorías, actualiza los botones y la lógica de filtrado en `MainActivity.java`.

## Solución de Problemas

### Error de Compilación
- Verifica que todas las dependencias estén sincronizadas
- Limpia el proyecto: **Build > Clean Project**
- Reconstruye: **Build > Rebuild Project**

### La Aplicación No Se Instala
- Verifica que el dispositivo/emulador esté conectado
- Asegúrate de tener suficiente espacio en el dispositivo
- Revisa los permisos en `AndroidManifest.xml`

### Imágenes No Se Muestran
- Verifica que los recursos de imagen estén en `res/drawable/`
- Asegúrate de que los nombres de los recursos coincidan con los referenciados en el código

## Notas de Desarrollo

- El sistema de login actual es básico y no realiza validación real de credenciales
- Los productos están hardcodeados en `MainActivity.java`
- El carrito se mantiene en memoria durante la sesión de la aplicación
- No hay persistencia de datos entre sesiones

## Licencia

Este proyecto forma parte del Reto de la Primera Evaluación y está bajo la licencia especificada en el repositorio principal.

## Contribuidores

Proyecto desarrollado como parte del Reto de la Primera Evaluación por el grupo Janariak.
