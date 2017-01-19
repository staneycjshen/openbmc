SUMMARY = "Phosphor State Management"
DESCRIPTION = "Phosphor State Manager provides a set of system state \
management daemons. It is suitable for use on a wide variety of OpenBMC \
platforms."
HOMEPAGE = "https://github.com/openbmc/phosphor-state-manager"
PR = "r1"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

STATE_MGR_PACKAGES = " \
    ${PN}-host \
    ${PN}-chassis \
    ${PN}-bmc \
"
PACKAGES =+ "${STATE_MGR_PACKAGES}"
DBUS_PACKAGES = "${STATE_MGR_PACKAGES}"

# Set SYSTEMD_PACKAGES to empty because we do not want ${PN} and DBUS_PACKAGES
# handles the rest.
SYSTEMD_PACKAGES = ""

inherit autotools pkgconfig
inherit obmc-phosphor-dbus-service

DEPENDS += "autoconf-archive-native"
DEPENDS += "sdbusplus"
DEPENDS += "phosphor-logging"

RDEPENDS_${PN}-host += "libsystemd"
RDEPENDS_${PN}-chassis += "libsystemd"
RDEPENDS_${PN}-bmc += "libsystemd"

PROVIDES += "virtual/obmc-host-state-mgmt"
RPROVIDES_${PN}-host += "virtual-obmc-host-state-mgmt"
FILES_${PN}-host = "${sbindir}/phosphor-host-state-manager"
DBUS_SERVICE_${PN}-host += "xyz.openbmc_project.State.Host.service"

PROVIDES += "virtual/obmc-chassis-state-mgmt"
RPROVIDES_${PN}-chassis += "virtual-obmc-chassis-state-mgmt"
FILES_${PN}-chassis = "${sbindir}/phosphor-chassis-state-manager"
DBUS_SERVICE_${PN}-chassis += "xyz.openbmc_project.State.Chassis.service"

PROVIDES += "virtual/obmc-bmc-state-mgmt"
RPROVIDES_${PN}-bmc += "virtual-obmc-bmc-state-mgmt"
FILES_${PN}-bmc = "${sbindir}/phosphor-bmc-state-manager"
DBUS_SERVICE_${PN}-bmc += "xyz.openbmc_project.State.BMC.service"

SRC_URI += "git://github.com/openbmc/phosphor-state-manager"
SRCREV = "d613b8166a3c3dc652badf8d8c52e74492941f28"

S = "${WORKDIR}/git"