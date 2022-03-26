# u-boot-imx-%
# Auto Generate by Dianshao
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
DESCRIPTION = "u-boot-imx bbappend"
LICENSE = ""
DEPENDS = "vim-native bison-native"
SRC_URI_append = "\ 
	file://mx6ullevk.h.patch \ 
	file://Makefile.patch \ 
	file://mx6ull_gw1000_defconfig \ 
	file://imx6ull-gw1000-uboot.dts \ 
"
do_configure_prepend () {
	cp ${WORKDIR}/mx6ull_gw1000_defconfig ${S}/configs
	cp ${WORKDIR}/imx6ull-gw1000-uboot.dts ${S}/arch/arm/dts
}
