#!/bin/bash

echo "Creating application directory..."
sudo mkdir -p /opt/quickbite/user-service

echo "Changing owner..."
sudo chown -R quickbite:quickbite /opt/quickbite

echo "Setting permissions..."
sudo chmod -R 750 /opt/quickbite

echo "Directory information:"
ls -ld /opt/quickbite

echo ""
echo "Permission 750 means:"
echo "7 = Owner: read, write, execute"
echo "5 = Group: read, execute"
echo "0 = Others: no permissions"
