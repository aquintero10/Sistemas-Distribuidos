import socket
import sys
import threading
import time
 
# Creando un socket TCP/IP
sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

def EnviarNumero(server_address, NumeroAEnviar):
# Conecta el socket en el puerto cuando el servidor esté escuchando
    
    print (sys.stderr, 'conectando a %s puerto %s' % server_address)
    sock.connect(server_address)
    try:
        
        # Enviando datos
        message = str(NumeroAEnviar)
        print (sys.stderr, 'enviando %s' % message)
        sock.sendall(message.encode())
    
        # Buscando respuesta
        amount_received = 0
        amount_expected = len(message)
        
        
        data = sock.recv(1000)
        amount_received += len(data)
        print (sys.stderr, 'recibiendo "%s"' % data.decode())
    
    finally:
        print (sys.stderr, 'cerrando socket')
        sock.close()



arrIp = ['192.168.0.107','192.168.0.109'] 
sockConexion = (arrIp[0], 6000)
sockConexion1 = (arrIp[1], 6000)

thread1 = threading.Thread(target=EnviarNumero, args=(sockConexion,99,))
thread2 = threading.Thread(target=EnviarNumero, args=(sockConexion1,99,))

thread1.start()