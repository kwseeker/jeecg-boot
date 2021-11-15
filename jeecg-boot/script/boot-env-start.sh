#!/bin/zsh

REDIS_HOME=/opt/redis

# 启动本地Redis
nohup ${REDIS_HOME}/bin/redis-server ${REDIS_HOME}/redis.conf 1>redis_access.log 2>&1 &
