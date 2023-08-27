FROM ubuntu:22.04

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update

# https://docs.yoctoproject.org/4.0.12/ref-manual/system-requirements.html#ubuntu-and-debian
# pylint3 -> pylint
RUN apt-get install -y \
  gawk \
  wget \
  git \
  diffstat \
  unzip \
  texinfo \
  gcc \
  build-essential \
  chrpath \
  socat \
  cpio \
  python3 \
  python3-pip \
  python3-pexpect \
  xz-utils \
  debianutils \
  iputils-ping \
  python3-git \
  python3-jinja2 \
  libegl1-mesa \
  libsdl1.2-dev \
  pylint \
  xterm \
  python3-subunit \
  mesa-common-dev \
  zstd \
  liblz4-tool

# Set the locale
RUN apt-get -y install locales
RUN sed -i '/en_US.UTF-8/s/^# //g' /etc/locale.gen && \
    locale-gen
ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8

# Other oe deps
RUN apt-get -y install file tmux

# Some xcsoar tools that can't be build in oe yet.
RUN apt-get -y install fonts-dejavu fontconfig imagemagick sox

ARG USER_ID=1000
ARG GROUP_ID=1000

RUN if [ ${USER_ID:-0} -ne 0 ] && [ ${GROUP_ID:-0} -ne 0 ]; then \
    if getent passwd user; then userdel -f user; fi &&\
    if getent group user ; then groupdel user; fi &&\
    groupadd -g ${GROUP_ID} user &&\
    useradd -l -u ${USER_ID} -g user user \
;fi

USER user
