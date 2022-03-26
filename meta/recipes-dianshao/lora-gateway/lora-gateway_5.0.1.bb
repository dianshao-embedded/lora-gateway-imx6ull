# lora-gateway-5.0.1
# Auto Generate by Dianshao
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
DESCRIPTION = "sx1301 hal library"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = "\ 
	git://git@github.com/Lora-net/lora_gateway.git;protocol=https;tag=v${PV}; \ 
"
S = "${WORKDIR}/git/libloragw"
EXTRA_OEMAKE += "CC='${CC}'"
EXTRA_OEMAKE += "AR='${AR}'"
INSANE_SKIP_${PN} += "ldflags"
do_compile () {
	oe_runmake
}
