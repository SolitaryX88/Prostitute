
// this illustrates the use of select() to "poll" files to see if they are
// ready, instead of using signal(), SIGIO, and user-level interrupts.

// This is complicated, because it does everything.

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <termios.h>
#include <signal.h>
#include <string.h>
#include <sys/types.h>
#include <sys/time.h>

void main(void)
{ termios buf;
  tcgetattr(0, &buf);
  buf.c_lflag &= ~(ECHO | ICANON);
  buf.c_cc[VMIN]=1;
  buf.c_cc[VTIME]=0;
  tcsetattr(0, TCSAFLUSH, &buf);
  int savedflags=fcntl(0, F_GETFL, 0);
  fcntl(0, F_SETFL, savedflags | O_NONBLOCK );

  while (1)
  { fd_set files;        // an fd_set is a list of files we are interested in
    FD_ZERO(&files);     // empty the fd_set, then add the ones we care about:
    FD_SET(0, &files);   // 0 for stdin, multiple file ids may be set
    timeval timeout = { 0, 0 };  // seconds then microseconds
    int n=select(1,      // biggest file number set, plus one
                 &files, // fd_set for input files
                 NULL,   // fd_set for output files
                 NULL,   // fd_set for internet sockets gone peculiar
                 &timeout);
             // result n is number of ready file numbers, fd_sets are modified
             // so only ready ones are still set
    if (n>0 && FD_ISSET(0, &files))
    { int c=getchar();
      while (c>0) 
      { printf("You typed '%c'\n", c);
        c=getchar(); } }
    else
    { sleep(3);
      printf(".");
      fflush(stdout); }
  }
}

