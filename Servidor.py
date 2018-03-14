 
import socket
import sys
import time
import threading

server_address = ('192.168.0.107', 6000)
# Creando el socket TCP/IP
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# Enlace de socket y puerto
print (sys.stderr, 'empezando a levantar %s puerto %s' % server_address)

def EsPrimo(NumeroAVerificar):
    if NumeroAVerificar < 2:
        return False
    for i in range(2,NumeroAVerificar):
        if NumeroAVerificar % i==0:
            return False
        return True



def CalcularPrimosDe(NumeroRecibido):
    iCount = 0

    for i in range(0,NumeroRecibido):
        if EsPrimo(i) == True:
            iCount += 1
            print (i)





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
        iCount = 0
        
        while True:

            if  iCount < 1:
                data = connection.recv(1000)
                print (sys.stderr, 'recibido "%s"' % data.decode())
                
                thread1 = threading.Thread(target=CalcularPrimosDe, args=(int(float(data.decode())) ,))
                start = time.time()
                thread1.start()
            

                while thread1.is_alive() == True:
                    while thread1.is_alive() == False:
                        end = time.time()
                        threadTime = end - start
                        print (sys.stderr, 'enviando mensaje de vuelta al cliente')
                        connection.sendall(str(threadTime).encode())
                        threadTime = time.time()
                        break
            iCount +=1
            if iCount > 1:
                break
 
                
    finally:
        # Cerrando conexion
        connection.close()