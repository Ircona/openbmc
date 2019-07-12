SUMMARY = "OpenBMC for Ethanol Board"
PR = "r1"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
        ${PN}-chassis \
        ${PN}-fans \
	    ${PN}-flash \
        ${PN}-system \
        "

PROVIDES += "virtual/obmc-chassis-mgmt"
PROVIDES += "virtual/obmc-fan-mgmt"
PROVIDES += "virtual/obmc-flash-mgmt"
PROVIDES += "virtual/obmc-system-mgmt"

RPROVIDES_${PN}-chassis += "virtual-obmc-chassis-mgmt"
RPROVIDES_${PN}-fans += "virtual-obmc-fan-mgmt"
RPROVIDES_${PN}-flash += "virtual-obmc-flash-mgmt"
RPROVIDES_${PN}-system += "virtual-obmc-system-mgmt"

SUMMARY_${PN}-chassis = "Ethanol Chassis"
RDEPENDS_${PN}-chassis = " \
        obmc-phosphor-buttons-signals \
        obmc-phosphor-buttons-handler \
        obmc-control-chassis \
        x86-power-control \
        obmc-host-failure-reboots \
        "

SUMMARY_${PN}-fans = "Ethanol Fans"
RDEPENDS_${PN}-fans = " \
        obmc-control-fan \
        "

SUMMARY_${PN}-flash = "Ethanol Flash"
RDEPENDS_${PN}-flash = " \
        obmc-flash-bmc \
        obmc-mgr-download \
        obmc-control-bmc \
        openpower-software-manager \
        "

SUMMARY_${PN}-system = "Ethanol System"
RDEPENDS_${PN}-system = " \
	    bmcweb \
        obmc-ikvm \
        phosphor-dbus-interfaces\
	    phosphor-image-signing \
        phosphor-ipmi-ipmb \
        phosphor-hostlogger \
        "
