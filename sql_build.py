import subprocess

# 设置数据库连接信息
serverName = "localhost"
databaseName = "sugar"
userName = "root"
password = "123456"

# 设置导出SQL文件路径
sqlFilePath = "./data.sql"

# 导出SQL数据
exportCommand = f"mysqldump --host={serverName} --user={userName} --password={password} --databases {databaseName} > {sqlFilePath}"
subprocess.run(exportCommand, shell=True)
