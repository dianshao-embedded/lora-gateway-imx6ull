# ec20-1.0.0
# Auto Generate by Dianshao
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
DESCRIPTION = "ec20 module package"
LICENSE = "CLOSED"
SRC_URI = "\ 
	file://4g_provider \ 
	file://4g_pap \ 
	file://ec20.service \ 
"
inherit systemd
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "ec20.service"
do_install () {
	install -d ${D}/etc/systemd/system
	install -m 0644 ${WORKDIR}/ec20.service ${D}/etc/systemd/system
	install -d ${D}/etc/chatscripts
	install -m 0644 ${WORKDIR}/4g_pap ${D}/etc/chatscripts
	install -d ${D}//etc/ppp/peers
	install -m 0644 ${WORKDIR}/4g_provider ${D}//etc/ppp/peers
}
