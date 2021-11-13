#!/bin/zsh

REDIS_HOME=/opt/redis

# 启动本地Redis
${REDIS_HOME}/bin/redis-server ${REDIS_HOME}/redis.conf
