#!/bin/bash

# Set all output GPIOs as such and drive them with reasonable values.
function set_gpio_active_low() {
  if [ $# -ne 2 ]; then
    echo "set_gpio_active_low: need both GPIO# and initial level";
    return;
  fi

  echo $1 > /sys/class/gpio/export
  echo 1 > /sys/class/gpio/gpio$1/active_low
  echo $2 > /sys/class/gpio/gpio$1/direction
}

function set_gpio_active_high() {
  if [ $# -ne 2 ]; then
    echo "set_gpio_active_high: need both GPIO# and initial level";
    return;
  fi

  echo $1 > /sys/class/gpio/export
  echo 0 > /sys/class/gpio/gpio$1/active_low
  echo $2 > /sys/class/gpio/gpio$1/direction
}

function set_gpio_value() {
   if [ $# -ne 2 ]; then
     echo "set_gpio_value: need both GPIO# and Value level";
     return;
   fi

   echo $2 > /sys/class/gpio/gpio$1/value
}

GPIO_BASE=$(cat /sys/class/gpio/gpio*/base)

# MGMT_ASSERT_BMC_READY, GPIO M7
set_gpio_active_high $((${GPIO_BASE} + 96 + 7)) out

# set value high
set_gpio_value $((${GPIO_BASE} + 96 + 7)) 1

exit 0;
