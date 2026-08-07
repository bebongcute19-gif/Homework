#!/bin/bash

echo "=================================="
echo " QuickBite Initial Setup Script"
echo "=================================="

echo "Updating system..."
sudo apt-get update && sudo apt-get upgrade -y

echo "Installing required packages..."
sudo apt-get install -y openjdk-17-jdk git curl

echo "Checking group quickbite..."

if getent group quickbite > /dev/null; then
    echo "Group quickbite already exists."
else
    sudo groupadd quickbite
    echo "Group quickbite created."
fi

echo "Checking user quickbite..."

if id quickbite >/dev/null 2>&1; then
    echo "User quickbite already exists."
else
    sudo useradd -r -g quickbite -s /bin/false quickbite
    echo "User quickbite created."
fi

echo "=================================="
echo "Setup completed successfully."
echo "=================================="

