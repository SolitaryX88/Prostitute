#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <stdio.h>
#include <string.h>
#include <arpa/inet.h>
#include <netinet/in.h>

int status;
struct addrinfo hints;
struct addrinfo *servinfo;
int main(){

  memset(&hints, 0, sizeof hints); // make sure the struct is empty
  hints.ai_family = AF_UNSPEC; // UNSPECIFIED v4 or v6

  hints.ai_socktype = SOCK_STREAM; // TCP stream sockets
  hints.ai_flags = AI_PASSIVE; // fill in my IP for me

  if ((status = getaddrinfo(NULL, "3490", &hints, &servinfo)) != 0) {
	 fprintf(stderr, "getaddrinfo error: %s\n", gai_strerror(status));
	 exit(1);
  }

  if ((status = getaddrinfo("www.ict-romeo.eu", "http", &hints, &servinfo)) != 0) {
	 fprintf(stderr, "getaddrinfo error: %s\n", gai_strerror(status));
	 exit(1);
  }
  
  printf("The IP Addr: %s", servinfo.ai_addr.sa_data);


  freeaddrinfo(servinfo); // As always

}

