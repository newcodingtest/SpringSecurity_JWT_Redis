# SpringSecurity_JWT_Redis
시큐리티+JWT+Redis서버(로그인 세션 공유) 적용해보기




```
docker network create redist-net
docker run --name my-redis -p 6379:6379 --network redis-net -d redis ridis-server --appendonly yes
```


