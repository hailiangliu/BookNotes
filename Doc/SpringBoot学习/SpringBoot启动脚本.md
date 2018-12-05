#Linux下启动脚本
    1. nohup java -jar yourapp.jar &
##关闭应用的脚本：stop.sh
```text
#!/bin/bash
PID=$(ps -ef | grep yourapp.jar | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then
    echo Application is already stopped
else
    echo kill $PID
    kill $PID
fi
```
##启动应用的脚本：start.sh
```text
#!/bin/bash
nohup java -jar yourapp.jar --server.port=8888 &
```
    