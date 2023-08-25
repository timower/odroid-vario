FILESEXTRAPATHS:prepend := "${THISDIR}:"

SRC_URI += "file://wpa_supplicant-wlan0.conf"
SRC_URI += "file://wlan0.network"

do_install:append () {
  install -d ${D}${sysconfdir}/wpa_supplicant
  install -m 0644 ${WORKDIR}/wpa_supplicant-wlan0.conf ${D}/${sysconfdir}/wpa_supplicant/
  install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants
  ln -s ../../../../lib/systemd/system/wpa_supplicant@.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/wpa_supplicant@wlan0.service

  install -d ${D}${systemd_unitdir}/network
	install -m 0644 ${WORKDIR}/wlan0.network ${D}${systemd_unitdir}/network
}

FILES:${PN} += " \
  ${systemd_unitdir}/network \
  ${systemd_unitdir}/network/wlan0.network \
"
