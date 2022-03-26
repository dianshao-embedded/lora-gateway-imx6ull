# packet-forwarder-4.0.1
# Auto Generate by Dianshao
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
DESCRIPTION = "lora packet forwarder"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
DEPENDS = "lora-gateway"
SRC_URI = "\ 
	git://git@github.com/Lora-net/packet_forwarder.git;protocol=https;tag=v${PV}; \ 
	file://global_conf.json \ 
	file://local_conf.json \ 
	file://packet-forwarder.service \ 
	file://start.sh \ 
	file://Makefile.patch \ 
"
S = "${WORKDIR}/git/lora_pkt_fwd"
inherit systemd
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "packet-forwarder.service"
EXTRA_OEMAKE += "CC='${CC}'"
EXTRA_OEMAKE += "AR='${AR}'"
INSANE_SKIP_${PN} += "ldflags"
do_compile () {
	oe_runmake
}
do_install () {
	mkdir -p ${D}${libexecdir}/lora
	install -d ${D}/${libexecdir}/lora
	install -m 0755 ${S}/lora_pkt_fwd ${D}/${libexecdir}/lora
	install -d ${D}/${libexecdir}/lora
	install -m 0644 ${WORKDIR}/global_conf.json ${D}/${libexecdir}/lora
	install -d ${D}/${libexecdir}/lora
	install -m 0644 ${WORKDIR}/local_conf.json ${D}/${libexecdir}/lora
	install -d ${D}/${libexecdir}/lora
	install -m 0755 ${WORKDIR}/start.sh ${D}/${libexecdir}/lora
	install -d ${D}/etc/systemd/system
	install -m 0644 ${WORKDIR}/packet-forwarder.service ${D}/etc/systemd/system
}
