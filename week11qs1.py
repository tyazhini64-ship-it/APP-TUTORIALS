import socket
import threading
import time

def tcp_server():
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind(('127.0.0.1', 8000))
    server_socket.listen(1)
    conn, addr = server_socket.accept()
    data = conn.recv(1024).decode()
    results = {"REG101": "Passed - 85%", "REG102": "Passed - 92%", "REG103": "Passed - 78%"}
    response = results.get(data, "Result not found")
    conn.sendall(response.encode())
    conn.close()
    server_socket.close()

def tcp_client():
    time.sleep(1)
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client_socket.connect(('127.0.0.1', 8000))
    client_socket.sendall(b"REG101")
    response = client_socket.recv(1024).decode()
    print("Server Response:", response)
    client_socket.close()

server_thread = threading.Thread(target=tcp_server)
client_thread = threading.Thread(target=tcp_client)
server_thread.start()
client_thread.start()
server_thread.join()
client_thread.join()

