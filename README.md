# mapwriter-esc-fix-1.7.10
Official repo: https://github.com/Vectron/mapwriter/tree/1.7.10

 - Run ".\gradlew setupDecompWorkspace" in the mapwriter folder.
 - Run ".\gradlew reobf".
 - The reobfuscated jar should be output to the mapwriter/build/libs folder.
 
 Changes:
  - Added autosave after adding/deleting/editting markers.
  - Fixed a bug that could lead to the loss of MapWriter's markers when MineCraft stopped abnormally.
  - Fixed chunks grid in large map scale.
