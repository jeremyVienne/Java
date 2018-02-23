#!/bin/sh

read -p "Repository plugin? " x;
y=$(pwd $x)"/"$x"/plugins";
echo $y;
java -classpath classes:target/classes:$x plugin.Main   $y
