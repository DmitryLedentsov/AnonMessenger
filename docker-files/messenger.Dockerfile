FROM os_base

ARG SERVICEPATH
ARG INSTALLPATH
ARG BINPATH
ARG APP

COPY ./${APP} /etc/main_service/bin

# EXPOSE 443/tcp
EXPOSE 80/tcp
EXPOSE 9087/tcp

# TODO add logs destination for web app
ENTRYPOINT java -jar /etc/main_service/bin/${APP} & /bin/bash