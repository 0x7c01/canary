#!/bin/bash

cd flutter_modules

flutter build aar

flutter build ios-framework --xcframework --no-universal --output=../ios/Flutter/
