# linux-imx-5.10
# Auto Generate by Dianshao
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
DESCRIPTION = "linux-imx bbappend for lorawan gateway"
SRC_URI_append = "\ 
	file://Makefile.patch \
	file://gw1000.cfg \
	file://imx6ull-gw1000.dts \
"
do_configure_append () {
	cat ../*cfg >> ${B}/.config 
}

do_compile_prepend () {
	cp ${WORKDIR}/imx6ull-gw1000.dts \
	${S}/arch/${ARCH}/boot/dts
}
