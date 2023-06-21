import os
import subprocess
# 设置环境变量
os.environ['COMPOSE_DOCKER_CLI_BUILD'] = '1'
os.environ['DOCKER_BUILDKIT'] = '1'
# 执行docker-compose build命令
subprocess.run(['docker-compose', 'build'])
