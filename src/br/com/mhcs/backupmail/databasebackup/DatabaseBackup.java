/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.mhcs.backupmail.databasebackup;

import br.com.mhcs.backupmail.util.Utilities;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author MayzaHirose
 */
public class DatabaseBackup {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    static String date = LocalDateTime.now().format(formatter);

    public static void databaseBackup() {
        File dir = new File(Utilities.resourcePath);
        File bckup = new File("backup" + date + ".sql");
        // Cria diretório
        if (!dir.isDirectory()) {
            new File(Utilities.createPath).mkdirs();
        }
        // Cria Arquivo de Backup
        try {
            if (!bckup.isFile()) {
                Runtime.getRuntime().exec("cmd /c mysqldump -u" +Utilities.user+ "-p" +Utilities.pass+ Utilities.databaseName + " > resources/backup/backup" + date + ".sql");
            } else {
                while (bckup.isFile()) {
                    bckup = new File("resources/backup/backup" + date + ".sql");
                }
                Runtime.getRuntime().exec("cmd /c mysqldump -u" +Utilities.user+ "-p" +Utilities.pass+ Utilities.databaseName + " > " + bckup);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
