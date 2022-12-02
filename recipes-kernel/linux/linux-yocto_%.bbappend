FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# Config patches:
SRC_URI += "file://usb_wifi.cfg"
SRC_URI += "file://fbcon_rotate.cfg"
SRC_URI += "file://usb_serial.cfg"

# Device tree patches:
SRC_URI += "file://uart0.patch"
