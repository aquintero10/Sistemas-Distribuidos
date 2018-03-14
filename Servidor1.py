 
import socket
import sys
 

server_address = ('192.168.0.109', 6000)
# Creando el socket TCP/IP
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# Enlace de socket y puerto
print (sys.stderr, 'empezando a levantar %s puerto %s' % server_address)


sock.bind(server_address)
# Escuchando conexiones entrantes
sock.listen(1)
while True:
    # Esperando conexion
    print (sys.stderr, 'Esperando para conectarse')
    connection, client_address = sock.accept()

    try:
        print (sys.stderr, 'concexion desde', client_address)

        # Recibe los datos en trozos y reetransmite
        while True:
            data = connection.recv(1000)
            print (sys.stderr, 'recibido "%s"' % data.decode())
            if data:
                print (sys.stderr, 'enviando mensaje de vuelta al cliente')
                connection.sendall(data)
            else:
                print (sys.stderr, 'no hay mas datos', client_address)
                break
                
