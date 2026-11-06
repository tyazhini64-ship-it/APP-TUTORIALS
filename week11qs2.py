import socket
import threading
import time

def udp_server():
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    server_socket.bind(('127.0.0.1', 9000))
    data, addr = server_socket.recvfrom(1024)
    print("Received reading:", data.decode())
    server_socket.close()

def udp_client():
    time.sleep(1)
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    client_socket.sendto(b"Temperature: 24.5C", ('127.0.0.1', 9000))
    client_socket.close()

server_thread = threading.Thread(target=udp_server)
client_thread = threading.Thread(target=udp_client)
server_thread.start()
client_thread.start()
server_thread.join()
client_thread.join()
