FROM scottyhardy/docker-wine

#USER root
#
#RUN dpkg --add-architecture i386 && \
#  apt-get update && \
#  apt-get install -y wine32 && \
#  apt-get clean -y

COPY jdk-17_windows-x64_bin.exe /app/jdk.exe

RUN chmod +x /app/jdk.exe
RUN wine /app/jdk.exe /s REBOOT=Disable AUTO_UPDATE=0 WEB_JAVA=0 WEB_ANALYTICS=0 INSTALLDIR=C:\\java\\jdk /L "jdk_setup.log"
RUN wine /app/jdk.exe