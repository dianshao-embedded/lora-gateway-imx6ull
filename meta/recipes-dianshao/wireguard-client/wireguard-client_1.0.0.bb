# wireguard-client-1.0.0
# Auto Generate by Dianshao
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
DESCRIPTION = "wireguard client config"
LICENSE = "CLOSED"
DEPENDS = "wireguard-tools procps iproute2 iptables"
SRC_URI = "\ 
	file://wg0.conf \ 
"
do_install () {
	install -d ${D}/${sysconfdir}/wireguard
	install -m 0644 ${WORKDIR}/wg0.conf ${D}/${sysconfdir}/wireguard
}
