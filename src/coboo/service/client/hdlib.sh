#!/bin/sh
LIBDIR="/usr/local/apache-tomcat-6.0.20/webapps/cchss/WEB-INF/lib"
MAINCLASSDIR="$LIBDIR/../classes"
join()
{  
LINE=''
while [ $# -ne 0 ]
  do  
        LINE=$LINE:$LIBDIR/$1
        shift  
  done  
  echo $LINE >> lib.txt  
}  
  
FILES=`ls $LIBDIR`
join $FILES  
CLASSPATH=`cat lib.txt`
  
rm -f lib.txt  
export CLASSPATH 
ulimit -n 65535
cd $MAINCLASSDIR
java coboo.service.client.CommandClient
