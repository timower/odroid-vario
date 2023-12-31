# Copyright (C) 2014 Unknow User <unknow@user.org>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Autostart xcsoar"
HOMEPAGE = ""
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=c79ff39f19dfec6d293b95dea7b07891"
SECTION = "base/app"

inherit systemd

RDEPENDS:${PN} = " \
	xcsoar \
  dialog \
"

SRC_URI =      "\
	file://${BPN}.service \
	file://${BPN} \
"

do_compile() {
	:
}

do_install() {
  install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/${BPN}.service ${D}${systemd_unitdir}/system

  install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/${BPN} ${D}${bindir}

  install -d ${D}/data/home/.xcsoar
}

SYSTEMD_SERVICE:${PN} = "${PN}.service"

FILES:${PN} = "${bindir}/${BPN} \
               /data/home/.xcsoar"
