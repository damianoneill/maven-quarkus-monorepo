#!/bin/sh

# Quarkus 1.0.1 requires GraalVM 19.2.1
# wget -c https://github.com/oracle/graal/releases/download/vm-19.2.1/graalvm-ce-darwin-amd64-19.2.1.tar.gz -O - | sudo tar -xz -C "$HOME"/Development/
# ln -s "$HOME"/Development/graalvm-ce-19.2.1 "$HOME"/Development/graalvm

export GRAALVM_HOME=$HOME/Development/graalvm/Contents/Home/
export PATH=${GRAALVM_HOME}/bin:$PATH

# "${GRAALVM_HOME}"/bin/gu install native-image
# sudo xattr -r -d com.apple.quarantine "$HOME"/Development/graalvm
