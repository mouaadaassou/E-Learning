################################ Using Docker API to execute Linux command #########################################
################################         created by Moaad AASSOU           #########################################
import sys, docker

commands = ""



### get the command arguments ######
for cmd in sys.argv[1:] :
	commands += cmd + " "


### split the command into commands to be executed by the container #########
result = commands.split("@", 50);

commands = ""

############print result

for command in result[0:len(result)] :
	commands += command + " ; "

###########print commands 

client = docker.from_env()
container = client.containers.run("ubuntu:latest", ["/bin/bash", "-c", commands]);
print container;
