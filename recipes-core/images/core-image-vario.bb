SUMMARY = "Tiny image with Xcsoar"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"
IMAGE_INSTALL += "xcsoar xcsoar-start"

IMAGE_LINGUAS = " "

LICENSE = "GPL"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"

# For systemd
IMAGE_ROOTFS_EXTRA_SPACE:append = " + 4096"

IMAGE_FEATURES += "read-only-rootfs"
