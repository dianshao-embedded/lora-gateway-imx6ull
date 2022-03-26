#!/bin/sh

SX1301_RESET_PIN=118
echo $SX1301_RESET_PIN > /sys/class/gpio/export
echo "out" > /sys/class/gpio/gpio$SX1301_RESET_PIN/direction
echo 0 > /sys/class/gpio/gpio$SX1301_RESET_PIN/value
sleep 0.1
echo 1 > /sys/class/gpio/gpio$SX1301_RESET_PIN/value
sleep 0.1
echo 0 > /sys/class/gpio/gpio$SX1301_RESET_PIN/value
sleep 0.1
echo $SX1301_RESET_PIN > /sys/class/gpio/unexport
sleep 0.5
/usr/libexec/lora/lora_pkt_fwd