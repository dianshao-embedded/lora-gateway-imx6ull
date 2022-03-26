# chirpstack-gateway-bridge-3.13.2
# Auto Generate by Dianshao
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
DESCRIPTION = "chirpstack gateway bridge"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
DEPENDS = "go-native"
SRC_URI = "\ 
	git://git@github.com/brocaar/chirpstack-gateway-bridge.git;protocol=https;tag=v${PV}; \ 
	file://chirpstack-gateway-bridge.service \ 
	file://chirpstack-gateway-bridge.toml \ 
"
S = "${WORKDIR}/git"
inherit systemd goarch
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "chirpstack-gateway-bridge.service"
export HOME = "${WORKDIR}"
export GOOS = "${TARGET_GOOS}"
export GOARCH = "${TARGET_GOARCH}"
export GOARM = "${TARGET_GOARM}"
export GOCACHE = "${WORKDIR}/go/cache"
export GOPROXY = "https://proxy.golang.com.cn,direct"
INSANE_SKIP_${PN}_append = "already-stripped"
do_compile () {
	oe_runmake
	go clean -modcache
}
do_install () {
	install -d ${D}/etc/systemd/system
	install -m 0644 ${WORKDIR}/chirpstack-gateway-bridge.service ${D}/etc/systemd/system
	install -d ${D}/etc/chirpstack-gateway-bridge
	install -m 0644 ${WORKDIR}/chirpstack-gateway-bridge.toml ${D}/etc/chirpstack-gateway-bridge
	install -d ${D}/usr/bin
	install -m 0755 ${S}/build/chirpstack-gateway-bridge ${D}/usr/bin
}
