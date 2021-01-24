#!/usr/bin/env bash

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh

IDEL_PORT=$(find_idle_port)

echo "> $IDEL_PORT 에서 구동 중인 애플리케이션 pid 확인"
IDEL_PID=$(lsof -ti tcp:${IDEL_PORT})

if [ -z ${IDEL_PID} ]
then
    echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
else
    echo "> kill -15 $IDEL_PID"
    kill -15 ${IDEL_PID}
    sleep 5
fi
