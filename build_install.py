# easiest way that i found to automate build and install
from os import system, environ

def build_install():
    environ["GRAALVM_HOME"] = "/home/renan/Downloads/graalvm" # set the env for graalvm
    
    cmdList = [
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