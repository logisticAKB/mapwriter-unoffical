# mapwriter-esc-fix-1.7.10
Official repo: https://github.com/Vectron/mapwriter/tree/1.7.10

 - Run ".\gradlew setupDecompWorkspace" in the mapwriter folder.
 - Run ".\gradlew reobf".
 - The reobfuscated jar should be output to the mapwriter/build/libs folder.
 
 Info:
  - Фикс бага, при котором закрытие майнкрафта крестиком или сочетанием alt+f4, не сохраняет метки в конфиг. Автор предлагает сомнителний метод вызова сохранения конфига - когда игрок становится NULL вызывается процесс сохранения конфига, что вероятней всего вызывает подобный баг.
 
 Changes:
 - Удален метод сохранения автора, добавлен ивент выгрузки мира при срабатывании которого, данные сохраняются в конфиг.
 - Добавлено автосохранение после добавления/удаления метки.
 
 TODO:
 
  
 PLANS:
  
