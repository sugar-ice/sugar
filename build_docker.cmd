@echo off

REM 设置数据库连接信息
set serverName=localhost
set databaseName=sugar
set userName=root
set password=123456

REM 设置导出SQL文件路径
set sqlFilePath=./data.sql

REM 导出SQL数据
set exportCommand=mysqldump --host=%serverName% --user=%userName% --password=%password% --databases %databaseName% --result-file=%sqlFilePath%
%exportCommand%

REM 构建数据库
set buildCommand=docker compose up -d
%buildCommand%

