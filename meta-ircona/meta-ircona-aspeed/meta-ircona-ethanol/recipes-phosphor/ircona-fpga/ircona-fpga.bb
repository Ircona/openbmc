FILESEXTRAPATHS_append := "${THISDIR}/files:"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a8328fd2a610bf4527feedcaa3ae3d14"

inherit systemd

S = "${WORKDIR}/"

SRC_URI = "file://init_once.sh \
           file://bmc-ready.service \
           file://LICENSE"

DEPENDS += " \
    systemd \
    "

RDEPENDS_${PN} = "bash"

SYSTEMD_PACKAGES = "${PN}"

SYSTEMD_SERVICE_${PN} = " bmc-ready.service"


do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0755 ${S}bmc-ready.service ${D}${systemd_system_unitdir}
    install -d ${D}/usr/sbin
    install -m 0755 ${S}init_once.sh ${D}/${sbindir}/
}
