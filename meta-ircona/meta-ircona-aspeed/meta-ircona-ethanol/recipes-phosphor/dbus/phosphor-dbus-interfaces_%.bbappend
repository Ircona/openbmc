FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://00-disable-wdt-hard-reset.patch"
SRC_URI += "file://01-generate_sel_event.patch"
