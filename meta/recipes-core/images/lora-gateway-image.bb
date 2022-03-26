# lora-gateway-image-lora gateway image
# Auto Generate by Dianshao
require recipes-core/images/core-image-base.bb
inherit extrausers
EXTRA_USERS_PARAMS = "usermod -P root root;"
