#!/bin/bash
failedTags=$(< ./target/failedTests.txt)
echo "FailedTags: $failedTags"
mvn test -Dtags="$failedTags"