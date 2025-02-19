# easiest way that i found to automate build and install
from os import system

def build_install():
    cmdList = [
        "export GRAALVM_HOME=/home/renan/Downloads/graalvm-java23-linux-amd64-gluon-23+25.1-dev", # set the env for graalvm
        "mvn gluonfx:build gluonfx:package -e", # build
        "mvn gluonfx:install gluonfx:nativerun -e" # install and run app on mobile device connected
    ]

    for cmd in cmdList:
        try:
            system(cmd)
        except Exception as e:
            print(f"Erro: {e}")
            exit(1)


if __name__ == "__main__":
    build_install()