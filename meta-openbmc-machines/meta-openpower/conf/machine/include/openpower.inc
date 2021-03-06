OBMC_MACHINE_FEATURES += "\
        obmc-phosphor-fan-mgmt \
        obmc-phosphor-chassis-mgmt \
        obmc-phosphor-flash-mgmt \
        obmc-host-ipmi \
        obmc-host-ctl \
        openpower-pflash \
        obmc-host-state-mgmt \
        obmc-chassis-state-mgmt \
        obmc-bmc-state-mgmt \
        "

VIRTUAL-RUNTIME_skeleton_workbook = "${MACHINE}-config"

PREFERRED_PROVIDER_virtual/obmc-host-ipmi-hw = "phosphor-ipmi-bt"
PREFERRED_PROVIDER_virtual/obmc-chassis-mgmt = "packagegroup-op-apps"
PREFERRED_PROVIDER_virtual/obmc-fan-mgmt = "packagegroup-op-apps"
PREFERRED_PROVIDER_virtual/obmc-flash-mgmt = "packagegroup-op-apps"
PREFERRED_PROVIDER_virtual/obmc-system-mgmt = "packagegroup-op-apps"
PREFERRED_PROVIDER_virtual/obmc-host-ctl ?= "obmc-op-control-host"
PREFERRED_PROVIDER_virtual/obmc-inventory-data ?= "${VIRTUAL-RUNTIME_skeleton_workbook}"
PREFERRED_PROVIDER_virtual/phosphor-ipmi-fru-hostfw-config ?= "hostboot-inventory-config-native"
PREFERRED_PROVIDER_virtual/openpower-fru-vpd-layout ?= "openpower-fru-vpd-layout-native"
PREFERRED_PROVIDER_virtual/openpower-fru-inventory ?= \
    "${@cf_enabled(d, 'obmc-mrw', 'openpower-fru-inventory-mrw-native', 'openpower-fru-inventory-example-native')}"
