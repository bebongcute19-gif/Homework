#!/bin/bash

# Tao user rikkeilms
sudo useradd -m -s /bin/bash rikkeilms

# Tao thu muc workspace
sudo mkdir -p /opt/rikkei/course-service

# Chuyen quyen so huu
sudo chown -R rikkeilms:rikkeilms /opt/rikkei/course-service

# Cap quyen 755
sudo chmod 755 /opt/rikkei/course-service

# Kiem tra ket qua
ls -ld /opt/rikkei/course-service
