# 使用docker容器化部署springboot项目
## 如何使用

- 使用docker
```shell
docker compose up -d
```

- 本地开发
  - 设置环境变量
  - 安装redis
  - 安装mysql，data.sql

```idea
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/sugar?useUnicode=true&characterEncoding=utf8;SPRING_DATASOURCE_USERNAME=root;MYSQL_ROOT_PASSWORD=123456;MYSQL_DATABASE=sugar
```