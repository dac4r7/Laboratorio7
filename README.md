# Laboratorio7 ENUNCIADO
Utilizando como base lo que desarrollaste en el Laboratorio 6, implementar colecciones y archivos.

1. Utilizar una colección:

    ArrayList<Pedido>
para almacenar todos los pedidos cargados.

Implementar operaciones para:

Agregar Pedido: Registrar un nuevo pedido.
Buscar Pedido: Buscar por número de pedido.
Listar Pedidos: Mostrar todos los pedidos almacenados.
Eliminar Pedido: Eliminar un pedido indicando su número. Utilizar Iterator para realizar la eliminación.
2. Archivo de Texto.
Implementar una opción que exporte todos los pedidos a un archivo de texto.
Ejemplo:

    Pedido: 1001
    Cliente: Juan Perez
    Canal: WEB
    Importe: 25000

    Pedido: 1002
    Cliente: Ana Gomez
    Canal: TELEFONO
    Importe: 18000
Nombre sugerido:

    pedidos.txt
Utilizar:

    FileWriter
    BufferedWriter
    PrintWriter
3. Serialización
Las clases Cliente y Pedido deberán implementar:

    Serializable
Implementar una opción:
Guardar Datos: Serializar toda la colección de pedidos en un archivo:

    pedidos.dat
Utilizando:

    ObjectOutputStream
4. Deserialización
Implementar una opción:
Recuperar Datos: Leer el archivo:

    pedidos.dat
y reconstruir la colección de pedidos.
Utilizar:

    ObjectInputStream
5. Manejo de Excepciones
El programa deberá controlar:
Archivo inexistente
    FileNotFoundException
Error de lectura/escritura
    IOException
Clase no encontrada
    ClassNotFoundException
Datos inválidos

6. Menú Principal

Implementar un menú similar al siguiente:

    ===== MAT-NOODLES SRL =====
    1. Agregar pedido
    2. Buscar pedido
    3. Listar pedidos
    4. Eliminar pedido
    5. Exportar pedidos a TXT
    6. Guardar pedidos (Serialización)
    7. Recuperar pedidos (Deserialización)
    8. Salir
    Opción:





 * @author Diego Adrian Cesarin.
 * <p> Copyright (C) 2026 para Diego Adrian Cesarin.
 * Contacto: diegoacart@gmail.com  * - con licencia GNU GPL3.
 * <p> Este programa es software libre. Puede redistribuirlo y/o modificarlo bajo los términos de la
 * Licencia Pública General de GNU según es publicada por la Free Software Foundation, 
 * bien con la versión 3 de dicha Licencia o bien (según su elección) con cualquier versión posterior. 
 * Este programa se distribuye con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA, 
 * incluso sin la garantía MERCANTIL implícita o sin garantizar la CONVENIENCIA PARA UN PROPÓSITO
 * PARTICULAR. Véase la Licencia Pública General de GNU para más detalles.
 * Debería haber recibido una copia de la Licencia Pública General junto con este programa. 
 * Si no ha sido así ingrese a <a href = "http://www.gnu.org/licenses/"> GNU org </a>
